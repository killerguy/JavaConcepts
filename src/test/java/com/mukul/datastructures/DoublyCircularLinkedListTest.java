package com.mukul.datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyCircularLinkedListTest extends LinkedListGenericTest{
    @Override
    public LinkedList<Integer> createLinkedList() {
        return new DoublyCircularLinkedList<>();
    }

    @Test
    public void shouldByCyclic(){
        DoublyCircularLinkedList<Integer> list = new DoublyCircularLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insertAt(0, 1);
        list.insertAt(0, 3);
        list.removeAt(3);
        assertTrue(list.isCyclic());
    }
}
