package com.sicca.enums;

public enum EstadoInvernadero {
    ACTIVO("Activo"),
    DESHABILITADO("Deshabilitado");

    private final String valor;

    EstadoInvernadero(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}

