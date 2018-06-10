package pl.sdacademy.Zadania;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RandomNumberMain {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);

		List<Future<Integer>> randomNumbers = new ArrayList<>();

		for (int i = 0; i < 50; i++) {
			Future<Integer> randomFromFuture = executor.submit(new RandomNumberTask(2000));
			randomNumbers.add(randomFromFuture);
		}
		List<Integer> realResults = new ArrayList<>();
		for (Future<Integer> futureResult : randomNumbers) {
			try {
				realResults.add(futureResult.get());
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			catch (ExecutionException e) {
				e.printStackTrace();
			}

		}

		executor.shutdown();
		for (int i = 0; i < 50; i++) {
			System.out.println(i + " = " + realResults.get(i));
		}

	}
}
