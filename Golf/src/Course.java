/* 
 * Allan Hammer, ahammer3
 * PROJECT 2 LAB TR 12:30-1:45
 * I did not copy code from on this assignment.
 * TTY Golf */

public class Course {
	
	protected String name;
	protected int parC;
	
	public Course(String name, int parC) {
		this.name=name;
		this.parC=parC;
	}
	
	public String toString() {
		return "Welcome to beautiful " + name + "! This course has total par " + parC;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getParC() {
		return parC;
	}
	
	public void setParC(int parC) {
		this.parC = parC;
	}
}
