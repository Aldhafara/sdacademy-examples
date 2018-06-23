package pl.sdacademy.hr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		List<Employee> foundEmployeesList = new ArrayList<>();
		for (Employee employee:employeeList){
			if (employee.getLastName().equals(lastName))
		     	   foundEmployeesList.add(employee);
		}

		return foundEmployeesList;
	}

	public List<Employee> searchByAnyString(String searchString) {
		List<Employee> foundEmployeesList = new ArrayList<>();
		for (Employee employee:employeeList){
			if (employee.getLastName().equals(searchString) || employee.getFirstName().equals
				(searchString) || employee.getDateOfBirth().equals(searchString))
				foundEmployeesList.add(employee);
		}

		return foundEmployeesList;
	}
}
