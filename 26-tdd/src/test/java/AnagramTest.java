import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.sdacademy.tdd.Anagram;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class AnagramTest {


	@Test
	@DisplayName("should return anagram strings")
	public void testAnagram(){
		//given
		String word = "ul";
		//when
		Set<String> anagramWord = Anagram.of(word);
		//then
		assertThat(anagramWord).containsOnly("ul","lu");
	}

	@Test
	@DisplayName("should return anagram strings for kot")
	public void testAnagramKot(){
		//given
		String word = "kot";
		//when
		Set<String> anagramWord = Anagram.of(word);
		//then
		assertThat(anagramWord).contains("kot","kto","okt","otk");
	}

	@Test
	@DisplayName("should return epis for pies")
	public void testPies(){
		//given
		String word = "pies";
		//when
		Set<String> anagramWord = Anagram.of(word);
		//then
		assertThat(anagramWord).contains("epis");
	}
}
