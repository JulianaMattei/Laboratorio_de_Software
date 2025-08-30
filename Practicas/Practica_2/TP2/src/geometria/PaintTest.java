package geometria;

import java.util.ArrayList;
import java.util.Arrays;

public class PaintTest {

    public static void main(String[] args) {
        Paint paint = new Paint();

        paint.init();

        /*
        Implementación con ArrayList

        ArrayList<FiguraGeometrica> paleta = paint.getPaleta();

        for (FiguraGeometrica figura : paleta) {
            System.out.println("Area: " + figura.area());
            if (figura instanceof Circulo) {
                System.out.println("Radio: " + ((Circulo) figura).getRadio());
            }
        }
        */


        // Implementación con Arrays
        FiguraGeometrica paleta[] = paint.getPaleta();

        Arrays.sort(paleta);

        for (int i = 0; i < paleta.length; i++) {
            FiguraGeometrica figura = paleta[i];
            System.out.println("Area: " +  figura.area());
        }

    }
}
