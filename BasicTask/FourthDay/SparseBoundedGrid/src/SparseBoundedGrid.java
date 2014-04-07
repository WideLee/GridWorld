import java.util.ArrayList;
import java.util.LinkedList;

import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

public class SparseBoundedGrid<E> extends AbstractGrid<E> {

	ArrayList<LinkedList<OccupantInCol>> occupantArray;
	int rowNum;
	int colNum;

	public SparseBoundedGrid(int row, int column) {

		if (row <= 0)
			throw new IllegalArgumentException("rows <= 0");
		if (column <= 0)
			throw new IllegalArgumentException("cols <= 0");

		rowNum = row;
		colNum = column;

		occupantArray = new ArrayList<LinkedList<OccupantInCol>>();
		for (int i = 0; i < row; i++) {
			occupantArray.add(new LinkedList<OccupantInCol>());
		}
	}

	@Override
	public E get(Location loc) {
		if (!isValid(loc))
			throw new IllegalArgumentException("Location " + loc
					+ " is not valid");

		LinkedList<OccupantInCol> linkedList = occupantArray.get(loc.getRow());

		if (!linkedList.isEmpty()) {
			for (OccupantInCol occupantInCol : linkedList) {
				if (occupantInCol.getCol() == loc.getCol())
					return (E) occupantInCol.getOccupant();
			}
		}
		return null;

	}

	@Override
	public int getNumCols() {
		return rowNum;
	}

	@Override
	public int getNumRows() {
		return colNum;
	}

	@Override
	public ArrayList<Location> getOccupiedLocations() {
		ArrayList<Location> locs = new ArrayList<Location>();

		for (int i = 0; i < occupantArray.size(); i++) {
			for (int j = 0; j < occupantArray.get(i).size(); j++) {
				locs.add(new Location(i, occupantArray.get(i).get(j).getCol()));
			}
		}
		return locs;
	}

	@Override
	public boolean isValid(Location loc) {
		return 0 <= loc.getRow() && loc.getRow() < getNumRows()
				&& 0 <= loc.getCol() && loc.getCol() < getNumCols();
	}

	@Override
	public E put(Location loc, E object) {
		if (!isValid(loc))
			throw new IllegalArgumentException("Location " + loc
					+ " is not valid");
		if (object == null)
			throw new NullPointerException("object == null");

		// Add the object to the grid.
		E oldOccupant = remove(loc);
		occupantArray.get(loc.getRow()).add(
				new OccupantInCol(object, loc.getCol()));
		return oldOccupant;
	}

	@Override
	public E remove(Location loc) {
		if (!isValid(loc))
			throw new IllegalArgumentException("Location " + loc
					+ " is not valid");

		// Remove the object from the grid.
		LinkedList<OccupantInCol> linkedList = occupantArray.get(loc.getRow());
		if (!linkedList.isEmpty()) {
			for (int i = 0; i < linkedList.size(); i++) {
				if (linkedList.get(i).getCol() == loc.getCol()) {
					E removeObject = (E) linkedList.get(i).getOccupant();
					linkedList.remove(i);
					return removeObject;
				}
			}
		}
		return null;
	}

}