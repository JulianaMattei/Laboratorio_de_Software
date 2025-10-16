import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Facultad {

    private List<Alumno> alumnos;

    public Facultad() {
        alumnos = new ArrayList<>();
    }

    public void addAlumno(Alumno alumno){
        alumnos.add(alumno);
    }

    public List<Alumno> getAlumnos() { return alumnos; }

    public Alumno getAlumnoMejorNota() {
        return this.alumnos.stream()
                .max(Comparator.comparingDouble(Alumno::getNotaAprobacion))
                .orElse(null);
    }

    public void printDosAlumnos() {
        this.alumnos.stream()
                .limit(2)
                .forEach(System.out::println);
    }

    public Alumno getAlumnoLabSoft() {
        return this.alumnos.stream()
                .filter((alumno) -> alumno
                        .getMateriaAprobada()
                        .equals("Laboratorio de Software"))
                .findFirst()
                .orElse(null);
    }

    public List<Alumno> getMatcheo(char inicialNombre, int longNombre) {
        return this.alumnos.stream()
                .filter((alumno) -> alumno.getNombre().charAt(0) == inicialNombre)
                .filter((alumno) -> alumno.getNombre().length() <= longNombre)
                .collect(Collectors.toList());
    }

    public void sortByNota() {
        /*
        // Ordenamiento Básico
        this.alumnos.sort(new Comparator<Alumno>(){
            @Override
            public int compare(Alumno o1, Alumno o2) {
                if (o1.getNotaAprobacion() < o2.getNotaAprobacion()) return 1;
                else if (o1.getNotaAprobacion() > o2.getNotaAprobacion()) return -1;
                else return 0;
            }
        });

        // Ordenamiento con un lambda
        this.alumnos.sort((a1, a2) ->
                Double.compare(a2.getNotaAprobacion(), a1.getNotaAprobacion()));

        // Ordenamiento con lambda usando Comparator.comparingDouble()
        this.alumnos.sort(Comparator.comparingDouble((Alumno a) ->
                a.getNotaAprobacion()).reversed());
        */

        // Ordenamiento con referencia a método
        this.alumnos.sort(Comparator.comparingDouble(Alumno::getNotaAprobacion));

    }
}
