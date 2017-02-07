import java.util.EmptyStackException;

public class Stack<T> extends Structure<T> {

    public Stack(int size) {
        super(size);
        array = (T[]) new Object[initialSize];
    }

    public void push(T value){
        if(lastElementIndex == size - 1)
            extendArray();
        array[lastElementIndex++] = value;
    }

    @Override
    public T pop(){
        if(firstElementIndex == lastElementIndex)
            throw new EmptyStackException();
        if(lastElementIndex - firstElementIndex < size / 2 && initialSize < size)
            shrink();
        return array[--lastElementIndex];
    }

    @Override
    public T pick(){
        if(firstElementIndex == lastElementIndex)
            throw new EmptyStackException();
        return array[lastElementIndex - 1];
    }
}


