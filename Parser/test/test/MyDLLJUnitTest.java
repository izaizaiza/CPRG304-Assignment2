/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author izalu
 */


import ADTs.Iterator;
import ADTs.ListADT;
import utility.MyDLL;

public class MyDLLJUnitTest {

    private ListADT<String> myList;

    @BeforeEach
    public void setUp() {
        myList = new MyDLL<>();
    }

    @Test
    public void testSize() {
        assertEquals(0, myList.size());
        myList.add("Element 1");
        assertEquals(1, myList.size());
        myList.add("Element 2");
        assertEquals(2, myList.size());
    }

    @Test
    public void testClear() {
        myList.add("Element 1");
        myList.add("Element 2");
        myList.clear();
        assertEquals(0, myList.size());
        assertTrue(myList.isEmpty());
    }

    @Test
    public void testAddAtIndex() {
        myList.add("Element 1");
        myList.add("Element 2");
        myList.add(1, "New Element");
        assertEquals("Element 1", myList.get(0));
        assertEquals("Element 1", myList.get(0));
        assertEquals("New Element", myList.get(1));
        assertEquals("Element 2", myList.get(2));
        assertEquals(3, myList.size());
    }

    @Test
    public void testAddAtIndexOutOfBounds() {
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () ->{
            myList.add("Element 1");
            myList.add("Element 2");
            myList.add(5, "New Element");
        });
        
        // Print out the exception message
        System.out.println("Exception Message: " + exception.getMessage());
        
    }

    @Test
    public void testAddElement() {
        assertTrue(myList.isEmpty());
        myList.add("New Element");
        assertFalse(myList.isEmpty());
        assertEquals("New Element", myList.get(0));
        assertEquals(1, myList.size());
    }

    @Test
    public void testAddAll() {
        ListADT<String> toAdd = new MyDLL<>();
        toAdd.add("Element 1");
        toAdd.add("Element 2");

        myList.addAll(toAdd);

        assertEquals("Element 1", myList.get(0));
        assertEquals("Element 2", myList.get(1));
        assertEquals(2, myList.size());
    }

    @Test
    public void testGet() {
        myList.add("Element 1");
        myList.add("Element 2");
        assertEquals("Element 1", myList.get(0));
        assertEquals("Element 2", myList.get(1));
    }

    @Test
    public void testGetOutOfBounds() {
        
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            myList.get(0);
        });
        
        // Print out the exception message
        System.out.println("Exception Message: " + exception.getMessage());
    }

    @Test
    public void testRemoveAtIndex() {
        myList.add("Element 1");
        myList.add("Element 2");
        String removed = myList.remove(1);
        assertEquals("Element 2", removed);
        assertEquals("Element 1", myList.get(0));
        assertEquals(1, myList.size());
    }

    @Test
    public void testRemoveAtIndexOutOfBounds() {
        
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            myList.remove(0);
        });
        
        // Print out the exception message
        System.out.println("Exception Message: " + exception.getMessage());
    }

    @Test
    public void testRemoveElement() {
        myList.add("Element 1");
        myList.add("Element 2");
        String removed = myList.remove("Element 1");
        assertEquals("Element 1", removed);
        assertFalse(myList.contains("Element 1"));
        assertEquals("Element 2", myList.get(0));
        assertEquals(1, myList.size());
    }

    @Test
    public void testRemoveElementNotInList() {
        myList.add("Element 1");
        myList.add("Element 2");
        assertNull(myList.remove("Element 3"));
        assertEquals(2, myList.size());
    }
    @Test
    public void testSet() {
        myList.add("Element 1");
        myList.add("Element 2");
        String oldElement = myList.set(1, "New Element");
        assertEquals("Element 2", oldElement);
        assertEquals("Element 1", myList.get(0));
        assertEquals("New Element", myList.get(1));
        assertEquals(2, myList.size());
    }

    @Test
    public void testSetOutOfBounds() {
        
        Throwable exception = 
        assertThrows(IndexOutOfBoundsException.class, () -> {
            myList.set(0, "New Element");
        });
        
        // Print out the exception message
        System.out.println("Exception Message: " + exception.getMessage());
        
    }

    @Test
    public void testIsEmpty() {
        assertTrue(myList.isEmpty());
        myList.add("Element 1");
        assertFalse(myList.isEmpty());
    }

    @Test
    public void testContains() {
        myList.add("Element 1");
        myList.add("Element 2");
        assertTrue(myList.contains("Element 1"));
        assertFalse(myList.contains("Element 3"));
    }

    @Test
    public void testToArray() {
        myList.add("Element 1");
        myList.add("Element 2");
        Object[] array = myList.toArray();
        assertArrayEquals(new Object[]{"Element 1", "Element 2"}, array);
    }

    @Test
    public void testIterator() {
        myList.add("Element 1");
        myList.add("Element 2");

        Iterator<String> iterator = myList.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("Element 1", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("Element 2", iterator.next());
        assertFalse(iterator.hasNext());
    }
}

