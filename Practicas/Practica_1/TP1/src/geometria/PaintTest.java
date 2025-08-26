package geometria;

import java.util.ArrayList;

public class PaintTest {

    public static void main(String[] args) {
        Paint paint = new Paint();

        paint.init();
        ArrayList<FiguraGeometrica> paleta = paint.getPaleta();

        for (FiguraGeometrica figura : paleta) {
            System.out.println("Area: " + figura.area());
            if (figura instanceof Circulo) {
                System.out.println("Radio: " + ((Circulo) figura).getRadio());
            }
        }
    }
}
