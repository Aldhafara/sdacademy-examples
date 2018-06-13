package sdacademy.FizzBuzz;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class FizzBuzzTest {

	@Test
	void fizzBuzz() throws Exception {
		// given
		int number = 5;

		// when
		String msg = FizzBuzz.msg(number);

		// then
		assertThat(msg).isEqualTo("Fizz");
	}
}