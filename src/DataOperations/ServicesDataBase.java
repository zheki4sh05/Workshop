package DataOperations;

import User.Customer;
import Utils.ServicesProcessor;
import main.WService;

import java.util.ArrayList;
import java.util.List;

public class ServicesDataBase implements DataBaseEntity<ServicesDbIterator,WService>{
    public static int count=0;
    private void init(){
        this.wServiceList = new ArrayList<>();
        wServiceList.add(new WService(20,"Замена жидкостей",3, ServicesProcessor.getServiceID()));
        wServiceList.add(new WService(10,"Замена колодок",2, ServicesProcessor.getServiceID()));
        wServiceList.add(new WService(12,"Развал схождения",1, ServicesProcessor.getServiceID()));
        ServicesDataBase.count = wServiceList.size();
    }
    {
        init();
    }
    private static final ServicesDataBase INSTANCE = new ServicesDataBase();
    private List<WService> wServiceList;
    public static ServicesDataBase getInstance(){
        return INSTANCE;
    }
    private ServicesDataBase(){};

    @Override
    public ServicesDbIterator createIterator() {
        return new ServicesDbIterator(this);
    }

    @Override
    public List<WService> requestDataFromAPI() {
       return  this.wServiceList;
    }
    public boolean save(){
        return false;
    }
    public void remove(WService wService){
        wServiceList.remove(wService);
        count-=1;
    }
    public WService get(int index) {
        return wServiceList.get(index);
    }
    public void add(WService wService) {
         wServiceList.add(wService);
         count+=1;
    }


 }
