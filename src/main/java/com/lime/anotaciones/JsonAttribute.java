package com.lime.anotaciones;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonAttribute {

    String name() default "";

    boolean capitalizar() default false;

}
