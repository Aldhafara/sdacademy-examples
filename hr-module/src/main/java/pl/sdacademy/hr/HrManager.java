package pl.sdacademy.hr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class HrManager {


	private List<Employee> employeeList = new ArrayList<>();

	Employee create(String firstName, String lastName, String dateOfBirth) {
		Employee newEmployee = new Employee(firstName,lastName,dateOfBirth);
		employeeList.add(newEmployee);
		return newEmployee;
	}

	public List<Employee> findAll() {
		return employeeList;
	}

	public List<Employee> searchByLastName(String lastName) {
		/*
		List<Employee> foundEmployeesList = new ArrayList<>();
		for (Employee employee:employeeList){
			if (employee.getLastName().equals(lastName))
		     	   foundEmployeesList.add(employee);
		}

		return foundEmployeesList;
		*/

		return employeeList.stream().filter(Employee -> Employee.getLastName().contains(lastName)).collect
			(Collectors
			.toList());

	}

	public List<Employee> searchByAnyString(String searchString) {
		/*
		List<Employee> foundEmployeesList = new ArrayList<>();
		for (Employee employee:employeeList){
			if (employee.getLastName().equals(searchString) || employee.getFirstName().equals
				(searchString) || employee.getDateOfBirth().equals(searchString))
				foundEmployeesList.add(employee);
		}
		return foundEmployeesList;
		*/
		return employeeList.stream().filter(pracownik ->
				pracownik.matches(searchString)).collect(Collectors.toList());
	}

	public List<Employee> sortByFirstName() {

		/**
		*return employeeList.stream().sorted((p1, p2) ->
		*	p1.getFirstName().compareToIgnoreCase(p2.getFirstName())).collect(Collectors.toList());
		*/

		//return employeeList.stream().sorted(Comparator.comparing(Employee::getFirstName)).collect(Collectors
		//	.toList());

		return employeeList.stream().sorted().collect(Collectors.toList());
	}


	public <T extends Comparable<T>> List<T> sortByBouble(List<T> input) {
		ArrayList<T> sortedList = new ArrayList<>(input);
		if (input.size() > 1) {
			for (int i = 0; i < input.size() - 1; i++) {
				for (int j = 0; j < input.size() - 1; j++) {
					swapElements(j, sortedList);
				}
			}
		}
		return sortedList;
	}

	private <T extends Comparable<T>> void swapElements(int currentIndex, List<T> list) {
		T currentElement = list.get(currentIndex);
		int nextIndex = currentIndex + 1;
		T nextElement = list.get(nextIndex);
		if (currentElement.compareTo(nextElement) > 0) {
			list.set(currentIndex, nextElement);
			list.set(nextIndex, currentElement);
		}
	}
}
