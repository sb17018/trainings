package ie.yaawer.trainings.streams.interfaces;

import java.util.function.Predicate;

public class PredicateInterfaceTesting {
	
	

	void init() {
		

		// predicate
		Predicate<String> p = str -> str.endsWith("EX");
		Predicate<String> p2 = str -> str.length() < 5;
		
		System.out.println(p.test("DTYTFUGYEX"));
		System.out.println(p.test("DTY"));
		System.out.println(p.test("DTYdfaffa"));
		
		System.out.println("\np.and(p2)");

		System.out.println(p.and(p2).test("DTYTFUGYEX"));
		System.out.println(p.and(p2).test("DTY"));
		System.out.println(p.and(p2).test("DTYdfaffa"));
		
		System.out.println("\np.or(p2)");
		
		System.out.println(p.or(p2).test("DTYTFUGYEX"));
		System.out.println(p.or(p2).test("DTY"));
		System.out.println(p.or(p2).test("DTYdfaffa"));
		
		System.out.println("\np.negate()");
		
		System.out.println(p.negate().test("DTYTFUGYEX"));
		System.out.println(p.negate().test("DTY"));
		System.out.println(p.negate().test("DTYdfaffa"));

	

	}
}
