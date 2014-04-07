import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class EnergyCritter extends Critter {

	private int energy;
	private ArrayList<Color> colors;

	/**
	 * the constructor of class energyCritter
	 * 
	 * @param int _energy: the initializing energy of the critter.
	 */
	public EnergyCritter(int _energy) {
		initColor(Color.BLUE, Color.RED, 100);
		energy = _energy;
		setColor(getGradientColor(energy));
	}
	
	public int  getEnergy() {
		return energy;
	}
	/**
	 * the constructor of class energyCritter set the default value of energy
	 */
	public EnergyCritter() {
		initColor(Color.BLUE, Color.RED, 100);
		energy = 50;
		setColor(getGradientColor(energy));
	}

	/**
	 * initialize the gradient Color array list
	 * 
	 * @param Color
	 *            from, indicates the color at the begin of the color gradient.
	 *            Color to, indicates the color in the end of the color
	 *            gradient. int steps, indicates how many steps to complete the
	 *            color gradient.
	 */
	private void initColor(Color from, Color to, int steps) {

		colors = new ArrayList<Color>();

		for (int i = 0; i < 100; i++) {
			// get each element of changing color
			int red = from.getRed() + (to.getRed() - from.getRed()) * i / steps;
			int green = from.getGreen() + (to.getGreen() - from.getGreen()) * i
					/ steps;
			int blue = from.getBlue() + (to.getBlue() - from.getBlue()) * i
					/ steps;
			colors.add(new Color(red, green, blue));
		}
	}

	/**
	 * @return Color which is corresponding the energy.
	 */
	private Color getGradientColor(int energy) {
		return colors.get(energy);
	}

	/**
	 * Override the act method from Critter class.
	 * 
	 * If energy is less than 0, the EnergyCritter will change to a bug, which
	 * is random color if energy is larger than 100, the EnergyCritter will
	 * divide to two EnergyCritter, which the energy is 50. if is in range
	 * 0-100, it will set its color by energy, and random move to a location
	 * adjacent to it.
	 */
	@Override
	public void act() {
		if (getGrid() == null)
			return;
		ArrayList<Actor> actors = getActors();
		processActors(actors);
		if (energy <= 0)
			changeToBug();
		else if (energy >= 100) {
			divideTwoCritter();
		} else {
			setColor(getGradientColor(energy));
			ArrayList<Location> moveLocs = getMoveLocations();
			Location loc = selectMoveLocation(moveLocs);
			makeMove(loc);
		}
	}

	/**
	 * A EnergyCritter gets the actors in the two locations immediately to its
	 * front-right and to its front-left
	 * 
	 * @return a list of actors occupying these locations
	 */
	@Override
	public ArrayList<Actor> getActors() {
		ArrayList<Actor> actors = new ArrayList<Actor>();
		// Get actor from the location which is immediately to its front-right
		// and to its front-left
		int[] dirs = { Location.HALF_LEFT, Location.HALF_RIGHT };
		for (Location loc : getLocationsInDirections(dirs)) {
			Actor a = getGrid().get(loc);
			if (a != null)
				actors.add(a);
		}

		return actors;
	}

	/**
	 * Override the method processActors from Critter class.
	 * 
	 * If the actor is flower or a bug, the EnergyCritter will eat them. After
	 * processing actors, if EnergyCritter eat one or more than one actors, the
	 * energy of it will increase, if EnergyCritter eat none actor, the energy
	 * will be reduced.
	 * 
	 * @param ArrayList
	 *            <Actor>, the list of actors to be processed
	 */
	@Override
	public void processActors(ArrayList<Actor> actors) {
		int n = 0;
		for (Actor actor : actors) {
			// if actor is flower and bug, eat them
			if (actor instanceof Flower || actor instanceof Bug) {
				n++;
				actor.removeSelfFromGrid();
			}
		}
		if (n == 0) {
			// eat nothing, reduce energy.
			energy -= 3;
		} else {
			// eat something, increase energy
			energy += 5;
		}
	}

	/**
	 * Turns towards the new location as it moves.
	 */
	@Override
	public void makeMove(Location loc) {
		setDirection(getLocation().getDirectionToward(loc));
		super.makeMove(loc);
		return;
	}

	/**
	 * while the energy of EnergyCritter is larger than 100, it will call this
	 * method, and remove itself from grid, then add two EnergyCritter to grid,
	 * which the energy is 50.
	 */
	private void divideTwoCritter() {

		// get validLocations which the divided critter will be placed.
		ArrayList<Location> locations = getMoveLocations();
		locations.add(getLocation());

		Grid<Actor> grid = getGrid();

		removeSelfFromGrid();
		
		int i = (int) (Math.random() * (locations.size()));
		new EnergyCritter().putSelfInGrid(grid, locations.get(i));
		int j = (int) (Math.random() * (locations.size()));
		while (i == j) {
			j = (int) (Math.random() * (locations.size()));
		}
		new EnergyCritter().putSelfInGrid(grid, locations.get(j));
	}

	/**
	 * while the energy of EnergyCritter is smaller than 0, it will call this
	 * method, and remove itself from grid, then add a random color bug to the
	 * location it just in.
	 */
	private void changeToBug() {
		Location loc = getLocation();
		Grid<Actor> grid = getGrid();
		// get a random color
		Color color = new Color((int) (Math.random() * 255),
				(int) (Math.random() * 255), (int) (Math.random() * 255));
		removeSelfFromGrid();
		Bug bug = new Bug(color);
		bug.putSelfInGrid(grid, loc);
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