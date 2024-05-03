package DataOperations;

import User.User;
import User.UserAuthDecorator;


import java.util.Scanner;

public class UserRegistrationDecorator extends UserAuthDecorator {
    DataIterator<UserData> dataIterator;

    public UserRegistrationDecorator(User user) {
        super(user);
    }
    private boolean isExist(String login){
        while (dataIterator.hasNext()){
            if(dataIterator.getNext().getName().equals(login)){
                return true;
            }
        }
        return false;
    }
    @Override
    public void login() {
        dataIterator = new CustomersDbIterator(CustomersDataBase.getInstance());
        UserData customer=null;
        String login;
        String password1;
        String password2;
        boolean isLoginValid= false;
        boolean isPasswordValid = false;
        Scanner in = new Scanner(System.in);
        while(true){
            while(true){
                System.out.println("Введите логин:");
                login = in.nextLine();
                if(login.length()<5){
                    System.out.println("Логин слишком короткий!");
                } else if(isExist(login)){
                    System.out.println("Пользователь с таким логином существует!");
                }else{
                    break;
                }
            }
            while (true){
                System.out.println("Введите пароль:");
                password1 = in.nextLine();
                if(password1.length()<5){
                    System.out.println("Пароль слишком короткий!");

                }else{
                    System.out.println("Повторите пароль:");
                    password2 = in.nextLine();
                    if(password1.equals(password2)){
                        isPasswordValid=true;
                        break;
                    }else{

                        System.out.println("Пароли не совпадают!");
                    }

                }

            }

             customer = new UserData(Role.CUSTOMER.role, login,password1);
             break;

        }
        CustomersDataBase.getInstance().add(customer);

        make();
    }

    @Override
    public void logout() {

    }

    @Override
    public void make() {
        user.make();
    }
}
