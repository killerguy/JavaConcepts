package com.mukul.datastructures;

import java.lang.reflect.Array;

@SuppressWarnings("unchecked")
public class Stack<E> {

    private final Class<E> clazz;
    private E[] elements;
    private E top;
    private int capacity;
    private int index;

    public Stack(Class<E> clazz) {
        this.clazz = clazz;
        this.capacity = 10;
        this.top = null;
        this.index = -1;
        this.elements = (E[]) Array.newInstance(clazz, capacity);
    }

    public Stack(Class<E> clazz, int capacity) {
        this(clazz);
        this.capacity = capacity;
        this.elements = (E[]) Array.newInstance(clazz, capacity);
    }

    /*
     * Insere no final LIFO
     */
    public void push(E Node) {
        if ((index + 1) == capacity) {
            capacity *= 2;
            E[] resizedElements = (E[]) Array.newInstance(clazz, capacity);
            if (index + 1 >= 0) {
                System.arraycopy(elements, 0, resizedElements, 0, index + 1);
            }
            elements = resizedElements;
        }
        elements[++index] = Node;
        top = elements[index];
    }

    public E pop() throws IllegalStateException {
        if (index == -1) {
            throw new IllegalStateException("Stack is empty");
        }
        E oldTop = top;
        elements[index] = null;
        if (index == 0) {
            --index;
            top = null;
        } else {
            top = elements[--index];
        }

        return oldTop;
    }

    public E top() {
        return top;
    }

    public int size(){
        return index + 1;
    }

}
