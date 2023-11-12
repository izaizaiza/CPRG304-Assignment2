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
import java.util.*;

public class MyStack<T> implements StackADT<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] stack;
    private int top;

    public MyStack() {
        stack = (T[]) new Object[DEFAULT_CAPACITY];
        top = -1;
    }

    public MyStack(int initialCapacity) {
        stack = (T[]) new Object[initialCapacity];
        top = -1;
    }

    @Override
    public void push(T element) {
        if (size() == stack.length) {
            expandCapacity();
        }
        top++;
        stack[top] = element;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T element = stack[top];
        stack[top] = null;
        top--;
        return element;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top + 1;
    }

    private void expandCapacity() {
        T[] newArray = (T[]) new Object[stack.length * 2];
        System.arraycopy(stack, 0, newArray, 0, stack.length);
        stack = newArray;
    }
}
