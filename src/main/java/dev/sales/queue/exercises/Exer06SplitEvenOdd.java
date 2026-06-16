package dev.sales.queue.exercises;

import dev.sales.queue.linkedqueue.LinkedQueue;

public class Exer06SplitEvenOdd {


    public static class Result {
        public final LinkedQueue<Integer> evenQueue;
        public final LinkedQueue<Integer> oddQueue;

        public Result(LinkedQueue<Integer> evenQueue, LinkedQueue<Integer> oddQueue) {
            this.evenQueue = evenQueue;
            this.oddQueue  = oddQueue;
        }
    }


    public static Result splitEvenOdd(LinkedQueue<Integer> original) {
        LinkedQueue<Integer> evenQueue = new LinkedQueue<>();
        LinkedQueue<Integer> oddQueue  = new LinkedQueue<>();

        while (!original.isEmpty()) {
            int element = original.pop();

            if (element % 2 == 0) {
                evenQueue.push(element);
            } else {
                oddQueue.push(element);
            }
        }

        return new Result(evenQueue, oddQueue);
    }
}