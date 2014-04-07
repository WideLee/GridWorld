import static org.junit.Assert.*;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author limkuan
 *
 */
public class testSparseBoundedGrid {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * {@link SparseBoundedGrid#SparseBoundedGrid(int, int)} 的测试方法。
	 */
	@Test
	public void testSparseBoundedGrid() {
		SparseBoundedGrid<Actor> actorBoundedGrid = new SparseBoundedGrid<Actor>(10, 10);
		assertEquals(actorBoundedGrid.occupantArray.size(), 10);
		assertEquals(actorBoundedGrid.occupantArray.get(0).size(), 0);
	}

	/**
	 * {@link SparseBoundedGrid#get(info.gridworld.grid.Location)} 的测试方法。
	 */
	@Test
	public void testGet() {
		SparseBoundedGrid<Actor> actorBoundedGrid = new SparseBoundedGrid<Actor>(10, 10);
		Bug bug = new Bug();
		actorBoundedGrid.put(new Location(3, 3), bug);
		assertEquals(actorBoundedGrid.get(new Location(3, 3)), bug);
		assertEquals(actorBoundedGrid.get(new Location(5, 5)), null);
	}

	/**
	 * {@link SparseBoundedGrid#getNumCols()} 的测试方法。
	 */
	@Test
	public void testGetNumCols() {
		SparseBoundedGrid<Actor> actorBoundedGrid = new SparseBoundedGrid<Actor>(10, 10);
		assertEquals(actorBoundedGrid.getNumCols(), 10);
	}

	/**
	 * {@link SparseBoundedGrid#getNumRows()} 的测试方法。
	 */
	@Test
	public void testGetNumRows() {
		SparseBoundedGrid<Actor> actorBoundedGrid = new SparseBoundedGrid<Actor>(10, 10);
		assertEquals(actorBoundedGrid.getNumRows(), 10);
	}

	/**
	 * {@link SparseBoundedGrid#getOccupiedLocations()} 的测试方法。
	 */
	@Test
	public void testGetOccupiedLocations() {
		SparseBoundedGrid<Actor> actorBoundedGrid = new SparseBoundedGrid<Actor>(10, 10);
		Bug bug = new Bug();
		ArrayList<Location> locs = new ArrayList<Location>();
		locs = actorBoundedGrid.getOccupiedLocations();
		assertEquals(actorBoundedGrid.getNumRows(), 10);
		assertTrue(locs.isEmpty());
	}

	/**
	 * {@link SparseBoundedGrid#isValid(info.gridworld.grid.Location)} 的测试方法。
	 */
	@Test
	public void testIsValid() {
		SparseBoundedGrid<Actor> actorBoundedGrid = new SparseBoundedGrid<Actor>(10, 10);
		assertFalse(actorBoundedGrid.isValid(new Location(11, 9)));
		assertTrue(actorBoundedGrid.isValid(new Location(4, 4)));
	}

	/**
	 * {@link SparseBoundedGrid#put(info.gridworld.grid.Location, java.lang.Object)} 的测试方法。
	 */
	@Test
	public void testPut() {
		SparseBoundedGrid<Actor> actorBoundedGrid = new SparseBoundedGrid<Actor>(10, 10);
		Bug bug = new Bug();
		Flower flower = new Flower();
		actorBoundedGrid.put(new Location(3, 3), bug);
		assertEquals(actorBoundedGrid.put(new Location(3, 3), flower), bug);
		
		assertEquals(actorBoundedGrid.get(new Location(3, 3)), flower);
		assertEquals(actorBoundedGrid.get(new Location(5, 5)), null);
	}

	/**
	 * {@link SparseBoundedGrid#remove(info.gridworld.grid.Location)} 的测试方法。
	 */
	@Test
	public void testRemove() {
		SparseBoundedGrid<Actor> actorBoundedGrid = new SparseBoundedGrid<Actor>(10, 10);
		Bug bug = new Bug();
		actorBoundedGrid.put(new Location(3, 3), bug);
		actorBoundedGrid.put(new Location(6, 6), bug);
		
		assertEquals(actorBoundedGrid.remove(new Location(3, 3)), bug);
		assertEquals(actorBoundedGrid.get(new Location(3, 3)), null);
	}

}
