package com.igor.igor.domain;

import com.igor.igor.domain.enums.PaymentState;

import java.util.Date;

public class BoletoPayment extends Payment {
    private static final long serialVersionUID = 1L;

    private Date dataVencimento;
    private Date dataPagamento;


    public BoletoPayment() {
    }


    public BoletoPayment(Integer id, PaymentState state, Pedido pedido, Date dataVencimento, Date dataPagamento) {
        super(id, state, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }


    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

}