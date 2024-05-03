package User;
public class Customer {
    private final String name;
    private final String password;

    public Customer(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
