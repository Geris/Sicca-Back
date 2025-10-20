package com.sicca.enums;

public enum TipoCultivo {
    INTERIOR("Interior"),
    EXTERIOR("Exterior");

    private final String valor;

    TipoCultivo(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}

