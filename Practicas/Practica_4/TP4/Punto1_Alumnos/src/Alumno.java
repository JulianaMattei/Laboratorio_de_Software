import java.util.Comparator;

public class Alumno implements Comparable<Alumno> {

    private String dni;
    private String nombre;
    private String apellido;
    private String legajo;
    public static final Comparator<Alumno> COMPARADORLEGAJO = new ComparatorLegajo();

    public Alumno() {}

    public Alumno(String dni, String nombre, String apellido, String legajo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLegajo() {
        return legajo;
    }
    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", legajo='" + legajo + '\'' +
                '}';
    }

    @Override
    public int compareTo(Alumno a) {
        return this.getLegajo().compareTo(a.getLegajo());
    }

    private static class ComparatorLegajo implements Comparator<Alumno> {
        @Override
        public int compare(Alumno o1, Alumno o2) {
            int legajoO1 = Integer.parseInt(o1.getLegajo());
            int legajoO2 = Integer.parseInt(o2.getLegajo());
            return Integer.compare(legajoO1, legajoO2);
        }
    }
}
