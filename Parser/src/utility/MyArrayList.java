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
 * @param <E> - the data type of the elements in the array list
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
     * A method for getting the size of the array
     * @return the  size of Array
     */
    @Override
    public int size() {
        return size;
    }
    
    /**
     * Method clear() clears the array and turns its size to 0
     */
    @Override
    public void clear() {
        array = new Object[defaultCapacity];
        size = 0;
    }
    
    /**
     * Adds an element of type E to the array
     * at the index provided
     * @param index the index (int) where to add the element
     * @param toAdd the element to be added
     * @return true once the addition of the element is done
     * @throws NullPointerException if the element to be added is null
     * @throws IndexOutOfBoundsException if the given index is not in range: 0 to size - 1
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
     * method add() overloads the other add() method;
     * this method adds the given element at the end of the MyArrayList instance
     * which is not like the other which takes an additional parameter to specify the index where the element is added
     * @param toAdd the element to be added
     * @return true if successful, false if not
     * @throws NullPointerException if the array list given is empty
     */
    @Override
    public boolean add(E toAdd) throws NullPointerException {
        try{
            if(toAdd==null){
                throw new NullPointerException("The array list given is empty.");
            }
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
     * method addAll(...) takes a list and adds all its elements
     * to the MyArrayList instance.
     * @param toAdd the array list that contains the elements to be added
     * @return true if successful
     * @throws NullPointerException  if given toAdd is null
     */
    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        
        if(null==toAdd){
            throw new NullPointerException("The array list given is empty.");
        }
        
        Iterator<? extends E> iterator = toAdd.iterator();
        
        while(iterator.hasNext()){
            add(iterator.next());
        }
        
        return true;
    }
    
    
    /**
     * method get(index) takes an index parameter and returns the value in
     * the index of the the MyArrayList Instance
     * @param index the given index where to get the value from
     * @return the value of the element of type E
     * @throws IndexOutOfBoundsException if given an index not in range: 0 to size-1
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return (E) array[index];
    }
    
    /**
     * The method remove(index) removes the element in the MyArrayList
     * instance at the given index.
     * @param index the given index where to remove the value
     * @return the element removed
     * @throws IndexOutOfBoundsException if given an index not in range: 0 to size-1
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
     * Method remove(toRemove)overloads the other remove();
     * It takes an element to be removed and returns the index it was at.
     * @param toRemove element to be removed 
     * @return the element removed; other wise returns null
     * @throws NullPointerException if given element is null
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
     * method set(index, toChange) sets or changes the value or element at a given index of
     * the array (i.e., MyArrayList instance).
     * @param index of where the element to be set
     * @param toChange the element to be set
     * @return the previous element that was changed.
     * @throws NullPointerException is toChange is null
     * @throws IndexOutOfBoundsException if given an index not in range: 0 to size-1
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
     * The method isEmpty() checks if MyArrayList Instance is empty (i.e., if size is 0)
     * It returns true if it indeed is empty and false if not.
     * @return a boolean whether MyArrayList is empty or not.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * The method contains(toFind) checks whether the My array instance contains
     * the given element of type E.
     * @param toFind an element of type E
     * @return a boolean whether MyArrayList instance contains toFind
     * @throws NullPointerException if toFind is null
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if(toFind==null){
            throw new NullPointerException("The given element to check is null");
        }
        return indexOf(toFind) != -1;
    }
    
    /**
     * method toArray(toHold) converts elements of an internal array 
     * to an array with the type `E`.
     * @param toHold an array of type E[]
     * @return the array that contains the copied elements of the internal array
     * @throws NullPointerException if the array list to be converted is null;
     */
    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        
        if(size==0){
            throw new NullPointerException("The array list is empty. Nothing to convert to Array");
        }
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
     * Method toArray() overloads the other toArray(toHold) and
     * takes no parameters and instead creates a new array of type `Object`,
     * copies the elements of internal array and returns the new array
     * @return the new array.
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
     * @return an instance of an iterator of type `E` for the class
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
     * @param minCapacity the minimum capacity that the array is supposed to hold.
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
     *  The indexOf(toFind) method searches for the index element in the internal
     * array. If the given element (toFind) is found, it returns the index
     * @param toFind the element in the array to be found its index.
     * @return the index of the element type: int
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
     * Iterator class to implement Iterator interface for MyArrayList.
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
