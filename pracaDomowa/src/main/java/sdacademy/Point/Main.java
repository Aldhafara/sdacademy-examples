package sdacademy.Point;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Point pointA = new Point(0,0);
		Point pointB = new Point(0,0);
		Scanner skan = new Scanner(System.in);
		System.out.println("Podaj współrzędne punktu A:");
		System.out.print("x = "); pointA.setX(skan.nextDouble());
		System.out.print("y = "); pointA.setY(skan.nextDouble());

		System.out.println("Podaj współrzędne punktu B:");
		System.out.print("x = "); pointB.setX(skan.nextDouble());
		System.out.print("y = "); pointB.setY(skan.nextDouble());

		System.out.print("Współrzędne punktu A: "); pointA.printCoordinates(); System.out.println();
		System.out.print("Współrzędne punktu B: "); pointB.printCoordinates();
		System.out.println();

		System.out.println("Odległość |AB| = " + Point.distance(pointA,pointB));
		System.out.println("Odległość |AB| = " + pointA.distance(pointB));

	}
}