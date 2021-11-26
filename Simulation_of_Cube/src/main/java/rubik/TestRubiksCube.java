package rubik;

//import java.util.Random;



public class TestRubiksCube {
public static void main(String[] args) throws Exception {
		
		System.out.println("start testing");
		RubiksCube cube=new RubiksCube(3);
//		cube.performMove("RbLUlBDbUr");
	//	cube.displayRubiksCube();
//		cube.performMove("");
		String s="";
		s=cube.setPlus()+cube.setCorner();
		System.out.println(s);
		String s1=cube.setMiddleLayer();
		String s2=cube.setLastLayerPlus();
		String s3=cube.setLastLayerEdge();
		String s4=cube.setLastLayerCorner();
		String s5=cube.setLasteLayerCornerOrientation();
		//s=cube.setCorner();
		System.out.println("middle laye move"+s1);
		System.out.println("setLastLayerPlus"+s2);
		System.out.println("set LastLayerEdge"+s3);
		System.out.println("set LastLayerCorner"+s4);
		System.out.println("set LastLayerCornerOrientation"+s5);
		cube.displayRubiksCube();
		//System.out.println(cube.translation((cube.translation("URulUruL", 'R')),'R'));
		//System.out.println(cube.translation(cube.translation(cube.translation("URulUruL", 'R'),'R')));
		//cube.setLastLayerCorner();
		//cube.updatePositionAndOrientation();

				//cube.performMove("LUbURrrUDbUbDlUBdFrFbUfUddLrU");
		//cube.performMove("LRlrUDBFFlrfbD");
		//cube.performMove("FRU");
		//cube.performMove("R");

		//	cube.performMove("RRdfRRbRUUrrfbfrulLbfdrdfr");
		//cube.performMove("lRUfLFFll");
		//cube.performMove("RDUrUURfDbbLFURR");//case 5 solved

//		cube.displayRubiksCube();
	//	cube.performMove("DBFRbfl");
		//cube.updatePositionAndOrientation();
		//cube.displayRubiksCube();
		//cube.displayOrientationandPlace();
		//int a=cube.isEdgeCornerCenter(2, 2, 2);
		//System.out.println(a);
	//	cube.performMove("FfUu");
		//cube.performMove("f");
		//System.out.println(cube.translation(cube.translation("FRUrufUUFURurf", 'R'), 'R'));
		//cube.setLastLayerPlus();
		/*String str="FBUDLRfbudlr";
		char[] arr=new char[10];
		Random rand=new Random();
		int ran;
		int count=0;
		String move="";
		for(int j=0;j<100;j++) {
		for(int i=0;i<10;i++) {
			ran=rand.nextInt(12);
			arr[i]=str.charAt(ran);
			 move=new String(arr);
		}
		}	cube.performMove(move);
			*/
		//cube.performMove("LddBdbRBuRULLBRBrrUbULUDlrLDBfUBfBULDuDRuBRDBB");
		//cube.performMove("RfBdRLFuLDFRlBuRUfLDL");

		//cube.performMove("LRdbLLrRRUdURfRUlUBfRBDlDBDLrufbbdFdUfb");
		//cube.performMove("RfRLbLUUBdlBRBfBBuBDLDbDFBFRRLuLDlBU");
		//cube.displayOrientationandPlace();
		//cube.displayRubiksCube();
	//	cube.performMove("LBlBD");
		/*1cube.updatePositionAndOrientation();
		cube.displayRubiksCube();
		for(int i = 0;i<3;i++) {

			for(int j = 0;j<3;j++) {

				for(int k = 0;k<3;k++) {

					System.out.println(i+" "+j+" "+k);
					System.out.println(cube.validate_Position[i][j][k]);

					System.out.println(cube.validate_Orientation[i][j][k]);
				}	
			}
		}*/
		//cube.validate_Orientation
	//	Coordinate coordinate=new Coordinate(2,1,2);
		//Coordinate[] coordinates=cube.adjacentCorrdinate(coordinate);
		//coordinates[0].Display();
		//coordinates[1].Display();
		//cube.displayRubiksCube();
		//cube.performMove("");
		//String s=cube.translation("DFdfRfrF", 'U');
	//	System.out.println(move);
		//performMove(translation(translation("DFdfRfrF",'U'),'U'));
		//cube.displayRubiksCube();
			/*cube.setPlus();
			cube.setCorner();
		//	cube.updatePositionAndOrientation();
			if(cube.isFirstLayerSolved()) {
				System.out.println("Set plus");
			}
			cube.setMiddleLayer();
			//cube.updatePositionAndOrientation();
			if(cube.isSecondLayerSolved()) {
				System.out.println("Second layer solved");}
			//cube.displayRubiksCube();
			cube.setLastLayerPlus();
			System.out.println("3rd layer set plus");
			cube.setLastLayerEdge();
		//	cube.updatePositionAndOrientation();
			if(cube.isLastLayerSolved()) {
				System.out.println("Third layer  solved now display");
			}
		//	cube.setLastLayerCorner();
			//cube.updatePositionAndOrientation();
			//if(cube.isLastLayerCorner()) {
			//	System.out.println("Third layer corner solved now display");
			//}
			//cube.orientLastLayerCorner();
			//System.out.println("In testRubiks cube");
			//System.out.println("Third layer plus set");
			
			//cube.updatePositionAndOrientation();
			//cube.performMove("D");
			//cube.performMove("FFdRlffLrdff");
			if(cube.isLastLayerSolved()) {
				System.out.println("Third layer edges are in Right position");
			}
			
			//cube.displayRubiksCube();
			//cube.displayOrientationandPlace();
			cube.setLastLayerEdge();
//			cube.setLastLayerCorner();
			cube.setLasteLayerCornerOrientation();
			
			cube.displayRubiksCube();
			cube.displayOrientationandPlace();
		//	cube.displayRubiksCube();
			/*for(int i = 0;i<3;i++) {

				for(int j = 0;j<3;j++) {

					for(int k = 0;k<3;k++) {

					//	System.out.println(i+" "+j+" "+k+" "+cube.isEdgeCornerCenter(i, j, k));
						System.out.println(cube.validate_Position[i][j][k]);

						System.out.println(cube.validate_Orientation[i][j][k]);
					}	
				}
			}

		}
		
		//System.out.println("Count"+"="+count+"testing finish");*/







}
}

/*package zeel;

//import java.util.Random;



public class TestRubiksCube {
public static void main(String[] args) throws Exception {
		
		System.out.println("start testing");
		RubiksCube cube=new RubiksCube(3);
		cube.performMove("RbLUlBDbUr");
	//	cube.displayRubiksCube();
		String s="";
		s=cube.setPlus()+cube.setCorner();
		System.out.println(s);
		String s1=cube.setMiddleLayer();
		String s2=cube.setLastLayerPlus();
		String s3=cube.setLastLayerEdge();
		String s4=cube.setLastLayerCorner();
		String s5=cube.setLasteLayerCornerOrientation();
		//s=cube.setCorner();
		System.out.println("middle laye move"+s1);
		System.out.println("setLastLayerPlus"+s2);
		System.out.println("set LastLayerEdge"+s3);
		System.out.println("set LastLayerCorner"+s4);
		System.out.println("set LastLayerCornerOrientation"+s5);
		cube.displayRubiksCube();
		//System.out.println(cube.translation((cube.translation("URulUruL", 'R')),'R'));
		//System.out.println(cube.translation(cube.translation(cube.translation("URulUruL", 'R'),'R')));
		//cube.setLastLayerCorner();
		//cube.updatePositionAndOrientation();

				//cube.performMove("LUbURrrUDbUbDlUBdFrFbUfUddLrU");
		//cube.performMove("LRlrUDBFFlrfbD");
		//cube.performMove("FRU");
		//cube.performMove("R");

		//	cube.performMove("RRdfRRbRUUrrfbfrulLbfdrdfr");
		//cube.performMove("lRUfLFFll");
		//cube.performMove("RDUrUURfDbbLFURR");//case 5 solved

//		cube.displayRubiksCube();
	//	cube.performMove("DBFRbfl");
		//cube.updatePositionAndOrientation();
		//cube.displayRubiksCube();
		//cube.displayOrientationandPlace();
		//int a=cube.isEdgeCornerCenter(2, 2, 2);
		//System.out.println(a);
	//	cube.performMove("FfUu");
		//cube.performMove("f");
		//System.out.println(cube.translation(cube.translation("FRUrufUUFURurf", 'R'), 'R'));
		//cube.setLastLayerPlus();
		/*String str="FBUDLRfbudlr";
		char[] arr=new char[10];
		Random rand=new Random();
		int ran;
		int count=0;
		String move="";
		for(int j=0;j<100;j++) {
		for(int i=0;i<10;i++) {
			ran=rand.nextInt(12);
			arr[i]=str.charAt(ran);
			 move=new String(arr);
		}
		}	cube.performMove(move);
			*/
		//cube.performMove("LddBdbRBuRULLBRBrrUbULUDlrLDBfUBfBULDuDRuBRDBB");
		//cube.performMove("RfBdRLFuLDFRlBuRUfLDL");

		//cube.performMove("LRdbLLrRRUdURfRUlUBfRBDlDBDLrufbbdFdUfb");
		//cube.performMove("RfRLbLUUBdlBRBfBBuBDLDbDFBFRRLuLDlBU");
		//cube.displayOrientationandPlace();
		//cube.displayRubiksCube();
	//	cube.performMove("LBlBD");
		/*1cube.updatePositionAndOrientation();
		cube.displayRubiksCube();
		for(int i = 0;i<3;i++) {

			for(int j = 0;j<3;j++) {

				for(int k = 0;k<3;k++) {

					System.out.println(i+" "+j+" "+k);
					System.out.println(cube.validate_Position[i][j][k]);

					System.out.println(cube.validate_Orientation[i][j][k]);
				}	
			}
		}*/
		//cube.validate_Orientation
	//	Coordinate coordinate=new Coordinate(2,1,2);
		//Coordinate[] coordinates=cube.adjacentCorrdinate(coordinate);
		//coordinates[0].Display();
		//coordinates[1].Display();
		//cube.displayRubiksCube();
		//cube.performMove("");
		//String s=cube.translation("DFdfRfrF", 'U');
	//	System.out.println(move);
		//performMove(translation(translation("DFdfRfrF",'U'),'U'));
		//cube.displayRubiksCube();
			/*cube.setPlus();
			cube.setCorner();
		//	cube.updatePositionAndOrientation();
			if(cube.isFirstLayerSolved()) {
				System.out.println("Set plus");
			}
			cube.setMiddleLayer();
			//cube.updatePositionAndOrientation();
			if(cube.isSecondLayerSolved()) {
				System.out.println("Second layer solved");}
			//cube.displayRubiksCube();
			cube.setLastLayerPlus();
			System.out.println("3rd layer set plus");
			cube.setLastLayerEdge();
		//	cube.updatePositionAndOrientation();
			if(cube.isLastLayerSolved()) {
				System.out.println("Third layer  solved now display");
			}
		//	cube.setLastLayerCorner();
			//cube.updatePositionAndOrientation();
			//if(cube.isLastLayerCorner()) {
			//	System.out.println("Third layer corner solved now display");
			//}
			//cube.orientLastLayerCorner();
			//System.out.println("In testRubiks cube");
			//System.out.println("Third layer plus set");
			
			//cube.updatePositionAndOrientation();
			//cube.performMove("D");
			//cube.performMove("FFdRlffLrdff");
			if(cube.isLastLayerSolved()) {
				System.out.println("Third layer edges are in Right position");
			}
			
			//cube.displayRubiksCube();
			//cube.displayOrientationandPlace();
			cube.setLastLayerEdge();
//			cube.setLastLayerCorner();
			cube.setLasteLayerCornerOrientation();
			
			cube.displayRubiksCube();
			cube.displayOrientationandPlace();
		//	cube.displayRubiksCube();
			/*for(int i = 0;i<3;i++) {

				for(int j = 0;j<3;j++) {

					for(int k = 0;k<3;k++) {

					//	System.out.println(i+" "+j+" "+k+" "+cube.isEdgeCornerCenter(i, j, k));
						System.out.println(cube.validate_Position[i][j][k]);

						System.out.println(cube.validate_Orientation[i][j][k]);
					}	
				}
			}

		}
		
		//System.out.println("Count"+"="+count+"testing finish");







}
}
*/
/*package zeel;

//import java.util.Random;



public class TestRubiksCube {
public static void main(String[] args) throws Exception {
		
		System.out.println("start testing");
		RubiksCube cube=new RubiksCube(3);
		//cube.performMove("RbLUlBDbUr");
	//	cube.displayRubiksCube();
		String s="";
		s=cube.setPlus()+cube.setCorner();
		System.out.println(s);
		String s1=cube.setMiddleLayer();
		String s2=cube.setLastLayerPlus();
		String s3=cube.setLastLayerEdge();
		String s4=cube.setLastLayerCorner();
		String s5=cube.setLasteLayerCornerOrientation();
		//s=cube.setCorner();
		System.out.println("middle laye move"+s1);
		System.out.println("setLastLayerPlus"+s2);
		System.out.println("set LastLayerEdge"+s3);
		System.out.println("set LastLayerCorner"+s4);
		System.out.println("set LastLayerCornerOrientation"+s5);
		cube.displayRubiksCube();
}
}
		//System.out.println(cube.translation((cube.translation("URulUruL", 'R')),'R'));
		//System.out.println(cube.translation(cube.translation(cube.translation("URulUruL", 'R'),'R')));
		//cube.setLastLayerCorner();
		//cube.updatePositionAndOrientation();

				//cube.performMove("LUbURrrUDbUbDlUBdFrFbUfUddLrU");
		//cube.performMove("LRlrUDBFFlrfbD");
		//cube.performMove("FRU");
		//cube.performMove("R");

		//	cube.performMove("RRdfRRbRUUrrfbfrulLbfdrdfr");
		//cube.performMove("lRUfLFFll");
		//cube.performMove("RDUrUURfDbbLFURR");//case 5 solved

//		cube.displayRubiksCube();
	//	cube.performMove("DBFRbfl");
		//cube.updatePositionAndOrientation();
		//cube.displayRubiksCube();
		//cube.displayOrientationandPlace();
		//int a=cube.isEdgeCornerCenter(2, 2, 2);
		//System.out.println(a);
	//	cube.performMove("FfUu");
		//cube.performMove("f");
		//System.out.println(cube.translation(cube.translation("FRUrufUUFURurf", 'R'), 'R'));
		//cube.setLastLayerPlus();
		/*String str="FBUDLRfbudlr";
		char[] arr=new char[10];
		Random rand=new Random();
		int ran;
		int count=0;
		String move="";
		for(int j=0;j<100;j++) {
		for(int i=0;i<10;i++) {
			ran=rand.nextInt(12);
			arr[i]=str.charAt(ran);
			 move=new String(arr);
		}
		}	cube.performMove(move);
			*/
		//cube.performMove("LddBdbRBuRULLBRBrrUbULUDlrLDBfUBfBULDuDRuBRDBB");
		//cube.performMove("RfBdRLFuLDFRlBuRUfLDL");

		//cube.performMove("LRdbLLrRRUdURfRUlUBfRBDlDBDLrufbbdFdUfb");
		//cube.performMove("RfRLbLUUBdlBRBfBBuBDLDbDFBFRRLuLDlBU");
		//cube.displayOrientationandPlace();
		//cube.displayRubiksCube();
	//	cube.performMove("LBlBD");
		/*1cube.updatePositionAndOrientation();
		cube.displayRubiksCube();
		for(int i = 0;i<3;i++) {

			for(int j = 0;j<3;j++) {

				for(int k = 0;k<3;k++) {

					System.out.println(i+" "+j+" "+k);
					System.out.println(cube.validate_Position[i][j][k]);

					System.out.println(cube.validate_Orientation[i][j][k]);
				}	
			}
		}*/
		//cube.validate_Orientation
	//	Coordinate coordinate=new Coordinate(2,1,2);
		//Coordinate[] coordinates=cube.adjacentCorrdinate(coordinate);
		//coordinates[0].Display();
		//coordinates[1].Display();
		//cube.displayRubiksCube();
		//cube.performMove("");
		//String s=cube.translation("DFdfRfrF", 'U');
	//	System.out.println(move);
		//performMove(translation(translation("DFdfRfrF",'U'),'U'));
		//cube.displayRubiksCube();
			/*cube.setPlus();
			cube.setCorner();
		//	cube.updatePositionAndOrientation();
			if(cube.isFirstLayerSolved()) {
				System.out.println("Set plus");
			}
			cube.setMiddleLayer();
			//cube.updatePositionAndOrientation();
			if(cube.isSecondLayerSolved()) {
				System.out.println("Second layer solved");}
			//cube.displayRubiksCube();
			cube.setLastLayerPlus();
			System.out.println("3rd layer set plus");
			cube.setLastLayerEdge();
		//	cube.updatePositionAndOrientation();
			if(cube.isLastLayerSolved()) {
				System.out.println("Third layer  solved now display");
			}
		//	cube.setLastLayerCorner();
			//cube.updatePositionAndOrientation();
			//if(cube.isLastLayerCorner()) {
			//	System.out.println("Third layer corner solved now display");
			//}
			//cube.orientLastLayerCorner();
			//System.out.println("In testRubiks cube");
			//System.out.println("Third layer plus set");
			
			//cube.updatePositionAndOrientation();
			//cube.performMove("D");
			//cube.performMove("FFdRlffLrdff");
			if(cube.isLastLayerSolved()) {
				System.out.println("Third layer edges are in Right position");
			}
			
			//cube.displayRubiksCube();
			//cube.displayOrientationandPlace();
			cube.setLastLayerEdge();
//			cube.setLastLayerCorner();
			cube.setLasteLayerCornerOrientation();
			
			cube.displayRubiksCube();
			cube.displayOrientationandPlace();
		//	cube.displayRubiksCube();
			/*for(int i = 0;i<3;i++) {

				for(int j = 0;j<3;j++) {

					for(int k = 0;k<3;k++) {

					//	System.out.println(i+" "+j+" "+k+" "+cube.isEdgeCornerCenter(i, j, k));
						System.out.println(cube.validate_Position[i][j][k]);

						System.out.println(cube.validate_Orientation[i][j][k]);
					}	
				}
			}

		}
		
		//System.out.println("Count"+"="+count+"testing finish");*/










/*package zeel;


import java.util.Random;
 
//import java.util.Random;
public class TestRubiksCube {
public static void main(String[] args) throws Exception {
		
		System.out.println("start testing");
		RubiksCube cube=new RubiksCube(3);
		//System.out.println(cube.translation((cube.translation("rdRD", 'R')),'R'));
		//System.out.println(cube.translation(cube.translation(cube.translation("URulUruL", 'R'),'R')));
		//cube.setLastLayerCorner();
		//cube.updatePositionAndOrientation();

		//		cube.performMove("LRfRUbURrrUdDbBBUbDlUBdFBrFbUfBURLRddLrU");
	//	cube.performMove("lRUfLffll");
		//cube.performMove("FRU");
		//cube.performMove("R");
		int count = 0;
		for(int i=0;i<10;i++) {
			char[]arr = new char[40];
		
		Random r=new Random();
		String str = "FRBULDdlubrf";
//		int rand=r.nextInt(12);
		for(int k=0;k<40;k++) {

			int rand=r.nextInt(12);
			arr[k]=str.charAt(rand);
		}
		//System.out.println(move);
		String move= new String(arr);
		System.out.println(move);
		cube.performMove(move);
		cube.setPlus();
		cube.setCorner();
		cube.setMiddleLayer();
		cube.setLastLayerPlus();
		cube.setLastLayerEdge();
		cube.setLastLayerCorner();
		cube.setLasteLayerCornerOrientation();
		if(cube.isSolved()) {
			count++;
		}
		}
		System.out.println("Count ="+count);
		//	cube.performMove("RLRdfRRbRUUrrfbfrulLbfdBrdfr");
	//	cube.performMove("FRURurddbf");
	//	cube.performMove("RDUrUURfDbbLFURR");//case 5 solved
//		cube.displayRubiksCube();
	//	cube.performMove("DBFRbfl");
		//cube.updatePositionAndOrientation();
		//cube.displayRubiksCube();
		//cube.displayOrientationandPlace();
		//int a=cube.isEdgeCornerCenter(2, 2, 2);
		//System.out.println(a);
	//	cube.performMove("FfUu");
		//cube.performMove("f");
		//System.out.println(cube.translation(cube.translation("FRUrufUUFURurf", 'R'), 'R'));
		//cube.setLastLayerPlus();
	/*	String str="FBUDLRfbudlr";
		char[] arr=new char[10];
		Random rand=new Random();
		int ran;
		int count=0;
		String move="";
		for(int j=0;j<100;j++) {
		for(int i=0;i<10;i++) {
			ran=rand.nextInt(12);
			arr[i]=str.charAt(ran);
			 move=new String(arr);
		}
			cube.performMove(move);
		}*/
			
		//cube.performMove("LddBdbRBuRULLBRBrrUbULUDlrLDBfUBfBULDuDRuBRDBB");
		//cube.performMove("RfBdRLFuLDFRlBuRUfLDL");

		//cube.performMove("LRdbLLrRRUdURfRUlUBfRBDlDBDLrufbbdFdUfb");
		//cube.performMove("RfRLbLUUBdlBRBfBBuBDLDbDFBFRRLuLDlBU");
		//cube.displayOrientationandPlace();
		//cube.displayRubiksCube();
	//	cube.performMove("LBlBD");
		/*1cube.updatePositionAndOrientation();
		cube.displayRubiksCube();
		for(int i = 0;i<3;i++) {

			for(int j = 0;j<3;j++) {

				for(int k = 0;k<3;k++) {

					System.out.println(i+" "+j+" "+k);
					System.out.println(cube.validate_Position[i][j][k]);

					System.out.println(cube.validate_Orientation[i][j][k]);
				}	
			}
		}*/
		//cube.validate_Orientation
	//	Coordinate coordinate=new Coordinate(2,1,2);
		//Coordinate[] coordinates=cube.adjacentCorrdinate(coordinate);
		//coordinates[0].Display();
		//coordinates[1].Display();
		//cube.displayRubiksCube();
		//cube.performMove("");
		//String s=cube.translation("DFdfRfrF", 'U');
	//	System.out.println(move);
		//performMove(translation(translation("DFdfRfrF",'U'),'U'));
		//cube.displayRubiksCube();
			/*cube.setPlus();
			cube.setCorner();
			cube.updatePositionAndOrientation();
			if(cube.isFirstLayerSolved()) {
				System.out.println("Set plus");
			}
			cube.setMiddleLayer();
			cube.updatePositionAndOrientation();
			if(cube.isSecondLayerSolved()) {
				System.out.println("Second layer solved");}
			cube.displayRubiksCube();
			cube.setLastLayerPlus();
		//	cube.displayRubiksCube();
			cube.setLastLayerEdge();
			cube.updatePositionAndOrientation();
			
			cube.displayRubiksCube();
			if(cube.isLastLayerSolved()) {
				System.out.println("Third layer plus  solved now display");
			}
			cube.setLastLayerCorner();
			cube.updatePositionAndOrientation();
			if(cube.isLastLayerCorner()) {
				System.out.println("Third layer corner solved now display");
			}*/
//			cube.displayRubiksCube();
//			
		//	cube.setLasteLayerCornerOrientation();
			//System.out.println("In testRubiks cube");
//			//System.out.println("Third layer plus set");
//			
//			//cube.updatePositionAndOrientation();
//			//cube.performMove("D");
//			//cube.performMove("FFdRlffLrdff");
//			//cube.displayRubiksCube();
//			//cube.displayOrientationandPlace();
//
			//cube.displayRubiksCube();
			//cube.displayOrientationandPlace();
			//}
//		//	cube.displayRubiksCube();
//			/*for(int i = 0;i<3;i++) {
//
//				for(int j = 0;j<3;j++) {
//
//					for(int k = 0;k<3;k++) {
//
//					//	System.out.println(i+" "+j+" "+k+" "+cube.isEdgeCornerCenter(i, j, k));
//						System.out.println(cube.validate_Position[i][j][k]);
//
//						System.out.println(cube.validate_Orientation[i][j][k]);
//					}	
//				}
//			}
//
//		}
//		
//		//System.out.println("Count"+"="+count+"testing finish");*/
//
//
//
//
//




