# TypedLockedSortedLinkedList

TypedLockedSortedLinkedList is a Java-based project that provides a custom implementation of a LinkedList. The LinkedList is sorted and only accepts items of specific types defined in `SupportedTypes` enumeration.

Currently, the list can process `Integer` or `String` types, but not both.

## Features

- Custom sorted LinkedList (`SortedLinkedList`) implementation providing various LinkedList operations.
- Ensuring type consistency with `TypedLockedSortedLinkedList`, which extends `SortedLinkedList` with the restriction on the types of objects which can be added to the list.

## Prerequisites

- Java Development Kit (JDK must be greater or equal to 21)

## Usage

To use the `TypedLockedSortedLinkedList`:

```java
public class Main {
    public static void main(String[] args) {
        var integerList = new TypedLockedSortedLinkedList<Integer>();
        integerList.add(1);
        integerList.add(10);

        var stringList = new TypedLockedSortedLinkedList<String>();
        integerList.add("1");
        integerList.add("10");

        var unsupportedList = new TypedLockedSortedLinkedList<Date>();
        integerList.add(new Date()); // will throw IllegalArgumentException
        
        
    }
}

```

### Note

The base class (`SortedLinkedList`) is a generic sorted linked list implementation based on default Java `AbstractList<T>` to ensure well-defined interface and compatibility with List. 
The `TypedLockedSortedLinkedList` extends the `add(T value)` method to ensure the list limits types to classes specified in `SupportedTypes` enum. 

Since Java reflection does not allow restriction to certain types, but only Lower/Upper bounds for classes and the fact that generic types must be know at compile time, 
it was decided to check for types dynamically at runtime during `add` operation.
For sure, there are other approaches to given problematic
