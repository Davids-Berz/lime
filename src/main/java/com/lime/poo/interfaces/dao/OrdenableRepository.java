package com.lime.poo.interfaces.dao;

import com.lime.poo.interfaces.entity.Cliente;

import java.util.List;

public interface OrdenableRepository {
    List<Cliente> listar(String canpo, Direccion dir);


}
