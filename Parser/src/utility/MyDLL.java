/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;


import ADTs.Iterator;
import ADTs.ListADT;

import java.util.NoSuchElementException;



/**
 * The class <code>MyDLL</code> implements the ListADT and is a doubly linked list.
 * @author izalu
 * @author dlg12
 */
public class MyDLL<E> implements ListADT<E> {
    private MyDLLNode<E> head;
    private MyDLLNode<E> tail;
    private int size;

    /**
     * The constructor of MyDLL class.
     * It initializes the head and tail to be null; the size 0.
     */
    public MyDLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    /**
     * The method <code>size()</code> returns the size of the array (an Instance of MyDLL).
     * @return the size of the DLL
     */
    @Override
    public int size() {
        return size;
    }
    
    /**
     * <code>clear()</code> clears the elements in the DLL returning the head and tail to have null values and size to 0.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds an element of type `E` to the array at the given index
     * @param index - the index where the element toAdd will be added in the DLL (an instance of MyDLL).
     * @param toAdd - the element to be added to the the instance of MyDLL
     * @return - true if the element is successfully added to the specified index.
     * @throws NullPointerException - if toAdd is null
     * @throws IndexOutOfBoundsException - if Index specified is less not within the range of index the DLL's elements are assigned
     */
    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        
        if (toAdd == null){
            throw new NullPointerException("the element to be added is null");
        }

        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);

        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else if (index == 0) {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        } else if (index == size) {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        } else {
            MyDLLNode<E> current = getNodeAtIndex(index);
            newNode.setPrev(current.getPrev());
            newNode.setNext(current);
            current.getPrev().setNext(newNode);
            current.setPrev(newNode);
        }

        size++;
        return true;
    }
    
    /**
     * Adds the given element to the DLL
     * @param toAdd
     * @return
     * @throws NullPointerException 
     */
    @Override
    public boolean add(E toAdd) throws NullPointerException {
        return add(size, toAdd);
    }

    
    /**
     * Adds all elements from the specified ListADT to the end of the DLL
     * The elements are added in the order they are returned by the specified ListADT
     * If the specified ListADT is null or any of ts elements is null, a NullPointerException is thrown
     * 
     * @param toAdd a list containing elements to be added to this DLL
     * @return true if the DLL is modified
     * @throws NullPointerException if the given List toAdd is null or if element
     * in ListADT is null
     */
    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        
        if (toAdd == null){
            throw new NullPointerException("The given ListADT is null");
        }
        // get an iterator for the given ListADT
        Iterator<? extends E> iterator = toAdd.iterator();
        
        // add each element from the iterator to this DLL
        while (iterator.hasNext()) {
            E element = iterator.next();
            if (element==null){
                throw new NullPointerException("The given ListADT contains a null element");
            }
            add(element);
        }
        
        // DLL is modified
        return true;
    }
    
    
    /**
     * Returns the element at the specifies index in this DLL
     * @param index the index of the element to get
     * @return the element at the given index
     * @throws IndexOutOfBoundsException  if the index is out of the valid range: 0 to the size-1
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        //check if the index is within the valid range
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds:" + index);
        }
        
        // Retrieve the element at the given index
        return getNodeAtIndex(index).getData();
    }
    
    
    /**
     * Removes the element at the given index in this DLL and then returns it.
     * @param index the index of the element to be removed
     * @return the element that is removed
     * @throws IndexOutOfBoundsException if the index given is not within the range: 0 to size-1
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        // check if the index is w/in the valid range
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        // variable to store the removed node; to be returned afterits removed
        MyDLLNode<E> removedNode;
        
        // handling special cases
        // if there is only one node/element, if there are no elements/nodes, if the index
        // given is at the end of the DLL
        if (size == 1) {
            removedNode = head;
            head = null;
            tail = null;
        } else if (index == 0) {
            removedNode = head;
            head = head.getNext();
            head.setPrev(null);
        } else if (index == size - 1) {
            removedNode = tail;
            tail = tail.getPrev();
            tail.setNext(null);
        } else {
            // general case: removing the lement from the middle or somewhere else
            MyDLLNode<E> current = getNodeAtIndex(index);
            removedNode = current;
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
        }

        size--; // lessen the size of the dll
        return removedNode.getData();
    }
    
    /**
     * Removes the first occurrence of the given element/node? from the DLL.
     * If the element is found and removed, the removed element is returned
     * Otherwise, return null.
     * 
     * @param toRemove the element's index to be removed
     * @return the removed element, or null if element is not in this DLL
     * @throws NullPointerException if the given element to remove is null
     */
    @Override
    public E remove(E toRemove) throws NullPointerException {
        
        //check if the given element is null
        if (toRemove == null){
            throw new NullPointerException("The specified element to remove is null");
        }
        
        // go through the DLL
        MyDLLNode<E> current = head;
        while (current != null) {
            if (toRemove.equals(current.getData())) {
                // if the element is found then get its index and remove it
                int index = indexOf(toRemove);
                return remove(index);
            }
            current = current.getNext();
        }
        // if the element is not found, return null
        return null;
    }
    

    /**
     * Sets the value of the element/node at the given index and
     * returns the previous value of that index
     * @param index the index at which to set/change the the value
     * @param toChange the new value to set
     * @return the previous value at the given index
     * @throws NullPointerException if the value is set to null
     * @throws IndexOutOfBoundsException if the given value is not in the valid range: 0 to size-1
     */
    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        //check if the index is within the valid range
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        
        // check if the given value is null
        if(toChange ==null){
            throw new NullPointerException("The specified value to set is null");
        }
        
        // get the current node at the given index
        MyDLLNode<E> current = getNodeAtIndex(index);
        
        E oldData = current.getData(); // get the current data/value
        current.setData(toChange); //change the data
        return oldData;
    }
    
    
    /**
     * Checks whether the size of this DLL is 0 which
     * indicates if it is empty.
     * @return true if the size is 0, false if not.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    
    /**
     * Check if this DLL contains at least one occurrence of the given element
     * and returns true if so and false if not.
     * 
     * @param toFind the element/node to be checked if it is in the DLL
     * @return true if the element is found, false if not
     * @throws NullPointerException if the given element to find is null
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        
        //check if the specified element is null
        if(toFind == null){
            throw new NullPointerException("The given element/node to find is null");
        }
        
        // recall that -1 means that the index is not found
        // if the expression is true then the element is found
        return indexOf(toFind) != -1;
    }

    
    /**
     * Copies the elements of this DLL into a given array,
     * if the given array does not have enough space, a new array is created with the same size as the DLL
     * 
     * @param toHold the array into which the elements of this DLL are to be stored
     * @return the given array containing the elements of this DLL
     * @throws NullPointerException if the given array is null
     */
    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        //check if the given array is null
        if (toHold == null) {
            throw new NullPointerException("Array must not be null");
        }
        
        // if the given array does not have enough space, create a new array
        // at runtime with the same size as this DLL's
        
        if (toHold.length < size) {
            // toHold.getClass().getComponentType() gets the component type of the array
            // e.g. toHold is an array of type E then it returns E.class
            // java.lang.reflect.Array.newInstance(componentType, size) creates the new array
            // of the givent component type (E.class) and with the size given
            
            toHold = (E[]) java.lang.reflect.Array.newInstance(toHold.getClass().getComponentType(), size);
            
            // note: using reflection is necessary here b/c the type of array is determined during runtime
        }
        
        // copy the elements of this DLL into toHold
        MyDLLNode<E> current = head;
        int i = 0;
        while (current != null) {
            toHold[i++] = current.getData();
            current = current.getNext();
        }

        return toHold;
    }
    
    
    /**
     * Returns an array containing all elements of this DLL in the same order. The returned array is of
     * type Object[], and the elements are copied in the order they appear in
     * the DLL. The changes to the returned array will not affect the
     * original.
     * 
     * @return an array containing all the elements of the DLL
     */
    @Override
    public Object[] toArray() {
        
        // make a new object array with the same size as this dll
        Object[] result = new Object[size];
        
        // then copy all the elements in DLL into the array
        MyDLLNode<E> current = head;
        int i = 0;
        while (current != null) {
            result[i++] = current.getData();
            current = current.getNext();
        }
        return result;
    }
    
    
    /**
     *  Returns an iterator over the elements in the DLL
     * @return an iterator over the elements in DLL
     */
    @Override
    public Iterator<E> iterator() {
        return new DLLIterator();
    }

    
    /**
     * Returns the index of the 1st occurrence of the given element
     * If the element is not found, -1 is returned
     * @param toFind the element to find in the DLL
     * @return the index of the given element, -1 if not found
     */
    private int indexOf(E toFind) {
        MyDLLNode<E> current = head;
        int index = 0;
        while (current != null) {
            if (toFind.equals(current.getData())) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    /**
     * Returns the node at the given index in this DLL
     * @param index the index of the node to retrieve
     * @return the node at the given index
     * @throws IndexOutOfBounds if the index is not in 0 to size - 1 
     */
    private MyDLLNode<E> getNodeAtIndex(int index) {
        // validate that the index is w/in the valid range
        if (index < 0 || index>= size){
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        // iterate through the DLL to find the node 
        MyDLLNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    /**
     * Iterator implementation for iterating over the elements in the 
     * instance of MyDLL
     */
    private class DLLIterator implements Iterator<E> {
        private MyDLLNode<E> current;
        
        /**
         * Constructor, makes a new iterator starting from the head of dll
         */
        public DLLIterator() {
            current = head;
        }

        /**
         * checks if  the next node in the iterator is not null
         * @return true if the next node has a value, false if null
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Returns the data of the next node in the iteration
         * @return the data of the next node
         * @throws NoSuchElementException  if there are no elements in the iteration
         */
        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the iteration");
            }

            E data = current.getData();
            current = current.getNext();
            return data;
        }
    }
}

