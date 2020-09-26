/*
 * File: VotingBox.java
 */

import stanford.karel.*;
public class VotingBox extends SuperKarel {
	
	/*
	 * This will have Karel move forward until they find
	 * a ballot space that does not have a beeper. They
	 * will then clean the space and continue east.
	 */
	
	public void run() {
		while (frontIsClear()) {
			move();
			if (noBeepersPresent()) {
				cleanBallot();
			}
			move();
		}
	}

	/*
	 * This will have Karel move north and south within the
	 * ballot space and remove any beepers present. Karel
	 * will then be returned to the 3rd street facing east.
	 */
	
	private void cleanBallot() {
		turnRight();
		move();
		while (beepersPresent()) {
			pickBeeper();
		}
		turnAround();
		move();
		move();
		while (beepersPresent()) {
			pickBeeper();
		}
		turnAround();
		move();
		turnLeft();
	}
}
