package vacunas;

import java.util.List;
import java.util.ArrayList;

public class TestVacuna {
    public static void main(String[] args){
        List<Vacuna> vacunas = new ArrayList<Vacuna>();
        vacunas.add(new Vacuna("Marca A", "Pais A", "Enfermedad A", 1));
        vacunas.add(new Vacuna("Marca B", "Pais B", "Enfermedad B", 2));
        vacunas.add(new Vacuna("Marca C", "Pais C", "Enfermedad C", 3));
        vacunas.add(new Vacuna("Marca D", "Pais D", "Enfermedad D", 4));
        vacunas.add(new Vacuna("Marca E", "Pais E", "Enfermedad E", 5));


        for (Vacuna vacuna : vacunas) {
            System.out.println(vacuna.toString());
        }

        /*
        vacunas.Vacuna v1 = new vacunas.Vacuna("MarcaA", "PaisA","Enf.A", 2);
        vacunas.Vacuna v2 = new vacunas.Vacuna("MarcaB", "PaisB", "Enf.B", 3);

        if (v1.equals(v2)) {
            System.out.println("Iguales");
        } else {
            System.out.println("Diferentes");
        }

         */
    }
}
