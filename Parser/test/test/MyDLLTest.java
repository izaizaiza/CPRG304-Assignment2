package test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dlg12
 * @author izalu
 */


import ADTs.Iterator;
import ADTs.ListADT;
import utility.MyDLL;
import utility.MyDLL;

public class MyDLLTest {

    private ListADT<String> myList;
    
    //for some reason this setUp is not working
    //@BeforeEach
    //public void setUp() {
    //    myList = new MyDLL<>();
    //}

    @Test
    public void testSize() {
        myList = new MyDLL<>();
        assertEquals(0, myList.size());
        myList.add("Element 1");
        assertEquals(0, myList.size()); // should fail cause now there is a node in the DLL
        //myList.add("Element 2");
        //assertEquals(2, myList.size()); // should pass
    }

    @Test
    public void testClear() {
        myList = new MyDLL<>();
        myList.add("Element 1");
        myList.add("Element 2");
        myList.clear();
        assertEquals(0, myList.size());
        assertFalse(myList.isEmpty()); // should fail b/c myList is should be empty
    }

    @Test
    public void testAddAtIndex() {
        myList = new MyDLL<>();
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
        myList = new MyDLL<>();
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
        myList = new MyDLL<>();
        assertTrue(myList.isEmpty());
        myList.add("New Element");
        assertFalse(myList.isEmpty());
        assertEquals("New Element", myList.get(0));
        assertEquals(1, myList.size());
    }

    @Test
    public void testAddAll() {
        myList = new MyDLL<>();
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
        myList = new MyDLL<>();
        myList.add("Element 1");
        myList.add("Element 2");
        assertEquals("Element 1", myList.get(0));
        assertEquals("Element 2", myList.get(1));
    }

    @Test
    public void testGetOutOfBounds() {
        myList = new MyDLL<>();
        
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            myList.get(0);
        });
        
        // Print out the exception message
        System.out.println("Exception Message: " + exception.getMessage());
    }

    @Test
    public void testRemoveAtIndex() {
        myList = new MyDLL<>();
        myList.add("Element 1");
        myList.add("Element 2");
        String removed = myList.remove(1);
        assertEquals("Element 2", removed);
        assertEquals("Element 1", myList.get(0));
        assertEquals(1, myList.size());
    }

    @Test
    public void testRemoveAtIndexOutOfBounds() {
        myList = new MyDLL<>();
        
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            myList.remove(0);
        });
        
        // Print out the exception message
        System.out.println("Exception Message: " + exception.getMessage());
    }

    @Test
    public void testRemoveElement() {
        myList = new MyDLL<>();
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
        myList = new MyDLL<>();
        myList.add("Element 1");
        myList.add("Element 2");
        Object retturn = myList.remove("Element 3");
        assertNull(retturn); // pass
        assertEquals("Element 2", retturn); // should fail b/c it retturn should be null since the object wanted to be removed is not in the DLL
        assertEquals(2, myList.size()); //should pass
    }
    @Test
    public void testSet() {
        myList = new MyDLL<>();
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
        myList = new MyDLL<>();
        Throwable exception = 
        assertThrows(IndexOutOfBoundsException.class, () -> {
            myList.set(0, "New Element");
        });
        
        // Print out the exception message
        System.out.println("Exception Message: " + exception.getMessage());
        
    }

    @Test
    public void testIsEmpty() {
        myList = new MyDLL<>();
        assertTrue(myList.isEmpty()); //pass
        myList.add("Element 1");
        assertTrue(myList.isEmpty()); // fails cause now there is an element/node
    }

    @Test
    public void testContains() {
        myList = new MyDLL<>();
        myList.add("Element 1");
        myList.add("Element 2");
        assertTrue(myList.contains("Element 1")); //should pass
        assertTrue(myList.contains("Element 3")); // should fail b/c Element 3 is indeed not in the DLL
    }

    @Test
    public void testToArray() {
        myList = new MyDLL<>();
        myList.add("Element 1");
        myList.add("Element 2");
        Object[] array = myList.toArray();
        assertArrayEquals(new Object[]{"Element 1", "Element 3"}, array); // will fail because 2nd element is not the same value
    }

    @Test
    public void testIterator() {
        myList = new MyDLL<>();
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
