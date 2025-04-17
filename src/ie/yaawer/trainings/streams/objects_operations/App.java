package ie.yaawer.trainings.streams.objects_operations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		List<Employee> empList = new ArrayList<>();

		Employee emp_1 = new Employee("Peter", "HR", 45000, "Male", LocalDate.of(2000, 5, 5));
		Employee emp_2 = new Employee("Chloe", "Accounting", 45000, "Female", LocalDate.of(2002, 2, 22));
		Employee emp_3 = new Employee("Andy", "IT", 50000, "Male", LocalDate.of(2003, 7, 1));
		Employee emp_4 = new Employee("Suzanne", "IT", 60000, "Female", LocalDate.of(2000, 9, 27));
		Employee emp_5 = emp_2;
		
		empList.add(emp_1);
		empList.add(emp_2);
		empList.add(emp_3);
		empList.add(emp_4);
		empList.add(emp_5);
		
		// check how many of genders
		long femaleEmpl = empList.stream().filter(emp->emp.getGender().equals("Female")).count();
		
		empList.forEach(e->System.out.println(e.getName()));	
		System.out.println(femaleEmpl);
		
		// check unique values		
		long count = empList.stream().distinct().count();
		System.out.println(count);
		
		// select values as unique
		List<String> depts = empList.stream().map(e -> e.getDepartment()).distinct().toList();
		System.out.println(depts);

	}

}
