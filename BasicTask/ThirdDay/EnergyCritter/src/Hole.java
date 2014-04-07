import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class Hole extends Rock {

	private int max_steps;
	private int steps;

	public Hole(int max) {
		max_steps = max;
	}

	public Hole() {
		max_steps = 20;
	}

	/**
	 * The hole will create a critter or a bug after some steps.
	 */
	@Override
	public void act() {
		steps++;
		if (steps == max_steps) {
			steps = 0;
			Actor actor;
			double r = Math.random();
			if (r > 0.3) {
				Color color = new Color((int) (Math.random() * 255),
						(int) (Math.random() * 255),
						(int) (Math.random() * 255));
				actor = new Bug(color);
			} else {
				actor = new EnergyCritter();
			}
			ArrayList<Location> locations = getGrid()
					.getValidAdjacentLocations(getLocation());
			ArrayList<Location> validLocations = new ArrayList<Location>();
			for (Location loc : locations) {
				if (getGrid().get(loc) instanceof Flower
						|| getGrid().get(loc) == null)
					validLocations.add(loc);
			}
			if (!validLocations.isEmpty()) {
				actor.putSelfInGrid(getGrid(), validLocations.get((int) (Math
						.random() * validLocations.size())));
				actor.setDirection(getLocation().getDirectionToward(
						actor.getLocation()));
				setColor(actor.getColor());
			}
		}
	}
}