package com.lime.recursividad.dir;

import java.util.List;

public interface Directorio {

    String getNombre();

    List<Directorio> getSubdirectorios();

}
