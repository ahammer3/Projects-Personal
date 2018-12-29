/* 
 * Allan Hammer, ahammer3
 * CS50 2018 Final Project
 * Written on Mac OS using Eclipse Oxygen for Java SE JDK 8 - imported into CS50 IDE Cloud 9
 * Video Game rocketDrone - see README attached
 */

// This program produces a simple rocket drone video game that the user must navigate through space with. Instructions are provided in game. README attached for further details.

// import necessary java components
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
@SuppressWarnings("serial")  // Suppress warnings - don't really know why we need this but it fixed the warning
public class rocketDrone extends JPanel implements ActionListener, KeyListener {  // extend and implement necessary classes

	// declare variables needed - protected to be used throughout program
	protected int droneX = 50;
	protected int droneY = 300;
	protected Timer timer;
	protected int[] topH = new int[9];
	protected int topA;
	protected int[] bottomH = new int[9];
	protected int bottomA;
	protected double angle = 0;
	protected int fuel = 360;
	protected int score = 0;
	protected int lives = 3;
	protected int level = 1;
	protected int counter = 350;
	protected BufferedImage drone;
	protected JButton start;
	protected JLabel sLabel;
	protected JLabel lLabel;
	protected JLabel fLabel;
	protected JLabel lvl;
	protected boolean check = true;
	protected boolean check2 = true;
	protected JLabel gameOver;
	protected JLabel instructions;
	
	// declare a random variable
	Random rand = new Random();
	
	// set the image for the drone to be read into program
	// for the making of this program, the file path is: /Users/ahammer3/eclipse-workspace/rocketDrone/src/rocketDrone.png
	// in cs50, before submission, the file path will be changed to: TODO
	protected BufferedImage pic() {
		try {
			drone = ImageIO.read(new File ("/Users/ahammer3/eclipse-workspace/rocketDrone/src/rocketDrone.png"));
		} catch (IOException error) {
			// print the error just in case
			System.out.println("image error.");
		}
		return drone;
	}

	// rocketDrone constructor method
	public rocketDrone() {
		// make the top and bottom wall segment amounts using random ints
		topA = 3 + rand.nextInt(6);
		bottomA = 3 + rand.nextInt(6);
		
		// make the first segment a set distance to leave room for the drone to generate there
		topH[1] = 200; 
		bottomH[1] = 200;
		
		// generate random distances for the rest of the segments
		for (int i = 2; i <= topA; i++) {
			topH[i] = 100 + rand.nextInt(220);
		}
		for (int i = 2; i <= bottomA; i++) {
			bottomH[i] = 100 + rand.nextInt(220);
		}
		
		// set the timer to 50ms and set KeyListener
		this.timer = new Timer(50, this);
		this.addKeyListener(this);
		
		// set the whole thing to actually be visible!
		this.setFocusable(true);
		this.requestFocusInWindow();

		// score label
		sLabel = new JLabel("Score: " + score);
		sLabel.setForeground(Color.WHITE);
		add(sLabel);
		
		// lives label
		lLabel = new JLabel("Lives: " + lives);
		lLabel.setForeground(Color.WHITE);
		add(lLabel);
		
		// fuel label
		fLabel = new JLabel("Fuel: " + fuel);
		fLabel.setForeground(Color.RED);
		add(fLabel);
		
		// level count level
		lvl = new JLabel("Level: " + level);
		lvl.setForeground(Color.WHITE);
		add(lvl);
		
		// instructions message - will only appear at start
		instructions = new JLabel("Press arrow keys to start, 'Q' to quit. Retrieve the package and head to the pad!. Happy Travels!");
		instructions.setForeground(Color.WHITE);
		add(instructions);
	}
	
	// main method
	public static void main(String[] args) {
		// declare the drone object, frame, and set them as necessary - THAT'S IT for main method
		rocketDrone drone = new rocketDrone();
		JFrame frame = new JFrame("Drone");
		frame.add(drone);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,700);
		drone.setLayout(new FlowLayout(0,50,10));
		frame.setVisible(true);
	}

	@Override  // again don't know what this does except get rid of error 
	// triggered every time the timer (25s) is passed or action detected
	public void actionPerformed(ActionEvent e) {
		// adjust labels and drone Y position
		droneY+=1;  //emulates gravity
		fLabel.setText("Fuel: " + fuel);
		lLabel.setText("Lives: " + lives);
		sLabel.setText("Score: " + score);
		lvl.setText("Level: " + level);
		instructions.setVisible(false);  // no more instructions at start game
		
		// game over condition
		if (lives <= 0) {
			lose();
			finalDisplay();
		}
		
		// 'repaint' the game
		repaint();
	}

	@Override
	// triggered by pressing a keyboard key
	public void keyPressed(KeyEvent e) {
		// start the timer if pressed
		if (check = true) {
			timer.start();
			
			// left arrow key adjusts angle and fuel
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				angle -= 5;
				fuel -= 1;
				repaint();
			}
			
			// right arrow key
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				angle += 5;
				fuel -= 1;
				repaint();
			}
			
			// up arrow key adjusts drone position to "move" up wherever the nose is pointing as relative North
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				droneX = (int) (droneX + 5*Math.cos(Math.toRadians(-60+angle)));
				droneY = (int) (droneY + 5*Math.sin(Math.toRadians(-60+angle)));
				fuel -= 1;
				repaint();
			}
			
			// Q key quits the game and shows game over condition
			if (e.getKeyCode() == KeyEvent.VK_Q) {
				lose();
				finalDisplay();
			}
		} 
	}

	@Override
	// keyReleased and keyTyped empty - don't need them 
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	// returns the index i of the minimum wall height
	public int index() {
		// declare index and make it the minimum height
		int index = 1;
		for (int i = 2; i<=topA; i++) {
			if (topH[index] >= topH[i]) {
				index = i;
			}
		}
		return index;
	} 

	// this is the "package" to be received in the game. When it's hitbox is hit, gives fuel and score
	public void fuelBox() {
		fuel +=100;
		score += 100;
		
		// set check2 to false so we do not get the fuelBox twice in one level
		check2 = false;
	}
	
	// win condition method (wins a level)
	public void win() {
		// adjust drone position and variables as necessary
		droneX = 50;
		droneY = 300;
		angle = 0;
		level += 1;
		score += fuel + 100;
		fuel = counter;
		
		// stop the timer for now - generate new top and bottom walls
		timer.stop();
		topA = 3 + rand.nextInt(6);
		bottomA = 3 + rand.nextInt(6);
		topH[1] = 200; 
		bottomH[1] = 200;
		for (int i = 2; i <= topA; i++) {
			topH[i] = 100 + rand.nextInt(220);
		}
		for (int i = 2; i <= bottomA; i++) {
			bottomH[i] = 100 + rand.nextInt(220);
		}
		
		// make the new level when ready
		repaint();
		
		// adjust the display levels and set check2 to true - we can get the fuelBox again
		fLabel.setText("Fuel: " + fuel);
		lLabel.setText("Lives: " + lives);
		sLabel.setText("Score: " + score);
		lvl.setText("Level: " + level);
		check2 = true;
	}
	
	// lose/game over condition
	public void lose() {
		// set check to false to prevent any further actions, stop the timer
		check = false;
		timer.stop();
		this.setVisible(check);
	}
	
	// final display at game over method
	public void finalDisplay() {
		// first of all, make everything visible 
		this.setVisible(true);
		
		// game over labels
		gameOver = new JLabel("GAME OVER: FINAL SCORE: " + score);
		gameOver.setForeground(Color.RED);
		gameOver.setVisible(true);
		add(gameOver);
		
		// play again labels
		start = new JButton("Play Again?");
		start.setVisible(true);
		add(start);
		
		// add an actionListener to see if the button is pressed
		start.addActionListener(new ActionListener () {
			@Override
			// triggered when play again is pressed
			public void actionPerformed(ActionEvent e) {
				// if so, reset check to true, and reset all conditions - remake level 1
				check = true;
				lives = 3;
				fuel = 360;
				counter = 350;
				score = 0;
				level = 1;
				timer.start();
				gameOver.setVisible(false);
				start.setVisible(false);
				check2 = true;
				topA = 3 + rand.nextInt(6);
				bottomA = 3 + rand.nextInt(6);
				topH[1] = 200; 
				bottomH[1] = 200;
				for (int i = 2; i <= topA; i++) {
					topH[i] = 100 + rand.nextInt(220);
				}
				for (int i = 2; i <= bottomA; i++) {
					bottomH[i] = 100 + rand.nextInt(220);
				}
				repaint();
			}
		});
	}
	
	// paint method to make game GUI
	public void paintComponent(Graphics g) {
		// call super first
		super.paintComponents(g);
		
		// set a benchmark for wall heights
		int x = 700;
		int y = 700;
		
		// paint the upper walls
		for (int i = 0; i<topA; i++) {
			g.fillRect(i*x/topA, 0, x/topA, topH[i+1]);
		}
		
		// paint the lower walls
		for (int i = 0; i<bottomA; i++) {
			g.fillRect(i*x/bottomA, y-bottomH[i+1], x/bottomA, bottomH[i+1]);
		}
		
		// generate the drone - rotate it as necessary according to buttons pressed and render it again
		AffineTransform rote = AffineTransform.getTranslateInstance(droneX, droneY);
		rote.rotate(Math.toRadians(angle), 18, 25);
		BufferedImage drone = pic();
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(drone, rote, null);
		
		// generate a hitbox for the drone and upper walls
		for (int i = 0; i<topA; i++) {
			// hitbox for walls
			Rectangle rect = new Rectangle(i*x/topA, 0, x/topA, topH[i+1]);
			
			// hitbox for drone
			Rectangle rect2 = new Rectangle(droneX, droneY, 30, 40);
			
			// if they intersect...
			if (rect.intersects(rect2) || fuel <=0) {
				// ...reset the level with 1 less life (else game over if 0)
				timer.stop();
				score -= 100;
				lives -= 1;
				droneX = 50;
				droneY = 300;
				angle = 0;
				fuel = counter;
				check2 = true;
			}
		}
		
		// generate the same method for the drone and lower walls
		for (int i = 0; i<bottomA; i++) {
			Rectangle rect = new Rectangle(i*x/bottomA, y-bottomH[i+1], x/bottomA, bottomH[i+1]);
			Rectangle rect2 = new Rectangle(droneX, droneY, 30, 40);
			if (rect.intersects(rect2) || fuel <=0) {
				timer.stop();
				score -= 100;
				lives -= 1;
				droneX = 50;
				droneY = 300;
				angle = 0;
				fuel = counter;
				check2 = true;
			}
		}
		
		// generate rectangle hitboxs for the landing pad, drone, and "orb" (fuelBox)
		Rectangle pad = new Rectangle(600, 690-bottomH[bottomA], 100, 20);
		Rectangle droneBox = new Rectangle(droneX, droneY, 30, 40);
		Rectangle orb = new Rectangle(index()*x/topA-(x/topA/2), topH[index()]+20, 20, 20);
		
		
		// if drone lands on the pad upright as well as orb collected, win condition
		if (pad.intersects(droneBox) && (Math.abs(angle) < 60) && check2==false) {
			win();
			// next level will start with 10 less fuel, thus harder
			counter -= 10;
		}
		
		// draw the fuel left in circle format (1 degree = 1 fuel, will never have more than 360)
		for (int i = 0; i<fuel; i++) {
			g.setColor(Color.RED);
			g.drawLine(615, 60, (int) (615+(30*Math.cos(Math.toRadians(i)))), (int) (60+(30*Math.sin(Math.toRadians(i)))));
		}
		
		// draw the landing pad at end of level on last bottom segment wall
		g.setColor(Color.RED);
		g.fillRect(600, 690-bottomH[bottomA], 100, 20);
		
		// draw the fuelBox
		g.setColor(Color.YELLOW);
		g.fillRect(index()*x/topA-(x/topA/2), topH[index()]+20, 20, 20);
		
		// WHILE (not if) the drone hits the orb hitbox - this is to prevent infinite triggers if the drone stays inside the orb
		while (orb.intersects(droneBox) && check2) {
			// run the fuelbox method to give rewards, and flash it as a blue color to indicate that it was taken
			fuelBox();
			g.setColor(Color.BLUE);
			g.fillRect(index()*x/topA-(x/topA/2), topH[index()]+20, 20, 20);
		}
	}
}