import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * An <code>UnboundedGrid</code> is a rectangular grid with an unbounded number
 * of rows and columns. <br />
 * The implementation of this class is testable on the AP CS AB exam.
 */
public class SparseBoundedGridHashMap<E> extends AbstractGrid<E> {
	private Map<Location, E> occupantMap;
	int rowNum;
	int colNum;

	/**
	 * Constructs an empty SparseBounded grid.
	 */
	public SparseBoundedGridHashMap(int row, int column) {
		if (row <= 0)
			throw new IllegalArgumentException("rows <= 0");
		if (column <= 0)
			throw new IllegalArgumentException("cols <= 0");

		rowNum = row;
		colNum = column;

		occupantMap = new HashMap<Location, E>();
	}

	public int getNumRows() {
		return rowNum;
	}

	public int getNumCols() {
		return colNum;
	}

	public boolean isValid(Location loc) {
		return 0 <= loc.getRow() && loc.getRow() < getNumRows()
				&& 0 <= loc.getCol() && loc.getCol() < getNumCols();
	}

	public ArrayList<Location> getOccupiedLocations() {
		ArrayList<Location> a = new ArrayList<Location>();
		for (Location loc : occupantMap.keySet())
			a.add(loc);
		return a;
	}

	public E get(Location loc) {
		if (!isValid(loc))
			throw new IllegalArgumentException("Location " + loc
					+ " is not valid");
		
		return occupantMap.get(loc);
	}

	public E put(Location loc, E obj) {
		if (!isValid(loc))
			throw new IllegalArgumentException("Location " + loc
					+ " is not valid");
		
		if (obj == null)
			throw new NullPointerException("obj == null");
		return occupantMap.put(loc, obj);
	}

	public E remove(Location loc) {
		if (!isValid(loc))
			throw new IllegalArgumentException("Location " + loc
					+ " is not valid");
		
		return occupantMap.remove(loc);
	}
}
