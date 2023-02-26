package com.lime.recursividad.dir;

import java.util.ArrayList;
import java.util.List;

public class DirectorioImpl implements Directorio{

    private String nombre;

    List<Directorio> subdirectorios;

    public DirectorioImpl(String nombre) {
        this.nombre = nombre;
        this.subdirectorios = new ArrayList<>();
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public List<Directorio> getSubdirectorios() {
        return this.subdirectorios;
    }

    public void addSubdirectorio(Directorio subdirectorio){
        this.subdirectorios.add(subdirectorio);
    }

    public boolean isNotEmptySubDir(){
        return !subdirectorios.isEmpty();
    }


}
