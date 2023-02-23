package com.lime.poo.interfaces.dao;

import com.lime.poo.interfaces.entity.Cliente;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        CrudRepository repo = new ClienteListRepository();
        repo.save(new Cliente("David"));
        repo.save(new Cliente("Juan"));
        repo.save(new Cliente("Jose"));
        repo.save(new Cliente("Raul"));
        repo.save(new Cliente("Sandra"));
        repo.save(new Cliente("Ana"));
        repo.save(new Cliente("Sofia"));
        repo.save(new Cliente("Sofia"));

        List<Cliente> cliente = repo.listar();

        cliente.forEach(System.out::println);


        List<Cliente> paginable = ((PaginableRepository)repo).listar(0,4);

        System.out.println("Paginable");
        paginable.forEach(System.out::println);

        List<Cliente> paginable2 = ((PaginableRepository)repo).listar(4,8);

        System.out.println("Paginable2");
        paginable2.forEach(System.out::println);

        List<Cliente> ordenAsc = ((OrdenableRepository) repo).listar("nombre", Direccion.DESC);

        System.out.println("Orden");
        ordenAsc.forEach(System.out::println);
    }
}
