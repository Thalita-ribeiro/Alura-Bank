package com.alura.alurabank.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class CurrentAccount {
    @JsonProperty
    private String bank;
    @JsonProperty
    private String agency;
    @JsonProperty
    private String number;
    @JsonProperty
    private BigDecimal balance;
    @JsonIgnore
    private AccountHolder accountHolder;

    public CurrentAccount(String bank, String agency, String number, AccountHolder accountHolder) {
        this();
        this.bank = bank;
        this.agency = agency;
        this.number = number;
        this.accountHolder = accountHolder;
    }

    public CurrentAccount() {
        this.balance = ZERO;
    }

    public boolean indertifiedBy(String bank, String agency, String number) {
        return this.bank.equals(bank) && this.agency.equals(agency) && this.number.equals(number);
    }

    public BigDecimal readBalance() {
        return balance;
    }
}
