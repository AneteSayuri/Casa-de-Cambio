package com.ada.compra.exceptions;

public class ClienteInvalidoException extends Exception {
    private final String motivo;

    public ClienteInvalidoException(String motivo) {
        super("Cliente inválido. Motivo: " + motivo);
        this.motivo = motivo;
    }
}
