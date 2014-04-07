import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;

public class RockHound extends Critter{
	
	@Override
	public void processActors(ArrayList<Actor> actors) {
		
		for (Actor actor : actors)
        {
            if (!(actor instanceof Critter))
                actor.removeSelfFromGrid();
        }
	}
	
}