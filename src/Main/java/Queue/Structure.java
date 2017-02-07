import java.util.Arrays;
import java.util.EmptyStackException;

abstract class Structure<T> {
    T[] array;
    int initialSize;
    int size;
    int lastElementIndex;
    int firstElementIndex;

    Structure(int initialSize) {
        this.initialSize = size = initialSize;
//        array = (T[]) new Comparable[initialSize];
        lastElementIndex = 0;
        firstElementIndex = 0;
    }

    public T pop(){
        if(firstElementIndex == lastElementIndex)
            throw new EmptyStackException();
        if(lastElementIndex - firstElementIndex < size / 2 && initialSize < size)
            shrink();
        return array[firstElementIndex++];
    }

    public T pick(){
        if(firstElementIndex == lastElementIndex)
            throw new EmptyStackException();
        return array[firstElementIndex];
    }

    public int size(){
        return lastElementIndex - firstElementIndex;
    }

    public void clean(){
        array = (T[]) new Object[initialSize];
        lastElementIndex = 0;
        firstElementIndex = 0;
    }

    public T[] toArray(){
        return Arrays.copyOfRange(array, firstElementIndex, lastElementIndex);
    }

    void extendArray(){
        int newSize = size * 2;
        array = Arrays.copyOf(array, newSize);
        size = newSize;
        System.out.println("in extend " + size);
    }

    void shrink(){
        size /= 2;
        T[] tempArray = Arrays.copyOfRange(array, firstElementIndex, lastElementIndex);
        array = Arrays.copyOf(tempArray, size);
        lastElementIndex -= firstElementIndex;
        firstElementIndex = 0;
        System.out.println("In shrink " + size);
//        System.arraycopy(array, 0, tempArray, 0, array.length);
    }
}
