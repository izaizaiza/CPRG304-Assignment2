/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

/**
 * Represents a node in a doubly linked list
 * @author izalu
 * @param <E> the type of the data stored in the node
 */
public class MyDLLNode<E> {
    private E data;
    private MyDLLNode<E> next;
    private MyDLLNode<E> prev;

    
    /**
     * Constructs a new node with the given data
     * @param data the data to be stored in the node
     */
    public MyDLLNode(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    
    /**
     * Gets the data stored in the node
     * @return the data stored in the node
     */
    public E getData() {
        return data;
    }
    
    /**
     * Gets the next node in the DLL.
     * 
     * @return the next node in the list
     */
    public MyDLLNode<E> getNext() {
        return next;
    }

    /**
     * Gets the previous node in the DLL
     * @return the previous node
     */
    public MyDLLNode<E> getPrev() {
        return prev;
    }

    /**
     * Sets the next node in the DLL
     * @param next the next node to be set
     */
    public void setNext(MyDLLNode<E> next) {
        this.next = next;
    }

    /**
     * Set the data in the node; this node
     * @param data the data to be set
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * Sets the previous node in the DLL
     * @param prev the previous node to be set
     */
    public void setPrev(MyDLLNode<E> prev) {
        this.prev = prev;
    }
}
