package pl.pjatk;


public class User implements ScreenPrinter {
    private static int usersNumber = 0;
    private int userId;
    private String name;
    private int age;
    private String address;

    public User(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
        usersNumber++;
        this.userId = usersNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void printToScreen() {
        System.out.println(String.format("Imię i nazwisko: %s", name));
        System.out.println(String.format("Wiek: %d", age));
        System.out.println(String.format("Adres: %s", address));
    }
}
