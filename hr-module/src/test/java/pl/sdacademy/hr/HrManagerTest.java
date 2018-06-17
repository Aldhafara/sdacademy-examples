package pl.sdacademy.hr;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class HrManagerTest {

	private HrManager hrManager;
	@BeforeEach
	void setup(){
		hrManager = new HrManager();
	}

	@DisplayName("Should create and add not-null new employee when Firstname, Secondname and birth date is given")
	@Test
	void userTest0(){
		//given
		String firstName = "Adam";
		String lastName = "Nowak";
		String dateOfBirth = "01-01-1960";

		//when
		Employee employee = hrManager.create(firstName, lastName, dateOfBirth);

		//then
		assertThat(employee).isNotNull();
	}

	@DisplayName("Should create and add new employee with all filds: Firstname, Secondname and birth date is " +
		"given")
	@Test
	void userTest1(){
		//given
		String firstName = "Adam";
		String lastName = "Nowak";
		String dateOfBirth = "01-01-1960";

		//when
		Employee employee = hrManager.create(firstName, lastName, dateOfBirth);

		//then
		assertThat(employee.getFirstName()).isEqualTo(firstName);
		assertThat(employee.getLastName()).isEqualTo(lastName);
		assertThat(employee.getDateOfBirth()).isEqualTo(dateOfBirth);
	}

	@DisplayName("Should check if new Employee is added to the database")
	@Test
	void userTest2(){
		//given
		Employee newEmployee = hrManager.create("Adam","Nowak","01-01-1960");

		//when
		List<Employee> existingEmployees = hrManager.findAll();

		//then
		assertThat(existingEmployees).containsOnly(newEmployee);
	}

	@DisplayName("Should add two new Employees to the database")
	@Test
	void userTest3(){
		//given
		Employee adam = hrManager.create("Adam","Nowak","01-01-1960");
		Employee jan = hrManager.create("Jan","Kowalski","13-04-1988");

		//when
		List<Employee> existingEmployees = hrManager.findAll();

		//then
		assertThat(existingEmployees).containsOnly(adam,jan);
	}

}