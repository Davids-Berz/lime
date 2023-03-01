package com.lime.jdbc;

import com.lime.jdbc.Utils.ConexionBaseDatos;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try (
                Connection con = ConexionBaseDatos.getConnection();
                Statement stmt = con.createStatement();
                ResultSet resultSet = stmt.executeQuery("Select * from productos");
        ) {

            while (resultSet.next()) {
                System.out.print(resultSet.getString("id"));
                System.out.print("|");
                System.out.print(resultSet.getString("nombre"));
                System.out.print("|");
                System.out.print(resultSet.getString("precio"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
