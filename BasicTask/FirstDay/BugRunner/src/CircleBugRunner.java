/*********************************************************************
 * CircleBugRunner.java  Version 1.00  <Wed Jul  3 16:18:20 2013>
 * 
 * Copyright(C) 2011-2012 LiMingkuan(11331173)  All rights reserved.
 * LiMingkuan is a student majoring in Software Engineering,
 * from the School of Software, 
 * SUN YAT-SEN UNIVERSITY, GZ 510006, P. R. China
 ********************************************************************/

import java.awt.Color;

import info.gridworld.actor.*;
import info.gridworld.grid.Location;

public class CircleBugRunner{
	public static void main(String[] args) {
		
		ActorWorld world = new ActorWorld();

		CircleBug alice = new CircleBug(3);
		alice.setColor(Color.BLUE);
		CircleBug bob = new CircleBug(4);
		bob.setColor(Color.RED);      
		world.add(new Location(7, 8), bob);
		world.add(new Location(2, 2), alice);
		world.show();
	}
}
