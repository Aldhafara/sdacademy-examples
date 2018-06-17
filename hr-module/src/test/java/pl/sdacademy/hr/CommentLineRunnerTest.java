package pl.sdacademy.hr;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class CommentLineRunnerTest {
	@DisplayName("Should reject input data when first name is not given")
	@Test
	void test00(){
		//given
		HrManager hrManager = new HrManager();
		String[] args = {"lastName=Miałczyński","dateOfBirth=01-01-1960","ahdkhas"};

		//when
		assertThatThrownBy(() -> CommentLineRunner.load(args, hrManager))
			//then
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("Should reject input data when last name is not given")
	@Test
	void test01(){
		//given
		HrManager hrManager = new HrManager();
		String[] args = {"firstName=Adam","dateOfBirth=01-01-1960","ahdkhas"};

		//when
		assertThatThrownBy(() -> CommentLineRunner.load(args, hrManager))
			//then
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("Should reject input data when date of birth is not given")
	@Test
	void test02(){
		//given
		HrManager hrManager = new HrManager();
		String[] args = {"firstName=Adam","lastName=Miałczyński","ahdkhas"};

		//when
		assertThatThrownBy(() -> CommentLineRunner.load(args, hrManager))
			//then
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("Should check if 3 arguments are given then database is't empty")
	@Test
	void test03(){
		//given
		String[] args = {"firstName=Kogut ","lastName=Wściekły","dateOfBirth=01-01-12018"};
		HrManager hrManager = new HrManager();

		//when
		CommentLineRunner.load(args, hrManager);

		//then
		assertThat(hrManager.findAll()).isNotEmpty();
	}

	@DisplayName("Should check if firstname lastname and dateofbirth isn't empty than database contains " +
		"single employee with the same firstname lastname dateofbirth")
	@Test
	void test04 () {
		//given
		HrManager hrManager = new HrManager();
		String[] args = {"firstName=Adaś", "lastName=Miauczyński", "dateOfBirth=11-11-1911"};
		//when
		CommentLineRunner.load(args, hrManager);
		//then
		Employee employee = hrManager.findAll().get(0);
		assertThat(employee.getFirstName()).isEqualTo("Adaś");
		assertThat(employee.getLastName()).isEqualTo("Miauczyński");
		assertThat(employee.getDateOfBirth()).isEqualTo("11-11-1911");
	}


}
