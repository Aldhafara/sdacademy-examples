package pl.sdacademy.Zadania;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SayHelloMain {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);

		for (int i = 0; i <10 ; i++) {
			executor.submit(new SayHelloTask());
		}



		executor.shutdown();
		try {
			executor.awaitTermination(6, TimeUnit.SECONDS);
		}
		catch (InterruptedException e) {
			System.out.println("Executor nie chce już czekać...");;
		}finally {
			executor.shutdownNow();
		}



	}
}
