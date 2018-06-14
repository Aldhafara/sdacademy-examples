import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.sdacademy.tdd.FizzBuzz;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Fail.fail;

class FizzBuzzTest {

	@DisplayName("should return any non-empty string when number is 0")
	@Test
	void anyString() throws Exception{
		//when
		String result = FizzBuzz.msg(0);
		//then
		assertThat(result).isNotEmpty();
	}

	/*@DisplayName("should return \"1\" when number is 1")
	@Test
	void one() {
		//when
		String msg = FizzBuzz.msg(1);
		//then
		assertThat(msg).isEqualTo("1");
	}*/

	@DisplayName("should return string according FizzBuzz specyfication")
	@ParameterizedTest(name = "given = {0}, expected = \"{1}\"")
	@CsvSource({"1, 1","2, Whiz","3, FizzWhiz","4, 4","5, BuzzWhiz","6, Fizz","7, Whiz","10, Buzz","11, Whiz",
		"13, Whiz","17, Whiz","19, Whiz","15, FizzBuzz","30, FizzBuzz","97, Whiz"})
	void testFizzBuzz(int number, String expectedMsg) throws Exception{
		assertThat(FizzBuzz.msg(number)).isEqualTo(expectedMsg);
	}
}
