package myfirstpackage;
public class MySecondClass {
	private int x;
	private int y;

	public int getX() {return x;}
	public int getY() {return y;}

	public void setX(int n) {x=n;}
	public void setY(int n) {y=n;}

	public MySecondClass() {
		x = 0;
		y = 1;
	}
	
	public int divide() { return x/y;}
}