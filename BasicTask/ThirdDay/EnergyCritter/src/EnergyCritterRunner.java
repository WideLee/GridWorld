import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class EnergyCritterRunner
{
    public static void main(String[] args)
    {
    	Grid<Actor> grid = new BoundedGrid<Actor>(20, 20);
        ActorWorld world = new ActorWorld(grid);
       
        world.add(new Location(9, 9), new Hole(5));

        world.add(new EnergyCritter());

        world.show();
    }
}