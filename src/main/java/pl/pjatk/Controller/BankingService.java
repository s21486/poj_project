package pl.pjatk.Controller;

import pl.pjatk.Model.Account;
import pl.pjatk.Model.Bank;
import pl.pjatk.Model.User;
import java.math.BigDecimal;
import java.util.Optional;

public class BankingService {

    private Bank bank;

    public BankingService(Bank bank) {
        this.bank = bank;
    }

    //zwraca konto usera
    public Optional<Account> getAccountForUser(User user){
        return bank.getAccountList().stream().filter(acc -> acc.getUser().equals(user)).findFirst();
    }

    //zwraca stan konta dla usera
    public BigDecimal accountBalance(User user) {
        return getAccountForUser(user).get().getBalance();
    }

    //sprawdza, czy nr konta zgadza się z kodem banku
    public boolean checkBankAndAccountCorrelation(Account account) {
        return account.getAccountNumber().replaceAll("\\s+", "")
                .substring(2, 6).equals(bank.getBankId());
    }

    //zmienia stan konta usera o podaną kwotę i zwraca stan konta po zmianie
    public BigDecimal topUpAccount(BigDecimal topUpAmmount, User user) {
        Account account = getAccountForUser(user).get();
        account.addBalance(topUpAmmount);
        return account.getBalance();
    }

    //transferuje środki z konta jednego usera na konto drugiego usera, zwraca kwotę przelewu
    public BigDecimal transferMoney(User fromUser, User toUser, BigDecimal ammount) {
        topUpAccount(ammount.negate(), fromUser);
        topUpAccount(ammount, toUser);
        return ammount;
    }
}
