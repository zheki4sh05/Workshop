package main;

import DataOperations.DBMethod;
import DataOperations.ServicesDataBase;
import DataOperations.ServicesDbIterator;
import Utils.ServiceSummarizer;
import Utils.ServicesProcessor;
import main.WService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WorkShop implements CustomerWorkShop{
    private List<WService> list = new ArrayList<>();
    private List<WService> basket = new ArrayList<>();
    private final ServicesDbIterator servicesDbIterator = new ServicesDbIterator(ServicesDataBase.getInstance());
    public WorkShop(){
        reload();
    }
    public void addService(WService wService){
        servicesDbIterator.update(DBMethod.ADD.method, wService);
        reload();
    }
    public void deleteService(int index){
        WService wService = list.get(index-1);
        System.out.println(wService.getThis_ID());
        try{
           // list = list.stream().filter(item->item.getThis_ID()!=index).collect(Collectors.toList());
            servicesDbIterator.update(DBMethod.DEL.method, wService);
            basket.add(wService);
            reload();
        }catch (IndexOutOfBoundsException e){
            System.out.println("Неверный индекс");
        }

    }
    public List<WService> getList(){
        return list;
    }
    public void printList(){
        if(list.size()!=0){
            int counter=0;
           for(WService wService :list){
               counter+=1;
               System.out.print(counter+") ");
               System.out.println(wService.toString()); ;

           }
        }
        else{
            System.out.println("Список пуст");
        }
//        if(servicesDbIterator.hasNext()){
//            int counter=0;
//            while(servicesDbIterator.hasNext()){
//
//            }
//            servicesDbIterator.reset();
//        }else{
//            System.out.println("Список пуст");
//        }
//       else if(!servicesDbIterator.hasNext(){
//            System.out.println("Список пуст");
//        }
//        if(servicesDbIterator.hasNext()){
//            for(int i=0; i < list.size() ;i++){
//                System.out.println(i+1+")"+" "+list.get(i).toString());
//            }
//        }else{
//
//        }
    }
    private double summarizeTransactions(ServiceSummarizer serviceSummarizer, List<WService> orderedList){
        double result = 0;
        for (final WService bankTransaction : orderedList) {
            result = serviceSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }
   public double calculateTotalAmount(List<WService> orderedList) {
        return summarizeTransactions((acc,service)->{
            return acc+service.getPrice();
        },orderedList);
    }
    public double calculateTotalInDays(List<WService> orderedList){
        return summarizeTransactions((acc,service)->{
            return acc+service.getDays();
        },orderedList);
    }

    public void getItemsWithPriceMoreThan(double minPrice) {
        list = new ServicesProcessor(list).getItemsWithPriceMoreThan(minPrice);
    }

    public void getItemsWithPriceLessThan(Double maxPrice) {
        list=   new ServicesProcessor(list).getItemsWithPriceLessThan(maxPrice);
    }

    public void filterByCategory(String search) {
        list=  new ServicesProcessor(list).filterByCategory(search);
    }

    public void reload() {
        if(list.size()!=0){
            list.clear();
        }
        while (servicesDbIterator.hasNext()){
            list.add(servicesDbIterator.getNext());
        }
        servicesDbIterator.reset();
    }

    public void sortAscending() {
        list= new ServicesProcessor(list).sortAscending();
    }

    public void sortDescending() {
        list = new ServicesProcessor(list).sortDescending();
    }
    public int listSize(){
        return servicesDbIterator.count();
    }
    public WService get(int index){
       return list.get(index);
    }

    public void recoverData() {
        if(basket.size()!=0){
            for(WService wService:basket){
                servicesDbIterator.update(DBMethod.ADD.method, wService);
            }
            reload();
            basket.clear();
        }
    }
}
