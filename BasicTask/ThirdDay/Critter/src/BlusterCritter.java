import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class BlusterCritter extends Critter {

	private int courage;

	BlusterCritter(int cou) {
		super();
		courage = cou;
	}

	@Override
	public ArrayList<Actor> getActors() {

		Grid<Actor> grid = getGrid();
		ArrayList<Actor> actors = new ArrayList<Actor>();
		for (Location loc : getTwoAdjacentLocations(getLocation())) {
			Actor actor = grid.get(loc);
			if (actor != null) {
				actors.add(actor);
			}
		}
		// System.out.printf("actors: %d\n", actors.size());
		return actors;
	}

	@Override
	public void processActors(ArrayList<Actor> actors) {

		int courageNum = 0;
		for (Actor actor : actors) {
			if (actor instanceof Critter) {
				courageNum++;
			}
		}
		// System.out.print(courageNum);
		if (courageNum < courage) {
			brighter();
		} else {
			darker();
		}
	}

	/**
	 * 
	 */
	private void darker() {
		float color[] = Color.RGBtoHSB(getColor().getRed(), getColor()
				.getGreen(), getColor().getBlue(), null);
		color[2] *= 0.95;
		// System.out.printf("%f %f %f\n",color[0], color[1],color[2]);
		Color newColor = Color.getHSBColor(color[0], color[1], color[2]);
		setColor(newColor);
	}

	/**
	 * 
	 */
	private void brighter() {
		float color[] = Color.RGBtoHSB(getColor().getRed(), getColor()
				.getGreen(), getColor().getBlue(), null);
		double temp = 1.0 - color[2];
		temp *= 0.95;
		color[2] = (float) (1 - temp);
		// System.out.printf("%f %f %f\n",color[0], color[1],color[2]);
		Color newColor = Color.getHSBColor(color[0], color[1], color[2]);
		setColor(newColor);
	}

	/**
	 * 
	 */
	private ArrayList<Location> getTwoAdjacentLocations(Location location) {
		Grid<Actor> grid = getGrid();
		ArrayList<Location> locs = new ArrayList<Location>();
		for (int i = location.getRow() - 2; i <= location.getRow() + 2; i++)
			for (int j = location.getCol() - 2; j <= location.getCol() + 2; j++) {
				if (!location.equals(new Location(i, j))
						&& grid.isValid(new Location(i, j))) {
					locs.add(new Location(i, j));
				}
			}
		// System.out.printf("locs: %d\n", locs.size());
		return locs;
	}
}
