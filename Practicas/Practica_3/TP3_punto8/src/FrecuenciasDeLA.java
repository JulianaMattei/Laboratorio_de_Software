public enum FrecuenciasDeLA {
    _440HZ(440, "Organización Internacional de Estandarización ISO 16"),
    _444HZ(444, "Afinación de cámara"),
    _446HZ(446, "Renacimiento"),
    _480HZ(480, "Órganos alemanes que tocaba Batch");

    private int hz;
    private String descripcion;

    FrecuenciasDeLA(int hz, String descripcion) {}

    public int getHz() {
        return hz;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
