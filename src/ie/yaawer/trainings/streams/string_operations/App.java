package ie.yaawer.trainings.streams.string_operations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {
		
			String str = "Once upon a time in Hollywood.";
			
			List<String> charArr = Arrays.asList(str.split(""));
			
			System.out.println(charArr);
			
			// how many occurrences of each character
			Map<String, Long> charsOccurences = charArr.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			System.out.println(charsOccurences);
			
			// duplicated characters
			List<String> duplicatedChars = charArr.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(n -> n.getValue() > 1).map(Map.Entry::getKey).toList();
			System.out.println(duplicatedChars);
	
			// unique characters
			String uniqueChars = charArr.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(n -> n.getValue() == 1).map(Map.Entry::getKey).findFirst().get();
			System.out.println(uniqueChars);

	}

}
