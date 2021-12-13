package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private Object[] data;

    @Test
    public void add() {
        data = new Object[] {1, 2, 3, 4, 5};
        ImmutableList actualArr1 = new ImmutableArrayList(data);
        ImmutableList actualArr2 = actualArr1.add(6);
        Object[] expectedData = new Object[] {1, 2, 3, 4, 5, 6};
        assertArrayEquals(data, actualArr1.toArray());
        assertArrayEquals(expectedData, actualArr2.toArray());
    }

    @Test
    public void testAdd() {
        data = new Object[] {1, 2, 3, 4, 5};
        ImmutableList actualArr1 = new ImmutableArrayList(data);
        ImmutableList actualArr2 = actualArr1.add(0, 0);
        Object[] expectedData = new Object[] {0, 1, 2, 3, 4, 5};
        assertArrayEquals(data, actualArr1.toArray());
        assertArrayEquals(expectedData, actualArr2.toArray());
    }

    @Test
    public void addAll() {
        data = new Object[] {1, 2, 3, 4, 5};
        ImmutableList actualArr1 = new ImmutableArrayList(data);
        ImmutableList actualArr2 = actualArr1.addAll(new Object[] {0, 0, 0, 0});
        Object[] expectedData = new Object[] {1, 2, 3, 4, 5, 0, 0, 0, 0};
        assertArrayEquals(data, actualArr1.toArray());
        assertArrayEquals(expectedData, actualArr2.toArray());
    }

    @Test
    public void testAddAll() {
        data = new Object[] {1, 2, 3, 4, 5};
        ImmutableList actualArr1 = new ImmutableArrayList(data);
        ImmutableList actualArr2 = actualArr1.addAll(0, new Object[] {0, 0, 0, 0});
        Object[] expectedData = new Object[] {0, 0, 0, 0, 1, 2, 3, 4, 5};
        assertArrayEquals(data, actualArr1.toArray());
        assertArrayEquals(expectedData, actualArr2.toArray());
    }

    @Test
    public void get() {
        data = new Object[] {1, 2, 3, 4, 5};
        ImmutableList actualArr = new ImmutableArrayList(data);
        assertEquals(1, actualArr.get(0));
    }

    @Test
    public void remove() {
        data = new Object[] {1, 2, 3, 4, 5};
        ImmutableList actualArr1 = new ImmutableArrayList(data);
        ImmutableList actualArr2 = actualArr1.remove(0);
        Object[] expectedData = new Object[] {2, 3, 4, 5};
        assertArrayEquals(data, actualArr1.toArray());
        assertArrayEquals(expectedData, actualArr2.toArray());
    }

    @Test
    public void indexOf() {
        data = new Object[] {1, 2, 3, 4, 5};
        ImmutableList actualArr = new ImmutableArrayList(data);
        assertEquals(0, actualArr.indexOf(1));
        assertEquals(-1, actualArr.indexOf(10));
    }

    @Test
    public void size() {
        data = new Object[] {1, 2, 3, 4, 5};
        ImmutableList actualArr = new ImmutableArrayList(data);
        assertEquals(5, actualArr.size());
    }

    @Test
    public void clear() {
        data = new Object[] {1, 2, 3, 4, 5};
        ImmutableList actualArr1 = new ImmutableArrayList(data);
        assertArrayEquals(data, actualArr1.toArray());
    }

    @Test
    public void toArray() {
        data = new Object[] {1, 2, 3, 4, 5};
        ImmutableList actualArr1 = new ImmutableArrayList(data);
        assertArrayEquals(data, actualArr1.toArray());
    }
}