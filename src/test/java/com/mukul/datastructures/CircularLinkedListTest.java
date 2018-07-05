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
        CircularLinkedList<Integer> lista = new CircularLinkedList<>();
        lista.insert(1);
        lista.insert(2);
        lista.insert(3);
        lista.insertAt(0, 1);
        lista.insertAt(0, 3);
        lista.removeAt(3);
        assertTrue(lista.ehCircular());
    }



}