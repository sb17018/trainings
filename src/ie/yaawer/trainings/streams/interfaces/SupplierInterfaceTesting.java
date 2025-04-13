package ie.yaawer.trainings.streams.interfaces;

import java.util.function.Supplier;

public class SupplierInterfaceTesting {

	void init() {

		System.out.println();

		// supplier
		Supplier<String> s = () -> {
			int length = (int) (Math.random() * 14) + 6;

			String name = "" + (char) (Math.random() * 26 + 65);

			for (int i = 1; i < length; i++) {
				name += (char) (Math.random() * 26 + 97);
			}

			return name;
		};
		
		System.out.println(s.get());

	}
}
