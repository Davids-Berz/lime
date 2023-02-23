package com.lime.poo.interfaces.dao;

import com.lime.poo.interfaces.entity.Cliente;

import java.util.ArrayList;
import java.util.List;

public interface CrudRepository {
    List<Cliente> listar();
    Cliente findById(Integer id);
    void save(Cliente cliente);
    void edit(Cliente cliente);
    void delete(Integer id);
}
