package NotifyAndWait;

import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity = 5; //

    // Producer adds data
    public synchronized void produce(int value) throws InterruptedException {
        while (buffer.size() == capacity) {
            System.out.println("Buffer full. Producer waiting...");
            wait();
        }
        buffer.add(value);
        System.out.println("Produced: " + value);


        notify();
    }


    public synchronized void consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.println("Buffer empty. Consumer waiting...");
            wait();
        }
        int value = buffer.poll();
        System.out.println("Consumed: " + value);


        notify();
    }
}

public class NotifyExample {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        // Producer thread
        Thread producer = new Thread(() -> {
            int i = 1;
            try {
                while (true) {
                    buffer.produce(i++);
                    Thread.sleep(500); // simulate production time
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    buffer.consume();
                    Thread.sleep(1000); // simulate consumption time
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
