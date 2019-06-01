/* 
 * Allan Hammer, ahammer3
 ** Fireworks */

Fireworks Project ReadMe (explained from top to bottom of code)

FIREWORKS CLASS
//imported all necessary classes

//extended JFrame and implemented ChangeListener, ItemListener, ActionListener

//created all instance variables needed for the program. Panel, angle, velocity, time, their labels, 5 check boxes with their boolean counterparts, a launch button, a color c, and starting int values for x,y,t,v, and a double a, success label, reset button, color slider and label 

//in the public fireworks method, initiated all the variables in order, as well as their names created

//added all variables in order (flow layout makes this important)

//added a change listener to the angle slider (***all listeners printed out the event in the output code as I felt this could be important for back checking if it was an actual company***) that set an int i to the value of the slider, changed i to a (radians), then set the label to i(a)

//added a change listener to the velocity slider that did the same thing

//added a change listener to the time slider that did the same thing

//added an item listener to box1 where if the stateChange of the box was 1 (checked), check1 would be changed to true, else false

//repeated the same for box2-box5

//added a change listener to the color where if the slider value was 0, the color was the default black, if the value was 1, the color was red, and so on to 5=purple

//added an action listener for the launch button, and inside the method, declared int max to show the maximum x value that the firework would travel given the t chosen (at max t)

//declared a graphics g, and set the color to the c from before. Declared a polygon p, and in a for loop (at every x pixel value to the max x), an int y was the equation given in the project pdf, and a point p was added at (x, getHeight()-y) because of the inverted java structure. The resulting points were drawn in the PolyLine for the curve of the firework

//declared an int safe which was the y-point at the maximum x (y position of firework at explosion). Determined a safety factor for the firework where if getHeigh()-safe was less than 500, the success label was changed to Success!, else ERROR. This was to ensure the company can determine whether or not the firework exploded too close to the ground

//created the explosion patterns for the fireworks, depending on which check# boolean was true, determined in the item listeners. This also enabled different types of fireworks to be combined into different combinations. Check1 corresponded to Type One Firework, which was exploding circles. Type Two was exploding circles upward, Type Three was Exploding Squares to the right, Type Four was exploding squares centered, and Type Five was exploding squares to the left

//added an action listener to the reset button where every time it was pressed, the canvas would get repainted

//set layout to FlowLayout, set default size to (700,700) (can be changed, and would adjust to most sizes in FlowLayout), and set the DefaultCloseOperation to EXIT ON CLOSE

//in the main method, created the instance of fire as new Fireworks() and set fire to visible

//added the necessary override methods for the implementations at beginning of class for stateChanged, itemStateChanged, and actionPerformed