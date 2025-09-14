package punto6_estudiante;

public class Estudiante {

    private String apellido;
    private String nombre;
    private int edad;
    private String legajo;
    private int materiasAprobadas;


    public Estudiante(String apellido,
                      String nombre,
                      int edad,
                      String legajo,
                      int materiasAprobadas) {

        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
        this.legajo = legajo;
        this.materiasAprobadas = materiasAprobadas;
    }


    // Getters y Setters

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public int getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(int materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    @Override
    public String toString() {
        return "Estudiante: {" + "apellido=" + apellido + ", nombre=" + nombre + ", edad=" + edad + ", legajo=" + legajo
                + ", materiasAprobadas=" + materiasAprobadas + '}';
    }
}
