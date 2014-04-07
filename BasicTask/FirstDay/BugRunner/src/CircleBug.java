/*********************************************************************
 * CircleBug.java  Version 1.00  <Wed Jul  3 16:18:20 2013>
 * 
 * Copyright(C) 2011-2012 LiMingkuan(11331173)  All rights reserved.
 * LiMingkuan is a student majoring in Software Engineering,
 * from the School of Software, 
 * SUN YAT-SEN UNIVERSITY, GZ 510006, P. R. China
 ********************************************************************/

import info.gridworld.actor.*;

public class CircleBug extends Bug{
	private int steps;
	private int sideLength;
	
	public CircleBug(int length){
		steps = 0;
		sideLength = length;
	}
	
	/*
	 * Function act ()
	 * Moves to the next location of the octagon
	 */
	public void act(){
		if(steps < sideLength && canMove()){
			move();
			steps++;
		}
		
		else {
			turn();
			steps = 0;
		}
	}
}
