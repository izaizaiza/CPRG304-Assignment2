/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ADTs;

/**
 *
 * @author dlg12
 * @param <E> - the data type
 */
public interface StackADT<E> {
    /**
     * 
     * @param element 
     * adds element to the stack
     */
    void push(E element);
    /**
     * 
     * removes the last element in the stack 
     * @return E
     */
    E pop();
    /**
     * 
     * @return E, the element in the stack 
     */
    E peek();
    /**
     * 
     * @return boolean to see if stack has no elements 
     */
    boolean isEmpty();
    /**
     * 
     * @return int - how many elements in the stack 
     */
    int size();
}