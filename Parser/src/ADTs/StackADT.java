/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ADTs;

/**
 *
 * @author dlg12
 */
public interface StackADT<T> {
    void push(T element);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}