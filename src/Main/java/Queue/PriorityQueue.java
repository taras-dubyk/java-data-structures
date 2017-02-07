public class PriorityQueue<T extends Comparable<T>> extends Structure<T> {

    public PriorityQueue(int initialSize) {
        super(initialSize);
        array = (T[]) new Comparable[initialSize];
    }

    public void push(T value){
        if(lastElementIndex == size - 1)
            extendArray();
        T temp;
        if(lastElementIndex == 0)
            array[lastElementIndex++] = value;
        else {
            for(int i = firstElementIndex; i < lastElementIndex; i++){
                if(value.compareTo(array[i]) < 0){
                    temp = array[i];
                    array[i] = value;
                    for(int j = lastElementIndex; j > i+1; j--){
                        array[j] = array[j-1];
                    }
                    array[i + 1] = temp;
                    lastElementIndex++;
                    return;
                }
            }
            array[lastElementIndex++] = value;
        }
    }
}
