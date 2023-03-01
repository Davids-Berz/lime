package com.lime.jdbc.pool;

import com.lime.jdbc.Utils.ConexionBaseDatos;
import com.lime.jdbc.entity.Categoria;
import com.lime.jdbc.entity.Producto;
import com.lime.jdbc.repositorio.ProductoRepositorioImpl;
import com.lime.jdbc.repositorio.Repositorio;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try (Connection con = PoolConexionBaseDatos.getConnection()) {
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("===========Listar============");
            repositorio.listar().forEach(System.out::println);
            System.out.println("===========Por id============");
            System.out.println(repositorio.porId(3L).toString());

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
