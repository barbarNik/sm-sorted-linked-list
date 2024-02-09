package com.shipmonk.test.list;

import java.util.AbstractList;

public class SortedLinkedList<T extends Comparable<T>> extends AbstractList<T> {
    protected int size = 0;
    protected Node<T> head = null;

    @Override
    public T get(int index) {
        return getNode(index).getValue();
    }

    @Override
    public boolean add(T value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
        var newNode = new Node<T>(value, null);
        Node<T> current = head;
        Node<T> previous = null;
        while (current != null &&
                current.getValue().compareTo(value) < 0) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) {
            head = newNode;
        } else {
            previous.setNext(newNode);
        }

        newNode.setNext(current);
        size++;
        return true;
    }


    public T remove(int index) {
        Node<T> toDelete = getNode(index);

        if (toDelete == head) {
            head = toDelete.getNext();
        } else {
            var previous = getNode(index - 1);
            previous.setNext(toDelete.getNext());
        }
        size--;
        return toDelete.getValue();
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public void addLast(T e) {
        throw new UnsupportedOperationException();
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        var current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    @Override
    public int size() {
        return size;
    }
}
