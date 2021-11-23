package rubik;

public class Coordinate {
	private int x;
	private int y;
	private int z;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	public Coordinate(){
		x=0;
		y=0;
		z=0;
	}
	public Coordinate(int a,int b,int c) {
		x=a;
		y=b;
		z=c;
	}
	public boolean isEqual(Coordinate cor) {
		if(x==cor.getX()&&y==cor.getY()&&z==cor.getZ()) {
			return true;
		}
		return false;
	}
	public void Display() {
		System.out.println(x+" "+y+" "+z);
	}
	

}
