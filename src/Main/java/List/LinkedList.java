/**
 * Created by Taras on 02.12.2016.
 */
public class LinkedList<T> implements IList<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    private static class Node<T> {
        private Node<T> next = null;
        T data;

        private Node(T data) {
            this.data = data;
        }
    }

    @Override
    public void add(T value) {
        if(head == null){
            head = new Node<>(value);
            tail = head;
        }
        else {
//            Node<T> tail = head;
//            while (tail.next != null){
//                tail = tail.next;
//            }
            tail.next = new Node<>(value);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public void insert(T value, int position) {
        if(!isPositionCorrect(position) && position != 0)
            throw new IndexOutOfBoundsException();
        if(position == 0){
            Node<T> insert = new Node<T>(value);
            insert.next = head;
            head = insert;
        }
        int count = 0;
        Node<T> previous = head;
        while (count < position - 1){
            previous = previous.next;
            count++;
        }
        Node<T> insert = new Node<>(value);
        insert.next = previous.next;
        previous.next = insert;
        size++;
    }

    @Override
    public void remove(int position) {
        if(!isPositionCorrect(position))
            throw new IndexOutOfBoundsException();
        if(position == 0) {
            head = head.next;
            size--;
            return;
        }
        Node previous = getElementOnCurrentPosition(position - 1);
        Node current = previous.next;
        previous.next = current.next;
        size--;
        if(position == size - 2) {
            tail = previous.next;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int position) {
        if(!isPositionCorrect(position))
            throw new ArrayIndexOutOfBoundsException(position);
        Node temp = getElementOnCurrentPosition(position);
        return (T) temp.data;
    }

    @Override
    public void set(T value, int position) {
        if(!isPositionCorrect(position))
            throw new ArrayIndexOutOfBoundsException(position);
        Node temp = getElementOnCurrentPosition(position);
        temp.data = value;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray() {
        T[] data = (T[]) new Object[size];
        for(int i=0; i<size; i++){
            data[i] = (T) getElementOnCurrentPosition(i).data;
        }
        return data;
    }

    @Override
    public int size() {
        return size;
    }

    private Boolean isPositionCorrect(int position){
        return !(position < 0 || position >= size);
    }

    private Node getElementOnCurrentPosition(int position){
        Node<T> temp = head;
        for(int i=0; i < position; i++){
            temp = temp.next;
        }
        return temp;
    }
}
