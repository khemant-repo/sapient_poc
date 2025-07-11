package demo;

public class TestBlockingQueue {
    public static void main(String[] args) {
        CustomBlockingQueue<Integer> queue = new CustomBlockingQueue<>(5);

        Runnable producer = () -> {
            int count = 0;
            while (true) {
                try {
                    queue.put(count++);
                    Thread.sleep(500); // Slow down to observe behavior
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = () -> {
            while (true) {
                try {
                    queue.take();
                    Thread.sleep(1000); // Slow down to observe behavior
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Start multiple producers and consumers
        for (int i = 0; i < 2; i++) {
            new Thread(producer, "Producer-" + i).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(consumer, "Consumer-" + i).start();
        }
    }
}
