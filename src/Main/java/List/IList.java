/**
 * Created by Taras on 02.12.2016.
 */
public interface IList<T> {
    void add(T value);
    void insert(T value, int position);
    void remove(int position);
    T get(int position);
    void set(T value, int position);
    void clear();
    T[] toArray();
    int size();
    default int capacity(){
        System.out.println("Linkedlist haven't implementation for this method");
        return -1;
    }
}
