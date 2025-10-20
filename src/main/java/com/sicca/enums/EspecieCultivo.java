package com.sicca.enums;

public enum EspecieCultivo {
    INDICA("Indica"),
    SATIVA("Sativa");

    private final String valor;

    EspecieCultivo(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}

