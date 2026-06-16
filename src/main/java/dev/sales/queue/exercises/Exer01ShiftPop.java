package dev.sales.queue.exercises;

import dev.sales.queue.arrayqueue.ArrayQueue;


public class Exer01ShiftPop extends ArrayQueue<Integer> {

    public Exer01ShiftPop(int capacity) {
        super(capacity);
    }


    @Override
    @SuppressWarnings("unchecked")
    public Integer pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }

        Integer removedElement = (Integer) items[0];

        // Desloca todos os elementos uma posição para a esquerda
        for (int i = 1; i < count; i++) {
            items[i - 1] = items[i];
        }

        count--;
        items[count] = null; // Limpa referência para o GC
        return removedElement;
    }
}