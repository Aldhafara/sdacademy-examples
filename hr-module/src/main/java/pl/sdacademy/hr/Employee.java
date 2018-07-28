package pl.sdacademy.hr;

import java.util.Objects;

class Employee implements Comparable<Employee>{

	private final String firstName;
	private final String lastName;
	private final String dateOfBirth;

	Employee(String firstName, String lastName, String dateOfBirth){
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	@Override
	public String toString() {
		return firstName + ' ' + lastName + ", "+ dateOfBirth;
	}

	public boolean matches(String phrase) {
		return (lastName.contains(phrase) ||
			firstName.contains(phrase) ||
			dateOfBirth.contains(phrase));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Employee employee = (Employee) o;
		return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) &&
			Objects.equals(dateOfBirth, employee.dateOfBirth);
	}

	@Override
	public int hashCode() {

		return Objects.hash(firstName, lastName, dateOfBirth);
	}

	@Override
	public int compareTo(Employee other) {
		return firstName.compareTo(other.firstName);
	}
}
