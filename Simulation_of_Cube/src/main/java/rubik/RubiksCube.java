package rubik;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RubiksCube {
	public int  dimension=3;
	public Cube[][][] cubes= new Cube[dimension][dimension][dimension];
	public boolean [][][]validate_Orientation;//=new boolean[dimension][dimension][dimension];
	public boolean [][][]validate_Position;//=new boolean[dimension][dimension][dimension];
	//public String RubiksCubeMove="";
	public RubiksCube(int Dimension) {
		validate_Orientation=new boolean[dimension][dimension][dimension];
		validate_Position=new boolean[dimension][dimension][dimension];
		//this.dimension=Dimension;
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				for (int k = 0; k < dimension; k++) {
					cubes[i][j][k] = new Cube();
					if (i == 0) {
						cubes[i][j][k].setMap(Side.LEFT, RubiksCubeColor.GREEN);
					}
					if (i == dimension-1) {
						cubes[i][j][k].setMap(Side.RIGHT, RubiksCubeColor.BLUE);
					}
					if (j == 0) {
						cubes[i][j][k].setMap(Side.DOWN, RubiksCubeColor.YELLOW);
					}
					if (j == dimension-1) {
						cubes[i][j][k].setMap(Side.UP, RubiksCubeColor.WHITE);
					}
					if (k == 0) {
						cubes[i][j][k].setMap(Side.FRONT, RubiksCubeColor.RED);
					}
					if (k == dimension-1) {
						cubes[i][j][k].setMap(Side.BACK, RubiksCubeColor.ORANGE);
					}

					// new constraint added for validation
					if(isEdgeCornerCenter(i, j, k)==1||isEdgeCornerCenter(i, j, k)==6) {
						//System.out.println("set -"+i+""+j+""+k);
						validate_Orientation[i][j][k]=true;
						validate_Position[i][j][k]=true;
					}
					//updatePositionAndOrientation();
				}
			}
		}
	}
	public int isEdgeCornerCenter(int i,int j,int k) {
		Cube c=cubes[i][j][k];
		if(c.blackEdge()==3) {
			return 3;
		}
		if(c.blackEdge()==4) {
			return 2;
		}
		if(c.blackEdge()==5) {
			return 1;
		}
		if(c.blackEdge()==6) {
			return 6;
		}
		return 0;
	}
	public void updatePositionAndOrientation() {
		//System.out.println("Inside Update");
		for(int i=0;i<dimension;i++) {
			for(int j=0;j<dimension;j++) {
				for(int k=0;k<dimension;k++) {
					setPositionAndOreintation(i,j,k);
					/*
					Side side1=this.left_Or_right(i);
					Side side2=this.up_Or_down(j);
					Side side3=this.front_Or_Back(k);
					if(this.isEdgeCornerCenter(i, j, k)==2){
						RubiksCubeColor color1;
						RubiksCubeColor color2;
						RubiksCubeColor centerColor1;
						RubiksCubeColor centerColor2;
						if(side1!=null) {
							color1=cubes[i][j][k].getColor(side1);
							if(side2!=null) {
								color2=cubes[i][j][k].getColor(side2);
								centerColor1=cubes[i][j][k].getCenterColor(side1);
								centerColor2=cubes[i][j][k].getCenterColor(side2);
								if(color1.isEqual(cubes[i][j][k].getCenterColor(side1))&&color2.isEqual(cubes[i][j][k].getCenterColor(side2))){
									validate_Position[i][j][k]=true;
									validate_Orientation[i][j][k]=true;
								}else {
									Coordinate[] coordinate=search("Edge",centerColor1.name(),centerColor2.name());
									if(coordinate[0].getX()==i&&coordinate[0].getY()==j&&coordinate[0].getZ()==k) {
										//System.out.println("if orientation is false"+i+" "+j+" "+k);
										validate_Position[i][j][k]=true;
										validate_Orientation[i][j][k]=false;
									}
									else {
										validate_Position[i][j][k]=false;
										validate_Orientation[i][j][k]=false;
									}

								}
							}
							else {
								color2=cubes[i][j][k].getColor(side3);
								centerColor1=cubes[i][j][k].getCenterColor(side1);
								centerColor2=cubes[i][j][k].getCenterColor(side3);
								//System.out.println("i="+i+"j="+j+"k="+k);
									//System.out.println("color1"+color1+"color2"+color2);
									//System.out.println(cubes[i][j][k].getCenterColor(side1)+" "+cubes[i][j][k].getCenterColor(side3));

								if(color1.isEqual(cubes[i][j][k].getCenterColor(side1))&&color2.isEqual(cubes[i][j][k].getCenterColor(side3))){
									//System.out.println("I m not entering this");
									validate_Position[i][j][k]=true;
									validate_Orientation[i][j][k]=true;
									}
								else {
									Coordinate[] coordinate=search("Edge",centerColor1.name(),centerColor2.name());
									if(coordinate[0].getX()==i&&coordinate[0].getY()==j&&coordinate[0].getZ()==k) {
										//System.out.println("if orientation is false"+i+" "+j+" "+k);
										validate_Position[i][j][k]=true;
										validate_Orientation[i][j][k]=false;
									}
									else {
										validate_Position[i][j][k]=false;
										validate_Orientation[i][j][k]=false;
									}
								}
							}
						}
						else {
							color1=cubes[i][j][k].getColor(side2);
							color2=cubes[i][j][k].getColor(side3);
							centerColor1=cubes[i][j][k].getCenterColor(side2);
							centerColor2=cubes[i][j][k].getCenterColor(side3);
							if(color1.isEqual(cubes[i][j][k].getCenterColor(side2))&&color2.isEqual(cubes[i][j][k].getCenterColor(side3))){
								validate_Position[i][j][k]=true;
								validate_Orientation[i][j][k]=true;
							}else {
								Coordinate[] coordinate=search("Edge",centerColor1.name(),centerColor2.name());
								if(coordinate[0].getX()==i&&coordinate[0].getY()==j&&coordinate[0].getZ()==k) {
									//System.out.println("if orientation is false"+i+" "+j+" "+k);
									validate_Position[i][j][k]=true;
									validate_Orientation[i][j][k]=false;
								}
								else {
									validate_Position[i][j][k]=false;
									validate_Orientation[i][j][k]=false;
								}
							}

						}
					}
					else if(this.isEdgeCornerCenter(i, j, k)==3) {
						//System.out.println("i="+i+"j="+j+"k="+k);
						RubiksCubeColor cornerColor1=cubes[i][j][k].getColor(side1);
						RubiksCubeColor cornerColor2=cubes[i][j][k].getColor(side2);
						RubiksCubeColor cornerColor3=cubes[i][j][k].getColor(side3);
						RubiksCubeColor centerColor1=cubes[i][j][k].getCenterColor(side1);
						RubiksCubeColor centerColor2=cubes[i][j][k].getCenterColor(side2);
						RubiksCubeColor centerColor3=cubes[i][j][k].getCenterColor(side3);
			//			System.out.println("i="+i+"j="+j+"k="+k);
				//		System.out.println(cornerColor1+" "+cornerColor2+" "+cornerColor3+" "+centerColor1+"" +centerColor2+" "+centerColor3);
						if(cornerColor1.isEqual(centerColor1)&&cornerColor2==centerColor2&&cornerColor3==centerColor3) {
						//	System.out.println("if both are true"+"i="+i+"j="+j+"k="+k);
								validate_Position[i][j][k]=true;
								validate_Orientation[i][j][k]=true;
						}else {
							Coordinate[] coordinate=search("Corner",centerColor1.name(),centerColor2.name(),centerColor3.name());
							if(coordinate[0].getX()==i&&coordinate[0].getY()==j&&coordinate[0].getZ()==k) {
								validate_Position[i][j][k]=true;
								validate_Orientation[i][j][k]=false;
							}
							else {
								validate_Position[i][j][k]=false;
								validate_Orientation[i][j][k]=false;
							}
						}

					}*/
				}
			}
		}
		//System.out.println("Inside the update function");
		//displayOrientationandPlace();
	}
	public void setPositionAndOreintation(int i,int j,int k){
		Side side1=this.left_Or_right(i);
		Side side2=this.up_Or_down(j);
		Side side3=this.front_Or_Back(k);
		if(this.isEdgeCornerCenter(i, j, k)==2){
			RubiksCubeColor color1;
			RubiksCubeColor color2;
			RubiksCubeColor centerColor1;
			RubiksCubeColor centerColor2;
			if(side1!=null) {
				color1=cubes[i][j][k].getColor(side1);
				if(side2!=null) {
					color2=cubes[i][j][k].getColor(side2);
					centerColor1=cubes[i][j][k].getCenterColor(side1);
					centerColor2=cubes[i][j][k].getCenterColor(side2);
					if(color1.isEqual(cubes[i][j][k].getCenterColor(side1))&&color2.isEqual(cubes[i][j][k].getCenterColor(side2))){
						validate_Position[i][j][k]=true;
						validate_Orientation[i][j][k]=true;
					}else {
						Coordinate[] coordinate=search("Edge",centerColor1.name(),centerColor2.name());
						if(coordinate[0].getX()==i&&coordinate[0].getY()==j&&coordinate[0].getZ()==k) {
							//System.out.println("if orientation is false"+i+" "+j+" "+k);
							validate_Position[i][j][k]=true;
							validate_Orientation[i][j][k]=false;
						}
						else {
							validate_Position[i][j][k]=false;
							validate_Orientation[i][j][k]=false;
						}

					}
				}
				else {
					color2=cubes[i][j][k].getColor(side3);
					centerColor1=cubes[i][j][k].getCenterColor(side1);
					centerColor2=cubes[i][j][k].getCenterColor(side3);
					//System.out.println("i="+i+"j="+j+"k="+k);
					//System.out.println("color1"+color1+"color2"+color2);
					//System.out.println(cubes[i][j][k].getCenterColor(side1)+" "+cubes[i][j][k].getCenterColor(side3));

					if(color1.isEqual(cubes[i][j][k].getCenterColor(side1))&&color2.isEqual(cubes[i][j][k].getCenterColor(side3))){
						//System.out.println("I m not entering this");
						validate_Position[i][j][k]=true;
						validate_Orientation[i][j][k]=true;
					}
					else {
						Coordinate[] coordinate=search("Edge",centerColor1.name(),centerColor2.name());
						if(coordinate[0].getX()==i&&coordinate[0].getY()==j&&coordinate[0].getZ()==k) {
							//System.out.println("if orientation is false"+i+" "+j+" "+k);
							validate_Position[i][j][k]=true;
							validate_Orientation[i][j][k]=false;
						}
						else {
							validate_Position[i][j][k]=false;
							validate_Orientation[i][j][k]=false;
						}
					}
				}
			}
			else {
				color1=cubes[i][j][k].getColor(side2);
				color2=cubes[i][j][k].getColor(side3);
				centerColor1=cubes[i][j][k].getCenterColor(side2);
				centerColor2=cubes[i][j][k].getCenterColor(side3);
				if(color1.isEqual(cubes[i][j][k].getCenterColor(side2))&&color2.isEqual(cubes[i][j][k].getCenterColor(side3))){
					validate_Position[i][j][k]=true;
					validate_Orientation[i][j][k]=true;
				}else {
					Coordinate[] coordinate=search("Edge",centerColor1.name(),centerColor2.name());
					if(coordinate[0].getX()==i&&coordinate[0].getY()==j&&coordinate[0].getZ()==k) {
						//System.out.println("if orientation is false"+i+" "+j+" "+k);
						validate_Position[i][j][k]=true;
						validate_Orientation[i][j][k]=false;
					}
					else {
						validate_Position[i][j][k]=false;
						validate_Orientation[i][j][k]=false;
					}
				}

			}
		}
		else if(this.isEdgeCornerCenter(i, j, k)==3) {
			//System.out.println("i="+i+"j="+j+"k="+k);
			RubiksCubeColor cornerColor1=cubes[i][j][k].getColor(side1);
			RubiksCubeColor cornerColor2=cubes[i][j][k].getColor(side2);
			RubiksCubeColor cornerColor3=cubes[i][j][k].getColor(side3);
			RubiksCubeColor centerColor1=cubes[i][j][k].getCenterColor(side1);
			RubiksCubeColor centerColor2=cubes[i][j][k].getCenterColor(side2);
			RubiksCubeColor centerColor3=cubes[i][j][k].getCenterColor(side3);
			//			System.out.println("i="+i+"j="+j+"k="+k);
			//		System.out.println(cornerColor1+" "+cornerColor2+" "+cornerColor3+" "+centerColor1+"" +centerColor2+" "+centerColor3);
			if(cornerColor1.isEqual(centerColor1)&&cornerColor2==centerColor2&&cornerColor3==centerColor3) {
				//	System.out.println("if both are true"+"i="+i+"j="+j+"k="+k);
				validate_Position[i][j][k]=true;
				validate_Orientation[i][j][k]=true;
			}else {
				Coordinate[] coordinate=search("Corner",centerColor1.name(),centerColor2.name(),centerColor3.name());
				if(coordinate[0].getX()==i&&coordinate[0].getY()==j&&coordinate[0].getZ()==k) {
					validate_Position[i][j][k]=true;
					validate_Orientation[i][j][k]=false;
				}
				else {
					validate_Position[i][j][k]=false;
					validate_Orientation[i][j][k]=false;
				}
			}

		}
	}

/*	public boolean isSolved() {
		Color colorf = cubes[0][0][0].getColor(Sides.FRONT);
		// System.out.println("front:"+colorf);
		Color colorl = cubes[0][0][0].getColor(Sides.LEFT);
		// System.out.println("left:"+colorl);
		Color colord = cubes[0][0][0].getColor(Sides.DOWN);
		// System.out.println("down:"+colord);
		Color colorb = cubes[2][2][2].getColor(Sides.BACK);
		// System.out.println("back:"+colorb);
		Color colorr = cubes[2][2][2].getColor(Sides.RIGHT);
		// System.out.println("right:"+colorr);
		Color coloru = cubes[2][2][2].getColor(Sides.UP);
		// System.out.println("up:"+coloru);
		for (int i = 0; i < cubes.length; i++) {
			for (int j = 0; j < cubes[i].length; j++) {
				if (cubes[i][j][0].getColor(Sides.FRONT) != colorf) {
					return false;
				}
			}
		}
		for (int i = 0; i < cubes[0].length; i++) {
			for (int j = 0; j < cubes[0][i].length; j++) {
				if (cubes[0][i][j].getColor(Sides.LEFT) != colorl) {
					return false;
				}
			}
		}
		for (int i = 0; i < cubes.length; i++) {
			for (int j = 0; j < cubes[0][i].length; j++) {
				if (cubes[i][0][j].getColor(Sides.DOWN) != colord) {
					return false;
				}
			}
		}
		for (int i = 0; i < cubes.length; i++) {
			for (int j = 0; j < cubes[i].length; j++) {
				if (cubes[i][j][2].getColor(Sides.BACK) != colorb) {
					return false;
				}
			}
		}
		for (int i = 0; i < cubes[2].length; i++) {
			for (int j = 0; j < cubes[2][i].length; j++) {

				if (cubes[2][i][j].getColor(Sides.RIGHT) != colorr) {
					return false;
				}
			}
		}
		for (int i = 0; i < cubes.length; i++) {
			for (int j = 0; j < cubes[2][i].length; j++) {
				if (cubes[i][2][j].getColor(Sides.UP) != coloru) {
					return false;
				}
			}
		}
		return true;
	}
*/
	public boolean isSolved() {
		for(int i=0;i<dimension;i++) {
			for(int j=0;j<dimension;j++) {
				for(int k=0;k<dimension;k++) {
					if(validate_Position[i][j][k]==false||validate_Orientation[i][j][k]==false) {
						return false;
					}
				}
			}
		}
		return true;
	}
	public void setRubiksCube() throws Exception {
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j <dimension; j++) {
				for (int k = 0; k < dimension; k++) {
					
					Cube temp = setValuesCubic(i, j, k);
					cubes[i][j][k] = temp;
					
					//cubes[i][j][k] = temp;

				}
			}
		}
		// cube[i][j][k]= know(i,j,k);

	}
	public String SolveRubiksCube() {
		String move="";
		move=setPlus()+setCorner()+setMiddleLayer()+setLastLayerPlus()+setLastLayerEdge()+setLastLayerCorner()+setLasteLayerCornerOrientation();
		/*this.setCorner();
		this.setMiddleLayer();
		this.setLastLayerPlus();
		this.setLastLayerEdge();
		this.setLastLayerCorner();*/
		return move;
		
	}
	public void setRubiksCubeGui() throws Exception{
		int i=0;
		int j=0;
		int k=0;
		Cube temp = this.setValueCubicGui(i, j, k, Side.FRONT, RubiksCubeColor.GREEN);
		cubes[i][j][k] = temp;
	}
	public String setPlus() {
		updatePositionAndOrientation();
		Char_Permutation p= new Char_Permutation();
		if(isSetPlus()) {return "no move required";}
		p.input="UuFfBbDdLlRr";
		for(int j=1;j<=8;j++)
		{
			p.move_length=j;
		//System.out.println("j="+j);
		int k=Char_Permutation.power(12,j);
		for(int i=0;i<k;i++) { //35831808
			String s=p.permutation(i);
			//System.out.println("s="+s);
			performMove(s);
			if(isSetPlus()) {
				//System.out.println("valid inside set plus");
				return s;
			}
		 p.move_length=j;
		 p.move="";
		 //System.out.println("rev:"+Change_and_Rev(s));
		 performMove(Change_and_Rev(s));
		 }
		}
		return "not found";
	}
	public String setCorner() {
		//i=2;j=2;k=0;
		 String RubiksCubeMove="";
		updatePositionAndOrientation();
		int i,k;
		int j=2;
		for ( i = 0; i< dimension; i=i+(dimension-1)) {
			for ( k = 0; k <dimension; k=k+(dimension-1)) {
				if(isEdgeCornerCenter(i, j, k)==3) {
			//		System.out.println("in for loop");
		Side side1=this.left_Or_right(i);
		Side side2=this.up_Or_down(j);
		Side side3=this.front_Or_Back(k);
		RubiksCubeColor centerColor1=cubes[i][j][k].getCenterColor(side1);
		RubiksCubeColor centerColor2=cubes[i][j][k].getCenterColor(side2);
		RubiksCubeColor centerColor3=cubes[i][j][k].getCenterColor(side3);
		Coordinate[] coordinate =search("Corner",centerColor1.name(),centerColor2.name(),centerColor3.name());
		//coordinate[0].Display();
		if(validate_Position[i][j][k]!=true) {
			if(this.up_Or_down(coordinate[0].getY())==Side.UP) {
			if(coordinate[0].getX()==0&&coordinate[0].getY()==(dimension-1)&&coordinate[0].getZ()==0) {
				RubiksCubeMove=RubiksCubeMove+"LDL";
				performMove("LDl");	
			}
			if(coordinate[0].getX()==0&&coordinate[0].getY()==(dimension-1)&&coordinate[0].getZ()==(dimension-1)) {
				RubiksCubeMove=RubiksCubeMove+translation("LDl", 'U');
				performMove(translation("LDl", 'U'));
			}
			if(coordinate[0].getX()==2&&coordinate[0].getY()==(dimension-1)&&coordinate[0].getZ()==0) {
				performMove(translation("LDl",'D'));
				RubiksCubeMove=RubiksCubeMove+translation("LDl", 'D');
			}
			if(coordinate[0].getX()==(dimension-1)&&coordinate[0].getY()==(dimension-1)&&coordinate[0].getZ()==(dimension-1)) {
				performMove(translation(translation("LDl", 'U'),'U'));
				RubiksCubeMove=RubiksCubeMove+translation(translation("LDl", 'U'),'U');
				}
			}

			Coordinate coordinate1=new Coordinate(i,0,k);
			while(this.search("Corner",centerColor1.name(),centerColor2.name(),centerColor3.name())[0].isEqual(coordinate1)==false) {
				//System.out.println("D performed in while");
				performMove("D");
				RubiksCubeMove=RubiksCubeMove+"D";
			}
		}
			if(i==(dimension-1)&&j==(dimension-1)&&k==0) {
				updatePositionAndOrientation();
				while(validate_Orientation[i][j][k]!=true) {
					//System.out.println("Infinte 1");
					performMove("rdRD");
					RubiksCubeMove=RubiksCubeMove+"rdRD";
				//updatePositionAndOrientation();
				}
			}
			else if(i==0&&j==(dimension-1)&&k==0) {
				updatePositionAndOrientation();
				while(validate_Orientation[i][j][k]!=true) {
					//System.out.println("Infinte 2");
					//performMove("rdRD");
					performMove(translation("rdRD",'U'));
					RubiksCubeMove=RubiksCubeMove+translation("rdRD",'U');
					//updatePositionAndOrientation();
					}

			}
			else if(i==0&&j==(dimension-1)&&k==(dimension-1)) {
				updatePositionAndOrientation();
				while(validate_Orientation[i][j][k]!=true) {
					//System.out.println("Infinte 3");
					//performMove("rdRD");
					performMove(translation(translation("rdRD", 'U'),'U'));
					RubiksCubeMove=RubiksCubeMove+translation(translation("rdRD", 'U'),'U');
					//updatePositionAndOrientation();
					}
			}
			else if(i==(dimension-1)&&j==(dimension-1)&&k==(dimension-1)) {
				updatePositionAndOrientation();
				while(validate_Orientation[i][j][k]!=true) {
					//System.out.println("Infinte 4");
					//performMove("rdRD");
					performMove(translation("rdRD",'D'));
					RubiksCubeMove=RubiksCubeMove+translation("rdRD",'D');

					//updatePositionAndOrientation();
					}

			}
			}
		}
		}
		return RubiksCubeMove;
		}
	public void displayOrientationandPlace() {
		//System.out.println("Inside the Rubikscube project");
		for(int x = 0;x<3;x++) {
			for(int y = 0;y<3;y++) {

				for(int z = 0;z<3;z++) {
					//System.out.println("Inside the Rubikscube project");
					System.out.println(x+" "+y+" "+z+" ");
					System.out.println(validate_Position[x][y][z]+" "+validate_Orientation[x][y][z]);

					//System.out.println(validate_Orientation[x][y][z]);
				}
			}
		}

	}
		//return "";
	public String setMiddleLayer() {
		//System.out.println("At starting");
		//System.out.println(cubes[2][1][0].getColor(Side.FRONT));
		//System.out.println(cubes[2][1][0].getColor(Side.RIGHT));
		String middleLayerMove="";
		int j=1;
		if(!isSecondLayerSolved()) {
		for(int i=0;i<(dimension);i++) {
			for(int k=0;k<(dimension);k++) {
				if(isEdgeCornerCenter(i, j, k)==2) {
//					System.out.println("i="+i+"j="+j+"k="+k);
					Side side1=left_Or_right(i);
					//Side side2=up_Or_down(j);
					Side side3=front_Or_Back(k);
					RubiksCubeColor centerColor1,centerColor2;
					centerColor1=cubes[i][j][k].getCenterColor(side1);
					centerColor2=cubes[i][j][k].getCenterColor(side3);
	//	System.out.println(cubes[2][1][0].getColor(Side.FRONT));
		//System.out.println(cubes[2][1][0].getColor(Side.RIGHT));
		//updatePositionAndOrientation();
				if(validate_Orientation[i][j][k]==false) {
					Coordinate[] coordinate=search("Edge",centerColor1.name(),centerColor2.name());
					//System.out.println("First Search"+coordinate[0].getX()+" "+coordinate[0].getY()+" "+coordinate[0].getZ());
					if(coordinate[0].getY()==1 ) {
					//	System.out.println("Ahiya nathi aavvanu");
						if(coordinate[0].getX()==(dimension-1)&&coordinate[0].getZ()==0) {
							String move="DFdfRfrF";
							performMove(move);
							middleLayerMove=middleLayerMove+move;
						}
						else if(coordinate[0].getX()==0&&coordinate[0].getZ()==0){
							//System.out.println("In 0 0 ");
							String move=translation("DFdfRfrF",'U');
							performMove(move);
							middleLayerMove=middleLayerMove+move;
						}
						else if(coordinate[0].getX()==0&&coordinate[0].getZ()==(dimension-1)) {
							String move=translation(translation("DFdfRfrF",'U'),'U');
							performMove(move);
							middleLayerMove=middleLayerMove+move;
						}
						else if(coordinate[0].getX()==(dimension-1)&&coordinate[0].getZ()==(dimension-1)) {
							String move=translation("DFdfRfrF",'D');
							performMove(move);
							middleLayerMove=middleLayerMove+move;
						}
					}

			//Coordinate[] coordinate8=search("Edge",centerColor1.name(),centerColor2.name());
			//System.out.println("After performing move and edge is in down"+coordinate8[0].getX()+" "+coordinate8[0].getY()+" "+coordinate8[0].getZ());
				Coordinate[] cubeCoordinate=adjacentCorrdinate(new Coordinate(i,j,k));
//			System.out.println("First Search"+cubeCoordinate[0].getX()+" "+cubeCoordinate[0].getY()+" "+cubeCoordinate[0].getZ());

		//	Color cubeFirstEdgeColor1=cubes[cubeCoordinate[0].getX()][cubeCoordinate[0].getY()][cubeCoordinate[0].getZ()].getColor(left_Or_right(i));
		//	Color cubeFirstEdgeColor2=cubes[cubeCoordinate[0].getX()][cubeCoordinate[0].getY()][cubeCoordinate[0].getZ()].getColor(Side.DOWN);
			//Color cubeSecondEdgeColor1=cubes[cubeCoordinate[1].getX()][cubeCoordinate[1].getY()][cubeCoordinate[1].getZ()].getColor(Side.DOWN);
			//Color cubeSecondEdgeColor2=cubes[cubeCoordinate[1].getX()][cubeCoordinate[1].getY()][cubeCoordinate[1].getZ()].getColor(front_Or_Back(k));
		//	System.out.println(cubeFirstEdgeColor1+" "+cubeFirstEdgeColor2+" "+cubeSecondEdgeColor1+" "+cubeSecondEdgeColor2);
			//System.out.println(left_Or_right(i)+" "+front_Or_Back(k)+" "+left_Or_right(i)+" "+front_Or_Back(k));

				while(!((cubes[cubeCoordinate[0].getX()][cubeCoordinate[0].getY()][cubeCoordinate[0].getZ()].getColor(left_Or_right(i))==centerColor1&&cubes[cubeCoordinate[0].getX()][cubeCoordinate[0].getY()][cubeCoordinate[0].getZ()].getColor(Side.DOWN)==centerColor2) ||
						(cubes[cubeCoordinate[1].getX()][cubeCoordinate[1].getY()][cubeCoordinate[1].getZ()].getColor(Side.DOWN)==centerColor1&&cubes[cubeCoordinate[1].getX()][cubeCoordinate[1].getY()][cubeCoordinate[1].getZ()].getColor(front_Or_Back(k))==centerColor2))) {
					performMove("D");
					middleLayerMove=middleLayerMove+"D";
	//				System.out.println("D perform");
				}

			//System.out.println("Right="+cubes[2][0][1].getColor(Side.RIGHT)+"Down"+cubes[2][0][1].getColor(Side.DOWN));
			//System.out.println("Back"+cubes[1][0][2].getColor(Side.BACK)+"Down"+cubes[1][0][2].getColor(Side.DOWN));
				RubiksCubeColor cubeFirstEdgeColor1=cubes[cubeCoordinate[0].getX()][cubeCoordinate[0].getY()][cubeCoordinate[0].getZ()].getColor(left_Or_right(i));
					RubiksCubeColor cubeFirstEdgeColor2=cubes[cubeCoordinate[0].getX()][cubeCoordinate[0].getY()][cubeCoordinate[0].getZ()].getColor(Side.DOWN);
					RubiksCubeColor cubeSecondEdgeColor1=cubes[cubeCoordinate[1].getX()][cubeCoordinate[1].getY()][cubeCoordinate[1].getZ()].getColor(Side.DOWN);
					RubiksCubeColor cubeSecondEdgeColor2=cubes[cubeCoordinate[1].getX()][cubeCoordinate[1].getY()][cubeCoordinate[1].getZ()].getColor(front_Or_Back(k));
					if(i==(dimension-1)&&k==0) {
						if(cubeFirstEdgeColor1==centerColor1&&cubeFirstEdgeColor2==centerColor2){
							String move="DFdfRfrF";
							performMove(move);
							middleLayerMove=middleLayerMove+move;
							//performMove("drDRfRFr");
						}
						else if(cubeSecondEdgeColor1==centerColor1&&cubeSecondEdgeColor2==centerColor2){
							String move="drDRfRFr";
							performMove(move);
							middleLayerMove=middleLayerMove+move;
							//performMove("DFdfRfrF");
						}
					}
					if(i==0&&k==0) {
						if(cubeFirstEdgeColor1==centerColor1&&cubeFirstEdgeColor2==centerColor2) {
						//	System.out.println("I m first edge");
							String move=translation("drDRfRFr",'U');
							performMove(move);
							middleLayerMove=middleLayerMove+move;
						}
						else if(cubeSecondEdgeColor1==centerColor1&&cubeSecondEdgeColor2==centerColor2) {
							//System.out.println("I m first edge else");
							String move=translation("DFdfRfrF",'U');
							performMove(move);
							middleLayerMove=middleLayerMove+move;
						}
					}
					if(i==0&&k==(dimension-1)) {
						if(cubeFirstEdgeColor1==centerColor1&&cubeFirstEdgeColor2==centerColor2) {
							String move=translation(translation("DFdfRfrF",'U'),'U');
							performMove(move);
							middleLayerMove=middleLayerMove+move;
						}else if(cubeSecondEdgeColor1==centerColor1&&cubeSecondEdgeColor2==centerColor2) {
							String move=translation(translation("drDRfRFr",'U'),'U');
							performMove(move);
							middleLayerMove=middleLayerMove+move;
						}

					}
					if(i==(dimension-1)&&k==(dimension-1)){
						if(cubeFirstEdgeColor1.isEqual(centerColor1)&&cubeFirstEdgeColor2.isEqual(centerColor2)) {
							String move=translation("drDRfRFr",'D');
							performMove(move);
							middleLayerMove=middleLayerMove+move;
						}
						else if(cubeSecondEdgeColor1==centerColor1&&cubeSecondEdgeColor2==centerColor2) {
							String move=translation("DFdfRfrF",'D');
							performMove(move);
							middleLayerMove=middleLayerMove+move;
						}
					}
		//			Coordinate[] coordinate9=search("Edge",centerColor1.name(),centerColor2.name());
		//			System.out.println("final"+coordinate9[0].getX()+" "+coordinate9[0].getY()+" "+coordinate9[0].getZ());
					}
					}
				}
			}
		}
		return middleLayerMove;
		}

	public Coordinate[] adjacentCorrdinate(Coordinate coordinate) {
			Coordinate[] coordinates=new Coordinate[2];
			coordinates[0]=new Coordinate(coordinate.getX(),0,coordinate.getY());
			coordinates[1]=new Coordinate(coordinate.getY(),0,coordinate.getZ());
			//System.out.println("Inside Function"+coordinates[0]);
			/*coordinates[0].setY(0);
			coordinates[1].setY(0);
			coordinates[0].setX(coordinate.getX());
			coordinates[1].setX(coordinate.getY());
			coordinates[0].setZ(coordinate.getY());
			coordinates[1].setZ(coordinate.getZ());*/
			return coordinates;

	}
	public String setLastLayerEdge() {
		String lastLayerEdgeMove="";
//		 Color color1;
		System.out.println("inside set last layer");
		boolean []temp=new boolean[4];
		int k =0;
		for(int i=0;i<dimension;i++) {
			for(int j=0;j<dimension;j++) {
				if(isEdgeCornerCenter(i, 0, j)==2) {
//					System.out.println(i+" 0 "+j);
					if(!validate_Position[i][0][j]) {
						temp[k]=false;
					}
					else
					{
						temp[k]=true;
					}
					k++;
				}

			}
		}
//		System.out.println(" k1="+k);
		for(int i = 0;i<4;i++) {
			if(temp[i]==false) {
				k--;
			}
		}
//		System.out.println("k2="+k);

		while(k==0) {
			performMove("D");
			for(int i=0;i<dimension;i++) {
				for(int j=0;j<dimension;j++) {
					if(isEdgeCornerCenter(i, 0, j)==2) {
//						System.out.println(i+" 0 "+j);
						if(!validate_Position[i][0][j]) {
							temp[k]=false;
						}
						else
						{
							temp[k]=true;
						}
						k++;
					}

				}
			}
		for(int i = 0;i<4;i++) {
			if(temp[i]==false) {
				k--;
			}
		}
		}
//				Color color1=cubes[1][0][0].getColor(front_Or_Back(0));
//				Color color2=cubes[2][0][1].getColor(left_Or_right(2));
//				Color color3=cubes[0][0][1].getColor(left_Or_right(0));
//				Color color4=cubes[1][0][2].getColor(front_Or_Back(2));
//
//
//		System.out.println("k3="+k+color1.name() + color2.name() +color3.name()+color4.name());
		if(k!=4) {
			if(k==1) {
				while(isLastLayerEdgeSet()!=true) {
				if(temp[0]==true) {
//					System.out.println("case a");
					String move=translation(translation("RRuFbrrBfurr", 'R'),'R');
					performMove(move);
					lastLayerEdgeMove=lastLayerEdgeMove+move;
				}
				if(temp[1]==true) {
//					System.out.println("case b");
					String move=translation(translation(translation("RRuFbrrBfurr", 'R'),'R'),'D');
					performMove(move);
					lastLayerEdgeMove=lastLayerEdgeMove+move;
				}
				if(temp[2]==true) {
//					System.out.println("case c");
					String move=translation(translation(translation("RRuFbrrBfurr", 'R'),'R'),'U');
					performMove(move);
					lastLayerEdgeMove=lastLayerEdgeMove+move;
				}
				if(temp[3]==true) {
//					System.out.println("case d");
					String move=translation(translation(translation(translation("RRuFbrrBfurr", 'R'),'R'),'U'),'U');
					performMove(move);
					lastLayerEdgeMove=lastLayerEdgeMove+move;
				}
			}
			}
			if(k==2) {
				if(temp[0]!=true&&temp[2]!=true) {
//					System.out.println("case 0");
						String move=translation(translation("RUrURUUrU", 'R'),'R');
						performMove(move);
						lastLayerEdgeMove=lastLayerEdgeMove+move;
				}
				if(temp[0]!=true&&temp[1]!=true) {
//					System.out.println("case 1");
					String move=translation(translation(translation("RUrURUUrU", 'R'),'R'),'D');
					performMove(move);
					lastLayerEdgeMove=lastLayerEdgeMove+move;
				}
				if(temp[2]!=true&&temp[3]!=true) {
//					System.out.println("case 2");
					String move=translation(translation(translation("RUrURUUrU", 'R'),'R'),'U');
					performMove(move);
					lastLayerEdgeMove=lastLayerEdgeMove+move;
				}
				if(temp[1]!=true&&temp[3]!=true) {
//					System.out.println("case 3");
					String move=translation(translation(translation(translation("RUrURUUrU", 'R'),'R'),'U'),'U');
					performMove(move);
					lastLayerEdgeMove=lastLayerEdgeMove+move;
				}
				if(temp[1]==true&&temp[2]==true) {
//					System.out.println("case 4");
					String move1=translation(translation("URUrURUUrU",'R'),'R');
					performMove(move1);
					String move2=translation(translation(translation(translation("RUrURUUrU", 'R'),'R'),'U'),'U');
					performMove(move2);
					lastLayerEdgeMove=lastLayerEdgeMove+move1+move2;
					//	performMove(translation(translation("RUrUrUUrU", 'U'),'U'));
				}
				if(temp[0]==true&&temp[3]==true) {
//					System.out.println("case 5");
					String move1=translation(translation(translation("URUrURUUrU",'R'),'R'),'U');
					performMove(move1);
					String move2=translation(translation(translation("RUrURUUrU", 'R'),'R'),'D');
					performMove(move2);
					lastLayerEdgeMove=lastLayerEdgeMove+move1+move2;
				}
			}
		}
		return lastLayerEdgeMove;
		/*if(validate_Position[0][0][1]==true&&validate_Position[1][0][0]) {

		}
		if(validate_Position[0][0][1]==true&&validate_Position[0][0][2]) {

		}*/

		/*if(front_Or_Back(j)!=null) {
			color1=cubes[i][0][j].getColor(front_Or_Back(j));
			if(color1==cubes[i][0][j].getCenterColor(front_Or_Back(j))) {

			}
		}
		if(left_Or_right(i)!=null) {
			color1=cubes[i][0][j].getColor(left_Or_right(i));
		}
		//Color color1=cubes[1][0][0].getColor(front_Or_Back(0));
		Color color2=cubes[2][0][1].getColor(left_Or_right(2));
		Color color3=cubes[0][0][1].getColor(left_Or_right(0));
		Color color4=cubes[1][0][2].getColor(front_Or_Back(2));*/
	}

	public boolean isLastLayerEdgeSet() {
		boolean []temp=new boolean[4];
		int k =0;
		for(int i=0;i<dimension;i++) {
			for(int j=0;j<dimension;j++) {
				if(isEdgeCornerCenter(i, 0, j)==2) {
					if(!validate_Position[i][0][j]) {
						temp[k]=false;
					}
					else
					{
						temp[k]=true;
					}
					k++;
				}

			}
		}
		for(int i = 0;i<4;i++) {
			if(temp[i]==false) {
				k--;
			}
		}
		if(k==4) {
			return true;
		}
		else {
			return false;
		}

	}
	public String setLastLayerPlus() {
		String lastLayerPlusMove="";
//		int j=0;
		//System.out.println("Andar to aavyu");
		RubiksCubeColor color1=cubes[1][0][0].getColor(Side.DOWN);
		RubiksCubeColor color2=cubes[2][0][1].getColor(Side.DOWN);
		RubiksCubeColor color3=cubes[0][0][1].getColor(Side.DOWN);
		RubiksCubeColor color4=cubes[1][0][2].getColor(Side.DOWN);
		if(color1!=RubiksCubeColor.YELLOW&&color2!=RubiksCubeColor.YELLOW&&color3!=RubiksCubeColor.YELLOW&&color4!=RubiksCubeColor.YELLOW) {
			String move=translation(translation("FRUrufUUFURurf", 'R'), 'R');
			performMove(move);
			lastLayerPlusMove=lastLayerPlusMove+move;
		}
		else if(color1==RubiksCubeColor.YELLOW&&color4==RubiksCubeColor.YELLOW&&color2!=RubiksCubeColor.YELLOW&&color3!=RubiksCubeColor.YELLOW) {
			String move="D"+translation(translation("FRUruf", 'R'), 'R');
			performMove(move);
			lastLayerPlusMove=lastLayerPlusMove+move;
		}
		else if(color2==RubiksCubeColor.YELLOW&&color3==RubiksCubeColor.YELLOW&&color1!=RubiksCubeColor.YELLOW&&color4!=RubiksCubeColor.YELLOW) {
			String move=translation(translation("FRUruf", 'R'), 'R');
			performMove(move);
			lastLayerPlusMove=lastLayerPlusMove+move;
		}
		else if(color1==RubiksCubeColor.YELLOW&&color2==RubiksCubeColor.YELLOW&&color3==RubiksCubeColor.YELLOW&&color4==RubiksCubeColor.YELLOW) {
			System.out.println("kai na karyu");
		}
		else {
			while((cubes[1][0][0].getColor(Side.DOWN)!=RubiksCubeColor.YELLOW||cubes[0][0][1].getColor(Side.DOWN)!=RubiksCubeColor.YELLOW)) {
				performMove("D");
				lastLayerPlusMove=lastLayerPlusMove+"D";
				//System.out.println("D perform");
			}
//			System.out.println(cubes[1][0][0].getColor(Side.DOWN)+" "+cubes[0][0][1].getColor(Side.DOWN));
//			System.out.println(cubes[2][0][1].getColor(Side.DOWN)+" "+cubes[1][0][2].getColor(Side.DOWN));
			String move=translation(translation("FURurf", 'R'), 'R');
			performMove(move);
			lastLayerPlusMove=lastLayerPlusMove+move;
		}
		return lastLayerPlusMove;

	}
	public boolean isAdjacentorOpposite(Coordinate coordinate1,Coordinate coordinate2) {
		if((coordinate1.getZ()+coordinate2.getZ())%2==0) {
			return true;
		}
		else {
			return false;
		}
	}
	public String Change_and_Rev(String s) {
		StringBuffer a = new StringBuffer(s);
		StringBuffer s1=a.reverse();
		//String s3=null;
		for (int i=0; i<s1.length(); i++)
	    {
			char c=s1.charAt(i);
	        //String s2=null;
			if (Character.isLowerCase(c))
	        {
	        	s1.replace(i,i+1,Character.toUpperCase(c)+"");
	        }

	        else if(Character.isUpperCase(c))
	             s1.replace(i,i+1,Character.toLowerCase(c)+"");
		}
		return s1.toString();
	    		 //a.reverse();
	}
	public boolean isSetPlus() {
		//updatePositionAndOrientation();
		if(cubes[0][2][1].getColor(Side.LEFT)==RubiksCubeColor.GREEN&&cubes[0][2][1].getColor(Side.UP)==RubiksCubeColor.WHITE) {
			//return false;

		if(cubes[1][2][0].getColor(Side.UP)==RubiksCubeColor.WHITE&&cubes[1][2][0].getColor(Side.FRONT)==RubiksCubeColor.RED) {
			//return false;

		if(cubes[2][2][1].getColor(Side.RIGHT)==RubiksCubeColor.BLUE&&cubes[2][2][1].getColor(Side.UP)==RubiksCubeColor.WHITE) {
			//return false;

		if(cubes[1][2][2].getColor(Side.UP)==RubiksCubeColor.WHITE&&cubes[1][2][2].getColor(Side.BACK)==RubiksCubeColor.ORANGE) {
			return true;
		}}}}
		 /*for(int i=0;i<3;i++) { for(int j=0;j<3;j++) { if((i+j)%2!=0) {
		 cube[i][j][1].getColor_center()==cube[i][j][0]. } } }*/

		return false;
	}
	public boolean isFirstLayerSolved(){
	//	updatePositionAndOrientation();
		for(int i=0;i<dimension;i++) {
			for(int k=0;k<dimension;k++) {
				if(validate_Orientation[i][2][k]==false) {
					return false;
				}
			}
		}
		return true;

	}
	/*public String rotation(Coordinate position1, Coordinate position2) {
		if (position1.getX() > position2.getX() && position1.getY() == position2.getY()
				&& position1.getZ() == position2.getZ()) {

		}
		if (position1.getX() < position2.getX() && position1.getY() == position2.getY()
				&& position1.getZ() == position2.getZ()) {

		}
		if (position1.getX() == position2.getX() && position1.getY() < position2.getY()
				&& position1.getZ() == position2.getZ()) {

		}
		if (position1.getX() == position2.getX() && position1.getY() > position2.getY()
				&& position1.getZ() == position2.getZ()) {

		}
		if (position1.getX() == position2.getX() && position1.getY() == position2.getY()
				&& position1.getZ() > position2.getZ()) {

		}
		if (position1.getX() == position2.getX() && position1.getY() == position2.getY()
				&& position1.getZ() < position2.getZ()) {

		}
		/*
		 * if(position1.getX()==position2.getX() &&
		 * position1.getY()==position2.getY()&&position1.getZ()==position2.getZ()) {
		 *
		 * } if(position1.getX()==position2.getX() &&
		 * position1.getY()==position2.getY()&&position1.getZ()==position2.getZ()) {
		 *
		 * }
		 return null;
	}*/

	public Coordinate[] search(String... args) {/*
												 * this method searches a cube according to colours and returns their
												 * coordinates
												 */
		Coordinate coordinate[] = new Coordinate[4];
		int z = 0;
		if (args[0] == "Corner" && args.length <= 4) {
			for (int i = 0; i < dimension; i = i + 2) {
				for (int j = 0; j < dimension; j = j + 2) {
					for (int k = 0; k < dimension; k = k + 2) {
						// System.out.print(i+""+j+""+k);
						if (args[1] != null) {
							RubiksCubeColor c;
							// System.out.print(i+""+j+""+k);
							c = RubiksCubeColor.valueOf(args[1]);
							if (cubes[i][j][k].Search(c)) {

								if (args.length > 2 && args[2] != null) {

									c = RubiksCubeColor.valueOf(args[2]);
									if (cubes[i][j][k].Search(c)) {
										// return new Coordinate(i,j,k);
										if (args.length > 3 && args[3] != null) {

											c = RubiksCubeColor.valueOf(args[3]);
											if (cubes[i][j][k].Search(c)) {

												//System.out.println("Found exact");
												// Coordinate c_array[] = new Coordinate[1];
												coordinate[0] = new Coordinate(i, j, k);
												return coordinate;
											}

										} else {
											// Coordinate c_array[] = new Coordinate[2];

											// System.out.println(i+" "+j+" "+k);
											coordinate[(i + j) / 2] = new Coordinate(i, j, k);
										} // return new Coordinate(i,j,k);
									}
								} else {
									coordinate[z] = new Coordinate(i, j, k);
									z++;
									// System.out.println(i+" "+j+" "+k);
								} // return new Coordinate(i,j,k);
							}
						}
						// System.out.println();
					}
				}
			}
		}
		if (args[0] == "Edge" && args.length <= 3) {
			for (int i = 0; i < dimension; i++) {
				for (int j = 0; j <dimension ; j++) {
					for (int k = 0; k < dimension; k++) {
						if ((i + j + k) % 2 != 0) {
							if (i != 1 || j != 1 || k != 1) {
								// System.out.println(i+""+j+""+k);
								if (args.length > 1 && args[1] != null) {
									RubiksCubeColor c;
									c = RubiksCubeColor.valueOf(args[1]);
									if (cubes[i][j][k].Search(c)) {
										if (args.length > 2 && args[2] != null) {
											c = RubiksCubeColor.valueOf(args[2]);
											if (cubes[i][j][k].Search(c)) {
												coordinate[0] = new Coordinate(i, j, k);
												return coordinate;
											}
										} else {
											coordinate[z] = new Coordinate(i, j, k);
											z++;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println("Just for fun ");
		return coordinate;
	}
/*	public void watch_set(char c, Sides side) {
		if (c == 'R' || c == 'r') {
			while (cubes[2][1][0].getColor(Sides.BACK) != Color.WHITE) {
				performMove("B");
			}
		}
		if (c == 'L' || c == 'l') {
			while (cubes[0][1][0].getColor(Sides.FRONT) != Color.WHITE) {
				performMove("F");
			}
		}
		if (c == 'U' || c == 'u') {
			while (cubes[1][2][0].getColor(Sides.FRONT) != Color.WHITE) {
				performMove("F");
			}
		}
		if (c == 'D' || c == 'd') {
			while (cubes[1][0][0].getColor(Sides.FRONT) != Color.WHITE) {
				performMove("F");
			}
		}
	}*/

	/*
	 * public void makingPlus() {
	 *
	 *
	 * if(cube[0][1][0].getColor(Sides.LEFT)==Color.WHITE) { watch_set('L');
	 * performMove("L"); watch_set('D'); performMove("D"); }
	 * if(cube[0][0][1].getColor(Sides.LEFT)==Color.WHITE) { watch_set('d');
	 * performMove("d"); } if(cube[0][1][2].getColor(Sides.LEFT)==Color.WHITE) {
	 * watch_set('L'); performMove("L"); watch_set('U'); performMove("U");
	 *
	 * } if(cube[0][2][1].getColor(Sides.LEFT)==Color.WHITE) {
	 *
	 * performMove("U"); } if(cube[2][1][0].getColor(Sides.RIGHT)==Color.WHITE) {
	 * watch_set('R'); performMove("R"); watch_set('u'); performMove("u"); }
	 * if(cube[2][0][1].getColor(Sides.RIGHT)==Color.WHITE) { performMove("D"); }
	 * if(cube[2][1][2].getColor(Sides.RIGHT)==Color.WHITE) { watch_set('R');
	 * performMove("R"); watch_set('D'); performMove("D"); }
	 * if(cube[2][2][1].getColor(Sides.RIGHT)==Color.WHITE) { performMove("u"); }
	 * if(cube[1][0][0].getColor(Sides.DOWN)==Color.WHITE) { watch_set('D');
	 * performMove("D"); watch_set('r'); performMove("r"); //performMove("Dr"); }
	 * if(cube[0][0][1].getColor(Sides.DOWN)==Color.WHITE) { performMove("L"); }
	 * if(cube[1][0][2].getColor(Sides.DOWN)==Color.WHITE) { watch_set('D');
	 * performMove("D"); watch_set('L'); performMove("L");
	 *
	 * //performMove("DL"); } if(cube[2][0][1].getColor(Sides.DOWN)==Color.WHITE) {
	 * performMove("r"); } if(cube[1][2][0].getColor(Sides.UP)==Color.WHITE) {
	 * watch_set('U'); performMove("U"); watch_set('l'); performMove("l");
	 *
	 * //performMove("Ul"); } if(cube[0][2][1].getColor(Sides.UP)==Color.WHITE) {
	 * performMove("l"); } if(cube[1][2][2].getColor(Sides.UP)==Color.WHITE) {
	 * watch_set('L'); performMove("L"); watch_set('U'); performMove("U");
	 *
	 * //performMove("UR"); } if(cube[2][2][1].getColor(Sides.UP)==Color.WHITE) {
	 * performMove("R"); } }
	 */
	public void revolveCubes(Cube cube, Cube cube1, Cube cube2, Cube cube3) {
		Cube tmp = cube;
		cube = cube3;
		cube3 = cube2;
		cube2 = cube1;
		cube1 = tmp;
	}
//	private boolean isOrienteLastCorner() {
//		int j=0;
//		for(int i=0;i<dimension;i++) {
//			for(int k=0;k<dimension;k++) {
//				if(this.isEdgeCornerCenter(i, j, k)==3) {
//					if(validate_Orientation[i][j][k]==false) {
//						return false;
//					}
//				}
//			}
//		}
//		return true;
//	}
	public String translation(String move, char rotate) {
		String string = move;
		char[] one = new char[move.length()];
		String s1 = "";
		// char [] two = new char[move.length()];
		//System.out.println("String before translation   " + string);
		switch (rotate) {
		case 'R':
			string = string.replace('F', 'U');
			string = string.replace('f', 'u');
			string = string.replace('D', 'F');
			string = string.replace('d', 'f');
			string = string.replace('B', 'D');
			string = string.replace('b', 'd');
			for (int i = 0; i < move.length(); i++) {
				one[i] = string.charAt(i);
			}
			for (int i = 0; i < move.length(); i++) {
				if (move.charAt(i) == 'U') {
					one[i] = 'B';
				}
				if (move.charAt(i) == 'u') {
					one[i] = 'b';
				}
			}
			for (int i = 0; i < move.length(); i++) {
				s1 = s1 + one[i];
			}
			break;
		case 'L':
			string = string.replace('F', 'D');
			string = string.replace('f', 'd');
			string = string.replace('U', 'F');
			string = string.replace('u', 'f');
			string = string.replace('B', 'U');
			string = string.replace('b', 'u');
			for (int i = 0; i < move.length(); i++) {
				one[i] = string.charAt(i);
			}
			for (int i = 0; i < move.length(); i++) {
				if (move.charAt(i) == 'D') {
					one[i] = 'B';
				}
				if (move.charAt(i) == 'd') {
					one[i] = 'b';
				}
			}
			for (int i = 0; i < move.length(); i++) {
				s1 = s1 + one[i];
			}
			break;
		case 'F':
			string = string.replace('R', 'D');
			string = string.replace('r', 'd');
			string = string.replace('U', 'R');
			string = string.replace('u', 'r');
			string = string.replace('L', 'U');
			string = string.replace('l', 'u');
			for (int i = 0; i < move.length(); i++) {
				one[i] = string.charAt(i);
			}
			for (int i = 0; i < move.length(); i++) {
				if (move.charAt(i) == 'D') {
					one[i] = 'L';
				}
				if (move.charAt(i) == 'd') {
					one[i] = 'l';
				}
			}
			for (int i = 0; i < move.length(); i++) {
				s1 = s1 + one[i];
			}
			break;
		case 'B':
			string = string.replace('L', 'D');
			string = string.replace('l', 'd');
			string = string.replace('U', 'L');
			string = string.replace('u', 'l');
			string = string.replace('R', 'U');
			string = string.replace('r', 'u');
			for (int i = 0; i < move.length(); i++) {
				one[i] = string.charAt(i);
			}
			for (int i = 0; i < move.length(); i++) {
				if (move.charAt(i) == 'D') {
					one[i] = 'R';
				}
				if (move.charAt(i) == 'd') {
					one[i] = 'r';
				}
			}
			for (int i = 0; i < move.length(); i++) {
				s1 = s1 + one[i];
			}
			break;
		case 'U':
			string = string.replace('F', 'L');
			string = string.replace('f', 'l');
			string = string.replace('R', 'F');
			string = string.replace('r', 'f');
			string = string.replace('B', 'R');
			string = string.replace('b', 'r');
			for (int i = 0; i < move.length(); i++) {
				one[i] = string.charAt(i);
			}
			for (int i = 0; i < move.length(); i++) {
				if (move.charAt(i) == 'L') {
					one[i] = 'B';
				}
				if (move.charAt(i) == 'l') {
					one[i] = 'b';
				}
			}
			for (int i = 0; i < move.length(); i++) {
				s1 = s1 + one[i];
			}
			break;
		case 'D':
			string = string.replace('F', 'R');
			string = string.replace('f', 'r');
			string = string.replace('L', 'F');
			string = string.replace('l', 'f');
			string = string.replace('B', 'L');
			string = string.replace('b', 'l');
			for (int i = 0; i < move.length(); i++) {
				one[i] = string.charAt(i);
			}
			for (int i = 0; i < move.length(); i++) {
				if (move.charAt(i) == 'R') {
					one[i] = 'B';
				}
				if (move.charAt(i) == 'r') {
					one[i] = 'b';
				}
			}
			for (int i = 0; i < move.length(); i++) {
				s1 = s1 + one[i];
			}
			break;
		default:
			System.out.println("Enter correct string");
			break;
		}
		//System.out.println("String after translation   " + s1);
		return s1;
	}

	/*
	 * public void rotateCube(String move) { for(int i=0;i<move.length();i++) {
	 *
	 * char temp=move.charAt(i); switch(temp) { case 'L': Left(); break; case 'R':
	 * Right(); break; case 'U': Up(); break; case 'D': Down(); break; case 'F':
	 * Front(); break; case 'B': Back(); break; default:
	 * System.out.println("Enter valid moves"); break; } } }
	 */public void performMove(String move) {
		// System.out.println("MOVE-"+move);
		for (int i = 0; i < move.length(); i++) {
			// char temp;
			char temp = move.charAt(i);
			switch (temp) {
			case 'L':
				leftRotation();
				break;
			case 'l':
				leftprimeRotation();
				break;
			case 'R':
				rightRotation();
				break;
			case 'r':
				rightprimeRotation();
				break;
			case 'U':
				upRotation();
				break;
			case 'u':
				upprimeRotation();
				break;
			case 'D':
				down_rotation();
				break;
			case 'd':
				downprimeRotation();
				break;
			case 'F':
				front_rotation();
				break;
			case 'f':
				frontprime_rotation();
				break;
			case 'B':
				back_rotation();
				break;
			case 'b':
				backprime_rotation();
				break;
			default:
				System.out.println("Enter valid moves");
				break;
			}
	//		this.updatePositionAndOrientation();
		}
//		System.out.println("update thava aave che");
		this.updatePositionAndOrientation();
	 }
	/*
	 * private void Right() { this.leftprime_rotation();
	 * this.middle_right_rotation(); this.right_rotation(); } private void Left() {
	 * this.left_rotation(); this.middle_left_rotation();
	 * this.rightprime_rotation(); } private void Up() { this.up_rotation();
	 * this.middle_Up_rotation(); this.downprime_rotation(); } private void Down() {
	 * this.upprime_rotation(); this.middle_down_rotation(); this.down_rotation(); }
	 * private void Front() { this.front_rotation(); this.middle_front_rotation();
	 * this.backprime_rotation(); } private void Back() {
	 * this.frontprime_rotation(); this.middle_Back_rotation();
	 * this.back_rotation(); }
	 */
	/*
	 * private void middle_Up_rotation() { Cube tmp=cube[0][1][0];
	 * cube[0][1][0]=cube[2][1][0]; cube[2][1][0]=cube[2][1][2];
	 * cube[2][1][2]=cube[0][1][2]; cube[0][1][2]=tmp; Cube tmp1=cube[1][1][0];
	 * cube[1][1][0]=cube[2][1][1]; cube[2][1][1]=cube[1][1][2];
	 * cube[1][1][2]=cube[0][1][1]; cube[0][1][1]=tmp1;
	 * //this.revolve_Cubes(cube[0][0][0],cube[0][0][2],cube[0][2][2],cube[0][2][0])
	 * ;
	 * //this.revolve_Cubes(cube[0][0][1],cube[0][1][2],cube[0][2][1],cube[0][1][0])
	 * ; for(int i=0;i<this.cube.length;i++) { for(int
	 * j=0;j<this.cube[i][2].length;j++) { //cube[0][i][j]= new Cube();
	 * this.cube[i][1][j].upRotation(); } } } private void middle_down_rotation() {
	 * Cube tmp=cube[0][1][0]; cube[0][1][0]=cube[0][1][2];
	 * cube[0][1][2]=cube[2][1][2]; cube[2][1][2]=cube[2][1][0]; cube[2][1][0]=tmp;
	 * Cube tmp1=cube[0][1][1]; cube[0][1][1]=cube[1][1][2];
	 * cube[1][1][2]=cube[2][1][1]; cube[2][1][1]=cube[1][1][0]; cube[1][1][0]=tmp1;
	 * //this.revolve_Cubes(cube[0][0][0],cube[0][0][2],cube[0][2][2],cube[0][2][0])
	 * ;
	 * //this.revolve_Cubes(cube[0][0][1],cube[0][1][2],cube[0][2][1],cube[0][1][0])
	 * ; for(int i=0;i<this.cube.length;i++) { for(int
	 * j=0;j<this.cube[i][0].length;j++) { //cube[0][i][j]= new Cube();
	 * this.cube[i][0][j].downRotation(); } }
	 *
	 * } private void middle_left_rotation() { Cube tmp=cube[1][0][0];
	 * cube[1][0][0]=cube[1][2][0]; cube[1][2][0]=cube[1][2][2];
	 * cube[1][2][2]=cube[1][0][2]; cube[1][0][2]=tmp; Cube tmp1=cube[1][0][1];
	 * cube[1][0][1]=cube[1][1][0]; cube[1][1][0]=cube[1][2][1];
	 * cube[1][2][1]=cube[1][1][2]; cube[1][1][2]=tmp1;
	 * //this.revolve_Cubes(cube[0][0][0],cube[0][0][2],cube[0][2][2],cube[0][2][0])
	 * ;
	 * //this.revolve_Cubes(cube[0][0][1],cube[0][1][2],cube[0][2][1],cube[0][1][0])
	 * ; for(int i=0;i<this.cube.length;i++) { for(int
	 * j=0;j<this.cube[i].length;j++) { //cube[0][i][j]= new Cube();
	 * this.cube[1][i][j].leftRotation(); } } } private void middle_right_rotation()
	 * { Cube tmp=cube[1][0][0]; cube[1][0][0]=cube[1][0][2];
	 * cube[1][0][2]=cube[1][2][2]; cube[1][2][2]=cube[1][2][0]; cube[1][2][0]=tmp;
	 * Cube tmp1=cube[1][1][0]; cube[1][1][0]=cube[1][0][1];
	 * cube[1][0][1]=cube[1][1][2]; cube[1][1][2]=cube[1][2][1]; cube[1][2][1]=tmp1;
	 *
	 * //this.revolve_Cubes(cube[2][0][0],cube[2][2][0],cube[2][2][2],cube[2][0][2])
	 * ;
	 * //this.revolve_Cubes(cube[2][1][0],cube[2][2][1],cube[2][1][2],cube[2][0][1])
	 * ; for(int i=0;i<cube.length;i++) { for(int j=0;j<cube[i].length;j++) {
	 * cube[1][i][j].rightRotation(); } } } private void middle_front_rotation(){
	 * Cube tmp=cube[0][0][1]; cube[0][0][1]=cube[2][0][1];
	 * cube[2][0][1]=cube[2][2][1]; cube[2][2][1]=cube[0][2][1]; cube[0][2][1]=tmp;
	 * Cube tmp1=cube[0][1][1]; cube[0][1][1]=cube[1][0][1];
	 * cube[1][0][1]=cube[2][1][1]; cube[2][1][1]=cube[1][2][1]; cube[1][2][1]=tmp1;
	 * //this.revolve_Cubes(cube[0][0][0],cube[0][0][2],cube[0][2][2],cube[0][2][0])
	 * ;
	 * //this.revolve_Cubes(cube[0][0][1],cube[0][1][2],cube[0][2][1],cube[0][1][0])
	 * ; for(int i=0;i<this.cube.length;i++) { for(int
	 * j=0;j<this.cube[i].length;j++) { //cube[0][i][j]= new Cube();
	 * this.cube[i][j][1].frontRotation(); } } } private void middle_Back_rotation()
	 * { Cube tmp=cube[0][0][1]; cube[0][0][1]=cube[0][2][1];
	 * cube[0][2][1]=cube[2][2][1]; cube[2][2][1]=cube[2][0][1]; cube[2][0][1]=tmp;
	 * Cube tmp1=cube[0][1][1]; cube[0][1][1]=cube[1][2][1];
	 * cube[1][2][1]=cube[2][1][1]; cube[2][1][1]=cube[1][0][1]; cube[1][0][1]=tmp1;
	 * //this.revolve_Cubes(cube[0][0][0],cube[0][0][2],cube[0][2][2],cube[0][2][0])
	 * ;
	 * //this.revolve_Cubes(cube[0][0][1],cube[0][1][2],cube[0][2][1],cube[0][1][0])
	 * ; for(int i=0;i<this.cube.length;i++) { for(int
	 * j=0;j<this.cube[i].length;j++) { //cube[0][i][j]= new Cube();
	 * this.cube[i][j][1].backRotation(); } } }
	 */ private void leftRotation() {
		Cube tmp = cubes[0][0][0];
		cubes[0][0][0] = cubes[0][2][0];
		cubes[0][2][0] = cubes[0][2][2];
		cubes[0][2][2] = cubes[0][0][2];
		cubes[0][0][2] = tmp;
		Cube tmp1 = cubes[0][0][1];
		cubes[0][0][1] = cubes[0][1][0];
		cubes[0][1][0] = cubes[0][2][1];
		cubes[0][2][1] = cubes[0][1][2];
		cubes[0][1][2] = tmp1;
		// this.revolve_Cubes(cube[0][0][0],cube[0][0][2],cube[0][2][2],cube[0][2][0]);
		// this.revolve_Cubes(cube[0][0][1],cube[0][1][2],cube[0][2][1],cube[0][1][0]);
		for (int i = 0; i < this.cubes.length; i++) {
			for (int j = 0; j < this.cubes[i].length; j++) {
				// cube[0][i][j]= new Cube();
				this.cubes[0][i][j].leftRotation();
			}
		}
	}
	private void leftprimeRotation() {
		Cube tmp = cubes[0][0][0];
		cubes[0][0][0] = cubes[0][0][2];
		cubes[0][0][2] = cubes[0][2][2];
		cubes[0][2][2] = cubes[0][2][0];
		cubes[0][2][0] = tmp;
		Cube tmp1 = cubes[0][1][0];
		cubes[0][1][0] = cubes[0][0][1];
		cubes[0][0][1] = cubes[0][1][2];
		cubes[0][1][2] = cubes[0][2][1];
		cubes[0][2][1] = tmp1;

		// this.revolve_Cubes(cube[0][0][0],cube[0][2][0],cube[0][2][2],cube[0][0][2]);
		// this.revolve_Cubes(cube[0][1][0],cube[0][2][1],cube[0][1][2],cube[0][0][1]);
		for (int i = 0; i < cubes.length; i++) {
			for (int j = 0; j < cubes[i].length; j++) {
				cubes[0][i][j].rightRotation();
			}
		}
	}

	private void rightRotation() {
		Cube tmp = cubes[2][0][0];
		cubes[2][0][0] = cubes[2][0][2];
		cubes[2][0][2] = cubes[2][2][2];
		cubes[2][2][2] = cubes[2][2][0];
		cubes[2][2][0] = tmp;
		Cube tmp1 = cubes[2][1][0];
		cubes[2][1][0] = cubes[2][0][1];
		cubes[2][0][1] = cubes[2][1][2];
		cubes[2][1][2] = cubes[2][2][1];
		cubes[2][2][1] = tmp1;

		// this.revolve_Cubes(cube[2][0][0],cube[2][2][0],cube[2][2][2],cube[2][0][2]);
		// this.revolve_Cubes(cube[2][1][0],cube[2][2][1],cube[2][1][2],cube[2][0][1]);
		for (int i = 0; i < cubes.length; i++) {
			for (int j = 0; j < cubes[i].length; j++) {
				cubes[2][i][j].rightRotation();
			}
		}
	}

	private void rightprimeRotation() {
		Cube tmp = cubes[2][0][0];
		cubes[2][0][0] = cubes[2][2][0];
		cubes[2][2][0] = cubes[2][2][2];
		cubes[2][2][2] = cubes[2][0][2];
		cubes[2][0][2] = tmp;
		Cube tmp1 = cubes[2][0][1];
		cubes[2][0][1] = cubes[2][1][0];
		cubes[2][1][0] = cubes[2][2][1];
		cubes[2][2][1] = cubes[2][1][2];
		cubes[2][1][2] = tmp1;
		// this.revolve_Cubes(cube[0][0][0],cube[0][0][2],cube[0][2][2],cube[0][2][0]);
		// this.revolve_Cubes(cube[0][0][1],cube[0][1][2],cube[0][2][1],cube[0][1][0]);
		for (int i = 0; i < this.cubes.length; i++) {
			for (int j = 0; j < this.cubes[i].length; j++) {
				// cube[0][i][j]= new Cube();
				this.cubes[2][i][j].leftRotation();
			}
		}
	}

	private void upprimeRotation() {
		Cube tmp = cubes[0][2][0];
		cubes[0][2][0] = cubes[0][2][2];
		cubes[0][2][2] = cubes[2][2][2];
		cubes[2][2][2] = cubes[2][2][0];
		cubes[2][2][0] = tmp;
		Cube tmp1 = cubes[1][2][0];
		cubes[1][2][0] = cubes[0][2][1];
		cubes[0][2][1] = cubes[1][2][2];
		cubes[1][2][2] = cubes[2][2][1];
		cubes[2][2][1] = tmp1;
		// this.revolve_Cubes(cube[0][0][0],cube[0][0][2],cube[0][2][2],cube[0][2][0]);
		// this.revolve_Cubes(cube[0][0][1],cube[0][1][2],cube[0][2][1],cube[0][1][0]);
		for (int i = 0; i < this.cubes.length; i++) {
			for (int j = 0; j < this.cubes[i][2].length; j++) {
				// cube[0][i][j]= new Cube();
				this.cubes[i][2][j].downRotation();
			}
		}
	}

	private void downprimeRotation() {
		Cube tmp = cubes[0][0][0];
		cubes[0][0][0] = cubes[2][0][0];
		cubes[2][0][0] = cubes[2][0][2];
		cubes[2][0][2] = cubes[0][0][2];
		cubes[0][0][2] = tmp;
		Cube tmp1 = cubes[1][0][0];
		cubes[1][0][0] = cubes[2][0][1];
		cubes[2][0][1] = cubes[1][0][2];
		cubes[1][0][2] = cubes[0][0][1];
		cubes[0][0][1] = tmp1;
		// this.revolve_Cubes(cube[0][0][0],cube[0][0][2],cube[0][2][2],cube[0][2][0]);
		// this.revolve_Cubes(cube[0][0][1],cube[0][1][2],cube[0][2][1],cube[0][1][0]);
		for (int i = 0; i < this.cubes.length; i++) {
			for (int j = 0; j < this.cubes[i][0].length; j++) {
				// cube[0][i][j]= new Cube();
				this.cubes[i][0][j].upRotation();
			}
		}
	}

	private void upRotation() {
		Cube tmp = cubes[0][2][0];
		cubes[0][2][0] = cubes[2][2][0];
		cubes[2][2][0] = cubes[2][2][2];
		cubes[2][2][2] = cubes[0][2][2];
		cubes[0][2][2] = tmp;
		Cube tmp1 = cubes[1][2][0];
		cubes[1][2][0] = cubes[2][2][1];
		cubes[2][2][1] = cubes[1][2][2];
		cubes[1][2][2] = cubes[0][2][1];
		cubes[0][2][1] = tmp1;
		// this.revolve_Cubes(cube[0][0][0],cube[0][0][2],cube[0][2][2],cube[0][2][0]);
		// this.revolve_Cubes(cube[0][0][1],cube[0][1][2],cube[0][2][1],cube[0][1][0]);
		for (int i = 0; i < this.cubes.length; i++) {
			for (int j = 0; j < this.cubes[i][2].length; j++) {
				// cube[0][i][j]= new Cube();
				this.cubes[i][2][j].upRotation();
			}
		}
	}

	private void down_rotation() {
		Cube tmp = cubes[0][0][0];
		cubes[0][0][0] = cubes[0][0][2];
		cubes[0][0][2] = cubes[2][0][2];
		cubes[2][0][2] = cubes[2][0][0];
		cubes[2][0][0] = tmp;
		Cube tmp1 = cubes[0][0][1];
		cubes[0][0][1] = cubes[1][0][2];
		cubes[1][0][2] = cubes[2][0][1];
		cubes[2][0][1] = cubes[1][0][0];
		cubes[1][0][0] = tmp1;
		// this.revolve_Cubes(cube[0][0][0],cube[0][0][2],cube[0][2][2],cube[0][2][0]);
		// this.revolve_Cubes(cube[0][0][1],cube[0][1][2],cube[0][2][1],cube[0][1][0]);
		for (int i = 0; i < this.cubes.length; i++) {
			for (int j = 0; j < this.cubes[i][0].length; j++) {
				// cube[0][i][j]= new Cube();
				this.cubes[i][0][j].downRotation();
			}
		}
	}

	private void front_rotation() {
		Cube tmp = cubes[0][0][0];
		cubes[0][0][0] = cubes[2][0][0];
		cubes[2][0][0] = cubes[2][2][0];
		cubes[2][2][0] = cubes[0][2][0];
		cubes[0][2][0] = tmp;
		Cube tmp1 = cubes[0][1][0];
		cubes[0][1][0] = cubes[1][0][0];
		cubes[1][0][0] = cubes[2][1][0];
		cubes[2][1][0] = cubes[1][2][0];
		cubes[1][2][0] = tmp1;
		// this.revolve_Cubes(cube[0][0][0],cube[0][0][2],cube[0][2][2],cube[0][2][0]);
		// this.revolve_Cubes(cube[0][0][1],cube[0][1][2],cube[0][2][1],cube[0][1][0]);
		for (int i = 0; i < this.cubes.length; i++) {
			for (int j = 0; j < this.cubes[i].length; j++) {
				// cube[0][i][j]= new Cube();
				this.cubes[i][j][0].frontRotation();
			}
		}
	}

	private void backprime_rotation() {
		Cube tmp = cubes[0][0][2];
		cubes[0][0][2] = cubes[2][0][2];
		cubes[2][0][2] = cubes[2][2][2];
		cubes[2][2][2] = cubes[0][2][2];
		cubes[0][2][2] = tmp;
		Cube tmp1 = cubes[0][1][2];
		cubes[0][1][2] = cubes[1][0][2];
		cubes[1][0][2] = cubes[2][1][2];
		cubes[2][1][2] = cubes[1][2][2];
		cubes[1][2][2] = tmp1;
		// this.revolve_Cubes(cube[0][0][0],cube[0][0][2],cube[0][2][2],cube[0][2][0]);
		// this.revolve_Cubes(cube[0][0][1],cube[0][1][2],cube[0][2][1],cube[0][1][0]);
		for (int i = 0; i < this.cubes.length; i++) {
			for (int j = 0; j < this.cubes[i].length; j++) {
				// cube[0][i][j]= new Cube();
				this.cubes[i][j][2].frontRotation();
			}
		}
	}

	private void back_rotation() {
		Cube tmp = cubes[0][0][2];
		cubes[0][0][2] = cubes[0][2][2];
		cubes[0][2][2] = cubes[2][2][2];
		cubes[2][2][2] = cubes[2][0][2];
		cubes[2][0][2] = tmp;
		Cube tmp1 = cubes[0][1][2];
		cubes[0][1][2] = cubes[1][2][2];
		cubes[1][2][2] = cubes[2][1][2];
		cubes[2][1][2] = cubes[1][0][2];
		cubes[1][0][2] = tmp1;
		// this.revolve_Cubes(cube[0][0][0],cube[0][0][2],cube[0][2][2],cube[0][2][0]);
		// this.revolve_Cubes(cube[0][0][1],cube[0][1][2],cube[0][2][1],cube[0][1][0]);
		for (int i = 0; i < this.cubes.length; i++) {
			for (int j = 0; j < this.cubes[i].length; j++) {
				// cube[0][i][j]= new Cube();
				this.cubes[i][j][2].backRotation();
			}
		}
	}

	private void frontprime_rotation() {
		Cube tmp = cubes[0][0][0];
		cubes[0][0][0] = cubes[0][2][0];
		cubes[0][2][0] = cubes[2][2][0];
		cubes[2][2][0] = cubes[2][0][0];
		cubes[2][0][0] = tmp;
		Cube tmp1 = cubes[0][1][0];
		cubes[0][1][0] = cubes[1][2][0];
		cubes[1][2][0] = cubes[2][1][0];
		cubes[2][1][0] = cubes[1][0][0];
		cubes[1][0][0] = tmp1;
		// this.revolve_Cubes(cube[0][0][0],cube[0][0][2],cube[0][2][2],cube[0][2][0]);
		// this.revolve_Cubes(cube[0][0][1],cube[0][1][2],cube[0][2][1],cube[0][1][0]);
		for (int i = 0; i < this.cubes.length; i++) {
			for (int j = 0; j < this.cubes[i].length; j++) {
				// cube[0][i][j]= new Cube();
				this.cubes[i][j][0].backRotation();
			}
		}
	}

	public void displayRubiksCube() {
		System.out.println("\nFront side :");
		for (int i = 0; i < cubes.length; i++) {
			System.out.println(" ");
			for (int j = 0; j < cubes[i].length; j++) {
				System.out.print(i+" "+j+" "+"0"+" "+cubes[i][j][0].getColor(Side.FRONT) + " ");// = know(i,j,k);
			}
		}
		System.out.println("\nBack side :");
		for (int i = 0; i < cubes.length; i++) {
			System.out.println(" ");
			for (int j = 0; j < cubes[i].length; j++) {
				System.out.print(i+" "+j+" "+2+" "+cubes[i][j][2].getColor(Side.BACK) + " ");// = know(i,j,k);
			}
		}
		System.out.println("\nDown side :");
		for (int i = 0; i < cubes.length; i++) {
			System.out.println(" ");
			for (int j = 0; j < cubes[i][0].length; j++) {
				System.out.print(i+" "+0+" "+j+" "+cubes[i][0][j].getColor(Side.DOWN) + " ");// = know(i,j,k);
			}
		}

		System.out.println("\nUp side :");
		for (int i = 0; i < cubes.length; i++) {
			System.out.println(" ");
			for (int j = 0; j < cubes[i][2].length; j++) {
				System.out.print(i+" "+2+" "+j+" "+cubes[i][2][j].getColor(Side.UP) + " ");// = know(i,j,k);
			}
		}

		System.out.println("\nLeft side :");
		for (int i = 0; i < cubes[0].length; i++) {
			System.out.println(" ");
			for (int j = 0; j < cubes[0][i].length; j++) {
				System.out.print("0"+" "+i+" "+j+" "+cubes[0][i][j].getColor(Side.LEFT) + " ");// = know(i,j,k);
			}
		}
		System.out.println("\nRight side :");
		for (int i = 0; i < cubes[2].length; i++) {
			System.out.println(" ");
			for (int j = 0; j < cubes[2][i].length; j++) {
				System.out.print("2"+" "+i+" "+j+" "+cubes[2][i][j].getColor(Side.RIGHT) + " ");// = know(i,j,k);
			}
		}

	}

	private Side left_Or_right(int i) {
		if (i == 0) {
			return Side.LEFT;
		} else if (i == 2) {
			return Side.RIGHT;
		} else
			return null;
	}

	private Side up_Or_down(int i) {
		if (i == 0) {
			return Side.DOWN;
		} else if (i == 2) {
			return Side.UP;
		} else {
			return null;
		}
	}

	private Side front_Or_Back(int i) {
		if (i == 0) {
			return Side.FRONT;
		} else if (i == 2) {
			return Side.BACK;
		} else {
			return null;
		}
	}
	public Cube setValueCubicGui(int i,int j,int k,Side side,RubiksCubeColor color)throws Exception{
		Cube c=new Cube();
		c=this.cubes[i][j][k];
		if (left_Or_right(i) != null&&(side==Side.LEFT||side==Side.RIGHT)) {
			c.setMap(left_Or_right(i), color);
			/*System.out.println("Enter color" + (left_Or_right(i)));
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String name = reader.readLine();
			try {
				RubiksCubeColor color = RubiksCubeColor.valueOf(RubiksCubeColor.class, name);
				c.setMap(left_Or_right(i), color);
			} catch (Exception e) {
				System.out.println("na chale ");
			}*/
		}
		if (up_Or_down(j) != null&&(side==Side.UP||side==Side.DOWN)) {
			c.setMap(left_Or_right(i), color);
			/*System.out.println("Enter up or down");
			BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
			String name1 = reader1.readLine();
			try {

				RubiksCubeColor color = RubiksCubeColor.valueOf(RubiksCubeColor.class, name1);
				c.setMap(left_Or_right(i), color);
			} catch (Exception e) {
				System.out.println("na chale ");
			}*/
		}
		if (front_Or_Back(k) != null&&(side==Side.FRONT||side==Side.BACK)) {
			System.out.println("In k line");
			System.out.println(color);
			c.setMap(front_Or_Back(k), color);
			/*System.out.println("enter front or back");
			BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
			String name2 = reader2.readLine();
			try {

				RubiksCubeColor color = RubiksCubeColor.valueOf(RubiksCubeColor.class, name2);
				c.setMap(front_Or_Back(k), color);
			} catch (Exception e) {
				System.out.println("na chale ");
			}*/
		}

		
		
		return c;
	}
	
	// Sides a[]= new Sides[3];
	public Cube setValuesCubic(int i, int j, int k) throws Exception {
		System.out.println("In set Value rubiks cube");
		Cube c = new Cube();
		if (left_Or_right(i) != null) {
			//c.setMap(left_Or_right(i), color);
			System.out.println("Enter color" + (left_Or_right(i)));
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String name = reader.readLine();
			try {
				RubiksCubeColor color = RubiksCubeColor.valueOf(RubiksCubeColor.class, name);
				c.setMap(left_Or_right(i), color);
			} catch (Exception e) {
				System.out.println("na chale ");
			}
		}

		/*
		 * if(i==2) { System.out.println("Enter Right"); BufferedReader reader = new
		 * BufferedReader(new InputStreamReader(System.in)); String name =
		 * reader.readLine(); try {
		 *
		 * Color color = Color.valueOf(Color.class, name); c.setMap(Sides.RIGHT,color );
		 * } catch(Exception e) { System.out.println("na chale "); }
		 * //c.setMap(Sides.RIGHT, Color.GREEN); }
		 */
		if (up_Or_down(j) != null) {
			//c.setMap(left_Or_right(i), color);
			System.out.println("Enter up or down");
			BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
			String name1 = reader1.readLine();
			try {

				RubiksCubeColor color = RubiksCubeColor.valueOf(RubiksCubeColor.class, name1);
				c.setMap(left_Or_right(i), color);
			} catch (Exception e) {
				System.out.println("na chale ");
			}
		}
		// c.setMap(Sides.DOWN, Color.RED);

		if (front_Or_Back(k) != null) {
			//c.setMap(front_Or_Back(k), color);
			System.out.println("enter front or back");
			BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
			String name2 = reader2.readLine();
			try {

				RubiksCubeColor color = RubiksCubeColor.valueOf(RubiksCubeColor.class, name2);
				c.setMap(front_Or_Back(k), color);
			} catch (Exception e) {
				System.out.println("na chale ");
			}
		}
		// c.setMap(Sides.UP, Color.ORANGE);
		/*
		 * } if(k==0) { System.out.println("enter Front"); BufferedReader reader = new
		 * BufferedReader(new InputStreamReader(System.in)); String name =
		 * reader.readLine(); try {
		 *
		 * Color color = Color.valueOf(Color.class, name); c.setMap(Sides.FRONT,color );
		 * } catch(Exception e) { System.out.println("na chale "); }
		 * //c.setMap(Sides.FRONT, Color.YELLOW); } if(k==2) {
		 * System.out.println("Enter Back's color "); BufferedReader reader = new
		 * BufferedReader(new InputStreamReader(System.in)); String name =
		 * reader.readLine(); try {
		 *
		 * Color color = Color.valueOf(Color.class, name); c.setMap(Sides.BACK,color );
		 * } catch(Exception e) { System.out.println("na chale "); }
		 * //c.setMap(Sides.BACK, Color.WHITE); } //c.Display();
		 */ return c;
	}
/*	private void making_plus_down() {
		//Cube small_cube = new Cube();
		Coordinate[] c = Search("Edge", "RED");
		for(int i=0;i<4;i++) {
		if (c[i].getZ() == 0) {
			//Color color = cube[c[0].getX()][c[0].getY()][c[0].getZ()].getColor(Sides.FRONT);
			Sides sidelR=left_Or_right(c[i].getX());
			Sides sideuD=up_Or_down(c[i].getY());
			if(sidelR!=null) {
				if(sidelR==Sides.LEFT) {
					while(cubes[c[i].getX()][c[i].getY()][2].Search(Color.RED)) {
						performMove("B");
					}
					performMove("LL");
				}
				if(sidelR==Sides.RIGHT) {
					while(cubes[c[i].getX()][c[i].getY()][2].Search(Color.RED)) {
						performMove("B");
					}
					performMove("RR");
				}
			}
			if(sideuD!=null) {
				if(sideuD==Sides.UP) {
					while(cubes[c[i].getX()][c[i].getY()][2].Search(Color.RED)) {
						performMove("B");
					}
					performMove("UU");
				}
				if(sideuD==Sides.DOWN) {
					while(cubes[c[i].getX()][c[i].getY()][2].Search(Color.RED)) {
						performMove("B");
					}
					performMove("DD");
				}

			}
		}
		if(c[0].getZ()==1) {
			Sides sidelR=left_Or_right(c[i].getX());
			Sides sideuD=up_Or_down(c[i].getY());
			if(sidelR!=null) {

				if(sidelR==Sides.LEFT) {

					if(sideuD!=null) {
						if(sideuD==Sides.UP) {
							while(cubes[0][1][2].Search(Color.RED)) {
								performMove("B");
							}
							performMove("l");
					}
					if(sideuD==Sides.DOWN) {
						while(cubes[0][1][2].Search(Color.RED)) {
							performMove("B");
						}
						performMove("L");
					}
				}
			}
				if(sidelR==Sides.RIGHT) {
					if(sideuD!=null) {
						if(sideuD==Sides.UP) {
							while(cubes[2][1][2].Search(Color.RED)) {
								performMove("B");
							}
							performMove("R");
						}
						if(sideuD==Sides.DOWN) {
							while(cubes[2][1][2].Search(Color.RED)) {
								performMove("B");
							}
							performMove("r");
						}
					}
				}
			}
		}

		}//For loop ending.
	}
	private void make_plus_2() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if((i+j)%2!=0) {
					while(cubes[i][j][2].Search(cubes[i][j][1].getColor_center())==false) {
						performMove("B");
					}
					if(j==2) {
						performMove("UU");
					}
					if(j==0) {
						performMove("DD");
					}
					if(i==0) {
						performMove("LL");
					}
					if(i==2) {
						performMove("RR");
					}
				}
			}
		}
	}
	private void make_plus_3() {
		Coordinate []coor=Search("Edge","RED");
		for(int i=0;i<4;i++) {
			Color color = cubes[coor[i].getX()][coor[i].getY()][coor[i].getZ()].getColor(Sides.FRONT);
			if(color!=Color.RED) {
				if(coor[i].getX()==1&&coor[i].getY()==2) {
					performMove("flFu");
				}
				if(coor[i].getX()==0&&coor[i].getY()==1) {
					performMove(translation("flFu",'B'));
				}
				if(coor[i].getX()==2&&coor[i].getY()==1) {
					performMove(translation("flFu", 'F'));
				}
				if(coor[i].getX()==1&&coor[i].getY()==0) {
					performMove(translation(translation("flFu", 'F'),'F'));
				}
			}
		}


	}
	public void make_plus_final() {
		making_plus_down();
		make_plus_2();
		make_plus_3();
	}*/
	public boolean isSecondLayerSolved() {
		for(int i=0;i<dimension;i++) {
			for(int k=0;k<dimension;k++) {
				if(validate_Orientation[i][1][k]==false) {
					return false;
				}
			}
		}
		//if(validate_Orientation[0][1][2]==true) {
			//return true;
		//}
		 
		return true;
	}
	public boolean isLastLayerSolved() {
		for(int i=0;i<dimension;i++) {
			for(int k=0;k<dimension;k++) {
				if(isEdgeCornerCenter(i, 0, k)==2&&validate_Orientation[i][0][k]!=true) {
				return false;
				}
			}
		}
		return true;
	}
	public String setLasteLayerCornerOrientation() {
		String lastLayerCornerOrientationMove="";
		//int j=0;
	//	if(!isOrienteLastCorner()) {
		for(int i=0;i<4;i++) {
		//Color color=cubes[dimension-1][0][dimension-1].getColor(Side.DOWN);
//		System.out.println(color.name());
		if(!cubes[dimension-1][0][dimension-1].getColor(Side.DOWN).isEqual(RubiksCubeColor.YELLOW)) {
			System.out.println(cubes[dimension-1][0][dimension-1].getColor(Side.DOWN).name());
			while(!cubes[dimension-1][0][dimension-1].getColor(Side.DOWN).isEqual(RubiksCubeColor.YELLOW)) {
			//	System.out.println("in while loop");
				String move=translation(translation("rdRD", 'R'), 'R');
				performMove(move);
				lastLayerCornerOrientationMove=lastLayerCornerOrientationMove+move;
			}
			//System.out.println(cubes[dimension-1][0][dimension-1].getColor(Side.DOWN).name());

		}
		
		performMove("D");
		lastLayerCornerOrientationMove=lastLayerCornerOrientationMove+"D";
		}
		return lastLayerCornerOrientationMove;
	}

	public String setLastLayerCorner() {
//	int j=0;
		String lastLayerCornerMove="";
	//updatePositionAndOrientation();
	boolean b1=validate_Position[0][0][0];
	boolean b2=validate_Position[0][0][dimension-1];
	boolean b3=validate_Position[dimension-1][0][0];
	boolean b4=validate_Position[dimension-1][0][dimension-1];
	System.out.println(b1+""+b2+""+b3+""+b4);
	if(b1==false&&b2==false&&b3==false&&b4==false) {
		//while(!(validate_Position[0][0][0]==true||validate_Position[0][0][dimension-1]==true||validate_Position[dimension-1][0][0]==true||validate_Position[dimension-1][0][dimension-1]==true)) {
			performMove(("DRdlDrdL"));
			lastLayerCornerMove=lastLayerCornerMove+"DRdlDrdL";
			boolean b11=validate_Position[0][0][0];
			boolean b22=validate_Position[0][0][dimension-1];
			boolean b33=validate_Position[dimension-1][0][0];
			boolean b44=validate_Position[dimension-1][0][dimension-1];
			System.out.println(b11+""+b22+""+b33+""+b44);
			String move1=translation(translation("URulUruL", 'R'),'R');
			performMove(move1);
			lastLayerCornerMove=lastLayerCornerMove+move1;
			/*boolean b111=validate_Position[0][0][0];
			boolean b222=validate_Position[0][0][dimension-1];
			boolean b333=validate_Position[dimension-1][0][0];
			boolean b444=validate_Position[dimension-1][0][dimension-1];
			System.out.println(b111+""+b222+""+b333+""+b444);*/

		//}
		if(validate_Position[0][0][0]==true||validate_Position[0][0][dimension-1]==true||validate_Position[dimension-1][0][0]==true||validate_Position[dimension-1][0][dimension-1]==true) {
			//updatePositionAndOrientation();
		//	System.out.println("First condition ma aave che");
			 b11=validate_Position[0][0][0];
			 b22=validate_Position[0][0][dimension-1];
			 b33=validate_Position[dimension-1][0][0];
			 b44=validate_Position[dimension-1][0][dimension-1];
			System.out.println(b11+""+b22+""+b33+""+b44);
			if(b11==true) {
			//	System.out.println("b1 is true");
				System.out.println(translation(translation(translation(translation("URulUruL", 'R'),'R'),'U'),'U'));
				while(!(validate_Position[0][0][dimension-1]==true&&validate_Position[dimension-1][0][0]==true
					&&validate_Position[dimension-1][0][dimension-1]==true)){
				//	System.out.println("infinye");
					String move=translation(translation(translation(translation("URulUruL", 'R'),'R'),'U'),'U');
					performMove(move);
					lastLayerCornerMove=lastLayerCornerMove+move;
					
				}
			}
			else if(b22==true) {
				while(!(validate_Position[0][0][0]==true&&validate_Position[dimension-1][0][0]==true
						&&validate_Position[dimension-1][0][dimension-1]==true)){
					String move=translation(translation(translation("URulUruL", 'R'),'R'),'D');
					performMove(move);
					lastLayerCornerMove=lastLayerCornerMove+move;
				}
			}
			else if(b33==true) {
				while(!(validate_Position[0][0][dimension-1]==true&&validate_Position[0][0][0]==true
						&&validate_Position[dimension-1][0][dimension-1]==true)){
					String move=translation(translation(translation("URulUruL", 'R'),'R'),'U');
					performMove(move);
					lastLayerCornerMove=lastLayerCornerMove+move;
				}
			//	performMove(translation(translation(translation("URulUruL", 'R'),'R'),'D'));
			}
			else if(b44==true) {
				while(!(validate_Position[0][0][dimension-1]==true&&validate_Position[dimension-1][0][0]==true
						&&validate_Position[0][0][0]==true)){
					//performMove(translation(translation(translation(translation("URulUruL", 'R'),'R'),'U'),'U'));
					String move=translation(translation("URulUruL", 'R'),'R');
					performMove(move);
					lastLayerCornerMove=lastLayerCornerMove+move;
				}
			}
		}
	}
		else if(b1==true&&b2==true&&b3==true&&b4==true) {
		}
		else if(b1==true||b2==true||b3==true||b4==true) {
			System.out.println("In else if ");
			if(b1==true) {
			//	System.out.println("b1 is true");
	//			System.out.println(translation(translation(translation(translation("URulUruL", 'R'),'R'),'U'),'U'));
				while(!(validate_Position[0][0][dimension-1]==true&&validate_Position[dimension-1][0][0]==true
					&&validate_Position[dimension-1][0][dimension-1]==true)){
					//System.out.println("Infinte");
					String move=translation(translation(translation(translation("URulUruL", 'R'),'R'),'U'),'U');
					performMove(move);
					lastLayerCornerMove=lastLayerCornerMove+move;
				}
			}
			else if(b2==true) {
				while(!(validate_Position[0][0][0]==true&&validate_Position[dimension-1][0][0]==true
						&&validate_Position[dimension-1][0][dimension-1]==true)){
						String move=translation(translation(translation("URulUruL", 'R'),'R'),'D');
						performMove(move);
						lastLayerCornerMove=lastLayerCornerMove+move;
				}
			}
			else if(b3==true) {
				while(!(validate_Position[0][0][dimension-1]==true&&validate_Position[0][0][0]==true
						&&validate_Position[dimension-1][0][dimension-1]==true)){
						String move=translation(translation(translation("URulUruL", 'R'),'R'),'U');
						performMove(move);
						lastLayerCornerMove=lastLayerCornerMove+move;
				}
			//	performMove(translation(translation(translation("URulUruL", 'R'),'R'),'D'));
			}
			else if(b4==true) {
				while(!(validate_Position[0][0][dimension-1]==true&&validate_Position[dimension-1][0][0]==true
						&&validate_Position[0][0][0]==true)){
					//performMove(translation(translation(translation(translation("URulUruL", 'R'),'R'),'U'),'U'));
					String move=translation(translation("URulUruL", 'R'),'R');
					performMove(move);
					lastLayerCornerMove=lastLayerCornerMove+move;
				}
			}
		}
	return lastLayerCornerMove;
	}

}
