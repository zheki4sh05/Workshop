package User;

import DataOperations.CustomersDataBase;

public class UserAuthDecorator implements User{
    protected User user;

    public UserAuthDecorator(User user) {
        this.user = user;
    }

    @Override
    public void login() {
        //Сделать сделать интерйес ввода
        user.login();
    }

    @Override
    public void logout() {
        user.logout();
    }

    @Override
    public void make() {
        user.make();
    }
    public String checkRole(){
       return CustomersDataBase.getInstance().getActiveUser().getRole();
    }
    private void deleteSession(){

    }

}
