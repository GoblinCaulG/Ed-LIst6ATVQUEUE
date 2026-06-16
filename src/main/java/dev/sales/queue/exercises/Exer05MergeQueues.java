package dev.sales.queue.exercises;

import dev.sales.queue.linkedqueue.LinkedQueue;

public class Exer05MergeQueues {

    public static LinkedQueue<Integer> mergeTwoQueues(LinkedQueue<Integer> q1,
                                                      LinkedQueue<Integer> q2) {
        LinkedQueue<Integer> result = new LinkedQueue<>();

        // Enquanto ambas tiverem elementos, compara e insere o menor
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.peek() <= q2.peek()) {
                result.push(q1.pop());
            } else {
                result.push(q2.pop());
            }
        }

        // Despeja o restante da fila que ainda tiver elementos
        while (!q1.isEmpty()) {
            result.push(q1.pop());
        }
        while (!q2.isEmpty()) {
            result.push(q2.pop());
        }

        return result;
    }
}