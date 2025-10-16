import java.util.SortedSet;
import java.util.TreeSet;

public class Materia {

    private String nombre;
    private SortedSet<Alumno> alumnos;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.alumnos = new TreeSet<>(Alumno.COMPARADORLEGAJO);
    }

    public void addAlumno(Alumno alumno) {
        this.alumnos.add(alumno);
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public SortedSet<Alumno> getAlumnos() {
        return alumnos;
    }
    public void setAlumnos(SortedSet<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
