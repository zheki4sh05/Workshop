package DataOperations;

import User.AdminAuthDecorator;
import User.CustomerAuthDecorator;
import User.UserAuthDecorator;

import java.util.Scanner;

public class App {
    public void start(){
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Выберите действие");
            System.out.println("1- Вход");
            System.out.println("2- Регистрация");
            System.out.println("0- Выход");
            String choice = in.nextLine();
            UserAuthManager userAuthManager = new UserAuthManager();
            try{
                switch(Integer.parseInt(choice)){
                    case 1: {
                        UserAuthDecorator userAuthDecorator = new UserAuthDecorator(userAuthManager);
                        userAuthDecorator.login();
                            if (userAuthDecorator.checkRole().equals(Role.ADMIN.role)) {
                                AdminAuthDecorator adminAuthDecorator = new AdminAuthDecorator(userAuthDecorator);
                                adminAuthDecorator.login();
                                adminAuthDecorator.make();
                            }
                            else if(userAuthDecorator.checkRole().equals(Role.BLOCK.role)){
                                System.out.print("К сожалению вы заблокированы в системе!");
                            } else if (userAuthDecorator.checkRole().equals(Role.CUSTOMER.role)) {
                                CustomerAuthDecorator customerAuthDecorator = new CustomerAuthDecorator(userAuthDecorator);
                                customerAuthDecorator.make();
                            }

                            break;
                        }

                        case 2:
                        UserRegistrationDecorator userRegistrationDecorator = new UserRegistrationDecorator(new CustomerAuthDecorator(userAuthManager));
                        userRegistrationDecorator.login();
                        System.out.print("Теперь войдите в систему!");
                       CustomerAuthDecorator customerAuthDecorator =new CustomerAuthDecorator(userAuthManager);
                       customerAuthDecorator.login();
                       customerAuthDecorator.make();
                        break;
                    case 0:
                        return;
                    default :
                        System.out.println("Неверный ввод...");
                }
            }catch(NumberFormatException e){
                System.out.println("Некоректный ввод!");
            }

        }


    }
}
