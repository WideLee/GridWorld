/*********************************************************************
 * DancingBug.java  Version 1.00  <Wed Jul  3 16:18:20 2013>
 * 
 * Copyright(C) 2011-2012 LiMingkuan(11331173)  All rights reserved.
 * LiMingkuan is a student majoring in Software Engineering,
 * from the School of Software, 
 * SUN YAT-SEN UNIVERSITY, GZ 510006, P. R. China
 ********************************************************************/

import info.gridworld.actor.Bug;

public class DancingBug extends Bug {
	private int[] turns;
	private int steps;

	public DancingBug(String array) {

        // change the string to integer array
		String[] strings = array.split(",");
        turns = new int[strings.length];
        
		for (int i = 0; i < strings.length; i++) {
			turns[i] = Integer.parseInt(strings[i]);
		}
		steps = 0;
	}

	public void act() {
		if (steps == turns.length) {
			steps = 0;
		}
		for (int i = 0; i < turns[steps]; i++)
			turn();
		steps++;
		if (canMove()) {
			move();
		} else {
			turn();
		}
	}
}
