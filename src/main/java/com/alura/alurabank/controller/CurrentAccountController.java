package com.alura.alurabank.controller;

import com.alura.alurabank.dominio.AccountHolder;
import com.alura.alurabank.dominio.AccountTransaction;
import com.alura.alurabank.dominio.CurrentAccount;
import com.alura.alurabank.repositoy.CurrentAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Random;

import static java.lang.Integer.MAX_VALUE;

@RestController
@RequestMapping("/accounts")
public class CurrentAccountController {

    @Autowired
    private CurrentAccountRepository currentAccountRepository;

    @GetMapping
    public String checkBalance(
            @RequestParam(name = "bank") String bank,
            @RequestParam(name = "agency") String agency,
            @RequestParam(name = "number") String number) {

        CurrentAccount currentAccount =
                currentAccountRepository.search(bank, agency, number)
                        .orElse(new CurrentAccount());

        return String.format("Bank: %s, Agency: %s, Account: %s. Balance: %s.", bank, agency, number, currentAccount.readBalance());
    }

    @PostMapping
    public ResponseEntity<CurrentAccount> createNewAccount(@RequestBody AccountHolder accountHolder) {
        String bank = "111";
        String agency = "2222";
        String number = Integer.toString(new Random().nextInt(MAX_VALUE));
        CurrentAccount account = new CurrentAccount(bank, agency, number, accountHolder);
        currentAccountRepository.save(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    @PutMapping
    public ResponseEntity<AccountTransaction> manageAnAccount(@RequestBody AccountTransaction accountTransaction) {
        return ResponseEntity.ok(accountTransaction);
    }
}
