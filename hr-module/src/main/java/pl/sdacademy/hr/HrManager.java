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
}
