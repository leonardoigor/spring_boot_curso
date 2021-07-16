package com.igor.igor.domain.enums;

public enum PaymentState {
    PENDENT(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    PaymentState() {
    }

    private int cod;
    private String description;

    PaymentState(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public int getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }

    public static PaymentState toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (PaymentState x : PaymentState.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id Invalido: " + cod);
    }
}