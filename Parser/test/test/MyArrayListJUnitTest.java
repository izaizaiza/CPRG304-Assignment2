/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ADTs.Iterator;
import ADTs.ListADT;
import utility.MyArrayList;
import java.util.NoSuchElementException;


/**
 *
 * @author izalu
 */


public class MyArrayListJUnitTest {

    private ListADT<String> myList;

    @BeforeEach
    public void setUp() {
        myList = new MyArrayList<>();
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
        assertEquals("New Element", myList.get(1));
        assertEquals("Element 2", myList.get(2));
    }

    @Test
    public void testAddAtIndexOutOfBounds() {
        Throwable exception =
        assertThrows(IndexOutOfBoundsException.class, () -> myList.add(1, "Element"));
        
        // Print out the exception message
        System.out.println("Exception Message: " + exception.getMessage());
    }

    @Test
    public void testAddElement() {
        assertTrue(myList.isEmpty());
        myList.add("New Element");
        assertFalse(myList.isEmpty());
        assertEquals("New Element", myList.get(0));
    }

    @Test
    public void testAddAll() {
        ListADT<String> anotherList = new MyArrayList<>();
        anotherList.add("Element 1");
        anotherList.add("Element 2");
        myList.addAll(anotherList);
        assertEquals(2, myList.size());
        assertEquals("Element 1", myList.get(0));
        assertEquals("Element 2", myList.get(1));
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
        
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> myList.get(0));
        
        // Print out the exception message
        System.out.println("Exception Message: " + exception.getMessage());
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
