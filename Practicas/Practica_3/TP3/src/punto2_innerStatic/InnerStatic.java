package punto2_innerStatic;

import java.util.Scanner;

import static java.lang.Math.pow;

public class InnerStatic {

    static double PI = 3.1416;

    static class Circulo {

        // static double radio = 2;
        static double radio;

        static void setRadio() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingresa el radio: ");
            radio = scanner.nextDouble();
        }

        static double getArea() {
            // double a = PI * Math.pow(radio, 2);
            double a = PI * pow(radio,2);
            System.out.println("El area es: " + a);
            return a;
        }

        static double getLongitudCircunferencia() {
            double l = 2*PI*radio;
            System.out.println("El longitud es: " + l);
            return l;
        }
    }

}
