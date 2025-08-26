package geometria;

import java.util.ArrayList;

public class Paint {
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
}
