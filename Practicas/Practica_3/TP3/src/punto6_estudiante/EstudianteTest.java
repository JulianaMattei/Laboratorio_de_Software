package punto6_estudiante;

import java.util.Arrays;
import java.util.Comparator;

public class EstudianteTest {

    public static void main(String[] args) {
        Estudiante e1 = new Estudiante("Perez", "Juan", 25, "4123", 12);
        Estudiante e2 = new Estudiante("Pascal", "Pedro", 43, "1234", 35);
        Estudiante e3 = new Estudiante("Esposito", "Lucia", 19, "6434", 2);
        Estudiante e4 = new Estudiante("Arana", "Esteban", 32, "4143", 16);
        Estudiante e5 = new Estudiante("Cirio", "Martin", 41, "6324", 28);
        Estudiante e6 = new Estudiante("Ramirez", "Lucia", 26, "7213", 38);

        Estudiante[] estudiantes = {e1,e2,e3,e4,e5,e6};

        // Ordenar por cantidad de materias aprobadas en forma ascendente

        Arrays.sort(estudiantes, new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante o1, Estudiante o2) {
                return o1.getMateriasAprobadas() - o2.getMateriasAprobadas();
            }
        });

        System.out.println("Ordenados por cantidad de materias aprobadas (ascendente): ");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.toString());
        }


        // Ordenar por edad en forma descendente

        Arrays.sort(estudiantes, new Comparator<Estudiante>() {
           @Override
           public int compare(Estudiante o1, Estudiante o2) {
               return o2.getEdad() - o1.getEdad();
           }
        });

        System.out.println("Ordenados por edad (descendente): ");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.toString());
        }


        // Ordenar por legajo en forma ascendente

        Arrays.sort(estudiantes, new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante o1, Estudiante o2) {
                return o1.getLegajo().compareTo(o2.getLegajo());
            }
        });

        System.out.println("Ordenados por legajo (ascendente): ");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.toString());
        }

        // Ordenar por nombre y apellido en forma descendente

        Arrays.sort(estudiantes, new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante o1, Estudiante o2) {
                int aux = o2.getNombre().compareTo(o1.getNombre());
                return aux != 0 ? aux : o2.getApellido().compareTo(o1.getApellido());
            }
        });

        System.out.println("Ordenados por nombre y apellido (descendente): ");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.toString());
        }
    }

}
