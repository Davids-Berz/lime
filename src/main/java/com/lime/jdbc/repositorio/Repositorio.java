package com.lime.jdbc.repositorio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface Repositorio<T> {

    List<T> listar() throws SQLException;

    T porId(Long id) throws SQLException;

    void guardar(T t) throws SQLException;

    void eliminar(Long id);
}
