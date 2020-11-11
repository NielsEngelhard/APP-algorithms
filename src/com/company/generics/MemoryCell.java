package com.company.generics;

// 2.29
public class MemoryCell<T extends  Comparable<T>> implements Comparable<MemoryCell<T>> {
    public T read( ) { return storedValue; }
    public void write( T x ) { storedValue = x; }

    private T storedValue;

    @Override
    public int compareTo(MemoryCell<T> o) {
        return read().compareTo(o.read());
    }
}
