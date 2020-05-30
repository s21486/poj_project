package pl.pjatk;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        User test = new User("test", 1, "test");
        User test2 = new User("test1", 2, "test1");
        User test3 = new User("test2", 3, "test2");

        test.printToScreen();
        Account testowe = new Account(test, "2151", Locale.UK, 21.20);
        testowe.printToScreen();


    }
}
