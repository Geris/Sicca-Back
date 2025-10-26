package com.sicca.enums;

public enum TipoSensor {
    SENSOR("Sensor"),
    ACTUADOR("Actuador");

    private final String valor;

    TipoSensor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}

