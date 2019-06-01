/* 
 * Allan Hammer, ahammer3
 * PROJECT 2 LAB TR 12:30-1:45
 * I did not copy code from on this assignment.
 * TTY Golf */

public class Player {
	
	int score;
	int hole;
	int shot;
	int distanceLeft;
	
	public Player(int score, int hole, int shot, int distanceLeft) {
		this.score=score;
		this.hole=hole;
		this.shot=shot;
		this.distanceLeft=distanceLeft;
	}
	
	public String toString() { 
		return "Shot #" + shot + ", " + distanceLeft + " yards left to the hole.";
	}
	
	public String toString2() {
		return "Shot #" + shot + ", " + distanceLeft + " feet left to the hole.";
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getHole() {
		return hole;
	}

	public void setHole(int hole) {
		this.hole = hole;
	}

	public int getShot() {
		return shot;
	}

	public void setShot(int shot) {
		this.shot = shot;
	}

	public int getDistanceLeft() {
		return distanceLeft;
	}

	public void setDistanceLeft(int distanceLeft) {
		this.distanceLeft = distanceLeft;
	}
}
