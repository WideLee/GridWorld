/*********************************************************************
 * ZBug.java  Version 1.00  <Wed Jul  3 16:18:20 2013>
 * 
 * Copyright(C) 2011-2012 LiMingkuan(11331173)  All rights reserved.
 * LiMingkuan is a student majoring in Software Engineering,
 * from the School of Software, 
 * SUN YAT-SEN UNIVERSITY, GZ 510006, P. R. China
 ********************************************************************/

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class ZBug extends Bug {
	private int steps;
	private int turns;
	private int sideLength;

	public ZBug(int length) {
		steps = 0;
		turns = 0;
		sideLength = length;
		setDirection(Location.EAST);
	}

	public void act() {
		if (turns < 3 && steps < sideLength) {
			// System.out.println("turns: " + Integer.toString(turns));
			// System.out.println("steps: " + Integer.toString(steps));
			if (canMove()) {
				steps++;
				move();
			} else {
				setDirection(Location.EAST);
				turns = 0;
				steps = 0;
			}
		} else if (turns == 0) {
			setDirection(Location.SOUTHWEST);
			steps = 0;
			turns++;
		} else if (turns == 1) {
			setDirection(Location.EAST);
			steps = 0;
			turns++;
		} else if (turns == 2) {
			steps = 0;
			turns++;
		}
	}
}
