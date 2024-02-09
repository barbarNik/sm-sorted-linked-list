package com.shipmonk.test.list;

import java.util.Arrays;

public class TypedLockedSortedLinkedList<T extends Comparable<T>> extends SortedLinkedList<T> {

    public enum SupportedTypes {
        STRING(String.class),
        INTEGER(Integer.class);
        private final Class<?> typeClass;

        SupportedTypes(Class<?> typeClass) {
            this.typeClass = typeClass;
        }

        public Class<?> getTypeClass() {
            return typeClass;
        }
    }

    @Override
    public boolean add(T value) {
        var matchCount = Arrays.stream(SupportedTypes.values())
                .map(SupportedTypes::getTypeClass)
                .filter(it -> it.isInstance(value))
                .count();
        if (matchCount <= 0) {
            throw new IllegalArgumentException("Only classes specified in " + SupportedTypes.class + " are supported");
        }
        return super.add(value);
    }
}
