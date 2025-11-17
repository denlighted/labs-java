package org.example;

import org.example.MonteCarloWorker;

public class ParallelMonteCarloPi {

    private static final long ITERATIONS = 1_000_000_000L;

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1) {
            System.out.println("Usage: java ParallelMonteCarloPi <threads>");
            return;
        }

        int threads = Integer.parseInt(args[0]);
        Thread[] workers = new Thread[threads];
        MonteCarloWorker[] results = new MonteCarloWorker[threads];

        long iterationsPerThread = ITERATIONS / threads;

        long start = System.currentTimeMillis();

        for (int i = 0; i < threads; i++) {
            results[i] = new MonteCarloWorker(iterationsPerThread);
            workers[i] = new Thread(results[i]);
            workers[i].start();
        }

        for (Thread t : workers) {
            t.join();
        }

        long end = System.currentTimeMillis();

        long totalInside = 0;
        for (MonteCarloWorker w : results) {
            totalInside += w.getInsideCount();
        }

        double pi = 4.0 * totalInside / ITERATIONS;
        double timeMs = end - start;

        System.out.printf("PI is %.5f%n", pi);
        System.out.println("THREADS " + threads);
        System.out.printf("ITERATIONS %,d%n", ITERATIONS);
        System.out.printf("TIME %.2fms%n", timeMs);
    }
}