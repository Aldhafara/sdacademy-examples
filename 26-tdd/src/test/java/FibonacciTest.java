import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.sdacademy.tdd.Fibonacci;

import static org.assertj.core.api.Assertions.*;

class FibonacciTest {


	@DisplayName("should return string according FizzBuzz specyfication")
	@ParameterizedTest(name = "given = {0}, expected = {1}")
	@CsvSource({"0, 0","1, 1","2, 1","3, 2","4, 3","5, 5","6, 8","7, 13","8, 21"})
	void testFibonacci(int number, int expectedInt) throws Exception{
		assertThat(Fibonacci.Fibonacci(number)).isEqualTo(expectedInt);
	}
}
