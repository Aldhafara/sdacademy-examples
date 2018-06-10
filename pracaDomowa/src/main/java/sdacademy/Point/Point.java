package sdacademy.Point;

import static java.lang.Math.*;

public class Point {
	private double x,y;

	public Point (double x, double y){
		this.x = x;
		this.y = y;
	}

	public void setX (double x){
		this.x = x;
	}

	public void setY (double y){
		this.y = y;
	}

	public double  getX(){
		return x;
	}

	public double  getY(){
		return y;
	}

	public void printCoordinates(){
		System.out.print("( " + x + " , " + y + " )");
	}

	public static double distance (Point a, Point b)
	{
		//double dx = b.x-a.x, dy = b.y-a.y;
		//return sqrt(pow(dx,2)+pow(dy,2));
		return sqrt(pow((b.x-a.x),2)+pow((b.y-a.y),2));
	}

	public double distance (Point other)
	{
		return sqrt(pow((this.x-other.x),2)+pow((this.y-other.y),2));
	}
}
