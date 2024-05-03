package User;

import DataOperations.Role;
import main.AdminInterface;
import main.UserInterface;

public class AdminAuthDecorator extends UserAuthDecorator {

    public AdminAuthDecorator(User user) {
        super(user);
    }
    @Override
    public void login(){
       System.out.println("Вы вошли как "+ Role.ADMIN.role);
    }
    @Override
    public void make() {
        showAdminInterface();
    }
    private void showAdminInterface(){
        UserInterface adminInterface = new AdminInterface();
        adminInterface.show();
    }


}
