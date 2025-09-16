public class FitoPaezTest {

    public static void main(String[] args) {

        Notas[] notas = { Notas.DO, Notas.RE, Notas.MI, Notas.FA,
                            Notas.SOL};
        int[] tiempos = { 1, 3, 2, 5, 2 };

        FitoPaez.INSTANCE.tocarCancion(notas, tiempos);

    }

}
