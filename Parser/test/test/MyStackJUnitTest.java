/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;


import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import ADTs.Iterator;
import ADTs.StackADT;
import utility.MyStack;
import java.util.EmptyStackException;


/**
 *
 * @author izalu
 */
public class MyStackJUnitTest {

    private StackADT<String> myStack;

    @BeforeEach
    public void setUp() {
        myStack = new MyStack<>();
    }

    @Test
    public void testPushAndPop() {
        myStack.push("Element 1");
        myStack.push("Element 2");
        assertEquals("Element 2", myStack.pop());
        assertEquals("Element 1", myStack.pop());
        assertTrue(myStack.isEmpty());
    }

    @Test
    public void testPopEmptyStack() {
        
        Throwable exception = assertThrows(EmptyStackException.class, () ->{
            myStack.pop();
        });
        
        // Print out the exception message
        System.out.println("Exception Message: " + exception.getMessage());
        
    }

    @Test
    public void testPeek() {
        myStack.push("Element 1");
        myStack.push("Element 2");
        assertEquals("Element 2", myStack.peek());
        assertFalse(myStack.isEmpty());
    }

    @Test
    public void testPeekEmptyStack() {
        Throwable exception = assertThrows(EmptyStackException.class, () ->{
            myStack.peek();
        });
        
        // Print out the exception message
        System.out.println("Exception Message: " + exception.getMessage());
 
    }

    @Test
    public void testClear() {
        myStack.push("Element 1");
        myStack.push("Element 2");
        myStack.clear();
        assertTrue(myStack.isEmpty());
    }

    @Test
    public void testSize() {
        myStack.push("Element 1");
        myStack.push("Element 2");
        assertEquals(2, myStack.size());
        myStack.pop();
        assertEquals(1, myStack.size());
    }

    @Test
    public void testSearch() {
        myStack.push("Element 1");
        myStack.push("Element 2");
        myStack.push("Element 3");
        assertEquals(2, myStack.search("Element 2"));
        assertEquals(-1, myStack.search("Element 4"));
    }

    @Test
    public void testToArray() {
        myStack.push("Element 1");
        myStack.push("Element 2");
        Object[] array = myStack.toArray();
        assertEquals("Element 1", array[0]);
        assertEquals("Element 2", array[1]);

    }

    @Test
    public void testIterator() {
        myStack.push("Element 1");
        myStack.push("Element 2");

        Iterator<String> iterator = myStack.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("Element 1", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("Element 2", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testEquals() {
        myStack.push("Element 1");
        myStack.push("Element 2");

        StackADT<String> otherStack = new MyStack<>();
        otherStack.push("Element 1");
        otherStack.push("Element 2");

        assertTrue(myStack.equals(otherStack));
    }
}
