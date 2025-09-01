package punto4_serializable;

public class Rectangulo extends FiguraGeometrica {
    private int alto;
    private int ancho;

    public Rectangulo(){}

    public Rectangulo(int alto, int ancho, String color){
        this.alto = alto;
        this.ancho = ancho;
        super.setColor(color);
    }

    @Override
    public void dibujar() {
        StringBuffer str = new StringBuffer("Se dibuja un rectángulo de alto ");
        str.append(this.alto);
        str.append(", ancho ");
        str.append(this.ancho);
        str.append(" y de color ");
        str.append(this.getColor());
        System.out.println(str.toString());
    }

    @Override
    public int area() {
        return this.alto * this.ancho;
    }
}
