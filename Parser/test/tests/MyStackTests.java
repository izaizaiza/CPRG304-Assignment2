/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author izalu
 */
import static org.junit.Assert.*;

import ADTs.Iterator;
import ADTs.StackADT;
import org.junit.*;

import java.util.EmptyStackException;

public class MyStackTests {

    private StackADT<String> myStack;

    @Before
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

    @Test(expected = EmptyStackException.class)
    public void testPopEmptyStack() {
        myStack.pop();
    }

    @Test
    public void testPeek() {
        myStack.push("Element 1");
        myStack.push("Element 2");
        assertEquals("Element 2", myStack.peek());
        assertFalse(myStack.isEmpty());
    }

    @Test(expected = EmptyStackException.class)
    public void testPeekEmptyStack() {
        myStack.peek();
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
/*
public class MyStackTests {
    
    public MyStackTests() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
*/
