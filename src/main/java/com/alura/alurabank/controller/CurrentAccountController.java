package com.alura.alurabank.controller;

import com.alura.alurabank.dominio.AccountHolder;
import com.alura.alurabank.dominio.AccountTransaction;
import com.alura.alurabank.dominio.CurrentAccount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/accounts")
public class CurrentAccountController {

    @GetMapping
    public String checkBalance(
            @RequestParam(name = "bank") String bank,
            @RequestParam(name = "agency") String agency,
            @RequestParam(name = "number") String number) {
        return String.format("Bank: %s, Agency: %s, Account: %s. Balance: R$1380,00", bank, agency, number);
    }

    @PostMapping
    public ResponseEntity<CurrentAccount> createNewAccount(@RequestBody AccountHolder accountHolder) {
        CurrentAccount account = new CurrentAccount("111", "2222", "700");
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    @PutMapping
    public ResponseEntity<AccountTransaction> manageAnAccount(@RequestBody AccountTransaction accountTransaction) {
        return ResponseEntity.ok(accountTransaction);
    }
}
