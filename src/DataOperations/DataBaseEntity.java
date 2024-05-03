package DataOperations;

import main.WService;

import java.util.List;

public interface DataBaseEntity<T,K> {
    T createIterator();
    List<K> requestDataFromAPI();
    public void remove(K item);
    public K get(int index);
    public void add(K wService);

}
