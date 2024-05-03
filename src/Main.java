import DataOperations.App;
public class Main {
    public static void main(String[] args)

    {
//        WorkShop workShop  = new WorkShop();
//        List<WService> activeCollection = workShop.getList();
//        String choice;
//        Scanner in = new Scanner(System.in);
//        List<WService> ordersList = new ArrayList<>();
//        try {
//            while(true) {
//                System.out.println("1-Редактировать список");
//                System.out.println("2-Создать заказ");
//                System.out.println("0-Выйти");
//                choice = in.nextLine();
//                switch (Integer.parseInt(choice)) {
//                    case MenuControls.SHOW_LIST -> {
//                        String choice2;
//                        while (true){
//                            activeCollection.forEach(System.out::println);
//                            System.out.println("1-Добавить  2-Удалить 3-Фильтрация 0-Назад");
//                            choice2 = in.nextLine();
//                            try {
//                                switch (Integer.parseInt(choice2)) {
//                                    case 1: {
//                                        System.out.println("Введите данные");
//                                        System.out.print("Название ");
//                                        String name = in.nextLine();
//                                        System.out.print("Цена ");
//                                        double price = Double.parseDouble(in.nextLine());
//                                        System.out.print("Срок ");
//                                        int days = Integer.parseInt(in.nextLine());
//                                        workShop.addService(new WService(price,name,days, ServicesProcessor.getServiceID()));
//                                        break;
//                                    }
//                                    case 2: {
//                                        System.out.println("Введите номер");
//                                        int index = Integer.parseInt(in.nextLine());
//                                        int serviceID = activeCollection.get(index-1).getThis_ID();
//                                        System.out.println(serviceID);
//                                        workShop.deleteService(serviceID);
//                                        activeCollection = workShop.getList();
//                                        break;
//                                    }
//                                    case 3:{
//                                        try {
//                                            while (true){
//                                                System.out.println("1-Мин. цена 2-Макс. цена 3-По названию 4-Отменить 5-Сортировка по возрастанию 6-Сортировка по убыванию 7-Открыть список 0-Назад");
//                                                int index = Integer.parseInt(in.nextLine());
//                                                System.out.println("Введите значение: ");
//                                                switch (index){
//                                                    case 1:{
//                                                        double minPrice = Double.parseDouble(in.nextLine());
//                                                        activeCollection = new ServicesProcessor(activeCollection).getItemsWithPriceMoreThan(minPrice);
//                                                        break;
//                                                    }
//                                                    case 2:{
//                                                        double maxPrice = Double.parseDouble(in.nextLine());
//                                                        activeCollection = new ServicesProcessor(activeCollection).getItemsWithPriceLessThan(maxPrice);
//                                                        break;
//                                                    }
//                                                    case 3:{
//                                                        String search = in.nextLine();
//                                                        activeCollection = new ServicesProcessor(activeCollection).filterByCategory(search);
//                                                        break;
//                                                    }
//                                                    case 4:{
//                                                        activeCollection  = workShop.getList();
//                                                        System.out.println("Отменено!");
//                                                        break;
//                                                    }
//                                                    case 5:{
//                                                        activeCollection = new ServicesProcessor(activeCollection).sortAscending();
//                                                        break;
//                                                    }
//                                                    case 6:{
//                                                        activeCollection = new ServicesProcessor(activeCollection).sortDescending();
//                                                        break;
//                                                    }
//                                                    case 7:{
//                                                        try{
//                                                            activeCollection.forEach(System.out::println);
//                                                        }catch (ConcurrentModificationException e){
//                                                            System.out.println("Выполняется сортировка...");
//                                                        }
//                                                        break;
//                                                    }
//                                                    case 0:{break;}
//                                                    default:
//                                                        break;
//                                                }
//                                                if (index==0) break;
//                                            }
//                                        }catch (NumberFormatException e){
//                                            System.out.println("Неверный ввод!");
//                                        }
//
//                                        break;
//                                    }
//                                    case 0: {
//                                        break;
//                                    }
//                                    default:
//                                        System.out.println("Неверный ввод...");
//                                        break;
//                                }
//                            }catch (NumberFormatException e){
//                                System.out.println("Неверный ввод!");
//                            }
//                            if(choice2.equals("0"))
//                                break;
//
//                        }
//                    }
//                    case MenuControls.CREATE_ORDER -> {
//                        int index;
//                        List<WService>  list= workShop.getList();
//                        while(true){
//                            workShop.printList();
//                            System.out.println("Введите индекс (0-Выход):");
//                            index= Integer.parseInt(in.nextLine());
//                            if(index==0)break;
//                            if(index>list.size() && index<0){
//                                System.out.println("Неверный ввод!");
//                                continue;
//                            }
//                            ordersList.add(list.get(index-1));
//                            System.out.println("Отобрано: "+ ordersList.size());
//                        }
//                        System.out.println("Сумма заказа$: "+ workShop.calculateTotalAmount(ordersList));
//                        System.out.println("Срок в днях: "+ workShop.calculateTotalInDays(ordersList));
//                        break;
//                    }
//                    case MenuControls.EXIT -> {
//                        return;
//                    }
//                    default -> System.out.println("Неверный ввод!");
//                }
//            }
//        }catch (NumberFormatException e){
//            System.out.println("Неверный ввод!");
//        };
//        }
        App root = new App();
        root.start();
    }
}


