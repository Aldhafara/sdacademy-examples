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

	@DisplayName("Should find one employee with given last name")
	@Test
	void userTest4(){
		//given
		Employee adam = hrManager.create("Adam","Nowak","01-01-1960");
		Employee jan = hrManager.create("Jan","Kowalski","13-04-1988");
		Employee piotr = hrManager.create("Piotr","Kowalski","13-04-1988");
		Employee steffen = hrManager.create("Steffen","Möller","22-01-1969");

		//when
		List<Employee> foundEmployees = hrManager.searchByLastName("Nowak");

		//then
		assertThat(foundEmployees).containsOnly(adam);
	}

	@DisplayName("Should find every employee with given last name")
	@Test
	void userTest5(){
		//given
		Employee adam = hrManager.create("Adam","Nowak","01-01-1960");
		Employee jan = hrManager.create("Jan","Kowalski","13-04-1988");
		Employee piotr = hrManager.create("Piotr","Kowalski","13-04-1988");
		Employee steffen = hrManager.create("Steffen","Möller","22-01-1969");

		//when
		List<Employee> foundEmployees = hrManager.searchByLastName("Kowalski");

		//then
		assertThat(foundEmployees).containsOnly(jan,piotr);
	}

	@DisplayName("Should return empty list when list do not contains search last name")
	@Test
	void userTest6(){
		//given
		Employee adam = hrManager.create("Adam","Nowak","01-01-1960");
		Employee jan = hrManager.create("Jan","Kowalski","13-04-1988");
		Employee piotr = hrManager.create("Piotr","Kowalski","13-04-1988");
		Employee steffen = hrManager.create("Steffen","Möller","22-01-1969");

		//when
		List<Employee> foundEmployees = hrManager.searchByLastName("wiśniewski");

		//then
		assertThat(foundEmployees).isEmpty();
	}

	@DisplayName("Should find every employee with any firstName, lastName or dateOfBirth matching given search " +
		"phrase")
	@Test
	void userTest7(){
		//given
		Employee adam = hrManager.create("Adam","Nowak","01-01-1960");
		Employee jan = hrManager.create("Jan","Kowalski","13-04-1988");
		Employee piotr = hrManager.create("Piotr","Kowalski","13-04-1988");
		Employee steffen = hrManager.create("Steffen","Möller","22-01-1969");

		//when
		List<Employee> foundEmployees = hrManager.searchByAnyString("Piotr");

		//then
		assertThat(foundEmployees).containsOnly(piotr);
	}

	@DisplayName("Should sort by first name ascending")
	@Test
	void userTest8(){
		//given
		Employee adam = hrManager.create("Adam","Nowak","01-01-1960");
		Employee zenon = hrManager.create("Zenon","Kowalski","13-04-1988");
		Employee jan = hrManager.create("Jan","Kowalski","13-04-1988");

		//when
		List<Employee> sortEmployees = hrManager.sortByFirstName();

		//then
		assertThat(sortEmployees).containsExactly(adam,jan,zenon);
	}

	@DisplayName("Should sort by first name ascending with boublesort")
	@Test
	void userTest9(){
		//given
		Employee adam = hrManager.create("Adam","Nowak","01-01-1960");
		Employee zenon = hrManager.create("Zenon","Kowalski","13-04-1988");
		Employee aaron = hrManager.create("Aaron","Michnik","10-06-1978");
		Employee jan = hrManager.create("Jan","Kowalski","13-04-1988");

		//when
		List<Employee> sortEmployees = hrManager.sortByBouble(hrManager.findAll());

		//then
		assertThat(sortEmployees).containsExactly(aaron,adam,jan,zenon);
	}

}