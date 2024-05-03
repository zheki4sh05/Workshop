package User;

import main.CustomerInterface;
import main.UserInterface;

public class CustomerAuthDecorator extends UserAuthDecorator{
    public CustomerAuthDecorator(User user) {
        super(user);
    }
    @Override
    public void make() {
        showCustomerInterface();
    }
    private void showCustomerInterface(){
        UserInterface userInterface = new CustomerInterface();
        userInterface.show();
    }

}
