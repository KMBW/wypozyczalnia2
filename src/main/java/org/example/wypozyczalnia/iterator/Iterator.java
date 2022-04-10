package org.example.wypozyczalnia.iterator;

public interface Iterator<T> {
    T getNext();
    T getCurrent();
    boolean hasNext();
}

