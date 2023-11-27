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
 * @author dlg12
 * @author izalu
 */


public class MyArrayListTest {

    private MyArrayList<String> myList;

    //for some reason this setUp is not working
    //@BeforeEach
    //public void setUp() {
    //    myList = new MyArrayList<>();
    //}
    

    @Test
    public void testSize() {
         myList = new MyArrayList<>();
        assertEquals(0, myList.size());
        this.myList.add("Element 1");
        assertEquals(2, myList.size()); // supposed to fail since only one is added
        this.myList.add("Element 2");
        //assertEquals(2, myList.size()); // this will pass
    }

    @Test
    public void testClear() {
        myList = new MyArrayList<>();
        myList = new MyArrayList<>();
        myList.add("Element 1");
        myList.add("Element 2");
        myList.clear();
        assertEquals(0, myList.size());
        assertFalse(myList.isEmpty()); // this should fail b/c myList should be empty
    }

    @Test
    public void testAddAtIndex() {
        myList = new MyArrayList<>();
        myList.add("Element 1");
        myList.add("Element 2");
        myList.add(1, "New Element");
        assertEquals("Element 0", myList.get(0));
        assertEquals("New Element", myList.get(1));
        assertEquals("Element 2", myList.get(2));
    }
    
    
    @Test
    public void testAddAtIndexOutOfBounds() {
        myList.add("Element 1");
        Throwable exception1 =
        assertThrows(IndexOutOfBoundsException.class, () -> myList.add(-1, "Element")); // should pass because no IndexOutOfBounds thrown
        
        Throwable exception2 =
        assertThrows(IndexOutOfBoundsException.class, () -> myList.add(1, "Element")); // should fail because no IndexOutOfBounds thrown
        
         //Print out the exception message
        System.out.println("Exception Message: " + exception2.getMessage());
    }



    @Test
    public void testAddElement() {
        myList = new MyArrayList<>();
        assertTrue(myList.isEmpty());
        myList.add("New Element");
        assertFalse(myList.isEmpty());
        assertEquals("New Element", myList.get(0));
    }

    @Test
    public void testAddAll() {
        myList = new MyArrayList<>();
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
        myList = new MyArrayList<>();
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
        myList = new MyArrayList<>();
        myList.add("Element 1");
        Throwable exception1 = assertThrows(IndexOutOfBoundsException.class, () -> myList.get(-1)); // should pass because no Index Out of bounds is thrown
        Throwable exception2 = assertThrows(IndexOutOfBoundsException.class, () -> myList.get(0)); // should fail because no Index Out of bounds is thrown
        
        // Print out the exception message
        System.out.println("Exception Message: " + exception2.getMessage());
    }
    

    @Test
    public void testIterator() {
        myList = new MyArrayList<>();
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