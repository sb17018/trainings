package ie.yaawer.trainings.streams.numbers_operations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Numbers_02 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 45, 46, 3, 44, 55, 49, 545);

		// statistics
//		DoubleSummaryStatistics summaryStatistics = numbers.stream().mapToDouble(n -> n).summaryStatistics();
//		System.out.println(summaryStatistics);

		// max and min
		int maxNumber = numbers.stream().max(Comparator.comparing(Integer::valueOf)).get();
		System.out.println(maxNumber);
		maxNumber = numbers.stream().max((a,b) -> a.compareTo(b)).get();
		System.out.println(maxNumber);
		
		int minNumber = numbers.stream().min(Comparator.comparing(Integer::valueOf)).get();
		System.out.println(minNumber);
		minNumber = numbers.stream().min((a,b) -> a.compareTo(b)).get();
		System.out.println(minNumber);

	}

}
