package vacunas;

public class Vacuna {
    private String marca;
    private String pais_origen;
    private String enfermedad_previene;
    //private int cantidad_dosis;
    private int cantidad_dosis;

    public Vacuna(String marca, String pais_origen, String enfermedad_previene, int cantidad_dosis) {
        this.marca = marca;
        this.pais_origen = pais_origen;
        this.enfermedad_previene = enfermedad_previene;
        this.cantidad_dosis = cantidad_dosis;
    }


    @Override
    public String toString() {
        StringBuffer datos = new StringBuffer("vacunas.Vacuna:");
        datos.append("\nMarca: " + this.marca);
        datos.append("\nPaís de origen: " + this.pais_origen);
        datos.append("\nEnfermedad que previene: " + this.enfermedad_previene);
        datos.append("\nCantidad de dosis: " + this.cantidad_dosis);
        return datos.toString();
    }


    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getPais_origen() {
        return pais_origen;
    }
    public void setPais_origen(String pais_origen) {
        this.pais_origen = pais_origen;
    }
    public String getEnfermedad_previene() {
        return enfermedad_previene;
    }
    public void setEnfermedad_previene(String enfermedad_previene) {
        this.enfermedad_previene = enfermedad_previene;
    }
    public int getCantidad_dosis() {
        return cantidad_dosis;
    }
    public void setCantidad_dosis(int cantidad_dosis) {
        this.cantidad_dosis = cantidad_dosis;
    }

}
