import java.util.SortedSet;

public class TestPunto1 {

    public static void main(String[] args) {

        Materia materia = new Materia("LabSoft");

        materia.addAlumno(new Alumno("12345678", "Amanda", "Luna", "123"));
        materia.addAlumno(new Alumno("12467890", "Andres", "Hernandez", "152"));
        materia.addAlumno(new Alumno("23674583", "Julio", "Iglesias", "224"));
        materia.addAlumno(new Alumno("22842236", "Laura", "Abad", "234"));
        materia.addAlumno(new Alumno("9345135", "Diego", "Iglesias", "25"));
        materia.addAlumno(new Alumno("19457204", "Martin", "Sanchez", "439"));
        materia.addAlumno(new Alumno("9124000", "Cintia", "Zotele", "28"));
        materia.addAlumno(new Alumno("36485613", "Tamara", "Torres", "280"));
        materia.addAlumno(new Alumno("45777228", "Laura", "Cheuquepan", "500"));
        materia.addAlumno(new Alumno("30455032", "Francisco", "Burgos", "418"));


        SortedSet<Alumno> alumnos = materia.getAlumnos();

        for (Alumno alumno : alumnos) {
            System.out.println(alumno.toString());
        }

    }

}
