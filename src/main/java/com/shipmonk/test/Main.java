package com.shipmonk.test;

import com.shipmonk.test.list.TypedLockedSortedLinkedList;
import com.shipmonk.test.list.TypedLockedSortedLinkedList.SupportedTypes;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        var list = new TypedLockedSortedLinkedList<Integer>();
        list.add(1);
        list.add(10);
        list.add(34);
        list.add(8);
        System.out.println(list);
    }
}
