public class OccupantInCol{
	
	private Object occupant;
	private int col;
	
	/**
	 * 
	 */
	public OccupantInCol(Object occupantObject, int column) {
		occupant = occupantObject;
		col = column;
	}
	
	public int getCol(){
		return col;
	}
	
	public Object getOccupant(){
		return occupant;
	}
	
	public void setOccupant(Object occupantObject){
		occupant = occupantObject;
	}
}