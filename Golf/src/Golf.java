/* 
 * Allan Hammer, ahammer3
 * PROJECT 2 LAB TR 12:30-1:45
 * I did not copy code from on this assignment.
 * TTY Golf */

import java.util.Scanner;
public class Golf {
	
	public static void main(String[] args) {
		Course course = null;
		Course course1 = new Course("Genesee Valley Park North Course", 71);
		Course course2 = new Course("Thendara Golf Course", 72);
		
		Hole holeArray[] = new Hole[18];
		holeArray[0] = new Hole("Genesee Valley Park North Course", 71, 1, 530, 5);
		holeArray[1] = new Hole("Genesee Valley Park North Course", 71, 2, 305, 4);
		holeArray[2] = new Hole("Genesee Valley Park North Course", 71, 3, 331, 4);
		holeArray[3] = new Hole("Genesee Valley Park North Course", 71, 4, 201, 3);
		holeArray[4] = new Hole("Genesee Valley Park North Course", 71, 5, 500, 5);
		holeArray[5] = new Hole("Genesee Valley Park North Course", 71, 6, 226, 3);
		holeArray[6] = new Hole("Genesee Valley Park North Course", 71, 7, 409, 4);
		holeArray[7] = new Hole("Genesee Valley Park North Course", 71, 8, 410, 4);
		holeArray[8] = new Hole("Genesee Valley Park North Course", 71, 9, 229, 3);
		holeArray[9] = new Hole("Genesee Valley Park North Course", 71, 10, 433, 4);
		holeArray[10] = new Hole("Genesee Valley Park North Course", 71, 11, 363, 4);
		holeArray[11] = new Hole("Genesee Valley Park North Course", 71, 12, 174, 3);
		holeArray[12] = new Hole("Genesee Valley Park North Course", 71, 13, 545, 5);
		holeArray[13] = new Hole("Genesee Valley Park North Course", 71, 14, 419, 4);
		holeArray[14] = new Hole("Genesee Valley Park North Course", 71, 15, 512, 5);
		holeArray[15] = new Hole("Genesee Valley Park North Course", 71, 16, 410, 4);
		holeArray[16] = new Hole("Genesee Valley Park North Course", 71, 17, 320, 4);
		holeArray[17] = new Hole("Genesee Valley Park North Course", 71, 18, 170, 3);
		
		Hole holeArray2[] = new Hole[18];
		holeArray2[0] = new Hole("Thendara Golf Course", 72, 1, 406, 4);
		holeArray2[1] = new Hole("Thendara Golf Course", 72, 2, 420, 5);
		holeArray2[2] = new Hole("Thendara Golf Course", 72, 3, 340, 4);
		holeArray2[3] = new Hole("Thendara Golf Course", 72, 4, 428, 5);
		holeArray2[4] = new Hole("Thendara Golf Course", 72, 5, 128, 3);
		holeArray2[5] = new Hole("Thendara Golf Course", 72, 6, 369, 4);
		holeArray2[6] = new Hole("Thendara Golf Course", 72, 7, 356, 4);
		holeArray2[7] = new Hole("Thendara Golf Course", 72, 8, 389, 4);
		holeArray2[8] = new Hole("Thendara Golf Course", 72, 9, 195, 3);
		holeArray2[9] = new Hole("Thendara Golf Course", 72, 10, 415, 5);
		holeArray2[10] = new Hole("Thendara Golf Course", 72, 11, 369, 4);
		holeArray2[11] = new Hole("Thendara Golf Course", 72, 12, 176, 3);
		holeArray2[12] = new Hole("Thendara Golf Course", 72, 13, 429, 5);
		holeArray2[13] = new Hole("Thendara Golf Course", 72, 14, 494, 4);
		holeArray2[14] = new Hole("Thendara Golf Course", 72, 15, 342, 4);
		holeArray2[15] = new Hole("Thendara Golf Course", 72, 16, 149, 3);
		holeArray2[16] = new Hole("Thendara Golf Course", 72, 17, 403, 4);
		holeArray2[17] = new Hole("Thendara Golf Course", 72, 18, 395, 4);
		
		Club clubArray[] = new Club[10];
		clubArray[0] = new Club (1, 230, 30);
		clubArray[1] = new Club (2, 215, 20);
		clubArray[2] = new Club (3, 180, 20);
		clubArray[3] = new Club (4, 170, 17);
		clubArray[4] = new Club (5, 155, 15);
		clubArray[5] = new Club (6, 145, 15);
		clubArray[6] = new Club (7, 135, 15);
		clubArray[7] = new Club (8, 125, 15);
		clubArray[8] = new Club (9, 110, 10);
		clubArray[9] = new Club (10, 50, 10);
		
		Club clubArray2[] = new Club[10];
		clubArray2[0] = new Club (11, 1, 1);
		clubArray2[1] = new Club (12, 2, 1);
		clubArray2[2] = new Club (13, 4, 2);
		clubArray2[3] = new Club (14, 8, 2);
		clubArray2[4] = new Club (15, 12, 3);
		clubArray2[5] = new Club (16, 16, 3);
		clubArray2[6] = new Club (17, 20, 4);
		clubArray2[7] = new Club (18, 25, 4);
		clubArray2[8] = new Club (19, 30, 5);
		clubArray2[9] = new Club (20, 40, 5);
		
		Player p1 = new Player(0, 0, 0, 0);
	
	
	System.out.println("Welcome to TTY Golf! \nIn this game, you will be playing a simplified version of real golf on a simplified version of real courses.\n");
	boolean done = true;
	Scanner input = new Scanner(System.in);
	while (done) {
		System.out.println("To see information about Courses, enter 1. \nTo see information about holes, enter 2. \nTo see information about Clubs, enter 3. \nTo see information about Players, enter 4. \nTo begin, enter 5");
		int enter = input.nextInt();
		if (enter == 1) {
			System.out.println("There are two courses in this game representing two real life courses in New York: The Genesee Valley Park North Golf Course in Rochester, NY and Thendara Golf Course in Thendara, NY.\n");
		} else if (enter == 2) {
			System.out.println("Each course has 18 holes, varying in par size and distance. Try to sink the ball in the hole under par!\n");
		} else if (enter == 3) {
			System.out.println("You will be prompted to enter a club# and a power from 1-10 on each hit. While on the green, this will be a putter. \nWhile off the green, this will be whichever club you choose from 1-10, being a driver, 3-wood, 3-iron, 4-iron, 5-iron, 6-iron, 7-iron, 8-iron, 9-iron, or wedge, respectively. \nThe power you enter will then be calculated, and a random realistic distance will then be outputted.\n");
		} else if (enter == 4) {
			System.out.println("The player (you) starts out with a score of 0 and points get added or subtracted after each hole (negative is good!). \nYour shot# as well as distance to go will be provided before every shot on every hole.\n");
		} else if (enter == 5) {
			done = false;
			System.out.println("Let's begin!\n");
		} else {
			System.out.println("Try again.\n");
		}
	}
	
	done = true;
	while (done) {
		System.out.println("Choose a Golf Course: Genesee Valley Park North Course (1) or Thendara Golf Course (2).");
		int choice = input.nextInt();
		if (choice == 1) {
			course = course1;
			System.out.println("Welcome to beautiful Genesee Valey Park North Course! (Par 71)\n");
			done = false;
		} else if (choice == 2) {
			course = course2;
			System.out.println("Welcome to breathtaking Thendara Golf Course! (Par 72)\n");
			done = false;
		} else {
			System.out.println("Try again.");
		}
	}
	
	done = true;
	while (done) {
		for (int i = 0; i < 18; i++) {
			if (course == course1) {
				System.out.println(holeArray[i]);
				p1.setDistanceLeft(holeArray[i].distance);
			} else {
				System.out.println(holeArray2[i]);
				p1.setDistanceLeft(holeArray2[i].distance);
			}
			int shot = 1;
			p1.setShot(shot);
			System.out.println(p1.toString());
			
			while (p1.distanceLeft > 20) {
				System.out.print("\nChoose your club (1-10): ");
				int club = input.nextInt();
				System.out.print("\nChoose your power (1-10): ");
				int power = input.nextInt();
				int travel = clubArray[club-1].nextDistance(clubArray[club-1].mean, clubArray[club-1].std, power);
				
				System.out.print("\nYou hit the ball " + travel + " yards. ");
				if (travel > (clubArray[club-1].mean*power/10) + (clubArray[club-1].std*power/10)) {
					System.out.print("Nice shot!\n");
				} else if (travel < (clubArray[club-1].mean*power/10) - (clubArray[club-1].std*power/10)) {
					System.out.print("Oof.\n");
				} else {
					System.out.println();
				}
				p1.setDistanceLeft(Math.abs(p1.distanceLeft - travel));
					
				if (p1.distanceLeft != 0) {
					p1.setShot(shot=shot +1);
					System.out.println(p1.toString());
					if (p1.distanceLeft > 20) {
						System.out.println("You are on the fairway.");
					} else {
						System.out.println("You hit the Green! " + p1.distanceLeft*3 + " feet to go.");
					}
				}
			}
			
			p1.setDistanceLeft(p1.distanceLeft*3);
			while (p1.distanceLeft > 1) {
				System.out.print("\nChoose your putt power (1-10): ");
				int power = input.nextInt();
				int travel = clubArray2[power-1].nextPutt(clubArray2[power-1].mean, clubArray2[power-1].std);
				if (travel == 0) {
					travel = 1;
				}
				p1.setDistanceLeft(Math.abs(p1.distanceLeft - travel));
				if (p1.distanceLeft > 1) {
					System.out.print("\nYou hit the ball " + travel + " feet. ");
					if (p1.distanceLeft < 5 ) {
						System.out.print("Almost there!\n");
					} else {
						System.out.println();
					}
					
				p1.setShot(shot = shot+1);
				System.out.println(p1.toString2());
				}
			}
				
			p1.setScore(p1.score + (shot - holeArray[i].par));
			System.out.println("\nIt's in the hole! Next round! \n Current score: " + p1.getScore() + "\n");
			System.out.println("Would you like to quit? [Y/N]: ");
			String check = input.next();
			String check2 = check.toLowerCase();
			if (check2.contains("y")) {
				i=100;
				done=false;
				System.out.println("Visit again soon!");
			}		
		}
			
		done = false;
		System.out.print("\nThats the game! Your total score is: " + p1.getScore() + ". ");
		if (p1.getScore() > 0) {
			System.out.print("Try for a better score next time! Visit again soon!");
		} else if (p1.getScore() < 0) { 
			System.out.print("Nice golfing! Visit again soon!");
		} else {
			System.out.print("Right on par! Visit again soon!");
		}
	}
	
	input.close();
	}
}