import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by taras on 07.02.17.
 */
public class LinkedListTest {

    private static LinkedList<String> list;
    private static int N = 50;

    private void addElements(int n){
        list = new LinkedList<>();
        for(int i = 0; i < n; i++)
            list.add(Integer.toString(i));
    }

    private void addElements(){
        addElements(N);
    }

    @Test
    public void testAdd() {
        addElements();

        for(int i = 0; i < N; i++) {
            assertEquals(Integer.toString(i), list.get(i));
        }
    }

    @Test()
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



}
