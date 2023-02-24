package com.lime.anotaciones.procesador;

import com.lime.anotaciones.JsonAttribute;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class JsonUtils {

    public static void inicializar(Object o) {
        if (o == null) {
            throw new JsonUtilsException("El objeto serializable es null");
        }

        Method[] metodos = o.getClass().getDeclaredMethods();

        Arrays.stream(metodos).filter(m -> m.isAnnotationPresent(Init.class))
                .forEach(m -> {
                    m.setAccessible(true);
                    try {
                        m.invoke(o);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new JsonUtilsException("Error al Serializar " + e.getCause());
                    }
                });

    }

    public static String convertJson(Object o) {

        if (o == null) {
            throw new JsonUtilsException("El objeto serializable es null");
        }
        inicializar(o);

        Field[] atributos = o.getClass().getDeclaredFields();

        return Arrays.stream(atributos)
                .filter(f -> f.isAnnotationPresent(JsonAttribute.class))
                .map(field -> {
                    field.setAccessible(true);
                    String nombre =
                            field.getAnnotation(JsonAttribute.class).name().equals("")
                                    ? field.getName()
                                    : field.getAnnotation(JsonAttribute.class).name();
                    try {
                        Object valor = field.get(o);

                        if (field.getAnnotation(JsonAttribute.class).capitalizar() == true
                                && valor instanceof String) {
                            String nuevoValor = (String) valor;
                            nuevoValor = String.valueOf(nuevoValor
                                            .charAt(0)
                                    ).toUpperCase()
                                    .concat(nuevoValor.substring(1).toLowerCase());
                            field.set(o, nuevoValor);
                        }

                        return "\"" + nombre + "\":\"" + field.get(o) + "\"";
                    } catch (IllegalAccessException e) {
                        throw new JsonUtilsException("Error al serializar el json " + e.getCause());
                    }
                })
                .reduce("{", (a, b) -> {
                    if ("{".equals(a)) {
                        return a + b;
                    }
                    return a + ", " + b;
                })
                .concat("}");
    }
}
