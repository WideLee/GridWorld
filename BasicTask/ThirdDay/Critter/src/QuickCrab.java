import info.gridworld.grid.Location;

import java.util.ArrayList;

public class QuickCrab extends CrabCritter {

	@Override
	public ArrayList<Location> getMoveLocations() {
		ArrayList<Location> locations = new ArrayList<Location>();
		ArrayList<Location> allLocations = new ArrayList<Location>();
		int[] attr = { 0, 0, 0, 0, 0, 0, 0, 0 };
		int direction = getDirection();
		if (direction == Location.WEST || direction == Location.EAST) {
			int[] temp = { -1, 0, 1, 0, -2, 0, 2, 0 };
			attr = temp;
		} else if (direction == Location.NORTH || direction == Location.SOUTH) {
			int[] temp = { 0, -1, 0, 1, 0, -2, 0, 2 };
			attr = temp;
		}
		for (int i = 0; i < 4; i++) {
			allLocations.add(new Location(getLocation().getRow() + attr[2 * i],
					getLocation().getCol() + attr[2 * i + 1]));
		}
		if (isValid(allLocations.get(0)) && isValid(allLocations.get(2))) {
			locations.add(allLocations.get(2));
		}
		if (isValid(allLocations.get(1)) && isValid(allLocations.get(3))) {
			locations.add(allLocations.get(3));
		}
		if (locations.isEmpty()) {
			if (isValid(allLocations.get(0))) {
				locations.add(allLocations.get(0));
			}
			if (isValid(allLocations.get(1))) {
				locations.add(allLocations.get(1));
			}
		}
		return locations;
	}

	public boolean isValid(Location loc) {
		return getGrid().isValid(loc) && getGrid().get(loc) == null;
	}
}
