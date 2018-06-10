package sdacademy.Swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

class AppBootstrapper {
	private static DefaultTableModel peopleTableModel = new DefaultTableModel();

	static void start() {
		SwingUtilities.invokeLater(new Runnable() {


			@Override
			public void run() {
				final JFrame jFrame = new JFrame();

				LayoutManager layout = new GridLayout(2,1);
				jFrame.setLayout(layout);


				//jFrame.setLayout(new FlowLayout());
				jFrame.setTitle("First Swing App");
				jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				addTable(jFrame);
				addButton(jFrame);


				jFrame.setPreferredSize(new Dimension(320, 240));
				jFrame.pack();
				jFrame.setVisible(true);
			}


			private void addTable(JFrame jFrame) {
				//JPanel tablePanel = new JPanel(new GridLayout(1, 0));

				peopleTableModel.addColumn("First Name");
				peopleTableModel.addColumn("Last Name");
				peopleTableModel.addColumn("Age");

				JTable table = new JTable(peopleTableModel);
				JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane
					.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.createHorizontalScrollBar();

				jFrame.add(scrollPane);

			}

			private void addButton(JFrame jFrame) {
				JPanel buttonPanel  = new JPanel();
				buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
				JButton button = new JButton("Read People");
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new Thread(AppBootstrapper::readFile).start();
					}
				});
				buttonPanel.add(button);

				/*
				final JTextField textField = new JTextField("Jak masz na imię?");
				jFrame.add(textField);

				JButton button1 = new JButton("Red");
				JButton button2 = new JButton("Green");
				JButton button3 = new JButton("Blue");
				JButton button4 = new JButton("Resize");
				JButton button5 = new JButton("Read");

				button1.addActionListener((e) -> {
					jFrame.getContentPane().setBackground(new Color(255, 0, 0));
				});

				button2.addActionListener((e) -> {
					jFrame.getContentPane().setBackground(new Color(0, 255, 0));
				});

				button3.addActionListener((e) -> {
					jFrame.getContentPane().setBackground(new Color(0, 0, 255));
				});

				button4.addActionListener((e) -> {
					jFrame.setPreferredSize(new Dimension(640, 480));
					jFrame.pack();
				});

				button5.addActionListener((e) -> {
					new Thread(AppBootstrapper::readFile).start();
				});


				jFrame.add(button4);
				jFrame.add(button1);
				jFrame.add(button2);
				jFrame.add(button3);
				jFrame.add(button5);*/
				jFrame.add(button);
			}

		});
	}
	private static void readFile(){
		try {
			List<String> people = Files.readAllLines(Paths.get("pracaDomowa\\src\\main\\java" +
				"\\sdacademy\\Swing", "people.txt"));
			people.forEach(AppBootstrapper::readPersonLine);
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	private static void readPersonLine(String personLine){
		Person person = parsePerson(personLine);
		peopleTableModel.addRow(new Object[]{person.getName(), person.getLastName(), person.getAge()});
		//System.out.println(person);

		try {
			Thread.sleep(1_200);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static Person parsePerson(String personLine) {
		Scanner scanner = new Scanner(personLine);
		scanner.useDelimiter(" ");

		String firstName = scanner.next();
		String lastName = scanner.next();
		int age = scanner.nextInt();
		return new Person(firstName,lastName,age);
	}




/*


	private void renderRoot() {
		SwingUtilities.invokeLater(() -> {
			final JFrame jFrame = new JFrame();
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			content(jFrame);

			jFrame.setPreferredSize(new Dimension(320, 240));
			jFrame.pack();
			jFrame.setVisible(true);
		});
	}

*/


}
