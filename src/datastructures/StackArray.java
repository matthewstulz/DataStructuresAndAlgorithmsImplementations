package datastructures;

import java.util.EmptyStackException;

public class StackArray {

    private static final int STACK_SIZE = 50;
    private static final String STACK_OVERFLOW = "Stack overflow";
    private int[] array;
    private int top;

    public StackArray() {
        array = new int[STACK_SIZE];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return array[top--];
    }

    public void push(int value) throws StackOverflowError {
        if (top + 1 >= STACK_SIZE) throw new StackOverflowError();
        array[++top] = value;
    }

    public int peek() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return array[top];
    }

    public int search(int value) {
        int i = 0;
        while (i < STACK_SIZE - 1) {
            if (array[i] == value) return i + 1;
            else i++;
        }
        return -1;
    }
}
