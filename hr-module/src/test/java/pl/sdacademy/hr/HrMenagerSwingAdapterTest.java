package pl.sdacademy.hr;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import javax.swing.table.DefaultTableModel;

import static org.assertj.core.api.Assertions.*;

class HrMenagerSwingAdapterTest {

	@DisplayName("Should add to table model new row matching employee created by HrMenager given Adam Nowak")
	@Test
	void test01(){
		//given
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("First Name");
		tableModel.addColumn("Last Name");
		tableModel.addColumn("Date of Birth");
		HrMenagerSwingAdapter adapter = new HrMenagerSwingAdapter(fakeHrMenager());

		//when
		adapter.addNewEmployee(tableModel,"Adam","Nowak","01-01-1960");

		//then
		Object firtsNameFromTable = tableModel.getValueAt(0,0 );
		Assertions.assertThat(firtsNameFromTable).isEqualTo("Zolten");
		Object lastNameFromTable = tableModel.getValueAt(0,1 );
		Assertions.assertThat(lastNameFromTable).isEqualTo("rupper");
		Object dateFromTable = tableModel.getValueAt(0,2 );
		Assertions.assertThat(dateFromTable).isEqualTo("11-01-1210");
	}

	private HrManager fakeHrMenager(){
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