package geometria;

public class Circulo extends FiguraGeometrica {
    private int radio;

    public Circulo(){}

    public Circulo(int radio, String color) {
        this.radio = radio;
        super.setColor(color);
    }

    @Override
    public void dibujar() {
        StringBuffer str = new StringBuffer("Se dibuja un círculo de radio");
        str.append(this.radio);
        str.append(" y de color ");
        str.append(this.getColor());
        System.out.println(str.toString());
    }

    @Override
    public int area() {
        return (int) (Math.PI * Math.sqrt(this.radio));
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }
}
