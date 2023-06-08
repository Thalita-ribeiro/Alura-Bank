package com.alura.alurabank.repositoy;

import com.alura.alurabank.dominio.CurrentAccount;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class CurrentAccountRepository {
    private Set<CurrentAccount> currentAccount;

    public CurrentAccountRepository() {
        currentAccount = new HashSet<>();
    }

    public void save(CurrentAccount account) {
        currentAccount.add(account);
    }

    public Optional<CurrentAccount> search(String bank, String agency, String number) {
        return currentAccount.stream()
                .filter(currentAccount -> currentAccount.indertifiedBy(bank, agency, number)).findFirst();
    }
}
