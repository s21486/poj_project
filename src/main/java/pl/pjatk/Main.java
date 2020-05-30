package pl.pjatk;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Locale;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User test = new User("test", 1, "test");
        User test2 = new User("test1", 2, "test1");
        User test3 = new User("test2", 3, "test2");

        test.printToScreen();
        Account testowe = new Account(test, "69 8243 4584 3196 7898 6162 6338", Locale.UK, 21.20);
        testowe.printToScreen();

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Account>> validate = validator.validate(testowe);
        System.out.println(validate);


    }
}
