package ADTs;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


/**
 * 
 * @author izalu
 * @param <E> 
 */
public interface QueueADT<E> {
    
    
    
    //methods or operations
    /**
     * @return an int data type; the size of the queue, i.e., how many elements
     * are in the queue
     */
    public int size();
    
    /**
     * @param element, with generic T data type
     * takes element and add it at the end of the queue
     */
    public void enqueue(E element);
    
    /**
     * removes the first element in the queue
     * @return E
     */
    public E dequeue();
    
    
    /**
     * accesses the first element in the queue without removing it
     * @return E
     */
    public E peek();
    
    
    /**
     * @param otherQueue - another QueueADT to compare with
     * @return boolean - true or false if the two contain equal items
     * in the same order
     */
    public boolean equals(QueueADT<E> otherQueue);
    
    
    /**
     * @return an iterator over the items contained in the queue
     */
    public Iterator<E> iterator();
    
    
    /**
     * @param queue which E[] array 
     * @return  an array containing all of the items in this queue
     */
    public E[] toArray( E[] queue);
    

    
    
    /**
     * @return a boolean to see if queue is full
     */
    public boolean isFull();
    
    /**
     * @return a boolean to see if queue is empty
     */
    public boolean isEmpty();
    
    
    /**
     * clears the queue
     */
    public void dequeueAll();
    
}
