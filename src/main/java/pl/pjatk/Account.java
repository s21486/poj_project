package pl.pjatk;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class Account implements ScreenPrinter{
    private User user;

    @AccountNumber()
    private String accountNumber;

    private Locale locale;
    private Currency currency;
    private BigDecimal ammount;

    public Account(User user, String accountNumber, Locale locale, double ammount) {
        this.user = user;
        this.accountNumber = accountNumber;
        this.locale = locale;
        this.currency = Currency.getInstance(locale);
        this.ammount = new BigDecimal(Double.toString(ammount));
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

    public BigDecimal getAmmount() {
        return ammount;
    }

    public void setAmmount(BigDecimal ammount) {
        this.ammount = ammount;
    }

    @Override
    public void printToScreen() {
        System.out.println("Użytkownik:");
        user.printToScreen();
        System.out.println("Konto:");
        System.out.println(String.format("Numer konta: %s", accountNumber));
        System.out.println("Waluta: " + currency.getCurrencyCode());
        System.out.println("Stan konta: " + ammount.toString() + currency.getSymbol());
    }
}

