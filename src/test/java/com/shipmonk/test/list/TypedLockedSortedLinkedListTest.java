package com.shipmonk.test.list;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import java.util.Date;

public class TypedLockedSortedLinkedListTest {

    /**
     * Test case for add(T) method of TypedLockedSortedLinkedList class.
     * It validates whether the given value adheres to the specified type before insertion.
     */
    @Test
    public void add_StringType_SuccessfulInsertion() {
        var list = new TypedLockedSortedLinkedList<String>();
        assertDoesNotThrow(() -> list.add("test_string"));
    }

    @Test
    public void add_IntegerType_SuccessfulInsertion() {
        var list = new TypedLockedSortedLinkedList<Integer>();
        assertDoesNotThrow(() -> list.add(25));
    }

    @Test
    public void add_StringType_InsertionFailureDueToDifferentType() {
        var list = new TypedLockedSortedLinkedList<Date>();
        assertThrows(IllegalArgumentException.class, () -> list.add(new Date()));
    }
}
