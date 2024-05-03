package DataOperations;

import User.Customer;
import main.WService;
import main.WorkShop;

import java.util.ArrayList;
import java.util.List;

public class ServicesDbIterator implements DataIterator<WService>{
    private ServicesDataBase servicesDataBase;
    private int currentPosition = 0;
    public ServicesDbIterator(ServicesDataBase servicesDataBase) {
        this.servicesDataBase = servicesDataBase;
    }

    @Override
    public boolean hasNext() {
        return currentPosition<ServicesDataBase.count;
    }

    @Override
    public WService getNext() {
        if (!hasNext()){
            return null;
        }
       WService wService = servicesDataBase.get(currentPosition);
        currentPosition++;
        return wService;
    }
    public void update(String name,WService wService){
        switch (name){
            case "DEL":{
                servicesDataBase.remove(wService);
                break;
            }
            case "ADD":{
                servicesDataBase.add(wService);
                break;
            }
        }
    }
    @Override
    public void reset() {
        currentPosition=0;
    }
    public int count(){
        return ServicesDataBase.count;
    }
}
