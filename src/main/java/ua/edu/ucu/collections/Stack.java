package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;


public class Stack {

    private ImmutableLinkedList linkedlist = new ImmutableLinkedList();

    public void push(Object e) {
        linkedlist = linkedlist.addFirst(e);
    }

    public Object pop() {
        Object element = this.peek();
        linkedlist = linkedlist.removeFirst();
        return element;
    }

    public Object peek() {
        return linkedlist.getFirst();
    }
}
