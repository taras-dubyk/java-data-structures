import java.util.Arrays;

/**
 * Created by Taras on 02.12.2016.
 */
public class ArrayList<T> implements IList<T> {
    private T[] array;
    private int size;
    private int capacity;

    public ArrayList(int size) throws ClassCastException {
        capacity = size;
        this.size = 0;
        array = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        makeArrayExtendingIfNeeded();
        array[size] = value;
        size++;
    }

    @Override
    public Boolean insert(T value, int position) {
        if(!isPositionCorrect(position))
            return false;
        makeArrayExtendingIfNeeded();
//        for(int i = size; i > position; i--){
//            array[i] = array[i - 1];
//        }
        System.arraycopy(array, position, array, position + 1, size - position);
        array[position] = value;
        size++;
        return true;
    }

    @Override
    public Boolean remove(int position) {
        if(!isPositionCorrect(position))
            return false;
        makeArrayExtendingIfNeeded();
//        for(int i = position; i < size; i++){
//            array[i] = array[i + 1];
//        }
        System.arraycopy(array, position + 1, array, position, size - position - 1);
        size--;
        return true;
    }

    @Override
    public T get(int position) {
        if(!isPositionCorrect(position))
            return null;
        return array[position];
    }

    @Override
    public Boolean set(T value, int position) {
        if(!isPositionCorrect(position))
            return false;
        array[position] = value;
        return true;
    }

    @Override
    public void clear() {
        array = (T[]) new Object[10];
        size = 0;
        capacity = 0;
    }

    @Override
    public IList clone() {
        return null;
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOfRange(array, 0, size - 1);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    private void extendArray(){
        int newSize = capacity * 2;
        array = Arrays.copyOf(array, newSize);
        capacity = newSize;
        System.out.println("in extend " + capacity);
    }

    private void makeArrayExtendingIfNeeded(){
        if (size == capacity)
            extendArray();
    }

    private Boolean isPositionCorrect(int position){
        return !(position < 0 || position >= size());
    }
}
