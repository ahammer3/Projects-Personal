/* 
 * Allan Hammer, ahammer3
 * PROJECT 2 LAB TR 12:30-1:45
 * I did not copy code from on this assignment.
 * TTY Golf */

import java.util.Random;
public class Club {
	
	int number;
	int mean;
	int std;
	
	public Club(int number, int mean, int std) {
		this.number=number;
		this.mean=mean;
		this.std=std;
	}
	
	public String toString() {
		return "Club #" + number + " has mean distance of " + mean + " and standard deviation of " + std + " in yards.";
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getMean() {
		return mean;
	}

	public void setMean(int mean) {
		this.mean = mean;
	}

	public int getStd() {
		return std;
	}

	public void setStd(int std) {
		this.std = std;
	}
	
	public int nextDistance(int mean, int std, int power) {
		Random rand = new Random();
		double meanAdj = mean*power/10.0;
		double stdAdj = std*power/10.0;
		double value = Math.abs(rand.nextGaussian()*stdAdj + meanAdj);
		return (int)value;
	}
	
	public int nextPutt(int mean, int std) {
		Random rand = new Random();
		double value = Math.abs(rand.nextGaussian()*std + mean);
		return (int)value;
	}
}
