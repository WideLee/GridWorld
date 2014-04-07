/*********************************************************************
 * SpiralBug.java  Version 1.00  <Wed Jul  3 16:18:20 2013>
 * 
 * Copyright(C) 2011-2012 LiMingkuan(11331173)  All rights reserved.
 * LiMingkuan is a student majoring in Software Engineering,
 * from the School of Software, 
 * SUN YAT-SEN UNIVERSITY, GZ 510006, P. R. China
 ********************************************************************/

import info.gridworld.actor.Bug;

public class SpiralBug extends Bug {
	private int steps;
	private int sideLength;

	public SpiralBug(int length) {
		steps = 0;
		sideLength = length;
	}

	public void act() {
		if (steps < sideLength && canMove()) {
			move();
			steps++;
		}

		else {
			turn();
			turn();
			sideLength++;
			steps = 0;
		}
	}
}
