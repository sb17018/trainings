package ie.yaawer.trainings.streams.numbers_operations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Numbers_03 {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 46, 45, 3, 44, 55, 49, 545);
		
		
		//sorting
		List<Integer> listSorted = numbers.stream().sorted(Comparator.reverseOrder()).toList();
		System.out.println(listSorted);

		listSorted = numbers.stream().sorted(Comparator.naturalOrder()).toList();
		System.out.println(listSorted);
	}

}
