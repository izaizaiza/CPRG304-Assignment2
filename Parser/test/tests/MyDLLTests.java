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
import ADTs.ListADT;
import org.junit.*;

public class MyDLLTests {

    private ListADT<String> myList;

    @Before
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

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtIndexOutOfBounds() {
        myList.add("Element 1");
        myList.add("Element 2");
        myList.add(5, "New Element");
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

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBounds() {
        myList.get(0);
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

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveAtIndexOutOfBounds() {
        myList.remove(0);
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

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetOutOfBounds() {
        myList.set(0, "New Element");
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



/*
public class MyDLLTests {
    
    public MyDLLTests() {
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