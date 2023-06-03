package com.alura.alurabank.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class AccountTransaction {
    @JsonProperty
    private CurrentAccount currentAccount;
    @JsonProperty
    private BigDecimal value;
    @JsonProperty
    private Operation operation;
}
