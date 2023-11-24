/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;
import ADTs.Iterator;
import ADTs.ListADT;
import java.util.NoSuchElementException;

/**
 *
 * @author dlg12
 * @param E
 * 
 */
public class MyArrayList<E> implements ListADT<E> {
    
    private static int defaultCapacity = 5;
    private Object[] array;
    private int size;
    
    /**
     * MyArrayList Constructor
     */
    public MyArrayList(){
        this.array = new Object[defaultCapacity]; // created an object array with capacity of 5 elements
        this.size = 0; // so empty no elements atm;
    }
    
    /**
     * method <code>size()</code> is a method for getting the size of the array
     * @return int size - size of Array
     */
    @Override
    public int size() {
        return size;
    }
    
    /**
     * method <code>clear()</code> clears the array and turns its size to 0
     */
    @Override
    public void clear() {
        array = new Object[defaultCapacity];
        size = 0;
    }
    
    /**
     * method <code>add(params)</code> adds an element (toAdd) of type E to the array
     * at the <code>index</code> provided
     * @param index
     * @param toAdd
     * @return
     * @throws NullPointerException
     * @throws IndexOutOfBoundsException 
     */
    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        ensureCapacity(size + 1);

        // Shift elements to the right to make space for the new element
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = toAdd;
        size++;
        return true;
    }
    
    
    /**
     * method <code>add()</code>  overloads the other add() method;
     * this method adds the given element at the end of the MyArrayList instance
     * which is not like the other which takes an additional parameter to specify the index where the element is added
     * @param toAdd
     * @return - a boolean when 
     * @throws NullPointerException 
     */
    @Override
    public boolean add(E toAdd) throws NullPointerException {
        try{
        ensureCapacity(size + 1);
        array[size++] = toAdd;
        return true;
        }
        catch(Exception E){
            System.out.println("Something went wrong adding the element to the array.");
            return false;
        }
        
    }

    /**
     * method <code>addAll(param)</code> takes a list and adds all its elements
     * to the MyArrayList instance.
     * @param toAdd
     * @return
     * @throws NullPointerException 
     */
    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        
        Iterator<? extends E> iterator = toAdd.iterator();
        
        while(iterator.hasNext()){
            add(iterator.next());
        }
        
        return true;
    }
    
    
    /**
     * method <code>get(index)</code> takes an index parameter and returns the value in
     * the index of the the MyArrayList Instance
     * @param index
     * @return E array[index]
     * @throws IndexOutOfBoundsException 
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return (E) array[index];
    }
    
    /**
     * The method <code>remove(index)</code> removes the element in the MyArrayList
     * instance at the given index.
     * @param index
     * @return - the element removed
     * @throws IndexOutOfBoundsException 
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        E removedElement = (E) array[index];

        // Shift elements to the left to fill the gap
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null; // Set the last element to null
        size--;

        return removedElement;
    }
    /**
     * Method <code>remove(toRemove)</code>overloads the other remove();
     * It takes an element to be removed and returns the index it was at.
     * @param toRemove
     * @return - the element removed; other wise returns null
     * @throws NullPointerException 
     */
    @Override
    public E remove(E toRemove) throws NullPointerException {
        int index = indexOf(toRemove);
        if (index != -1) {
            return remove(index);
        }
        return null;
    }
    
    /**
     * method <code>set(index, toChange)</code> sets or changes the value or element at a given index of
     * the array (i.e., MyArrayList instance).
     * @param index
     * @param toChange
     * @return - the previous element that was changed.
     * @throws NullPointerException
     * @throws IndexOutOfBoundsException 
     */
    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        E previousElement = (E) array[index];
        array[index] = toChange;
        return previousElement;
    }
    
    /**
     * The method <code>isEmpty()</code> checks if MyArrayList Instance is empty (i.e., if size is 0)
     * It returns true if it indeed is empty and false if not.
     * @return - a boolean whether MyArrayList is empty or not.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * The method <code>contains(toFind)</code> checks whether the My array instance contains
     * the given element of type E.
     * @param toFind - an element of type E
     * @return - a boolean whether MyArrayList instance contains toFind
     * @throws NullPointerException 
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        return indexOf(toFind) != -1;
    }
    
    /**
     * method <code>toArray(toHold)</code> converts elements of an internal array 
     * to an array with the type `E`.
     * @param toHold -  an array of type E[]
     * @return - the array that contains the copied elements of the internal array
     * @throws NullPointerException 
     */
    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        // if array is not enough, create new array of the same type `E` and with
        // the same size as array the internal array.
        if (toHold.length < size) {
            toHold = (E[]) new Object[size];
        }

        // Manual copy of elements to the array
        for (int i = 0; i < size; i++) {
            toHold[i] = (E) array[i];
        }

        return toHold;
    }

    /**
     * Method <code>toArray()</code> overloads the other toArray(toHold) and
     * takes no parameters and instead creates a new array of type `Object`,
     * copies the elements of internal array and returns the new array
     * @return - the new array.
     */
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];

        // Manual copy of elements to the array
        for (int i = 0; i < size; i++) {
            result[i] = array[i];
        }

        return result;
    }
    
    /**
     * Creates an iterator for the elements in the class.
     * @return - an instance of an iterator of type `E` for the class
     */
    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }
    
    /**
     * Ensures that the internal array has enough capacity to accommodate at least
     * a specified minimum of elements which is the parameter.
     * if the old capacity is less than the minimum, then it doubles the old capacity.
     * Then creates a new array of type `Object` with the new capacity as the size,
     * and copies the current element in the array into the new one.
     * @param minCapacity - the minimum capacity that the array is supposed to hold.
     */
    private void ensureCapacity(int minCapacity) {
        int oldCapacity = array.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            Object[] newArray = new Object[newCapacity];

            // Manual copy of elements to the new array
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }

            array = newArray;
        }
    }
    
    /**
     *  The <code>indexOf(toFind)</code> method searches for the index element in the internal
     * array. If the given element (toFind) is found, it returns the index
     * @param toFind - the element in the array to be found its index.
     * @return - the index of the element type: int
     */
    private int indexOf(E toFind) {
        for (int i = 0; i < size; i++) {
            if (toFind.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Iterator class to implement Iterator<E> interface for MyArrayList.
     * This iterator allows iterating over the element of the internal array.
     */
    private class MyIterator implements Iterator<E> {
        // The current index of the iterator
        private int currentIndex = 0;
        
        /**
         * Checks if there are more elements in the array to iterate over
         * @return true if there are more elements, false otherwise
         */
        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }
        /**
         * Retrieves the next element in the iteration
         * @return  the next element in the iteration
         * @throws NoSuchElementException if there are no more element in the iteration
         */
        @Override
        public E next() {
            if (!hasNext()){
                throw new NoSuchElementException("No more elements in the array to iterate.");
            }
            return (E) array[currentIndex++];
        }
    }

}
