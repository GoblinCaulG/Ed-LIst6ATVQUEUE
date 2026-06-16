package dev.sales.queue.exercises;

import dev.sales.queue.arrayqueue.ArrayQueue;


public class Exer03OutputRestrictedDeque extends ArrayQueue<Integer> {

    public Exer03OutputRestrictedDeque(int capacity) {
        super(capacity);
    }


    @SuppressWarnings("unchecked")
    public Integer popBack() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }

        // O último elemento sempre está em items[count - 1]
        Integer removedElement = (Integer) items[count - 1];

        // Limpa a posição e reduz o contador — sem deslocamento!
        items[count - 1] = null;
        count--;

        return removedElement;
    }
}