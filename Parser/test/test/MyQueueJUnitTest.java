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
import ADTs.QueueADT;
import exceptions.EmptyQueueException;
import utility.MyQueue;

public class MyQueueJUnitTest {

    private QueueADT<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new MyQueue<>();
    }

    @Test
    public void testEnqueueAndDequeue() throws EmptyQueueException {
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertFalse(queue.isEmpty());
        assertEquals(1, (long)queue.dequeue());
        assertEquals(2, (long)queue.dequeue());
        assertEquals(3, (long)queue.dequeue());

        assertTrue(queue.isEmpty());

        Throwable exception = assertThrows(EmptyQueueException.class, queue::dequeue);
        
        // Print out the exception message
        System.out.println("Exception Message: " + exception.getMessage());
    }

    @Test
    public void testPeek() throws EmptyQueueException {
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(1, (long)queue.peek());
        assertEquals(1, (long) queue.peek());

        queue.dequeue();

        assertEquals(2, (long)queue.peek());
    }

    @Test
    public void testDequeueAll() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertFalse(queue.isEmpty());

        queue.dequeueAll();

        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsEmpty() throws EmptyQueueException {
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(1);

        assertFalse(queue.isEmpty());

        queue.dequeue();
        queue.dequeue();

        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIterator() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Iterator<Integer> iterator = queue.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(1, (long)iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, (long)iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, (long)iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testEquals() throws EmptyQueueException {
        QueueADT<Integer> queue2 = new MyQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);

        assertTrue(queue.equals(queue2));

        queue2.dequeue();

        assertFalse(queue.equals(queue2));
    }
}
