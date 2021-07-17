package com.igor.igor.domain;

import com.igor.igor.domain.enums.PaymentState;

import javax.persistence.Entity;

@Entity
public class CartaoPayment extends Payment {
    private static final long serialVersionUID = 1L;

    private Integer numberInstallments;


    public CartaoPayment() {
    }


    public CartaoPayment(Integer id, PaymentState state, Pedido pedido, Integer numberInstallments) {
        super(id, state, pedido);
        this.numberInstallments = numberInstallments;
    }
}