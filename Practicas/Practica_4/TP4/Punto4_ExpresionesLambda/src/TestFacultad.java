public class TestFacultad {

    public static void main(String[] args) {
        Facultad facultad = new Facultad();

        facultad.addAlumno(new Alumno(130, "Patricio", "Lopez",
                                35, "Redes y Comunicaciones", 7.2));
        facultad.addAlumno(new Alumno(422, "Pedro", "Granos",
                                22, "Laboratorio de Software", 8.8));
        facultad.addAlumno(new Alumno(360, "Paula", "Paredes",
                                26, "Matemática I", 4.6));
        facultad.addAlumno(new Alumno(98, "Paulina", "Torres",
                            48, "Sistemas Paralelos", 9.4));

        System.out.println("Alumno con mayor nota: " + facultad.getAlumnoMejorNota());

        System.out.println("Dos alumnos: ");
        facultad.printDosAlumnos();

        System.out.println("Alumno que aprobó Laboratorio de Software: " + facultad.getAlumnoLabSoft());

        System.out.println("Alumnos que matchean con inicial de nombre P y longitud de nombre menor-igual a 6: ");
        facultad.getMatcheo('P', 6).forEach(System.out::println);

        System.out.println("Alumnos ordenados por nota de aprobación: ");
        facultad.sortByNota();
        facultad.getAlumnos().forEach(System.out::println);
    }

}

