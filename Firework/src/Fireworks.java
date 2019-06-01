/* 
 * Allan Hammer, ahammer3
 * PROJECT 3 LAB TR 12:30-1:45
 * I did not copy code from on this assignment.
 * Fireworks */

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Polygon;
@SuppressWarnings("serial")
public class Fireworks extends JFrame implements ChangeListener, ItemListener, ActionListener {

	public JPanel panel;
	public JSlider angle;
	public JSlider velocity;
	public JSlider time;
	public JLabel aLabel;
	public JLabel vLabel;
	public JLabel tLabel;
	public JCheckBox box1;
	public JCheckBox box2;
	public JCheckBox box3;
	public JCheckBox box4;
	public JCheckBox box5;
	public boolean check1 = false;
	public boolean check2 = false;
	public boolean check3 = false;
	public boolean check4 = false;
	public boolean check5 = false;
	public JButton launch;
	Color c = Color.BLACK;
	public int x = 0;
	public int y = 0;
	public int t = 0;
	public double a = 0;
	public int v = 0;
	public JLabel success;
	public JButton reset;
	public JSlider color;
	public JLabel cLabel;
	
	public Fireworks () {
		panel = new JPanel();
		angle = new JSlider(0,90);
		aLabel = new JLabel("Angle (degrees)");
		velocity = new JSlider(100,300);
		vLabel = new JLabel("Velocity (m/s)");
		time = new JSlider(0,5);
		tLabel = new JLabel("Flight Time (s)");
		box1 = new JCheckBox("Type One");
		box2 = new JCheckBox("Type Two");
		box3 = new JCheckBox("Type Three");
		box4 = new JCheckBox("Type Four");
		box5 = new JCheckBox("Type Five");
		launch = new JButton("Launch");
		success = new JLabel("Success?");
		reset = new JButton("Reset");
		color = new JSlider(0,5);
		cLabel = new JLabel("Color");
		
		add(angle);
		add(aLabel);
		add(velocity);
		add(vLabel);
		add(time);
		add(tLabel);
		add(box1);
		add(box2);
		add(box3);
		add(box4);
		add(box5);
		add(launch);
		add(success);
		add(reset);
		add(color);
		add(cLabel);

		angle.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println(e);
				int i = angle.getValue();
				a=Math.toRadians(i);
				aLabel.setText(Integer.toString(i));
			}
		});
		
		velocity.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println(e);
				int i = velocity.getValue();
				v=i;
				vLabel.setText(Integer.toString(i));
			}
		});
		
		time.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println(e);
				int i = time.getValue();
				t=i;
				tLabel.setText(Integer.toString(i));
			}
		});
		
		box1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e);
				if (e.getStateChange() == 1) {
					check1 = true;
				} else {
					check1 = false;
				}
			}
		});
		
		box2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e);
				if (e.getStateChange() == 1) {
					check2 = true;
				} else {
					check2 = false;
				}
			}
		});
		
		box3.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e);
				if (e.getStateChange() == 1) {
					check3 = true;
				} else {
					check3 = false;
				}
			}
		});
		
		box4.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e);
				if (e.getStateChange() == 1) {
					check4 = true;
				} else {
					check4 = false;
				}
			}
		});
		
		box5.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e);
				if (e.getStateChange() == 1) {
					check5 = true;
				} else {
					check5 = false;
				}
			}
		});
		
		color.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println(e);
				if (color.getValue()==0) {
					c = Color.BLACK;
					cLabel.setText("Black");
				} else if (color.getValue()==1) {
					c = Color.RED;
					cLabel.setText("Red");
				} else if (color.getValue()==2) {
					c = Color.BLUE;
					cLabel.setText("Blue");
				} else if (color.getValue()==3) {
					c = Color.GREEN;
					cLabel.setText("Green");
				} else if (color.getValue()==4) {
					c = Color.ORANGE;
					cLabel.setText("Orange");
				} else {
					c = Color.MAGENTA;
					cLabel.setText("Purple");
				}
			}
		});
		
		launch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int max = (int) (t*v*Math.cos(a));
				System.out.println(e);
				Graphics g = getGraphics();
				g.setColor(c);
				Polygon p = new Polygon();
				for (int x=0;x<=max;x++) {
					int y = (int) (((v*Math.sin(a)*x)/(v*Math.cos(a))) - ((9.8*x*x)/((v*Math.cos(a))*(v*Math.cos(a)))*2));
					p.addPoint(x, getHeight() - y);
				}
				g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
				
				int safe = (int) (((v*Math.sin(a)*max)/(v*Math.cos(a))) - ((9.8*max*max)/((v*Math.cos(a))*(v*Math.cos(a)))*2));
				if (getHeight() - safe <= 500) {
					success.setForeground(Color.GREEN);
					success.setText("Success!");
				} else if (getHeight() - safe > 500) {
					success.setForeground(Color.RED);
					success.setText("ERROR");
				}
				
				if (check1) {
					for (int i=1; i<=4; i++) {
						g.drawOval(max-(i*10), (getHeight() - safe)-(i*10), i*20, i*20);
					}
				}
				
				if (check2) {
					for (int i=1; i<=4; i++) {
						g.drawOval(max-(i*15), (getHeight() - safe)-(i*15), i*30, i*10);
					}
				}
				
				if (check3) {
					for (int i=1; i<=4; i++) {
						g.drawRect(max+(-10+i*10), (getHeight()-safe)-(i*10), 20*i, 20*i);
					}	
				}
				
				if (check4) {
					for (int i=1; i<=4; i++) {
						g.drawRect(max+(10-i*10), (getHeight()-safe)-(i*10), 20*i, 20*i);
					}
				}
				
				if (check5) {
					for (int i=1; i<=4; i++) {
						g.drawRect(max+(5-i*25),(getHeight()- safe)-(i*10), 20*i, 20*i);
					}
				}
			}
		});
		
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e);
				repaint();
			}
		});
		
		setLayout(new FlowLayout());
		setSize(700,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Fireworks fire = new Fireworks();
		fire.setVisible(true);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
