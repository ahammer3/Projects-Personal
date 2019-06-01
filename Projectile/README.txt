/* 
 * Allan Hammer, ahammer3
 ** TTY Projectile */

Projectile Project ReadMe (explained from top to bottom of code)

//imported Scanner and Random for this program

//created Scanner to input, and 2 random variables wallH and wallD

// Print out the instructions to the game, separated by lines at appropriate places so it doesn’t get too messy

//set points to start off at 10, and a boolean variable done to true

//set up a while loop while done is true

//set 2 random integers randH and randD for wall height and distance using wallH and wallD at a maximum of 10 and 20 meters respectively

//Print out the wall’s height and distance for the user’s information at the start of each round, and then prompted a velocity and launch angle in the same line (no newline)

//set a velocity double and a double to be the user inputs

//used doubles for inputs but integers for the wall height and distance to make the outputs to the user easier and cleaner to read, I believed their was enough variability in the game already from 0-20 meters without going to decimals

//changed a to angle using Math.toRadians, and set a double y to the projectile motion formula given, with x = randD the random distance of the wall. This way y is calculated to be the height of the projectile at the wall distance

//set a range double variable to be the max distance that the projectile travels, aka where it hits the ground (using physics formula (v^2*sin2angle)/g)

//set a difference double variable to be the absolute value of range - randD to find the distance from the projectile to the wall

//set points to subtract by 1 after every launch

//set up a nested if statement inside the while, with condition that y>randH, aka y is greater than the height of the wall at distance randD, in other words the projectile clears the wall

//printed out different messages respectively as a result, and adjusted points accordingly

//for a landing difference of under 5 meters, I defined that as a perfect launch and the user got 5 points. For a difference under 10 otherwise, it was a good launch and +3 points, and for just clearing the wall otherwise the user got +2

//if y < randH, the else statement ran

//for y>0 aka the projectile didn’t clear the wall but also had a positive y value, meaning it hit the wall, the user got +1 (the launch point back) because it was almost there

//otherwise, for a losing difference of under 5, it was close and the user only lost the launch point

//otherwise, for a losing difference of under 10, it was a bit off and the user lost 1 point

//otherwise, the user was counted as being way off and the user lost 2 points (3 total)

//After the nested if statement ran, the score of the user was printed with \n to make the messages look cleaner between previous message and future message

//another nested if statement then runs, determining whether or not the user had one the game. If the user score hits <=0 or >=25, the appropriate loss or win message appears and done is set to false to end the while loop, ending the game

//otherwise, a prompted quit option appears, and the user enters their answer on the same line (no newline)

//their string is converted to lowercase and then checked if it contains the word “yes” for various entries such as Yes, yes, yes I would, etc.

//if yes is contained, done is set to false and the while loop ends, ending the game

//Otherwise, the if statement is skipped, ending the nested if statement, and thus ending the run of the while loop, going back to the beginning, setting a new randH and randD, and prompting the user again

//closed the Scanner input outside of the loop

/////end

