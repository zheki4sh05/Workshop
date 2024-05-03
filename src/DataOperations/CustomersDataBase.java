package DataOperations;

import User.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomersDataBase implements DataBaseEntity<CustomersDbIterator,UserData>{
    private static int count=0;
    private String pass = "admin111";
    private String login = "admin111";
    private UserData activeUser;
    private static final CustomersDataBase INSTANCE = new CustomersDataBase();
    private List<UserData> list = new ArrayList<>();
    {
            list.add(new UserData(Role.CUSTOMER.role, "Pazaree","1234567890"));
            list.add(new UserData(Role.CUSTOMER.role,"RoyGreen","1234567890"));
            list.add(new UserData(Role.CUSTOMER.role,"HowardWells","1234567890"));
            list.add(new UserData(Role.CUSTOMER.role,"user123","user123"));
            list.add(new UserData(Role.ADMIN.role, login,pass));
            count = list.size();
    }
    public static CustomersDataBase getInstance(){
        return INSTANCE;
    }
    private CustomersDataBase(){};

    @Override
    public CustomersDbIterator createIterator() {
        return new CustomersDbIterator(this);
    }

    @Override
    public List<UserData> requestDataFromAPI() {
        return new ArrayList<UserData>();
    }

    @Override
    public void remove(UserData item) {
        list.remove(item);
        count-=1;
    }

    @Override
    public UserData get(int index) {
        return list.get(index);
    }

    @Override
    public void add(UserData customer) {
        list.add(customer);
        count+=1;
    }
    public void setActiveUser(UserData user){
        if(user.getName().equals(login) && user.getPassword().equals(pass)){
            this.activeUser= new UserData(Role.ADMIN.role, login,pass);
        }else{
            this.activeUser = user;
        }

    }
    public UserData getActiveUser() {
        return activeUser;
    }
    public static int getCount() {
        return count;
    }

}
