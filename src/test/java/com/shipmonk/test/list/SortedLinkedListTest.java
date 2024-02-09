package com.shipmonk.test.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SortedLinkedListTest {

    @Test
    public void add_NodeToEmptyList_ElemAddedAtHead() {
        SortedLinkedList<Integer> sll = new SortedLinkedList<>();
        assertTrue(sll.add(100));
        assertEquals(100, sll.get(0).intValue());
    }

    @Test
    public void add_NodeToNonemptyList_SortedOrderMaintained() {
        SortedLinkedList<Integer> sll = new SortedLinkedList<>();
        sll.add(100);
        sll.add(50);
        assertTrue(sll.add(75));
        assertEquals(50, sll.get(0).intValue());
        assertEquals(75, sll.get(1).intValue());
        assertEquals(100, sll.get(2).intValue());
    }

    @Test
    public void add_DuplicateNode_SortedOrderMaintained() {
        SortedLinkedList<Integer> sll = new SortedLinkedList<>();
        sll.add(100);
        sll.add(50);
        assertTrue(sll.add(50));
        assertEquals(50, sll.get(0).intValue());
        assertEquals(50, sll.get(1).intValue());
        assertEquals(100, sll.get(2).intValue());
    }

    @Test
    public void add_NullNode_IllegalArgumentException_Thrown() {
        SortedLinkedList<Integer> sll = new SortedLinkedList<>();
        sll.add(100);
        sll.add(50);
        assertThrows(IllegalArgumentException.class, () -> {
            sll.add(null);
        });
    }

    @Test
    void get_WithNoElements_NoSuchElementException_Throws() {
        SortedLinkedList<Integer> sortedLinkedList = new SortedLinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> sortedLinkedList.get(0));
    }

    @Test
    void get_WithSingleElement() {
        SortedLinkedList<Integer> sortedLinkedList = new SortedLinkedList<>();
        sortedLinkedList.add(5);
        assertEquals(5, sortedLinkedList.get(0));
    }

    @Test
    void get_WithMultipleElements_SortedOrderMaintained() {
        SortedLinkedList<Integer> sortedLinkedList = new SortedLinkedList<>();
        sortedLinkedList.add(10);
        sortedLinkedList.add(5);
        assertEquals(5, sortedLinkedList.get(0));
        assertEquals(10, sortedLinkedList.get(1));
    }

    @Test
    void get_IncorrectIndex_IndexOutOfBoundsException_Thrown() {
        SortedLinkedList<Integer> sll = new SortedLinkedList<>();
        sll.add(10);
        sll.add(5);
        assertThrows(IndexOutOfBoundsException.class, () -> sll.get(4));
    }

    @Test
    public void remove_NodeFromEmptyList_IndexOutOfBoundsException_Thrown() {
        SortedLinkedList<Integer> sll = new SortedLinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> sll.remove(1));
    }

    @Test
    public void remove_NodeFromListMiddle_OrderMaintained() {
        SortedLinkedList<Integer> sll = new SortedLinkedList<>();

        sll.add(100);
        sll.add(50);
        sll.add(75);
        sll.remove(1);

        assertEquals(50, sll.get(0));
        assertEquals(100, sll.get(1));
    }

    @Test
    public void remove_NodeFromListStart_OrderMaintained() {
        SortedLinkedList<Integer> sll = new SortedLinkedList<>();

        sll.add(100);
        sll.add(50);
        sll.add(75);
        sll.remove(0);

        assertEquals(75, sll.get(0));
        assertEquals(100, sll.get(1));
    }

    @Test
    public void clear_sizeZero() {
        SortedLinkedList<Integer> list = new SortedLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void size_n_elements() {
        SortedLinkedList<Integer> list = new SortedLinkedList<>();
        list.add(5);
        list.add(3);
        list.add(8);
        assertEquals(3, list.size());
    }

    // This test will check if the size method correctly returns the size of an empty list.
    @Test
    public void size_0_elements() {
        SortedLinkedList<Integer> list = new SortedLinkedList<>();
        assertEquals(0, list.size());
    }

    @Test
    public void size_1_element() {
        SortedLinkedList<Integer> list = new SortedLinkedList<>();
        list.add(2);
        assertEquals(1, list.size());
    }

    @Test
    public void size_after_removal() {
        SortedLinkedList<Integer> list = new SortedLinkedList<>();
        list.add(2);
        list.add(5);
        list.remove(0);
        assertEquals(1, list.size());
    }
}
