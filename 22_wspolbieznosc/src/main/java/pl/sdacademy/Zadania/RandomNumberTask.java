package pl.sdacademy.Zadania;

import java.util.Random;
import java.util.concurrent.Callable;

public class RandomNumberTask implements Callable {

	private static final Random random = new Random();
	private int range;

	public RandomNumberTask(int range){
		this.range=range;
	}

	@Override
	public Object call() throws Exception {
		return random.nextInt(range);
	}
}
