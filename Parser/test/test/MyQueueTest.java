package test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */



import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dlg12
 * @author izalu
 */
import ADTs.Iterator;
import ADTs.QueueADT;
import exceptions.EmptyQueueException;
import utility.MyQueue;

public class MyQueueTest {

    private QueueADT<Integer> queue;
    //for some reason this setUp is not working
    //@BeforeEach
    //public void setUp() {
    //    queue = new MyQueue<>();
    //}

    @Test
    public void testEnqueueAndDequeue() throws EmptyQueueException {
        queue = new MyQueue<>();
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
        queue = new MyQueue<>();
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(1, (long)queue.peek());//pass

        queue.dequeue(); // removes first element added

        assertEquals(2, (long)queue.peek()); //pass b/c now the first element is 2
        assertEquals(1, (long)queue.peek());// fails b/c 1 is not removed
    }

    @Test
    public void testDequeueAll() {
        queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertFalse(queue.isEmpty()); //pass

        queue.dequeueAll();
        assertTrue(queue.isEmpty()); //pass
        assertFalse(queue.isEmpty()); // should fail b/c we dequeued it
    }

    @Test
    public void testIsEmpty() throws EmptyQueueException {
        queue = new MyQueue<>();
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(1);

        assertFalse(queue.isEmpty());

        queue.dequeue();
        queue.dequeue();

        assertTrue(queue.isEmpty()); // should be pass b/c we dequed it
        assertFalse(queue.isEmpty()); // if the above is pass this should fail
    }

    @Test
    public void testIterator() {
        queue = new MyQueue<>();
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
        assertTrue(iterator.hasNext()); // should be fail because 3 is the last in the queue
    }

    @Test
    public void testEquals() throws EmptyQueueException {
        queue = new MyQueue<>();
        QueueADT<Integer> queue2 = new MyQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);

        assertTrue(queue.equals(queue2)); // pass

        queue2.dequeue(); // remove one element
      
        assertTrue(queue.equals(queue2)); // fail b/c we removed one element from queue2
    }
}