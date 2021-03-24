package com.mukul.datastructures;

import org.junit.Test;

import static java.util.Optional.*;
import static org.junit.Assert.*;

public class StackTest {
    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenStackIsEmpty() {
        Stack<Integer> stack = new Stack<>(Integer.class);
        stack.pop();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenPopingFullStack(){
        Stack<Integer> stack = new Stack<>(Integer.class, 2);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

    }

    @Test
    public void shouldPush5Elements() {
        Stack<Integer> stack = new Stack<>(Integer.class);
        stack.push(0);
        stack.push(10);
        stack.push(100);
        stack.push(1000);
        stack.push(10000);
        assertEquals(5, stack.size());
    }

    @Test
    public void shouldPushRightAfterResizing() {
        Stack<Integer> stack = new Stack<>(Integer.class, 3);
        stack.push(0);
        stack.push(10);
        stack.push(100);
        stack.push(1000);
        stack.push(10000);
        assertEquals(5, stack.size());
        assertEquals(10000, stack.top().intValue());
    }

    @Test
    public void shouldBeTheSameElementOnTop() {
        Stack<Integer> stack = new Stack<>(Integer.class);
        stack.push(0);
        stack.push(10);
        stack.push(100);
        assertEquals(of(100).get(), stack.top());
    }

    @Test
    public void takenValueAndSizeShouldBeRight() {
        Stack<Integer> stack = new Stack<>(Integer.class);
        stack.push(0);
        stack.push(10);
        stack.push(100);

        Integer pop = stack.pop();
        assertEquals(100, pop.intValue());
        assertEquals(2, stack.size());

        Integer pop2 = stack.pop();
        assertEquals(10, pop2.intValue());
        assertEquals(1, stack.size());
    }

}
