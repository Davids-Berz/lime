package com.lime.poo.interfaces.dao;

import com.lime.poo.interfaces.entity.Cliente;

import java.util.List;

public interface PaginableRepository {
    List<Cliente> listar(int desde, int hasta);
}
