package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableArrayList implements ImmutableList {
    private int length;
    private Object[] array_list;

    public ImmutableArrayList(Object[] elements) {
        length = elements.length;
        array_list = Arrays.copyOf(elements, length);
    }

    public ImmutableArrayList() {
        length = 0;
        array_list = new Object[]{};
    }

    @Override
    public ImmutableList add(Object e) {
        return addAll(length, new Object[]{e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] newArr = new Object[length + c.length];
        System.arraycopy(array_list, 0, newArr, 0, index);
        System.arraycopy(c, 0, newArr, index, c.length);
        System.arraycopy(array_list, index, newArr, index + c.length, length - index);
        return new ImmutableArrayList(newArr);
    }

    @Override
    public Object get(int index) {
        return array_list[index];
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] newArr = new Object[this.length - 1];
        for (int i = 0; i < this.length - 1; i++) {
            if (i<index)
                newArr[i] = get(i);
            else
                newArr[i] = get(i+1);
        }
        return new ImmutableArrayList(newArr);

    }

    @Override
    public ImmutableList set(int index, Object e) {
        ImmutableList fictional = this.remove(index);
        return fictional.add(index, e);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < length; i++) {
            if (array_list[i] == e)
                return i;
        }
        return -1;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public ImmutableList clear() {
        Object[] cleared = new Object[this.length];
        return new ImmutableArrayList(cleared);
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array_list, length);
    }
}