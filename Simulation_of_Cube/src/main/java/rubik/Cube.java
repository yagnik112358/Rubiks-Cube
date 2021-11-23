package rubik;

import java.util.*;

public class Cube {
	private HashMap<Side,RubiksCubeColor> map = new HashMap<Side,RubiksCubeColor>();

	/*public HashMap<Sides, Color> getMap() {
		return map;
	}
*/
	public Cube (){
		
		map.put(Side.BACK, RubiksCubeColor.BLACK);
		map.put(Side.FRONT, RubiksCubeColor.BLACK);
		map.put(Side.LEFT, RubiksCubeColor.BLACK);
		map.put(Side.RIGHT, RubiksCubeColor.BLACK);
		map.put(Side.UP, RubiksCubeColor.BLACK);
		map.put(Side.DOWN, RubiksCubeColor.BLACK);
		
	}
	public boolean is_Equal(Cube c) {
		for(Side s:this.map.keySet()) {
			if(this.getColor(s)!=c.getColor(s)) {
				return false;
			}
		}
		return true;
	}
	public RubiksCubeColor getCenterColor(Side side) {
		if(side==Side.FRONT) {
			return RubiksCubeColor.RED;
		}
		if(side==Side.UP) {
			return RubiksCubeColor.WHITE;
		}
		if(side==Side.LEFT) {
			return RubiksCubeColor.GREEN;
		}
		if(side==Side.RIGHT) {
			return RubiksCubeColor.BLUE;
		}
		if(side==Side.DOWN) {
			return RubiksCubeColor.YELLOW;
		}
		if(side==Side.BACK) {
			return RubiksCubeColor.ORANGE;
		}
		return null;
		
	}
	public void setMap(Side side, RubiksCubeColor color) {
			map.put(side, color);
	}
	public RubiksCubeColor getColor(Side side) {
		if(map.get(side)!=null) {
		RubiksCubeColor c=map.get(side);
			return c;
		}
		return null;
	}
	
	public boolean Search(RubiksCubeColor color) {
		for(Side s:this.map.keySet()) {
			if(this.map.get(s)==color) {
				return true;
				//return s;
			}
		}
		//return null;
		return false;
	}
	public RubiksCubeColor getColor_center() {
		
		for(Side s:this.map.keySet()) {
			if(this.map.get(s).isEqual(RubiksCubeColor.BLACK)) {
				return this.getColor(s);
			}
		}
			
		return null;
	}
	public void circularShift(Side s1,Side s2,Side s3,Side s4) {
		//Color c= new Color();
		RubiksCubeColor c = getColor(s1);
		setMap(s1,getColor(s4));
		setMap(s4,getColor(s3));
		setMap(s3,getColor(s2));
		setMap(s2,c);
	}
	public void rightRotation() {
		circularShift(Side.FRONT,Side.UP,Side.BACK,Side.DOWN );
	}
	public void leftRotation() {
		circularShift(Side.BACK,Side.UP,Side.FRONT,Side.DOWN );
	}
	public void downRotation() {
		circularShift(Side.FRONT,Side.RIGHT,Side.BACK,Side.LEFT );
	}
	public void upRotation() {
		circularShift(Side.FRONT,Side.LEFT,Side.BACK,Side.RIGHT );
	}
	public void frontRotation() {
		circularShift(Side.LEFT,Side.UP,Side.RIGHT,Side.DOWN );
	}
	public void backRotation() {
		circularShift(Side.RIGHT,Side.UP,Side.LEFT,Side.DOWN );
	}
	/*public void rightRotation() {
		circularShift(Sides.FRONT,Sides.UP,Sides.BACK,Sides.DOWN );
	}
	public void rightRotation() {
		circularShift(Sides.FRONT,Sides.UP,Sides.BACK,Sides.DOWN );
	}
	public void rightRotation() {
		circularShift(Sides.FRONT,Sides.UP,Sides.BACK,Sides.DOWN );
	}
	public void rightRotation() {
		circularShift(Sides.FRONT,Sides.UP,Sides.BACK,Sides.DOWN );
	}
	
*/	public void Display() {
		for(Map.Entry<Side,RubiksCubeColor>  m : map.entrySet())
		{
			System.out.println("Side ="+m.getKey()+" Color ="+m.getValue());  
		}
		//System.out.println(this.map);
	}
public int blackEdge() {
	int count=0;
	for(Side s:this.map.keySet()) {
		//System.out.println(this.map.get(s));
		
		if(this.map.get(s)==RubiksCubeColor.BLACK) {
			//System.out.println("inside blackedge");
			
			count=count+1;
		}
		
	}
	
	return count;
}

}
