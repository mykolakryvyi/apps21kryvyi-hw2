package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList linkedlist = new ImmutableLinkedList();

    public Object peek() {
        return linkedlist.getFirst();
    }

    public Object dequeue() {
        Object node = linkedlist.getFirst();
        linkedlist = linkedlist.removeFirst();
        return node;
    }

    public void enqueue(Object e) {
        linkedlist = linkedlist.addLast(e);
    }
}
