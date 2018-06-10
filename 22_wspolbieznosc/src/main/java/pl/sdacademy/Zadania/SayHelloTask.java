package pl.sdacademy.Zadania;

import java.util.concurrent.TimeUnit;

public class SayHelloTask implements Runnable{
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println("Witaj " + threadName);
		try {
			TimeUnit.SECONDS.sleep(5);
		}
		catch (InterruptedException e) {
			System.out.println(threadName + " Ktoś mi przerwał!");
		}
	}
}
