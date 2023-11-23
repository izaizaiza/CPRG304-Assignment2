/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

/**
 *
 * @author dlg12
 */
import ADTs.StackADT;
import ADTs.Iterator;
import utility.MyArrayList;

import java.util.EmptyStackException;

public class MyStack<E> implements StackADT<E> {
    private MyArrayList<E> list;

    public MyStack() {
        this.list = new MyArrayList<>();
    }

    @Override
    public void push(E toAdd) throws NullPointerException {
        list.add(toAdd);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.remove(list.size() - 1);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(list.size() - 1);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        return list.toArray(holder);
    }

    @Override
    public boolean contains(E toFind) {
        return list.contains(toFind);
    }

    @Override
    public int search(E toFind) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (toFind.equals(list.get(i))) {
                return list.size() - i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public boolean equals(StackADT<E> that) {
        if (that == null) {
            return false;
        }

        if (this.size() != that.size()) {
            return false;
        }

        Iterator<E> thisIterator = this.iterator();
        Iterator<E> thatIterator = that.iterator();

        while (thisIterator.hasNext()) {
            E thisElement = thisIterator.next();
            E thatElement = thatIterator.next();

            if (!thisElement.equals(thatElement)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int size() {
        return list.size();
    }
}
