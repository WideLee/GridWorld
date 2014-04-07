import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.Critter;

/*** This class runs a world with additional grid choices. */
public class SparseGridRunner {
	public static void main(String[] args) {
		SparseBoundedGridHashMap<Actor> grid = new SparseBoundedGridHashMap<Actor>(10, 10);
		ActorWorld world = new ActorWorld(grid);
		world.addGridClass("SparseBoundedGrid");
		world.addGridClass("SparseBoundedGridHashMap");
		world.add(new Location(2, 2), new Critter());
		world.show();
	}
}
