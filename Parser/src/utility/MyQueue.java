/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author izalu
 */
package utility;
import ADTs.QueueADT;
import ADTs.Iterator;

import utility.MyArrayList;
public class MyQueue<E> implements QueueADT<E> {
    private MyArrayList<E> list;

    public MyQueue() {
        this.list = new MyArrayList<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void enqueue(E element) {
        list.add(element);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.remove(0);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.get(0);
    }

    @Override
    public boolean equals(QueueADT<E> otherQueue) {
        // Implement the equality comparison logic
        // This depends on how you want to compare two queues
        // It might involve comparing each element in order
        // or using other criteria specific to your use case.
        // For simplicity, let's assume two queues are equal if their elements are equal.
        return list.equals(((MyQueue<E>) otherQueue).list);
    }

   
    @Override
    public Iterator<E> iterator(){
        Iterator<E> iterator = this.list.iterator();
        return iterator;
    }

    @Override
    public E[] toArray(E[] queue) {
        return list.toArray(queue);
    }
    
    

    @Override
    public boolean isFull() {
        // This might be true depending on the underlying implementation
        // If you have a fixed-size implementation, you can implement it accordingly
        return false;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void dequeueAll() {
        list.clear();
    }
}
