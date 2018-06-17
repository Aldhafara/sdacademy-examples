package pl.sdacademy.tdd;


import java.util.Map;

public class Fibonacci {
	public static int Fibonacci(int number)
	{
		if (number == 0 || number == 1)
		{
			return number;
		}
		return (Fibonacci(number - 1)) + (Fibonacci(number - 2));
	}
}
