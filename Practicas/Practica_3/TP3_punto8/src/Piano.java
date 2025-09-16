public class Piano implements InstrumentoMusical {

    @Override
    public void hacerSonar() {
        System.out.println("Suena el piano");
    }

    @Override
    public void hacerSonar(Notas nota, int duracion) {
        System.out.println("Suena el piano, con la nota "
                + nota + "(" + nota.getCifradoAmericano() + ")"
                + " durante " + duracion + " segundos.");
    }

    @Override
    public String queEs() {
        return "Un piano";
    }

    @Override
    public void afinar() {
        System.out.println("Afinando el piano");
    }

    @Override
    public void afinar(FrecuenciasDeLA frecuencia) {
        System.out.println("Afinando el piano en la frecuencia "
                + frecuencia.getHz() + "Hz, descripto como: "
                + frecuencia.getDescripcion());
    }
}
