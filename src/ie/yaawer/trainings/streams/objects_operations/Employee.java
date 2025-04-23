package ie.yaawer.trainings.streams.objects_operations;

import java.time.LocalDate;

public class Employee {
	
	private String name;
	private String department;
	private double salary;
	private String gender;
	private LocalDate joiningDate;
	
	public Employee(String name, String department, double salary, String gender, LocalDate joiningDate) {
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.gender = gender;
		this.joiningDate = joiningDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "Employee:\n\tname:\t" + name + ",\n\tdepartment:\t" + department + ",\n\tsalary:\t" + salary + ",\n\tgender:\t" + gender
				+ ",\n\tjoining date:\t" + joiningDate + "\n";
	}
	
}
