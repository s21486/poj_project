package pl.pjatk.Model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigInteger;

public class AccountNumberValidator implements ConstraintValidator<AccountNumber, String> {

    @Override
    public void initialize(AccountNumber AccountNumber) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        //sprawdzam, czy zawiera same liczby
        try{
            new BigInteger(s.replaceAll("\\s+",""));
        }catch (NumberFormatException e) {
            return false;
        }

        //sprawdzam, czy ma długość 26 znaków
        if(s.replaceAll("\\s+", "").length() == 26) {
            return true;
        }
        return false;
    }
}

