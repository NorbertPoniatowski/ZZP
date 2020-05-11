package callable;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 1. Stwórz pulę wątków
 * 	a) Wykorzystaj Runtime.getRuntime().availableProcessors() aby pobrać ilość dostępnych procesów
 * 	b) pulę stwórz wykorzystując Executors.newFixedThreadPool(numberOfThreads);
 * 2. Stwórz zadania ComplexMathCallable w zależności od ilości wątków
 * 3. Zgłoś zadania do wykonania (metoda submit);
 * 4. Odłóż zwracane obiekty typu Future na listę - przydadzą się przy pobieraniu wyników
 * 5. Przeiteruj po liście i wywołaj metodę get() na obiektach Future
 * 	a) pamiętaj, że poszczególne wyniki należy zsumować
 * 6. Pamiętaj o zamknięciu ExecutorService'u - executor.shutdown();
 * 7. Zaprezentuj wyniki i zinterpretuj czas wykonania
 * 
 */
public class ComplexMathRunner {
	public static void main(String[] args) {
		System.out.println("Program start...");
		ComplexMath cm = new ComplexMath(8000, 8000);
		long startTime = System.currentTimeMillis();
		System.out.println(cm.calculate());
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time: " + ((endTime - startTime) / 1000d) + " seconds.");


		System.out.println("\nProgram start with threads...");
		int numberOfThreads = Runtime.getRuntime().availableProcessors();
		ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
		List<Future<Double>> futures = new LinkedList<>();
		int columnsPerThread = 8000 / numberOfThreads;
		startTime = System.currentTimeMillis();
		for (int threadNumber = 0; threadNumber < numberOfThreads; threadNumber++) {
			ComplexMathCallable complexMathCallable = new ComplexMathCallable(cm,
					columnsPerThread * threadNumber, columnsPerThread * (threadNumber + 1) - 1);
			futures.add(executorService.submit(complexMathCallable));
		}
		executorService.shutdown();
		System.out.println(futures.stream().mapToDouble(doubleFuture -> {
			try {
				return doubleFuture.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
				return 0.0;
			}
		}).sum());
		endTime = System.currentTimeMillis();
		System.out.println("Execution time: " + ((endTime - startTime) / 1000d) + " seconds.");
	}
}
