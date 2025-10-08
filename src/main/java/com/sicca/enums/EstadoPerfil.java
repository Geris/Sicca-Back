package com.sicca.enums;

public enum EstadoPerfil {
    ACTIVO("Activo"),
    EVALUANDO("Evaluando"),
    DESHABILITADO("Deshabilitado");

    private final String valor;

    EstadoPerfil(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}

