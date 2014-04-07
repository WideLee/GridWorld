/*********************************************************************
 * DancingBugRunner.java  Version 1.00  <Wed Jul  3 16:18:20 2013>
 * 
 * Copyright(C) 2011-2012 LiMingkuan(11331173)  All rights reserved.
 * LiMingkuan is a student majoring in Software Engineering,
 * from the School of Software, 
 * SUN YAT-SEN UNIVERSITY, GZ 510006, P. R. China
 ********************************************************************/

import java.awt.Color;

import info.gridworld.actor.*;
import info.gridworld.grid.Location;

public class DancingBugRunner{
	public static void main(String[] args) {
		
		ActorWorld world = new ActorWorld();
		String array = new String("1,2,3,4");
		DancingBug dancingBug= new DancingBug(array);
		dancingBug.setColor(Color.BLUE);
		world.add(new Location(4, 4), dancingBug);
		world.show();
	}
}
