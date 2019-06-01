/* 
 * Allan Hammer, ahammer3
 * PROJECT 2 LAB TR 12:30-1:45
 * I did not copy code from on this assignment.
 * TTY Golf */

public class Hole extends Course{

	int number;
	int distance;
	int par;
	
	public Hole(String name, int parC, int number, int distance, int par) {
		super(name, parC);
		this.number=number;
		this.distance=distance;
		this.par=par;
	}
	
	public String toString() {
		return "You are at hole #" + number + ". Par " + par + ", " + distance + " yards. Tee off.";
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getPar() {
		return par;
	}

	public void setPar(int par) {
		this.par = par;
	}
}
