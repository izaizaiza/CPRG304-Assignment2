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
import ADTs.Iterator;
import ADTs.ListADT;
import utility.MyArrayList;

public class MyArrayListTests {

    private ListADT<String> myList;

    @Before
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

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtIndexOutOfBounds() {
        myList.add(1, "Element");
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

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBounds() {
        myList.get(0);
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
public class MyArrayListTests {
    
    public MyArrayListTests() {
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
