package laboratorio;

import java.io.File;

public class MiArchivo extends File {
    public MiArchivo() {
        super("./miarchivo.txt");
        System.out.println("Mi Archivo instanciado");
    }
}
