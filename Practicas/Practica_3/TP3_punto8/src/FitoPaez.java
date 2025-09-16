public enum FitoPaez {
    INSTANCE;

    private final Piano piano;

    FitoPaez() {
        this.piano = new Piano();
    }

    public void tocarCancion(Notas[] notas, int[] tiempos) {
        System.out.println("Inicia la canción:");
        for (int i = 0; i < notas.length; i++) {
            piano.hacerSonar(notas[i], tiempos[i]);
        }
    }
}
