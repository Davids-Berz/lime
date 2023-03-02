package com.lime.jdbc.repositorio;

import com.lime.jdbc.Utils.ConexionBaseDatos;
import com.lime.jdbc.entity.Categoria;
import com.lime.jdbc.entity.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto> {

    private static String sqlListar = "Select p.*, c.nombre as categoria from productos p " +
                                        "inner join categorias c ON (p.categoria_id=c.id)";

    private Connection getConn() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        try (Statement st = getConn().createStatement();
             ResultSet resul = st.executeQuery(sqlListar)) {
            while (resul.next()) {
                Producto producto = getProducto(resul);
                productos.add(producto);
            }
        }
        return productos;
    }


    @Override
    public Producto porId(Long id) throws SQLException {
        Producto producto = null;
        try (PreparedStatement ps = getConn()
                .prepareStatement(sqlListar + " where p.id = ?")) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    producto = getProducto(rs);
                }
            }
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) throws SQLException {
        String sql;
        if (producto.getId() != null && producto.getId() > 0)
            sql = "update productos set nombre=?, precio=?, categoria=? where id=?";
        else
            sql = "Insert into productos (nombre, precio, categoria_id) values (?,?,?)";

        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setString(1, producto.getNombre());
            ps.setLong(2, producto.getPrecio());
            ps.setLong(3, producto.getCategoria().getId());
            if (producto.getId() != null && producto.getId() > 0)
                ps.setLong(4, producto.getId());

            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(Long id) {
        try (PreparedStatement ps = getConn().prepareStatement("Delete from productos where id=?")) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Producto getProducto(ResultSet resul) throws SQLException {

        Producto producto = new Producto();
        producto.setId(resul.getLong("id"));
        producto.setNombre(resul.getString("nombre"));
        producto.setPrecio(resul.getInt("precio"));

        Categoria categoria = new Categoria();
        categoria.setId(resul.getLong("categoria_id"));
        categoria.setNombre(resul.getString("categoria"));
        producto.setCategoria(categoria);
        return producto;
    }

}
