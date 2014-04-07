import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class KingCrab extends CrabCritter {

	@Override
	public void processActors(ArrayList<Actor> actors) {
	
		for (Actor actor : actors) {
			moveFuther(actor);
		}
	}

	/**
	 * If the actor can move to the location that
     *     the actor towards to KingCrab, then move to
     *     this location directly.
     * If not, remove the actor from the grid.
	 */
	private void moveFuther(Actor actor) {
		Location location = actor.getLocation().getAdjacentLocation(
				getLocation().getDirectionToward(actor.getLocation()));
		if (isValid(location)) {
			actor.moveTo(location);
		} else {
			actor.removeSelfFromGrid();
		}
	}

	public boolean isValid(Location loc) {
		return getGrid().isValid(loc) && getGrid().get(loc) == null;
	}
}
