import java.util.Arrays;

/**
 * Created by Taras on 02.12.2016.
 */
public class ArrayList<T> implements IList<T> {
    private Object[] array;
    private int size;
    private int capacity;

    public ArrayList(int size) {
        capacity = size;
        array = new Object[capacity];
    }

    @Override
    public void add(T value) {
        makeArrayExtendingIfNeeded();
        array[size] = value;
        size++;
    }

    @Override
    public void insert(T value, int position) {
        if(!isPositionCorrect(position))
            throw new IndexOutOfBoundsException();
        makeArrayExtendingIfNeeded();
//        for(int i = size; i > position; i--){
//            array[i] = array[i - 1];
//        }
        System.arraycopy(array, position, array, position + 1, size - position);
        array[position] = value;
        size++;
    }

    @Override
    public void remove(int position) {
        if(!isPositionCorrect(position))
            throw new IndexOutOfBoundsException();
        makeArrayExtendingIfNeeded();
//        for(int i = position; i < size; i++){
//            array[i] = array[i + 1];
//        }
        System.arraycopy(array, position + 1, array, position, size - position - 1);
        size--;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int position) {
        if(!isPositionCorrect(position))
            return null;
        return (T) array[position];
    }

    @Override
    public void set(T value, int position) {
        if(!isPositionCorrect(position))
            throw new IndexOutOfBoundsException();
        array[position] = value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        array = (T[]) new Object[10];
        size = 0;
        capacity = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray() {
        return Arrays.copyOfRange((T[]) array, 0, size - 1);
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
