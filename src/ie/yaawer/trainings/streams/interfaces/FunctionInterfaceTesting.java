package ie.yaawer.trainings.streams.interfaces;

import java.util.function.Function;

public class FunctionInterfaceTesting {

	void init() {

		// function
		Function<String, Integer> f = str -> str.length();
		Function<String, int[]> f2 = str -> {
			int[] caps = new int[2];
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) >= 65 && str.charAt(i) <= 91)
					caps[0]++;
				else
					caps[1]++;
			}
			return caps;
		};

		System.out.println(f.apply("DTYTFUGYEX"));
		System.out.println(f.apply("DTY"));
		System.out.println(f.apply("DTYdfaffa"));

		System.out.println("");

		String[] words = { "DTYGYEX", "DTYtyuGYEX", "DTYa", "DTYdfaffa", "dfaffa", "AzZa" };

		for (String w : words) {
			int[] diffFontCases = f2.apply(w);
			System.out.println(diffFontCases[0] + " " + diffFontCases[1]);
		}
		
		//chaining

//		System.out.println("\np.compose(f2)");
//
//		System.out.println(f.compose(f2).apply("DTYTFUGYEX"));
//		System.out.println(f.compose(f2).apply("DTY"));
//		System.out.println(f.compose(f2).apply("DTYdfaffa"));

	}
}
