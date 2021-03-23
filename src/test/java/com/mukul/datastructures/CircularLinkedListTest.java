package com.mukul.datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircularLinkedListTest extends LinkedListGenericTest {

    @Override
    public LinkedList<Integer> createLinkedList() {
        return new CircularLinkedList<>();
    }
    @Test
    public void shouldByCyclic(){
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insertAt(0, 1);
        list.insertAt(0, 3);
        list.removeAt(3);
        assertTrue(list.ehCircular());
    }



}
