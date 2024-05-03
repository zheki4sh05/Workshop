package DataOperations;

import User.User;
import User.Customer;

import java.util.Scanner;

public class UserAuthManager implements User {
    DataIterator<UserData> dataIterator = CustomersDataBase.getInstance().createIterator();
    @Override
    public void login() {
        String login;
        String password;
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print("Введите логин:");
            login = in.nextLine();
            System.out.print("Введите пароль:");
            password = in.nextLine();
            if(isExist(login,password)){
                UserData userData = find(login,password);
                if(userData!=null){
                    CustomersDataBase.getInstance().setActiveUser(userData);
                }
                break;
             }else{
                System.out.println("Неверный логин или пароль!");
            }

        }
    }

    @Override
    public void logout() {
        //тут будет реализация
    }

    @Override
    public void make() {

    }
    private boolean isExist(String login,String password){
        while (dataIterator.hasNext()){
            Customer customer=dataIterator.getNext();
            if(customer.getName().equals(login) && customer.getPassword().equals(password)){
                dataIterator.reset();
                return true;
            }

        }
        dataIterator.reset();
        return false;
    }
    private UserData find(String login,String password){
        while (dataIterator.hasNext()){
            UserData customer=dataIterator.getNext();
            if(customer.getName().equals(login) && customer.getPassword().equals(password)){
                dataIterator.reset();

                return customer;
            }

        }
        dataIterator.reset();
        return null;
    }
}
