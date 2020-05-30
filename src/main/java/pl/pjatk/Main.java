package pl.pjatk;

import pl.pjatk.Controller.BankingService;
import pl.pjatk.Model.Account;
import pl.pjatk.Model.Bank;
import pl.pjatk.Model.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        //test tworzenia userów
        User test = new User("test", 1, "test");
        User test1 = new User("test1", 2, "test1");
        User test2 = new User("test2", 3, "test2");

        test.printToScreen();

        //test tworzenia konta
        Account testowe = new Account(test, "69 8243 4584 3196 7898 6162 6338", Locale.UK, 21.20);
        testowe.printToScreen();
        Account testowe1 = new Account(test1, "68 1234 2222 2222 2222 2222 2222", Locale.UK, 20 );


        //test walidatora
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Account>> validate = validator.validate(testowe);
        System.out.println(validate);


        //test serwisu
        Bank bank = new Bank("1234", new ArrayList<Account>(Arrays.asList(testowe, testowe1)));
        BankingService service = new BankingService(bank);
        service.transferMoney(test, test1, new BigDecimal("12"));
        System.out.println(service.accountBalance(test));
        service.topUpAccount(new BigDecimal("450"), test);
        service.getAccountForUser(test).get().printToScreen();
        System.out.println(service.checkBankAndAccountCorrelation(testowe));
        System.out.println(service.checkBankAndAccountCorrelation(testowe1));

    }
}
