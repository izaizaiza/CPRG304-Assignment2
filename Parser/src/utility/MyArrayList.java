/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;
import ADTs.Iterator;
import ADTs.ListADT;

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
     * 
     */
    public MyArrayList(){
        this.array = new Object[defaultCapacity]; // created an object array with capacity of 5 elements
        this.size = 0; // so empty no elements atm;
    }
    
    /**
     * 
     * @return int size - size of Array
     */
    @Override
    public int size() {
        return size;
    }
    
    /**
     * 
     */
    @Override
    public void clear() {
        array = new Object[defaultCapacity];
        size = 0;
    }
    
    /**
     * 
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
     * 
     * @param toAdd
     * @return
     * @throws NullPointerException 
     */
    @Override
    public boolean add(E toAdd) throws NullPointerException {
        ensureCapacity(size + 1);
        array[size++] = toAdd;
        return true;
    }

    /**
     * 
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
     * 
     * @param index
     * @return
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
     * 
     * @param index
     * @return
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
     * 
     * @param toRemove
     * @return
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
     * 
     * @param index
     * @param toChange
     * @return
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
     * 
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 
     * @param toFind
     * @return
     * @throws NullPointerException 
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        return indexOf(toFind) != -1;
    }
    
    /**
     * 
     * @param toHold
     * @return
     * @throws NullPointerException 
     */
    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
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
     * 
     * @return 
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

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

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

    private int indexOf(E toFind) {
        for (int i = 0; i < size; i++) {
            if (toFind.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    private class MyIterator implements Iterator<E> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public E next() {
            return (E) array[currentIndex++];
        }
    }

}
