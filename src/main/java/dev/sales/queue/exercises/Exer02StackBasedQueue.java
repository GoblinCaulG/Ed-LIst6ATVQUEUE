package dev.sales.queue.exercises;

import dev.sales.stack.arraystack.ArrayStack;

public class Exer02StackBasedQueue {

    private final ArrayStack<Integer> inbox;   // Recebe os push()
    private final ArrayStack<Integer> outbox;  // Fornece os pop()/peek()
    private static final int CAPACITY = 100;

    public Exer02StackBasedQueue() {
        this.inbox  = new ArrayStack<>(CAPACITY);
        this.outbox = new ArrayStack<>(CAPACITY);
    }


    public void push(int x) {
        inbox.push(x);
    }


    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }
        transferIfNeeded();
        return outbox.pop();
    }


    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }
        transferIfNeeded();
        return outbox.peek();
    }


    public boolean isEmpty() {
        return inbox.isEmpty() && outbox.isEmpty();
    }

    public int size() {
        return inbox.size() + outbox.size();
    }


    private void transferIfNeeded() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
    }
}