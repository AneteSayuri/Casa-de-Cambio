package com.ada.cotacao;

public class OrdemDeCompraInvalidaExpeption extends Exception {
    private final String motivo;
    public OrdemDeCompraInvalidaExpeption(String motivo) {
        super("Reserva invalida. Motivo: " + motivo);
        this.motivo = motivo;
    }
}
