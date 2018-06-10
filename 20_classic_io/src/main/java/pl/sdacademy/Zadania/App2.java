package pl.sdacademy.Zadania;

import java.io.*;
import java.util.Scanner;

public class App2 {
	public static void main(String[] args) throws IOException {

		BufferedWriter bw = null;

		String outputPath = "files" + File.separator + "destFile2.txt";

		Scanner scanner = new Scanner(System.in);
		String line2 = scanner.nextLine();

		try {
			bw = new BufferedWriter(new FileWriter(outputPath, true));
			while (!line2.equals("exit")) {
				bw.append(line2 + " lenght: " + line2.length() + System.lineSeparator());
				line2 = scanner.nextLine();
			}
		}
		catch (IOException e) {
			System.err.println("Error: " + e);
		}
		finally {
            /*
            if (br != null) {
                br.close();
            }*/
			if (bw != null) {
				bw.close();

			}
		}

	}
}
