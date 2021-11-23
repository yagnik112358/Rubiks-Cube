package rubik;

public enum RubiksCubeColor {
	 WHITE,RED,GREEN,BLUE,ORANGE,YELLOW,BLACK;	//colours are arranged in the order such as the sum of ordinals of invalid combination is five.
	 
		public boolean isValid(RubiksCubeColor color) {
			if(this.ordinal()+color.ordinal()!=5) {
				return true;
			}
			return false;
		}
		static public RubiksCubeColor RGBValues(int i,int j,int k) {
			if(i==0&&j==0&&k==0) {
				return BLACK;
			}
			if(i==255&&j==255&&k==255) {
				return WHITE;
			}
			if(i==0&&j==255&&k==0) {
				return GREEN;
			}
			if(i==0&&j==0&&k==255) {
				return BLUE;
			}
			if(i==255&&j==0&&k==0) {
				return RED;
			}
			return BLACK;
		}
		public boolean isEqual(RubiksCubeColor color) {
			if(this.ordinal()==color.ordinal()) {
				return true;
			}
			return false;
		}
		
		/*public boolean isValid(Color color) {
			if(this.equals(BLUE)) {
				if(color==Color.GREEN) {
					return false;
				}
			}
			if(this.equals(GREEN)) {
				if(color==Color.BLUE) {
					return false;
				}
			}
			if(this.equals(RED)) {
				if(color==Color.ORANGE) {
					return false;
				}
			}
			if(this.equals(ORANGE)) {
				if(color==Color.RED) {
					return false;
				}
			}
			if(this.equals(WHITE)) {
				if(color==Color.YELLOW) {
					return false;
				}
			}
			if(this.equals(YELLOW)) {
				if(color==Color.WHITE) {
					return false;
				}
			}
			return true;
		}*/

}
