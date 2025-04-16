package ie.yaawer.trainings.streams.numbers_operations;

import java.util.Arrays;
import java.util.List;

public class Numbers_01 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 45, 46, 3, 44, 55, 49, 545);
		
		//sum with stream
		int sum = numbers.stream().reduce((a, b) -> {return (a + b);}).get();

		System.out.println(sum);
		
		//average with stream
		//transform => map
		double count = numbers.stream().mapToDouble(i -> i).average().getAsDouble();
		System.out.println(count);
		
		//even and odds
		//separation => filter
		
		//even
		List<Integer> listEven = numbers.stream().filter(i -> i % 2 == 0).toList();
		System.out.println(listEven);

		//odd
		List<Integer> listOdd = numbers.stream().filter(MyClass::checkEvenOdd).toList();
		System.out.println(listOdd);
		
		//starting with 4
		List<Integer> listStartsWith = numbers.stream().filter(i -> String.valueOf(i).startsWith("4")).toList();
		System.out.println(listStartsWith);
		
		List<String> listStartWith_mapping = numbers.stream().map(n -> n.toString()).filter(i -> i.startsWith("5")).toList();
		System.out.println(listStartWith_mapping);
		
		//skip first [5] numbers
		List<Integer> listSkipping = numbers.stream().skip(2).toList();
		System.out.println(listSkipping);
		
		List<String> listSorted = numbers.stream().map(n -> n.toString()).sorted().sorted((a, b) -> Integer.compare(a.length(), b.length())).toList();
		System.out.println(listSorted);
	}
	
	class MyClass{
		
		int i = 0;
		
		static boolean checkEvenOdd(Integer i) {
			if(i % 2 != 0) return true;
			else return false;
		}
	}

}
