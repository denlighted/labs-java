package org.example;

class Translator implements Runnable {
    private final CircularBuffer<String> inputBuffer;
    private final CircularBuffer<String> outputBuffer;
    private final int id;

    public Translator(CircularBuffer<String> inputBuffer, CircularBuffer<String> outputBuffer, int id) {
        this.inputBuffer = inputBuffer;
        this.outputBuffer = outputBuffer;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                String message = inputBuffer.remove();
                String translatedMessage = "Потік № " + id + " переклав повідомлення " + message;
                outputBuffer.add(translatedMessage);
                ConsoleOutput.print("Translator " + id + ": " + translatedMessage);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}