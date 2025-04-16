package ie.yaawer.trainings.streams.numbers_operations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Numbers_04 {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 46, 45, 3, 44, 55, 49, 545);
		
		// selecting of your choice
		
		// find second highest
		Integer integer = numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(integer);

		// find second lowest
		integer = numbers.stream().sorted().skip(1).findFirst().get();
		System.out.println(integer);

	}

}
