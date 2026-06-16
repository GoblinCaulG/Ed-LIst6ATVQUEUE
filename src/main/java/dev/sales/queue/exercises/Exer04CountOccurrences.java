package dev.sales.queue.exercises;

import dev.sales.queue.linkedqueue.LinkedQueue;


public class Exer04CountOccurrences {


    public static int countOccurrences(LinkedQueue<Integer> queue, int target) {
        int count = 0;
        int size = queue.size(); // Captura o tamanho antes de modificar

        // Usa uma fila auxiliar para preservar a ordem
        LinkedQueue<Integer> auxiliary = new LinkedQueue<>();

        // Esvazia a fila original, contando e guardando na auxiliar
        for (int i = 0; i < size; i++) {
            Integer element = queue.pop();
            if (element == target) {
                count++;
            }
            auxiliary.push(element);
        }

        // Reinsere todos na fila original, restaurando a ordem original
        for (int i = 0; i < size; i++) {
            queue.push(auxiliary.pop());
        }

        return count;
    }
}