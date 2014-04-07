import info.gridworld.actor.Actor;
import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * An <code>UnboundedGrid</code> is a rectangular grid with an unbounded number
 * of rows and columns. <br />
 * The implementation of this class is testable on the AP CS AB exam.
 */
public class UnboundedArrayGrid<E> extends AbstractGrid<E> {
	private Object[][] occupantArray;
	private int dimension;

	/**
	 * Constructs an empty unbounded grid.
	 */
	public UnboundedArrayGrid() {
		dimension = 16;
		occupantArray = new Object[16][16];
	}

	public int getNumRows() {
		return -1;
	}

	public int getNumCols() {
		return -1;
	}

	public boolean isValid(Location loc) {
		//return loc.getRow() >= 0 && loc.getCol() >= 0;
		return true;
	}

	public boolean isInCurrentGrid(Location loc) {
		return 0 <= (loc.getRow() + dimension / 2 - 1)
				&& (loc.getRow() + dimension / 2 - 1) < dimension
				&& 0 <= (loc.getCol() + dimension / 2 - 1)
				&& (loc.getCol() + dimension / 2 - 1) < dimension;
	}

	public ArrayList<Location> getOccupiedLocations() {
		ArrayList<Location> theLocations = new ArrayList<Location>();
		// Look at all grid locations.
		for (int r = 0; r < dimension; r++) {
			for (int c = 0; c < dimension; c++) {
				// If there's an object at this location, put it in the array.
				Location loc = new Location(r - (dimension / 2 - 1), c
						- (dimension / 2 - 1));
				if (get(loc) != null)
					theLocations.add(loc);
			}
		}

		return theLocations;
	}

	public E get(Location loc) {
		if (!isInCurrentGrid(loc))
			return null;
		return (E) occupantArray[loc.getRow() + (dimension / 2 - 1)][loc
				.getCol() + (dimension / 2 - 1)];
	}

	public E put(Location loc, E obj) {

		if (obj == null)
			throw new NullPointerException("obj == null");

		if (isInCurrentGrid(loc)) {
			// Add the object to the grid.
			E oldOccupant = get(loc);
			occupantArray[loc.getRow() + (dimension / 2 - 1)][loc.getCol()
					+ (dimension / 2 - 1)] = obj;
			return oldOccupant;
		}
		while (!isInCurrentGrid(loc))
			dimension *= 2;
		Object[][] anotherArray = new Object[dimension][dimension];
		for (int i = 0; i < occupantArray.length; i++)
			for (int j = 0; j < occupantArray[i].length; j++) {
				anotherArray[i + dimension / 4 ][j + dimension / 4 ] = occupantArray[i][j];
			}
		occupantArray = anotherArray;
		occupantArray[loc.getRow() + dimension / 2 - 1][loc.getCol()
				+ dimension / 2 - 1] = obj;
		//System.out.println(dimension);
		return null;
	}

	public E remove(Location loc) {
		if (!isInCurrentGrid(loc))
			return null;
		E r = get(loc);
		occupantArray[loc.getRow() + (dimension / 2 - 1)][loc.getCol()
				+ (dimension / 2 - 1)] = null;
		return r;
	}
}
