package punto4_serializable;

import java.io.Serializable;

public class Paint implements Serializable {

    /*  Implementación con ArrayList
    private ArrayList<FiguraGeometrica> paleta;

    public Paint() {
        this.paleta = new ArrayList<FiguraGeometrica>();
    }

    public void setPaleta(ArrayList<FiguraGeometrica> paleta) {
        this.paleta = paleta;
    }

    public ArrayList<FiguraGeometrica> getPaleta() {
        return this.paleta;
    }

    public void init() {
        paleta.add(new Circulo(2, "azul"));
        paleta.add(new Circulo(3, "amarillo"));
        paleta.add(new Rectangulo(2, 3, "verde"));
        paleta.add(new Rectangulo(4, 10, "rojo"));
    }
    */


    // Implementación con Array

    private FiguraGeometrica paleta[];

    public Paint() {};

    public FiguraGeometrica[] getPaleta() {
        return  paleta;
    }

    public void setPaleta(FiguraGeometrica[] paleta) {
        this.paleta = paleta;
    }

    public void init() {
        Circulo circulo1 = new Circulo(2, "azul");
        Circulo circulo2 = new Circulo(3, "amarillo");
        Rectangulo rectangulo1 = new Rectangulo(2, 3, "verde");
        Rectangulo rectangulo2 = new Rectangulo(4, 10, "rojo");

        paleta = new FiguraGeometrica[4];
        paleta[0] = circulo1;
        paleta[1] = circulo2;
        paleta[2] = rectangulo1;
        paleta[3] = rectangulo2;
    }
}
