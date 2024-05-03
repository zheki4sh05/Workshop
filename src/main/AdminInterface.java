package main;

import DataOperations.*;
import Utils.MenuControls;
import Utils.ServicesProcessor;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Scanner;

public class AdminInterface implements UserInterface{
    private List<UserData> userData=new ArrayList<>();
    CustomersDbIterator customersDbIterator;
    public void show(){
        WorkShop workShop  = new WorkShop();
        customersDbIterator = new CustomersDbIterator(CustomersDataBase.getInstance());
        initUsersList();
        String choice;
        Scanner in = new Scanner(System.in);
        List<WService> ordersList = new ArrayList<>();
        try {
            while(true) {
                System.out.println("1-Редактировать список");
                System.out.println("2-Создать заказ");
                System.out.println("3-Редактировать список пользователей");
                System.out.println("0-Выйти");
                choice = in.nextLine();
                switch (Integer.parseInt(choice)) {
                    case MenuControls.SHOW_LIST -> {
                        String choice2;
                        while (true){
                           // activeCollection.forEach(System.out::println);
                            workShop.printList();
                            System.out.println("1-Добавить  2-Удалить 3-Фильтрация 0-Назад");
                            choice2 = in.nextLine();
                            try {
                                switch (Integer.parseInt(choice2)) {
                                    case 1: {
                                        System.out.println("Введите данные");
                                        System.out.print("Название ");
                                        String name = in.nextLine();
                                        System.out.print("Цена ");
                                        double price = Double.parseDouble(in.nextLine());
                                        System.out.print("Срок ");
                                        int days = Integer.parseInt(in.nextLine());
                                        workShop.addService(new WService(price,name,days, ServicesProcessor.getServiceID()));
                                        break;
                                    }
                                    case 2: {
                                        try {
                                            System.out.println("Введите номер");
                                            int index = Integer.parseInt(in.nextLine());
                                            // int serviceID = activeCollection.get(index-1).getThis_ID();
                                            workShop.deleteService(index);
                                        }catch (IndexOutOfBoundsException e){
                                            System.out.println("Неверный ввод!");
                                        }


                                       // activeCollection = workShop.getList();
                                        break;
                                    }
                                    case 3:{
                                        try {
                                            while (true){
                                                workShop.printList();
                                                System.out.println("1-Мин. цена 2-Макс. цена 3-По названию 4-Отменить 5-Сортировка по возрастанию 6-Сортировка по убыванию 7-Открыть список 8-Отменить удаление 0-Назад");
                                                int index = Integer.parseInt(in.nextLine());
                                                System.out.println("Введите значение: ");
                                                switch (index){
                                                    case 1:{
                                                        double minPrice = Double.parseDouble(in.nextLine());
                                                        workShop.getItemsWithPriceMoreThan(minPrice);
                                                        //activeCollection = new ServicesProcessor(activeCollection).getItemsWithPriceMoreThan(minPrice);
                                                        break;
                                                    }
                                                    case 2:{
                                                        double maxPrice = Double.parseDouble(in.nextLine());
                                                        workShop.getItemsWithPriceLessThan(maxPrice);
                                                       // activeCollection = new ServicesProcessor(activeCollection).getItemsWithPriceLessThan(maxPrice);
                                                        break;
                                                    }
                                                    case 3:{
                                                        String search = in.nextLine();
                                                        workShop.filterByCategory(search);
                                                       // activeCollection = new ServicesProcessor(activeCollection).filterByCategory(search);
                                                        break;
                                                    }
                                                    case 4:{
                                                        workShop.reload();
                                                       // activeCollection  = workShop.getList();
                                                        System.out.println("Отменено!");
                                                        break;
                                                    }
                                                    case 5:{
                                                        workShop.sortAscending();
                                                      //  activeCollection = new ServicesProcessor(activeCollection).sortAscending();
                                                        break;
                                                    }
                                                    case 6:{
                                                        workShop.sortDescending();
                                                      //  activeCollection = new ServicesProcessor(activeCollection).sortDescending();
                                                        break;
                                                    }
                                                    case 7:{
                                                        try{
                                                            workShop.printList();
                                                            //activeCollection.forEach(System.out::println);
                                                        }catch (ConcurrentModificationException e){
                                                            System.out.println("Выполняется сортировка...");
                                                        }
                                                        break;
                                                    }
                                                    case 8:{
                                                        workShop.recoverData();
                                                        System.out.println("Данные восстановлены!");
                                                        break;
                                                    }
                                                    case 0:{break;}
                                                    default:
                                                        break;
                                                }
                                                if (index==0) break;
                                            }
                                        }catch (NumberFormatException e){
                                            System.out.println("Неверный ввод!");
                                        }

                                        break;
                                    }
                                    case 0: {
                                        break;
                                    }
                                    default:
                                        System.out.println("Неверный ввод...");
                                        break;
                                }
                            }catch (NumberFormatException e){
                                System.out.println("Неверный ввод!");
                            }
                            if(choice2.equals("0"))
                                break;

                        }
                    }
                    case MenuControls.CREATE_ORDER -> {
                        int index;
                        List<WService> list= workShop.getList();
                        while(true){
                            workShop.printList();
                            System.out.println("Введите индекс (0-Выход):");
                            index= Integer.parseInt(in.nextLine());
                            if(index==0)break;
                            if(index>workShop.listSize() || index<0){
                                System.out.println("Неверный ввод!");
                                continue;
                            }
                            ordersList.add(workShop.get(index-1));
                            System.out.println("Отобрано: "+ ordersList.size());
                        }
                        System.out.println("Сумма заказа$: "+ workShop.calculateTotalAmount(ordersList));
                        System.out.println("Срок в днях: "+ workShop.calculateTotalInDays(ordersList));
                        break;
                    }
                    case MenuControls.CUSTOMERS_LIST -> {
                       String choice2;

                        while (true){
                            initUsersList();
                            printCustomers();
                            System.out.println("1-Добавить  2-Удалить 3-Заблокировать 0-Назад");
                            choice2 = in.nextLine();
                            try {
                                switch (Integer.parseInt(choice2)) {
                                    case 1: {
                                        initUsersList();
                                        UserRegistrationDecorator userRegistrationDecorator = new UserRegistrationDecorator(new UserAuthManager());
                                        userRegistrationDecorator.login();
                                        initUsersList();
                                        break;
                                    }
                                    case 2: {
                                        initUsersList();
                                        System.out.println("Введите номер");
                                        int index = Integer.parseInt(in.nextLine());
                                        customersDbIterator.update(DBMethod.DEL.method, userData.get(index-1));

                                        break;
                                    }
                                    case 3: {
                                        initUsersList();
                                        System.out.println("Введите номер");
                                        int index = Integer.parseInt(in.nextLine());
                                        UserData oldValuew =  userData.get(index-1);
                                        if(!oldValuew.getRole().equals(Role.ADMIN.role)){
                                            UserData userData1 = new UserData(Role.BLOCK.role, oldValuew.getName(),oldValuew.getPassword());
                                            customersDbIterator.update(DBMethod.ADD.method, userData1);
                                            customersDbIterator.update(DBMethod.DEL.method, oldValuew);
                                            initUsersList();
                                        }

                                        break;
                                    }
                                    case 0: {
                                        break;
                                    }
                                    default:
                                        System.out.println("Неверный ввод...");
                                        break;
                                }
                            }catch (NumberFormatException e){
                                System.out.println("Неверный ввод!");
                            }
                            if(choice2.equals("0"))
                                break;

                        }

                        System.out.println("Введите индекс (0-Выход):");
                        int index= Integer.parseInt(in.nextLine());
                        if(index==0)break;
                        if(index>customersDbIterator.count() || index<0){
                            System.out.println("Неверный ввод!");
                            continue;
                        }

                        break;
                    }
                    case MenuControls.EXIT -> {
                        return;
                    }
                    default -> System.out.println("Неверный ввод!");
                }
            }
        }catch (NumberFormatException e){
            System.out.println("Неверный ввод!");
        };



    }
    private void printCustomers(){
        int count=0;
       for (UserData item:userData){
           count+=1;
           System.out.println(count+") "+item.toString());
       }
        customersDbIterator.reset();
    }
    private void initUsersList(){
        if(userData.size()!=0){
            userData.clear();
        }
        while (customersDbIterator.hasNext()){
            userData.add(customersDbIterator.getNext());
        }
        customersDbIterator.reset();
    }

}
