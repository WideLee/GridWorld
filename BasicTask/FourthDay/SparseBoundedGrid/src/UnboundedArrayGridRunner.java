import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

/*** This class runs a world with additional grid choices. */
public class UnboundedArrayGridRunner {
	public static void main(String[] args) {
		UnboundedArrayGrid<Actor> grid = new UnboundedArrayGrid<Actor>();
		ActorWorld world = new ActorWorld(grid);
		world.add(new Location(3, 3), new Bug());
		world.show();
	}
}
