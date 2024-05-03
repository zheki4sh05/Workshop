package Utils;

import main.WService;

import java.util.Collections;
import java.util.List;
public class SorterAscendingRunnable implements Runnable{
    private List<WService> list =null;
    SorterAscendingRunnable(List<WService> list) {
        this.list = list;
    }
    @Override
    public void run() {
        Collections.sort(list);
    }
    public List<WService> getResultCollection(){
        return this.list;
    }
}
