package pl.sdacademy.tdd;

import java.util.HashSet;
import java.util.Set;

public class Anagram {
	public static Set<String> of(String input){
		char ch[] = input.toCharArray();
		Set<String> anagram = new HashSet<>();
		String strLocalValue = "";
		for (int i = 0; i < ch.length; i++) {
			strLocalValue+=ch[i];
			for (int j = 0; j < ch.length; j++) {
				if (i != j)
					strLocalValue+=ch[j];
			}
		}
		anagram.add(strLocalValue);

		 strLocalValue = "";

			for (int j = ch.length-1; j>= 0; j--) {
				if (1 != j)
					strLocalValue+=ch[j];
			}



		return anagram;

	}
}
