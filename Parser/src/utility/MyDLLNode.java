/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

/**
 *
 * @author izalu
 */
public class MyDLLNode<E> {
    private E data;
    private MyDLLNode<E> next;
    private MyDLLNode<E> prev;

    public MyDLLNode(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public E getData() {
        return data;
    }

    public MyDLLNode<E> getNext() {
        return next;
    }

    public MyDLLNode<E> getPrev() {
        return prev;
    }

    public void setNext(MyDLLNode<E> next) {
        this.next = next;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setPrev(MyDLLNode<E> prev) {
        this.prev = prev;
    }
}
