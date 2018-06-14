package pl.sdacademy.tdd;

public class FizzBuzz {
		/**
		 * Returns a "Fizz" when {@code number} if divisible by 3, "Buzz" when divisible by 5, "FizzBuzz" when
		 * divisible by 3 and 5, and finally a string representation of a {@code number} in any other case (e.g. "1"
		 * for 1, "2" for 2).
		 *
		 * @param number a number
		 * @return the string according to the specification
		 */
		public static String msg(int number) {
			// TODO: implement according to javadoc specification following TDD principles  hgjgjhg
			if (isPrime(number)==true){
				if (number == 3)
					return "FizzWhiz";
				if (number == 5)
					return "BuzzWhiz";
				else
					return "Whiz";
			}
			if (number % 15==0)
				return "FizzBuzz";
			if (number % 3 == 0)
				return "Fizz";
			if (number % 5==0)
				return "Buzz";
			return String.valueOf(number);
		}
		private static boolean isPrime(int number){
			if ((number>0) && (number % 1 == 0) && (number % number == 0)){
				for (int i = 2; i <number ; i++)
				{
					if ((number % i == 0) == true)
						return false;
				}
			}
			if (number != 1)
				return true;
			else
				return false;

		}
}
