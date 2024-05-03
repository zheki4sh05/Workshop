package DataOperations;

public interface DataIterator<T> {
    boolean hasNext();

    T getNext();

    void reset();
}
