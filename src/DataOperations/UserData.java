package DataOperations;

import User.Customer;

public class UserData extends Customer {
    private final String role;
    public UserData(String role, String login, String password) {
        super(login,password);
        this.role = role;
    }
    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return
                "Статус= " + role + '\'' +
                        "Имя= "+super.getName();

    }
}
