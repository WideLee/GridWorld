/*********************************************************************
 * SpiralBugRunner.java  Version 1.00  <Wed Jul  3 16:18:20 2013>
 * 
 * Copyright(C) 2011-2012 LiMingkuan(11331173)  All rights reserved.
 * LiMingkuan is a student majoring in Software Engineering,
 * from the School of Software, 
 * SUN YAT-SEN UNIVERSITY, GZ 510006, P. R. China
 ********************************************************************/

import java.awt.Color;

import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

public class SpiralBugRunner{
	public static void main(String[] args) {
		
		UnboundedGrid<Actor> grid = new UnboundedGrid<Actor>();
		ActorWorld world = new ActorWorld(grid);
		SpiralBug alice = new SpiralBug(3);
		alice.setColor(Color.BLUE);
		world.add(new Location(10, 10), alice);
		world.show();
	}
}
