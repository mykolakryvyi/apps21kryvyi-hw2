package ua.edu.ucu.collections.immutable;

import java.util.Objects;

public final class ImmutableLinkedList implements ImmutableList {

    private Node head;
    private Node tail;
    public ImmutableLinkedList(Object[] elements) {
        if (elements.length > 0) {
            Node node = new Node(elements[0]);
            head = node;
            tail = node;
            for (int i = 1; i < elements.length; i++) {
                node = new Node(elements[i]);
                tail.setNext(node);
                node.setPrevious(tail);
                tail = node;
                tail.setNext(null);
            }
        }
    }

    public ImmutableLinkedList() {
        head = null;
        tail = null;
    }

    @Override
    public ImmutableList add(Object e) {
        return add(size(), e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size(), c);
    }

    private Node copyIntoArray(Object[] arr, int start, Node startNode, int count) {
        Node currNode = startNode;
        for (int i = start; i < start + count; i++) {
            arr[i] = currNode.getValue();
            currNode = currNode.getNext();
        }
        return currNode;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] newArr = new Object[size() + c.length];
        Node tempNode = copyIntoArray(newArr, 0, head, index);
        System.arraycopy(c, 0, newArr, index, c.length);
        copyIntoArray(newArr, index + c.length, tempNode, size() - index);
        return new ImmutableLinkedList(newArr);
    }

    @Override
    public Object get(int index) {
        Node curNode = head;
        for (int i = 0; i < index; i++) {
            curNode = curNode.getNext();
        }
        return curNode.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        Node currNode = getHead();
        Object[] all_elem = new Object[size() - 1];
        for (int i = 0; i < index; i++) {
            all_elem[i] = currNode.getValue();
            currNode = currNode.getNext();
        }
        currNode = currNode.getNext();
        for (int i = index; i < all_elem.length; i++) {
            all_elem[i] = currNode.getValue();
            currNode = currNode.getNext();
        }
        return new ImmutableLinkedList(all_elem);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        ImmutableList fictional = this.remove(index);
        return fictional.add(index, e);
    }

    @Override
    public int indexOf(Object e) {
        Node currNode = this.head;
        for (int i = 0; i < size(); i++) {
            if (Objects.equals(currNode.getValue(), e))
                return i;
            currNode = currNode.getNext();
        }
        return -1;
    }

    @Override
    public int size() {
        int size = 0;
        Node current = getHead();
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newArr = new Object[size()];
        Node tempNode = copyIntoArray(newArr, 0, head, size());
        return newArr;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(size(), e);
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Object getFirst() {
        return head.getValue();
    }

    public Object getLast() {
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(size()-1);
    }
}