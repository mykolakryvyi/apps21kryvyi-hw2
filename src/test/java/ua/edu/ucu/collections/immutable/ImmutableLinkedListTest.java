package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;


public class ImmutableLinkedListTest {
    private Object[] data;

    @Test
    public void add() {
        data = new Object[] {1, 2, 3, 4, 5};
        ImmutableList actualList1 = new ImmutableLinkedList(data);
        ImmutableList actualList2 = actualList1.add(6);
        Object[] expectedData = new Object[] {1, 2, 3, 4, 5, 6};
        assertArrayEquals(data, actualList1.toArray());
        assertArrayEquals(expectedData, actualList2.toArray());
    }

    @Test
    public void testAdd() {
        data = new Object[] {1, 2, 3, 4, 5};
        ImmutableList actualList1 = new ImmutableLinkedList(data);
        ImmutableList actualList2 = actualList1.add(0, 6);
        Object[] expectedData = new Integer[] {6, 1, 2, 3, 4, 5};
        assertArrayEquals(data, actualList1.toArray());
        assertArrayEquals(expectedData, actualList2.toArray());
    }

    @Test
    public void addAll() {
        data = new Object[] {1, 2, 3, 4, 5};
        ImmutableList actualList1 = new ImmutableLinkedList(data);
        ImmutableList actualList2 = actualList1.addAll(new Integer[] {6, 7});
        Integer[] expectedData = new Integer[] {1, 2, 3, 4, 5, 6, 7};
        assertArrayEquals(data, actualList1.toArray());
        assertArrayEquals(expectedData, actualList2.toArray());
    }
    @Test
    public void testGet() {
        data = new Object[] {1, 2, 3, 4, 5};
        ImmutableList actualArr = new ImmutableLinkedList(data);
        assertEquals(1, actualArr.get(0));
    }

    @Test
    public void remove() {
        data = new Object[] {1, 2, 3, 4, 5};
        ImmutableList actualList1 = new ImmutableLinkedList(data);
        ImmutableList actualList2 = actualList1.remove(2);
        Object[] expectedData = new Integer[] {1, 2, 4, 5};
        assertArrayEquals(expectedData, actualList2.toArray());
    }

    @Test
    public void set() {
        data = new Object[] {1, 2, 3, 4, 5};
        ImmutableList actualList1 = new ImmutableLinkedList(data);
        ImmutableList actualList2 = actualList1.set(0, 0);
        Object[] expectedData = new Integer[]  {0, 2, 3, 4, 5};
        assertArrayEquals(data, actualList1.toArray());
        assertArrayEquals(expectedData, actualList2.toArray());
    }

    @Test
    public void indexOf() {
        data = new Object[] {1, 2, 3, 4, 5};
        ImmutableList actualList1 = new ImmutableLinkedList(data);
        assertEquals(0, actualList1.indexOf(1));
        assertEquals(-1, actualList1.indexOf(10));
    }

    @Test
    public void size() {
        data = new Object[] {1, 2, 3, 4, 5};
        ImmutableList actualList1 = new ImmutableLinkedList(data);
        assertEquals(5, actualList1.size());
    }

    @Test
    public void clear() {
        data = new Object[] {1, 2, 3, 4, 5};
        ImmutableList actualList1 = new ImmutableLinkedList(data);
        ImmutableList actualList2 = actualList1.clear();
        Object[] expectedData = new Integer[] {};
        assertArrayEquals(expectedData, actualList2.toArray());
    }

    @Test
    public void isEmpty() {
        ImmutableList actualList1 = new ImmutableLinkedList();
        assertTrue(actualList1.isEmpty());
    }

    @Test
    public void toArray() {
        data = new Object[] {1, 2, 3, 4, 5};
        ImmutableList actualList1 = new ImmutableLinkedList(data);
        assertArrayEquals(data, actualList1.toArray());
    }

    @Test
    public void testAddFirst() {
        data = new Object[] {1, 2, 3, 4, 5};
        ImmutableLinkedList actualList1 = new ImmutableLinkedList(data);
        ImmutableLinkedList emptyList = new ImmutableLinkedList(new Integer[0]);
        ImmutableLinkedList emptyList2 = emptyList.addFirst(10);
        Object[] expectedData = new Integer[] {10, 1, -2, 3, -4};
        assertEquals(10, emptyList2.getFirst());
    }

    @Test
    public void testAddLast() {
        data = new Object[] {1, 2, 3, 4, 5};
        ImmutableLinkedList actualList1 = new ImmutableLinkedList(data);
        ImmutableLinkedList actualList2 = actualList1.addLast(8);
        Object[] expectedData = new Integer[] {1, 2, 3, 4, 5, 8};
        assertArrayEquals(data, actualList1.toArray());
        assertArrayEquals(expectedData, actualList2.toArray());
    }
}