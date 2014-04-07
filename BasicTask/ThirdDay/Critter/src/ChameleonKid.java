import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class ChameleonKid extends ChameleonCritter {

	@Override
	public ArrayList<Actor> getActors() {
		ArrayList<Actor> actors = new ArrayList<Actor>();
		int[] directions = { Location.AHEAD, Location.HALF_CIRCLE };

		for (Location loc : getLocationsInDirections(directions)) {
			Actor actor = getGrid().get(loc);
			if (actor != null) {
				actors.add(actor);
			}
		}
		return actors;
	}

	/**
	 * Finds the valid adjacent locations of this critter in different
	 * directions.
	 * 
	 * @param directions
	 *            - an array of directions (which are relative to the current
	 *            direction)
	 * @return a set of valid locations that are neighbors of the current
	 *         location in the given directions
	 */
	public ArrayList<Location> getLocationsInDirections(int[] directions) {
		ArrayList<Location> locs = new ArrayList<Location>();
		Grid<Actor> gr = getGrid();
		Location loc = getLocation();

		for (int d : directions) {
			Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
			if (gr.isValid(neighborLoc))
				locs.add(neighborLoc);
		}
		return locs;
	}
}
