package DataOperations;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;

public class WorkShopDataBase {

    private UserData userData;
    private static final WorkShopDataBase INSTANCE = new WorkShopDataBase();


    public WorkShopDataBase getInstance(){
        return this. INSTANCE;
    }
    private WorkShopDataBase(){};
    public void setUserData(){

    }
}
