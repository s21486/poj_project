package pl.pjatk.Model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class Account extends Entity{
    private User user;

    @AccountNumber()
    private String accountNumber;

    private Locale locale;
    private Currency currency;
    private BigDecimal balance;

    public Account(User user, String accountNumber, Locale locale, double ammount) {
        this.user = user;
        this.accountNumber = accountNumber;
        this.locale = locale;
        this.currency = Currency.getInstance(locale);
        this.balance = new BigDecimal(Double.toString(ammount));
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal ammount) {
        this.balance = ammount;
    }

    public void addBalance(BigDecimal ammount) {
        this.setBalance(getBalance().add(ammount));
    }

    @Override
    public void printToScreen() {
        System.out.println("Użytkownik:");
        user.printToScreen();
        System.out.println("Konto:");
        System.out.println(String.format("Numer konta: %s", accountNumber));
        System.out.println("Waluta: " + currency.getCurrencyCode());
        System.out.println("Stan konta: " + balance.toString() + currency.getSymbol());
    }
}

