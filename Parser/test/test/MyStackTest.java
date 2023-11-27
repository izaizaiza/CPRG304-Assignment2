package test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */



import org.junit.jupiter.api.BeforeEach;

//import org.junit.jupiter.api.Test;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;


import ADTs.Iterator;
import ADTs.StackADT;
import java.util.EmptyStackException;
import utility.MyStack;


/**
 * @author dlg12
 * @author izalu
 */
public class MyStackTest {

    private StackADT<String> myStack;

    //for some reason this setUp is not working
    //@BeforeEach
    //public void setUp() {
    //    myStack = new MyStack<>();
    //}

    @Test
    public void testPushAndPop() {
        myStack = new MyStack<>();
        myStack.push("Element 1");
        myStack.push("Element 2");
        assertEquals("Element 2", myStack.pop());
        assertEquals("Element 1", myStack.pop());
        assertTrue(myStack.isEmpty());
    }

    @Test
    public void testPopEmptyStack() {
        myStack = new MyStack<>();
        Throwable exception = assertThrows(EmptyStackException.class, () ->{
            myStack.pop();
        });
        
        // Print out the exception message
        System.out.println("Exception Message: " + exception.getMessage());
        
    }

    @Test
    public void testPeek() {
        myStack = new MyStack<>();
        myStack.push("Element 1");
        myStack.push("Element 2");
        assertEquals("Element 2", myStack.peek()); // pass
        assertEquals("Element 1", myStack.peek()); // fail b/c the last one is 2 not Element 1
    }

    @Test
    public void testPeekEmptyStack() {
        myStack = new MyStack<>();
        Throwable exception = assertThrows(EmptyStackException.class, () ->{
            myStack.peek();
        });
        
        // Print out the exception message
        System.out.println("Exception Message: " + exception.getMessage());
 
    }

    @Test
    public void testClear() {
        myStack = new MyStack<>();
        myStack.push("Element 1");
        myStack.push("Element 2");
        myStack.clear();
        assertTrue(myStack.isEmpty());
        assertFalse(myStack.isEmpty()); // should fail
    }

    @Test
    public void testSize() {
        myStack = new MyStack<>();
        myStack.push("Element 1");
        myStack.push("Element 2");
        assertEquals(2, myStack.size());
        myStack.pop();
        assertEquals(2, myStack.size()); // should fail b/c we popped one
    }

    @Test
    public void testSearch() {
        myStack = new MyStack<>();
        myStack.push("Element 1");
        myStack.push("Element 2");
        myStack.push("Element 3");
        assertEquals(2, myStack.search("Element 2"));
        assertEquals(-1, myStack.search("Element 4"));
        assertEquals(1, myStack.search("Element 1")); // should fail
    }

    @Test
    public void testToArray() {
        myStack = new MyStack<>();
        myStack.push("Element 1");
        myStack.push("Element 2");
        Object[] array = myStack.toArray();
        assertEquals("Element 1", array[0]);
        assertEquals("Element 2", array[1]);

    }

    @Test
    public void testIterator() {
        myStack = new MyStack<>();
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
        myStack = new MyStack<>();
        myStack.push("Element 1");
        myStack.push("Element 2");

        StackADT<String> otherStack = new MyStack<>();
        otherStack.push("Element 1");
        otherStack.push("Element 2");

        assertTrue(myStack.equals(otherStack));
        
        otherStack.push("Element 3");
        assertTrue(myStack.equals(otherStack)); // fail b/c we added one more
    }
}