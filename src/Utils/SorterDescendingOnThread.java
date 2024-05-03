package Utils;

import main.WService;

import java.util.Collections;
import java.util.List;
public class SorterDescendingOnThread extends Thread{
    private List<WService> list =null;
    SorterDescendingOnThread(List<WService> list) {
        this.list = list;
    }
    @Override
    public void run() {

        Collections.reverse(list);
    }
    public List<WService> getResultCollection(){
        return this.list;
    }
}
