/**
 * Created by Taras on 02.12.2016.
 */
public interface IList<T> {
    void add(T value);
    Boolean insert(T value, int position);
    Boolean remove(int position);
    T get(int position);
    Boolean set(T value, int position);
    void clear();
    IList clone();
    T[] toArray();
    int size();
    default int capacity(){
        System.out.println("Linkedlist haven't implemebtation for this method");
        return -1;
    }
}
