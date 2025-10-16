public class Alumno {

    private int nroAlumno;
    private String nombre;
    private String apellido;
    private int edad;
    private String materiaAprobada;
    private double notaAprobacion;

    public Alumno(int nroAlumno, String nombre,
                  String apellido, int edad,
                  String materiaAprobada, double notaAprobacion) {
        this.nroAlumno = nroAlumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.materiaAprobada = materiaAprobada;
        this.notaAprobacion = notaAprobacion;
    }

    public int getNroAlumno() { return nroAlumno; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getEdad() { return edad; }
    public String getMateriaAprobada() { return materiaAprobada; }
    public double getNotaAprobacion() { return notaAprobacion; }

    @Override
    public String toString() {
        return "Alumno{" +
                "nroAlumno=" + nroAlumno +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", materiaAprobada='" + materiaAprobada + '\'' +
                ", notaAprobacion=" + notaAprobacion +
                '}';
    }
}
