/* 
 * Allan Hammer, ahammer3
 * PROJECT 1 LAB TR 12:30-1:45
 * I did not copy code from on this assignment.
 * TTY Projectile */

import java.util.Scanner;
import java.util.Random;
public class Projectile {

	public static void main(String[] args) {
		
	Scanner input = new Scanner(System.in);	
	Random wallH = new Random();
	Random wallD = new Random();
		
	System.out.println("In this game, you will be launching a projectile at a wall of random distance (0-20 meters) and height (0-10 meters). \n You will gain 2 points for clearing the wall, and bonus points for clearing the wall in the optimal range (+3 for within 5 meters, +1 for within 10 meters). \n You will gain 1 point for hitting the wall, and gain no points/lose penalty points for failing to get close to within the wall (0 for within 5 meters, -1 for within 10 meters, -2 for over 10 meters). \n You lose when your score hits 0. You win when you reach 25! \n Each launch costs 1 point. Good luck! \n");
	System.out.println("Hint: Since the wall is based on 0-20 meters, try starting out with velocity ~10 m/s. \n");
	
	int points = 10;
	boolean done = true;
	
	while (done) {
		int randH = wallH.nextInt(10);
		int randD = wallD.nextInt(20);
		
		System.out.println("This round's wall height: " + randH + "\n This round's wall distance: " + randD + "\n");
		System.out.print("Enter your desired initial velocity and launch angle, separated by a space: ");
		
		double velocity = input.nextDouble();
		double a = input.nextDouble();
		double angle = Math.toRadians(a);
		double y = (randD*Math.tan(angle)) - ( (9.8*(randD*randD)) / (2* ((velocity*Math.cos(angle))*(velocity*Math.cos(angle))) ));
		double range = ((velocity*velocity)*Math.sin(2*angle)) / (9.8);
		double difference = Math.abs(range - randD);
		points = points - 1;
		
		if (y > randH) {
			if (difference < 5) {
				System.out.println("Perfect Launch! You cleared the wall to within 5 meters!");
				points = points + 5;
			} else if (difference < 10) {
				System.out.println("Good Launch! You cleared the wall to within 10 meters.");
				points = points + 3;
			} else {
				System.out.println("You cleared the wall! But it looks like you overshot, try to get a better attempt.");
				points = points + 2;
			}
		} else {
			if (y > 0) {
				System.out.println("Almost there! You hit the wall but didn't quite clear it.");
				points = points + 1;
			} else if (difference < 5) {
				System.out.println("Close! You didn't clear the wall by under 5 meters distance.");
				points = points - 0;
			} else if (difference < 10) {
				System.out.println("You're a bit off! You didn't clear the wall by under 10 meters distance.");
				points = points - 1;
			} else {
				System.out.println("You're way off! You missed by over 10 meters!");
				points = points - 2;
				}
			}
		System.out.println("\n Current points: " + points + "\n");
		
		if (points <= 0) {
			done = false;
			System.out.println("Your score hit 0! Try again next time. Thanks for playing!");
		} else if (points >= 25) {
			done = false;
			System.out.println("Your score hit 25! Congratulations! You beat the game. Thanks for playing!");
		} else {
			System.out.print("Would you like to quit? ");
			String check = input.next();
			String check2 = check.toLowerCase();
			if (check2.contains("yes")) {
			done = false;
			System.out.println("Thanks for playing!");		
			}
		}
	}	
	input.close();
	}
}
