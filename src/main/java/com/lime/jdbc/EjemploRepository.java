package com.lime.jdbc;

import com.lime.jdbc.Utils.ConexionBaseDatos;
import com.lime.jdbc.entity.Producto;
import com.lime.jdbc.repositorio.ProductoRepositorioImpl;
import com.lime.jdbc.repositorio.Repositorio;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploRepository {

    public static void main(String[] args) {

        try (Connection con = ConexionBaseDatos.getInstance()) {
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("===========Listar============");
            repositorio.listar().forEach(System.out::println);
            System.out.println("===========Por id============");
            System.out.println(repositorio.porId(3L).toString());
            /*System.out.println("===========Insertar============");
            Producto producto = new Producto();
            producto.setNombre("celular");
            producto.setPrecio(5900);
            repositorio.guardar(producto);
            System.out.println("Producto guardado con exito");*/
            /*System.out.println("===========Listar============");
            repositorio.listar().forEach(System.out::println);*/
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
