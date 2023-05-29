package com.alura.alurabank.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentAccount {
    @JsonProperty
    private String bank;
    @JsonProperty
    private String agency;
    @JsonProperty
    private String number;

    public CurrentAccount(String bank, String agency, String number) {
        this.bank = bank;
        this.agency = agency;
        this.number = number;
    }
}
