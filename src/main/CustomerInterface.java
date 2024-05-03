package main;

import DataOperations.DataIterator;
import DataOperations.ServicesDataBase;
import DataOperations.ServicesDbIterator;
import Utils.MenuControls;
import Utils.ServicesProcessor;

import java.security.Provider;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Scanner;

public class CustomerInterface implements UserInterface{
    private DataIterator<WService> serviceDataIterator;
    private List<WService> list = new ArrayList<>();
    private void init(){
        while (serviceDataIterator.hasNext()){
            list.add(serviceDataIterator.getNext());
        }
        serviceDataIterator.reset();
    }
    private void printList(){
        if(serviceDataIterator.hasNext()){
            int counter=0;
            while(serviceDataIterator.hasNext()){
                counter+=1;
                System.out.print(counter+") ");
                System.out.println(serviceDataIterator.getNext().toString());
            }
            serviceDataIterator.reset();
        }else{
            System.out.println("Список пуст");
        }
    }
    @Override
    public void show() {

        CustomerWorkShop customerWorkShop = new WorkShop();
        Scanner in = new Scanner(System.in);
        serviceDataIterator = ServicesDataBase.getInstance().createIterator();
        System.out.println("Добро пожаловать в магазин услуг нашего Автосервиса");
        List<WService> ordersList = new ArrayList<>();
        String choice;
        init();
        try {
            while(true) {
                System.out.println("1-Открыть каталог");
                System.out.println("0-Выйти");
                choice = in.nextLine();
                switch (Integer.parseInt(choice)) {
                    case MenuControls.SHOW_LIST -> {
                        String choice2;
                        while (true){
                            // activeCollection.forEach(System.out::println);
                            printList();
                            System.out.println("1-Создать заказ 0-Назад");
                            choice2 = in.nextLine();
                            try {
                                switch (Integer.parseInt(choice2)) {
                                    case 0: {
                                        break;
                                    }
                                    case 1: {
                                        int index;
                                        while(true){
                                            System.out.println("Введите индекс (0-Выход):");
                                            index= Integer.parseInt(in.nextLine());
                                            if(index==0)break;
                                            if(index>list.size() || index<0){
                                                System.out.println("Неверный ввод!");
                                                continue;
                                            }
                                            ordersList.add(list.get(index-1));
                                            System.out.println("Отобрано: "+ ordersList.size());
                                        }
                                        System.out.println("Сумма заказа$: "+ customerWorkShop.calculateTotalAmount(ordersList));
                                        System.out.println("Срок в днях: "+ customerWorkShop.calculateTotalInDays(ordersList));
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
}
