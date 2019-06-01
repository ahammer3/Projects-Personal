/* 
 * Allan Hammer, ahammer3
 * PROJECT 2 LAB TR 12:30-1:45
 * I did not copy code from on this assignment.
 * TTY Golf */

Golf Project ReadMe (explained from top to bottom of code)

COURSE CLASS
//created 2 instance variables name and par for the course parC, implemented a constructor and a toString that relayed an informative message for the main method, and getters and setters

HOLE CLASS
//extended course class to hole, with 3 new instance variables number, distance, and par for the hole. Created constructor calling the super, and a toString that overrides with an informative message. Then getters and setters

CLUB CLASS
//imported java.util.Random, and made 3 instance variables number, mean, and standard deviation std of the club. Implemented constructor and toString method, as well as getters and setters.

//made a nextDistance method that took in the mean, std, and power of a club, and using a new random variable that was turned into a Gaussian number, determined the distance hit using that certain club. Absolute value was used to avoid the negative part of the distribution, and the value was returned as an integer

//made a nextPutt method that took in the mean and std according to the putt power entered, and like above, used .nextGuassian to return a value as an integer

PLAYER CLASS
//made 4 instance variables score, hole, shot, and distanceLeft in the hole, with constructor, and 2 toString methods, depending on whether the player was on the fairway or green. Then getters and setters

GOLF CLASS
//In the golf or main class, imported scanner, and set a course variable to null to be declared later

//made all of the instance variables:

//For course, course1 and course2 representing 2 different courses

//For Hole, made 18 holes and an array of size 18, putting each instance of a hole (of course1) into the array holeArray, so that each hole could be corresponded to an index number of index+1=hole. Repeated for holeArray2 for course2

//For Club, made 10 club instances and an array of size 10, putting each instance of a club into the array clubArray, so that each club could be corresponded to an index number of index+1 = club. Repeated the process for clubArray2, where each index+1 represented the power chosen for the putt

//For player, created an instance p1 for the player with starting defaults of (0,0,0,0)

//Started the game

//set a boolean to true, then provided the user with an introduction as well as choices for more information. If the user does not enter 5, the while loop keeps going and the player can look at all of the information, or try again if incorrect input. Once 5 is entered, done is declared false, the loop stops, and the game begins

//done is declared true again, and in a while loop, the player is prompted to choose a golf course. If the player inputs correctly (1 or 2), done is false and the course variable is set to that course, as well as a message, otherwise try again

//done is once again declared true, and the main loop begins

//in a while loop, a for loop is nested cycling through each of the 18 holes, with an if statement printing out the necessary informative hole message depending on the course the player chose and setting distanceLeft to that respective hole

//an int shot is set to 1 and set as the player’s shot count to begin each hole, as well as the player’s informative message

//another while loop is started, while the distance left is over 20 yards (not on the green), the player will be prompted to choose a club and power. An int travel takes the club and puts it into the nextDistance method, storing the value in travel

//a message tells you how far the ball is then traveled, as well as Nice! if the ball is hit above 1 standard deviation of its mean, and oof vice versa. DistanceLeft is then set to the absolute value of the previous distanceLeft minus travel

//if distanceLeft is not 0 (chipped in the hole, happened during test runs), p1.shot is set to the next shot (+1), and the message is relayed. If the previous shot did not land on the green, a fairway message will appear, otherwise, a green message will with yards changed to feet with *3

//that while loop ends, and another one is started after changing the distanceLeft to feet, multiplying by 3

//while the ball is greater than 1 foot from the hole, the user will be prompted with a putt power. The travel variable is re-implemented for the nextPutt method, and its value is stored in travel. If travel is 0, travel was changed to 1 (putt power 1 has a mean of 1 and std of 1, so 0 was often possible. Not this likely in real golf)

//distanceLeft was calculated again using absolute value, and if the ball was still greater than 1 foot from the hole, a message with how far the ball was hit appears, as well as almost there! if you are within 5 feet. (there are various blank lines printed throughout the code to make the interface easier for the user to see)

//p1.shot was added (+1) again with the message printed out, and looped again

//if the distanceLeft was less than 1, aka the ball was in the hole, p1.score was set according to that hole’s par, and the score was printed. A quit option was then prompted

//if the user entered anything involving a y as instructed, i was set to 100 (so the for loop stopped looping to 18) and done was declared false so everything stopped. If not, the for loop is reset and i gets 1 added on, and we enter hole 2, etc.

//once the for loop is completed all the way, assuming the user does not quit, done is declared false to indicate no more looping

//a message is printed out with the total score, and various messages depending on whether or not the player finished above, below, or at par. Closed input scanner