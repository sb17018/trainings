package ie.yaawer.trainings.streams.objects_operations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {
		
		List<Employee> empList = new ArrayList<>();

		Employee emp_1 = new Employee("Peter", "HR", 60000, "Male", LocalDate.of(2000, 5, 5));
		Employee emp_2 = new Employee("Chloe", "Accounting", 45000, "Female", LocalDate.of(2002, 2, 22));
		Employee emp_3 = new Employee("Andy", "IT", 50000, "Male", LocalDate.of(2003, 7, 1));
		Employee emp_4 = new Employee("Suzanne", "IT", 60000, "Female", LocalDate.of(2000, 4, 27));
		Employee emp_5 = new Employee("George", "HR", 57000, "Female", LocalDate.of(2000, 9, 27));
		
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
		
		// select values as unique
		Employee highestPaid = empList.stream().max(Comparator.comparingDouble(Employee::getSalary)).get();
		System.out.println(highestPaid.toString());
		
		Employee lowestPaid = empList.stream().min(Comparator.comparingDouble(Employee::getSalary)).get();
		System.out.println(lowestPaid.toString());
		
		List<Employee> emplsAfter2000 = empList.stream().filter(e->e.getJoiningDate().isAfter(LocalDate.of(2000,12,31))).toList();
		
		List<Employee> highestPaidEmpls = new ArrayList<>();
		
		double highestSalary = 0.0;
		for(Employee empl : empList) {
			if(empl.getSalary() > highestSalary) {
				highestPaidEmpls.clear();
				highestSalary = empl.getSalary();
			}
			else if(empl.getSalary() < highestSalary) continue;
			highestPaidEmpls.add(empl);
		}
		
		highestPaidEmpls.forEach(e->System.out.println(e.getName() + ": " + e.getSalary()));
		emplsAfter2000.forEach(System.out::println);
		
//		List<String> lowestPaid = empList.stream().max(Comparator::getSalary);
//		System.out.println(lowestPaid);
		
		// grouping by variable
		Map<String, Long> emplsInDepts = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(emplsInDepts);
		
		// average in groups
		Map<String, Double> avarageInDepts = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(avarageInDepts);
		
		// senior in the organisation
		Employee emplSenior = empList.stream().min(Comparator.comparing(Employee::getJoiningDate)).get();
		System.out.println(emplSenior);
		
		// count by gender in IT
		Map<String, Long> emplsByGender = empList.stream().filter(empl -> empl.getDepartment().equals("IT")).collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(emplsByGender);
		
		Map<String, Map<String, Long>> emplsByGenderTwoGroupings = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getGender, Collectors.counting())));
		System.out.println(emplsByGenderTwoGroupings.get("IT"));
		
		// statistics
		DoubleSummaryStatistics summaryStatistics = empList.stream().mapToDouble(empl -> empl.getSalary()).summaryStatistics();
		System.out.println(summaryStatistics);
		
		// ordering employees
		List<Employee> listSalaryOrder = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).toList();
		System.out.println(listSalaryOrder );
		
		List<Employee> listSalaryOrderDesc = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).toList();
		System.out.println(listSalaryOrderDesc);
		
		// selection some employees
		List<Employee> listTop3 = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(3).toList();
		System.out.println("Top 3:" + listTop3);
		
		// average by genders
		Map<String, Double> averageByGender = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("Avearge by gender:" + averageByGender);
		
		Logger logger = Logger.getLogger("Status Logger");
		
		logger.log(Level.INFO, "OK");

	}

}
