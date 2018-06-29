package pl.sdacademy.hr;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class HrMenagerSwingAdapter {

	private HrManager hrManager;
	HrMenagerSwingAdapter(HrManager hrManager){
		this.hrManager = hrManager;
	}

	public void addNewEmployee(DefaultTableModel tableModel, String firstName, String lastName, String
		dateOfBirth) {
		Employee newEmployee = hrManager.create(firstName,lastName,dateOfBirth);
		tableModel.addRow(new Object[]{newEmployee.getFirstName(), newEmployee.getLastName(),newEmployee
			.getDateOfBirth()});

	}

	public void searchEmployee(DefaultTableModel tableModel, String phrase) {
		List<Employee> foundEmployeies = hrManager.searchByAnyString(phrase);
		for (Employee employee:foundEmployeies) {
			tableModel.addRow(new Object[]{employee.getFirstName(), employee.getLastName(),employee
				.getDateOfBirth()});
		}
	}

	public void searchEmployeeName(DefaultTableModel tableModel, String lastName) {
		List<Employee> foundEmployeies = hrManager.searchByLastName(lastName);
		for (Employee employee:foundEmployeies) {
			tableModel.addRow(new Object[]{employee.getFirstName(), employee.getLastName(),employee
				.getDateOfBirth()});
		}
	}

	public void clearTable(DefaultTableModel tableModel) {
		tableModel.setRowCount(0);
		}

}
