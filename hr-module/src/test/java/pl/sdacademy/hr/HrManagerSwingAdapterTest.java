package pl.sdacademy.hr;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.List;

class HrManagerSwingAdapterTest {

	@DisplayName("Should add to empty table model new row matching employee created by HrManager given Adam Nowak")
	@Test
	void test01(){
		//given
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("First Name");
		tableModel.addColumn("Last Name");
		tableModel.addColumn("Date of Birth");
		HrManagerSwingAdapter adapter = new HrManagerSwingAdapter(fakeHrManager());

		//when
		adapter.addNewEmployee(tableModel,"Adam","Nowak","01-01-1960");

		//then
		Object firstNameFromTable = tableModel.getValueAt(0,0 );
		Assertions.assertThat(firstNameFromTable).isEqualTo("Zolten");
		Object lastNameFromTable = tableModel.getValueAt(0,1 );
		Assertions.assertThat(lastNameFromTable).isEqualTo("Trupper");
		Object dateFromTable = tableModel.getValueAt(0,2 );
		Assertions.assertThat(dateFromTable).isEqualTo("11-01-1210");
	}

	@DisplayName("Should add to empty table model exactly two new rows matching employee created by HrManager " +
		"given Adam Nowak")
	@Test
	void test02(){
		//given
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("First Name");
		tableModel.addColumn("Last Name");
		tableModel.addColumn("Date of Birth");
		HrManagerSwingAdapter adapter = new HrManagerSwingAdapter(fakeSortHrManager());

		//when
		adapter.sort(tableModel);

		//then
			//row_0
		Object firstNameFromTable = tableModel.getValueAt(0,0 );
		Assertions.assertThat(firstNameFromTable).isEqualTo("Adam");
		Object lastNameFromTable = tableModel.getValueAt(0,1 );
		Assertions.assertThat(lastNameFromTable).isEqualTo("Tomczyk");
		Object dateFromTable = tableModel.getValueAt(0,2 );
		Assertions.assertThat(dateFromTable).isEqualTo("12-12-1690");
			//row_1
		Object firstNameFromTable2 = tableModel.getValueAt(1,0 );
		Assertions.assertThat(firstNameFromTable2).isEqualTo("Zolten");
		Object lastNameFromTable2 = tableModel.getValueAt(1,1 );
		Assertions.assertThat(lastNameFromTable2).isEqualTo("Trupper");
		Object dateFromTable2 = tableModel.getValueAt(1,2 );
		Assertions.assertThat(dateFromTable2).isEqualTo("11-01-1210");
	}


	@DisplayName("Zakładając że tableModel nie jest pusty, powinien zostać zastąpiony tableModelem zwruconym " +
		"przez sorta")
	@Test
	void test03(){
		//given
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("First Name");
		tableModel.addColumn("Last Name");
		tableModel.addColumn("Date of Birth");
		tableModel.addRow(new Object[]{"Urlich","Jugingen","15-03-1410"});
		HrManagerSwingAdapter adapter = new HrManagerSwingAdapter(fakeSortHrManager());

		//when
		adapter.sort(tableModel);

		//then
		//row_0
		Object firstNameFromTable = tableModel.getValueAt(0,0 );
		Assertions.assertThat(firstNameFromTable).isEqualTo("Adam");
		Object lastNameFromTable = tableModel.getValueAt(0,1 );
		Assertions.assertThat(lastNameFromTable).isEqualTo("Tomczyk");
		Object dateFromTable = tableModel.getValueAt(0,2 );
		Assertions.assertThat(dateFromTable).isEqualTo("12-12-1690");
		//row_1
		Object firstNameFromTable2 = tableModel.getValueAt(1,0 );
		Assertions.assertThat(firstNameFromTable2).isEqualTo("Zolten");
		Object lastNameFromTable2 = tableModel.getValueAt(1,1 );
		Assertions.assertThat(lastNameFromTable2).isEqualTo("Trupper");
		Object dateFromTable2 = tableModel.getValueAt(1,2 );
		Assertions.assertThat(dateFromTable2).isEqualTo("11-01-1210");
	}

	private HrManager fakeSortHrManager() {
		return new HrManager(){
			@Override
			public List<Employee> sortByFirstName() {
				return Arrays.asList(new Employee("Adam","Tomczyk","12-12-1690"),
				new Employee("Zolten", "Trupper","11-01-1210"));
			}
		};
	}

	private HrManager fakeHrManager(){
		return new HrManager(){
			@Override
			Employee create(String firstName, String lastName, String dateOfBirth) {
				if (firstName.equals("Adam") && lastName.equals("Nowak") && dateOfBirth.equals
					("01-01-1960"))
				return new Employee("Zolten", "Trupper","11-01-1210");
				throw new IllegalArgumentException("Bad Argument");
			}
		};
	}



}