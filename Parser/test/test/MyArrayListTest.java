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
import ADTs.ListADT;
import utility.MyArrayList;


/**
 *
 * @author izalu
 */


public class MyArrayListTest {

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
        assertEquals("Element 0", myList.get(0));
        assertEquals("New Element", myList.get(1));
        assertEquals("Element 2", myList.get(2));
    }
    
    @Test
    public void testAddAtIndexOutOfBounds() {
        try {
            myList.add(1, "Element");
            fail("Expected IndexOutOfBoundsException but no exception was thrown");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception, you can perform additional assertions on the exception
            System.out.println("Exception Message: " + e.getMessage());
        }
    }


    //@Test
    //public void testAddAtIndexOutOfBounds() {
    //    Throwable exception =
    //    assertThrows(IndexOutOfBoundsException.class, () -> myList.add(1, "Element"));
        
        // Print out the exception message
    //    System.out.println("Exception Message: " + exception.getMessage());
    //}

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
        // assert to ensure myList is not null
        assertNotNull(myList, "myList should not be null");
        
        myList.add("Element 1");
        myList.add("Element 2");
        assertEquals("Element 1", myList.get(0));
        assertEquals("Element 2", myList.get(1));
        System.out.println(String.format(
              """
                    Expected: Element 1
                    Actual: %s
                    Expected: Element 2
                    Actual: %s
                    """, myList.get(0), myList.get(1)));
    }

    
    @Test
    public void testGetOutOfBounds() {
        try {
            myList.get(0);
            fail("Expected IndexOutOfBoundsException but no exception was thrown");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception, you can perform additional assertions on the exception
            System.out.println("Exception Message: " + e.getMessage());
        }
    }
    
    //@Test
    //public void testGetOutOfBounds() {
        
    //    Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> myList.get(0));
        
        // Print out the exception message
    //    System.out.println("Exception Message: " + exception.getMessage());
    //}

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