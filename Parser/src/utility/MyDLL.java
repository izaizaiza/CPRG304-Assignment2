/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

/**
 *
 * @author izalu
 */
import ADTs.Iterator;
import ADTs.ListADT;

import java.util.NoSuchElementException;

public class MyDLL<E> implements ListADT<E> {
    private MyDLLNode<E> head;
    private MyDLLNode<E> tail;
    private int size;

    public MyDLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
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

    @Override
    public boolean add(E toAdd) throws NullPointerException {
        return add(size, toAdd);
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        Iterator<? extends E> iterator = toAdd.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }
        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        return getNodeAtIndex(index).getData();
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        MyDLLNode<E> removedNode;
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
            MyDLLNode<E> current = getNodeAtIndex(index);
            removedNode = current;
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
        }

        size--;
        return removedNode.getData();
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        MyDLLNode<E> current = head;
        while (current != null) {
            if (toRemove.equals(current.getData())) {
                int index = indexOf(toRemove);
                return remove(index);
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        MyDLLNode<E> current = getNodeAtIndex(index);
        E oldData = current.getData();
        current.setData(toChange);
        return oldData;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        return indexOf(toFind) != -1;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("Array must not be null");
        }
        if (toHold.length < size) {
            toHold = (E[]) java.lang.reflect.Array.newInstance(toHold.getClass().getComponentType(), size);
        }
        MyDLLNode<E> current = head;
        int i = 0;
        while (current != null) {
            toHold[i++] = current.getData();
            current = current.getNext();
        }

        return toHold;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        MyDLLNode<E> current = head;
        int i = 0;
        while (current != null) {
            result[i++] = current.getData();
            current = current.getNext();
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new DLLIterator();
    }

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

    private MyDLLNode<E> getNodeAtIndex(int index) {
        MyDLLNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    private class DLLIterator implements Iterator<E> {
        private MyDLLNode<E> current;

        public DLLIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

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

