public class Queue<T> extends Structure<T> {

    public Queue(int size) {
        super(size);
        array = (T[]) new Object[initialSize];
    }

    public void push(T value){
        if(lastElementIndex == size - 1)
            extendArray();
        array[lastElementIndex++] = value;
    }
}
