package Utils;

import main.WService;

import java.util.List;
import java.util.stream.Collectors;

public class ServicesProcessor {
    private static int serviceID=0;

    private final List<WService> originalCollection;
    public ServicesProcessor(List<WService> list){
        originalCollection = list;
    }
    public List<WService> getItemsWithPriceMoreThan(double minPrice){
        return originalCollection.stream().filter(s->s.getPrice()>=minPrice).collect(Collectors.toList());
    }
    public List<WService> getItemsWithPriceLessThan(double maxPrice){
        return originalCollection.stream().filter(s->s.getPrice()<=maxPrice).collect(Collectors.toList());
    }
    public  List<WService> filterByCategory(String name){
        return originalCollection.stream().filter(s->s.getName().contains(name)).collect(Collectors.toList());
    }
    public List<WService> sortAscending(){
        SorterAscendingRunnable sorter = new SorterAscendingRunnable(originalCollection);
        Thread sorterThread = new Thread(sorter);
        sorterThread.start();
        try {
            sorterThread.join();
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        return sorter.getResultCollection();
    }
    public List<WService> sortDescending(){
        SorterDescendingOnThread sorter = new SorterDescendingOnThread(originalCollection);
        sorter.start();
        try {
            sorter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return sorter.getResultCollection();
    }

    public static int getServiceID(){
        return serviceID+=1;
    }
}
