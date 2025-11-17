package org.example;

import java.util.Random;

public class MonteCarloWorker implements Runnable {

    private final long iterations;
    private long insideCount;

    public MonteCarloWorker(long iterations) {
        this.iterations = iterations;
    }

    public long getInsideCount() {
        return insideCount;
    }

    @Override
    public void run() {
        Random rand = new Random();
        long inside = 0;

        for (long i = 0; i < iterations; i++) {
            double x = rand.nextDouble();
            double y = rand.nextDouble();

            if (x * x + y * y <= 1.0) {
                inside++;
            }
        }

        this.insideCount = inside;
    }
} 