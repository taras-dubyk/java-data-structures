//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;


import org.junit.Test;

//import java.util.*;
//import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by taras on 07.02.17.
 */
public class LinkedListTest {

    private static LinkedList<Integer> list;
    private static int N = 50;

    private void addElements(int n){
        list = new LinkedList<>();
        for(int i = 0; i < n; i++)
            list.add(i);
    }

    private void addElements(){
        addElements(N);
    }

    @Test
    public void testAdd() {
        addElements();

        for(int i = 0; i < N; i++) {
            assertEquals((Integer) i, list.get(i));
        }
    }

    @Test
    public void testSize() {
        int a = 0;
        int b = 555;
        int c = 545645;

        addElements(a);
        assertEquals(a, list.size());

        addElements(b);
        assertEquals(b, list.size());

        addElements(c);
        assertEquals(c, list.size());
    }

    @Test
    public void testInsertValueOnTheFirstPositionForEmptyList() {
        int value = 5;
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(value, 0);
        assertEquals(1, list.size());
        assertEquals(value, (int)list.get(0));
    }

    @Test
    public void testInsertValueOnTheMiddlePositionForNotEmptyList() {
        int value = 5;
        int n = 500;
        int insertPosition = 250;
        addElements(n);
        list.insert(value, insertPosition);
        assertEquals(n + 1, list.size());
        assertEquals(value, (int)list.get(insertPosition));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertValueOnTheLastPositionForNotEmptyList() {
        int value = 5;
        int n = 500;
        int insertPosition = n + 1;
        addElements(n);
        list.insert(value, insertPosition);
    }

    @Test
    public void testRemove() {
        int n = 1015;
        int elementPosition = 387;
        addElements(n);
        int mustBeDeleted = list.get(elementPosition);
        list.remove(elementPosition);
        assertEquals(n - 1, list.size());
        assertNotEquals(mustBeDeleted, (int)list.get(elementPosition));
    }

    @Test
    public void testRemoveFirstElement() {
        int n = 100;
        int elementPosition = 0;
        addElements(n);
        int mustBeDeleted = list.get(elementPosition);
        list.remove(elementPosition);
        assertNotEquals(mustBeDeleted, (int) list.get(elementPosition));
        assertEquals(n - 1, list.size());
    }

    @Test
    public void testSet() {
        int n = 500125;
        int value = 777;
        int position = 263005;
        addElements(n);
        list.set(value, position);
        assertEquals(n, list.size());
        assertEquals(value, (int)list.get(position));
    }

    @Test
    public void test() {
        java.util.List<Integer> ll = new java.util.LinkedList<>();
        for(int i = 0; i < 500000; i++) {
            ll.add(i);
        }
        ll.set(263005, 777);
        assertEquals(777, (int)ll.get(263005));
    }

}
