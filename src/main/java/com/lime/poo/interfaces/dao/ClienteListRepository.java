package com.lime.poo.interfaces.dao;

import com.lime.poo.interfaces.entity.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepository implements OrdenablePaginableCrudRepository {

    public ClienteListRepository() {
        this.dataSource = new ArrayList<>();
    }

    private List<Cliente> dataSource;

    @Override
    public List<Cliente> listar() {
        return dataSource;
    }

    @Override
    public Cliente findById(Integer id) {
        return dataSource
                .stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Cliente cliente) {
        this.dataSource.add(cliente);
    }

    @Override
    public void edit(Cliente cliente) {
        Cliente actual = this.findById(cliente.getId());
        actual.setNombre(cliente.getNombre());
    }

    @Override
    public void delete(Integer id) {
        Cliente actual = findById(id);
        this.dataSource.remove(actual);
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> orden = new ArrayList<>(this.dataSource);
        orden.sort(( a,  b) -> {
            if (dir == Direccion.ASC) {
                return ordenar(campo, a, b);
            } else if (dir == Direccion.DESC){
                return ordenar(campo, b, a);
            }
            return 0;
        });
        return orden;
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    private static int ordenar(String campo, Cliente a, Cliente b) {
        int res = 0;
        switch (campo) {
            case "id" -> res = a.getId().compareTo(b.getId());
            case "nombre" -> res = a.getNombre().compareTo(b.getNombre());
        }
        return res;
    }
}
