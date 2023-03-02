package com.lime.jdbc.repositorio;

import com.lime.jdbc.Utils.ConexionBaseDatos;
import com.lime.jdbc.entity.Categoria;
import com.lime.jdbc.entity.Producto;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        try (Connection con = ConexionBaseDatos.getInstance()) {
            if (con.getAutoCommit()) {
                con.setAutoCommit(false);
            }
            try {
                Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
                System.out.println("===========Listar============");
                repositorio.listar().forEach(System.out::println);
                System.out.println("===========Por id============");
                System.out.println(repositorio.porId(3L).toString());
                System.out.println("===========Insertar============");
                Producto producto = new Producto();
                producto.setNombre("piano");
                producto.setPrecio(15900);
                Categoria categoria = new Categoria();
                categoria.setId(1L);
                categoria.setNombre("Deporte");
                producto.setCategoria(categoria);
                repositorio.guardar(producto);
                System.out.println("Producto guardado con exito");
                System.out.println("===========Listar============");
                repositorio.listar().forEach(System.out::println);
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                e.printStackTrace();
            }
        }
    }
}
