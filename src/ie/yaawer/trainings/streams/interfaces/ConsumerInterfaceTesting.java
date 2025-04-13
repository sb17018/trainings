package ie.yaawer.trainings.streams.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterfaceTesting {

	void init() {
		
		List<Person> listOfPersons = new ArrayList<>();

		int numberOfPersons = (int) (Math.random() * 14) + 6;

		for (int i = 0; i < numberOfPersons; i++) {
			listOfPersons.add(new Person());
		}

		for (Person p : listOfPersons) {
			System.out.println(p.getName());
		}

		System.out.println();

		// consumer
		Consumer<Person> c = p -> {
			int nameLength = (int) (Math.random() * 5) + 3;
			String name = generateName(nameLength);
			p.setName(name);
		};

		Consumer<Person> c2 = p -> {
			p.setName(p.getName().toUpperCase());
		};

		for (Person p : listOfPersons) {
			c.andThen(c2).accept(p);
			System.out.println(p.getName());
		}

	}

	static String generateName(int length) {

		String name = "" + (char) (Math.random() * 26 + 65);

		for (int i = 1; i < length; i++) {
			name += (char) (Math.random() * 26 + 97);
		}

		return name;
	}

	class Person {

		private String name = "John";

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	}
}
