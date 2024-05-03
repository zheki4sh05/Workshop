package DataOperations;

import User.Customer;
import main.WService;

import java.util.ArrayList;
import java.util.List;

public class CustomersDbIterator implements DataIterator<UserData>{
    private CustomersDataBase customersDataBase;
    private List<Customer> customerList = new ArrayList<>();
    private int currentPosition = 0;
    public CustomersDbIterator(CustomersDataBase customersDataBase) {
        this.customersDataBase = customersDataBase;
    }
    @Override
    public UserData getNext() {
       if (!hasNext()){
           return null;
       }

        UserData customer = customersDataBase.get(currentPosition);
        currentPosition++;
       return customer;
    }

    public boolean hasNext() {
        return currentPosition<CustomersDataBase.getCount();
    }

    public void update(String name,UserData customer){
        switch (name){
            case "DEL":{
                customersDataBase.remove(customer);
                break;
            }
            case "ADD":{
                customersDataBase.add(customer);
                break;
            }
        }
    }
    @Override
    public void reset() {
        currentPosition=0;
    }
    public int count(){
        return CustomersDataBase.getCount();
    }

}
