package org.example;

class Producer implements Runnable {
    private final CircularBuffer<String> buffer;
    private final int id;

    public Producer(CircularBuffer<String> buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                String message = "Потік № " + id + " згенерував повідомлення " + (i + 1);
                buffer.add(message);
                ConsoleOutput.print("Producer " + id + ": " + message);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}