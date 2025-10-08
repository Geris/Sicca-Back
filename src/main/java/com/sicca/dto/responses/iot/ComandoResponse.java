package com.sicca.dto.responses.iot;

public class ComandoResponse {
    private boolean luz;
    private boolean riego;
    private boolean ventilacion;

    // Getters y setters
    public boolean isLuz() {
        return luz;
    }

    public void setLuz(boolean luz) {
        this.luz = luz;
    }

    public boolean isRiego() {
        return riego;
    }

    public void setRiego(boolean riego) {
        this.riego = riego;
    }

    public boolean isVentilacion() {
        return ventilacion;
    }

    public void setVentilacion(boolean ventilacion) {
        this.ventilacion = ventilacion;
    }
}
