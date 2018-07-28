package pl.sdacademy.hr;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SwingView {

	private static final HrManagerSwingAdapter adapter = new HrManagerSwingAdapter(new HrManager());
	private static DefaultTableModel tableModelOne = new DefaultTableModel();
	private static DefaultTableModel tableModelTwo = new DefaultTableModel();

	public SwingView(){


	}
	public static void main(String[] args) {

		tableModelOne.addColumn("First Name");
		tableModelOne.addColumn("Last Name");
		tableModelOne.addColumn("Date of birth");

		tableModelTwo.addColumn("First Name");
		tableModelTwo.addColumn("Last Name");
		tableModelTwo.addColumn("Date of birth");



		SwingUtilities.invokeLater(() -> {
			// prepare the jframe
			final JFrame jFrame = new JFrame();
			LayoutManager layout = new GridLayout(4, 1);
			jFrame.setLayout(layout);
			jFrame.setTitle("HrManager");
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// content
			addFirstRow(jFrame);
			addSecondRow(jFrame);
			addThirdRow(jFrame);
			addFourthRow(jFrame);


			// pack and show
			jFrame.setPreferredSize(new Dimension(640, 480));
			jFrame.pack();
			jFrame.setVisible(true);
		});
		}
	private static void addFourthRow(JFrame jFrame) {


		JTable table = new JTable(tableModelTwo);
		JScrollPane scrollPane = new JScrollPane(table);
		jFrame.add(scrollPane);
	}

	private static void addThirdRow(JFrame jFrame) {
		JPanel row = new JPanel();
		LayoutManager layout = new GridLayout(3, 1);
		row.setLayout(layout);

		row.add(new JLabel("Filters"));

		JPanel lastNameFilter = new JPanel();
		lastNameFilter.add(new JLabel("last name"));
		JTextField name = new JTextField("domyśna wartość");

		clearTextField(name);

		lastNameFilter.add(name);


		JButton okOneButton = new JButton("OK");
		lastNameFilter.add(okOneButton);
		okOneButton.addActionListener(e -> {
			adapter.clearTable(tableModelTwo);
			adapter.searchEmployeeName(tableModelTwo, name.getText() );
		});
		row.add(lastNameFilter);


		JPanel Phrase = new JPanel();
		Phrase.add(new JLabel("search"));
		JTextField phrase = new JTextField("domyśna wartość");

		clearTextField(phrase);

		Phrase.add(phrase);
		JButton okTwoButton = new JButton("OK");
		Phrase.add(okTwoButton);
		okTwoButton.addActionListener(e -> {
			adapter.clearTable(tableModelTwo);
			adapter.searchEmployee(tableModelTwo, phrase.getText() );
		});

		row.add(Phrase);



		jFrame.add(row);
	}

	private static void addSecondRow(JFrame jFrame) {


		JTable table = new JTable(tableModelOne);
		JScrollPane scrollPane = new JScrollPane(table);
		jFrame.add(scrollPane);
	}

	private static void addFirstRow(JFrame jFrame) {
		//populate row
		JPanel row = new JPanel();
		JButton addButton = new JButton("Add");
		JTextField firstNameTextField = new JTextField("first Name");
		clearTextField(firstNameTextField);

		JTextField lastNameTextField = new JTextField("last Name");
		clearTextField(lastNameTextField);

		JTextField dateOfBirthTextField = new JTextField("01-01-1960");
		clearTextField(dateOfBirthTextField);


		row.add(addButton);
		addButton.addActionListener(e -> {
			adapter.addNewEmployee(tableModelOne, firstNameTextField.getText(),
				lastNameTextField.getText(), dateOfBirthTextField.getText() );
		});
		row.add(new JLabel("first Name"));
		row.add(firstNameTextField);
		row.add(new JLabel("last Name"));
		row.add(lastNameTextField);
		row.add(new JLabel("date of birth"));
		row.add(dateOfBirthTextField);

		//add row to jFrame
		jFrame.add(row);
	}



	private static void clearTextField(JTextField fieldName){

		fieldName.addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent e){
				fieldName.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {

			}
		});


	}


}