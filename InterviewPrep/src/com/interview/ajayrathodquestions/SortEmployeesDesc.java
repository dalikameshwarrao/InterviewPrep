package com.interview.ajayrathodquestions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class SortEmployeesDesc {
	public static void main(String[] args) {

		List<Employee> employeeList = Employee.getEmployeeList();

		// Sort the list by salary in ascending order
		employeeList.sort(Comparator.comparingDouble(Employee::getSalary));
		employeeList.stream().map(Employee::getSalary).forEach(System.out::println);

		// Sort the list by salary in descending order
		employeeList.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
		employeeList.stream().map(Employee::getSalary).forEach(System.out::println);

		// Male and female employees count
		Map<String, Long> noOfMaleAndFemaleEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("No of male & female Employees : " + noOfMaleAndFemaleEmployees);

		Map<String, Long> employeeCountByDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("No of male & female Employees : " + employeeCountByDepartment);

		employeeCountByDepartment.entrySet()
				.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

		Map<String, Double> averageSalaryGenderWise = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println("Average salary of male and female employees : " + averageSalaryGenderWise);

		Map<String, Optional<Employee>> maxSalaryMaleAndFemaleEmployee = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender,
						Collectors.maxBy((t1, t2) -> (int) (t1.getSalary() - t2.getSalary()))));
		System.out.println("Highest paid male and female employee : " + maxSalaryMaleAndFemaleEmployee);

		Map<String, Optional<Employee>> collect = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.maxBy((employee, t1) -> (int) (t1.getSalary() - employee.getSalary()))));
		System.out.println("Highest paid employee in each department ");

		Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper = employeeList.stream()
				.filter(e -> e.getGender() == "Male" && e.getDepartment() == "Product Development")
				.min(Comparator.comparingInt(Employee::getAge));
		Employee youngestMaleEmployeeInProductDevelopment = youngestMaleEmployeeInProductDevelopmentWrapper.get();
		System.out.println("Details Of Youngest Male Employee In Product Development");
		System.out.println("----------------------------------------------");
		System.out.println("Employee : " + youngestMaleEmployeeInProductDevelopment);

		DoubleSummaryStatistics employeeSalaryStatistics = employeeList.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));

		System.out.println("Average Salary = " + employeeSalaryStatistics.getAverage());
		System.out.println("Total Salary = " + employeeSalaryStatistics.getSum());

		Map<Boolean, List<Employee>> partitionEmployeesByAge = employeeList.stream()
				.collect(Collectors.partitioningBy(e -> e.getAge() > 30));

		Set<Map.Entry<Boolean, List<Employee>>> entrySet = partitionEmployeesByAge.entrySet();

		for (Map.Entry<Boolean, List<Employee>> entry : entrySet) {
			System.out.println("----------------------------");

			if (entry.getKey()) {
				System.out.println("Employees older than 30 years :");
			} else {
				System.out.println("Employees younger than or equal to 30 years :");
			}

			System.out.println("----------------------------");

			List<Employee> list = entry.getValue();

			for (Employee e : list) {
				System.out.println(e.getName());
			}
		}

	}
}
