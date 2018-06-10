package sdacademy.SitoArystotelesa;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class AppBootstrapper {
	static void start() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				final JFrame jFrame = new JFrame();
				jFrame.setLayout(new FlowLayout());
				jFrame.setTitle("First Swing App");
				jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				jFrame.add(button5);
				jFrame.setPreferredSize(new Dimension(320, 240));
				jFrame.pack();
				jFrame.setVisible(true);
			}
		});
	}
	private static void readFile(){
		try {
			List<String> people = Files.readAllLines(Paths.get("pracaDomowa\\src\\main\\java" +
				"\\sdacademy\\Swing", "people.txt"));
			people.forEach((person) ->{
				System.out.println(person);
				try {
					Thread.sleep(1_200);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
}
