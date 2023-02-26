package com.lime.recursividad.dir;

public class Main {

    public static void main(String[] args) {
        Directorio directorioRaiz = new DirectorioImpl("raiz");
        Directorio subdirectorio1 = new DirectorioImpl("subdirectorio1");
        Directorio subdirectorio2 = new DirectorioImpl("subdirectorio2");

        ((DirectorioImpl)directorioRaiz).addSubdirectorio(subdirectorio1);
        ((DirectorioImpl)directorioRaiz).addSubdirectorio(subdirectorio2);

        Directorio subsubdirectorio1 = new DirectorioImpl("subsubdirectorio1");
        Directorio subsubdirectorio2 = new DirectorioImpl("subsubdirectorio2");

        ((DirectorioImpl)subdirectorio1).addSubdirectorio(subsubdirectorio1);
        ((DirectorioImpl)subdirectorio1).addSubdirectorio(subsubdirectorio2);
        int nivel = 0;
        dirRecursivo(directorioRaiz, nivel);
    }

    public static void dirRecursivo(Directorio d, int nivel) {
        System.out.println("\t".repeat(nivel++)+ d.getNombre());
        if (!d.getSubdirectorios().isEmpty()) {
            for (Directorio dir: d.getSubdirectorios()) {
                dirRecursivo(dir, nivel);
            }
        }
    }
}
