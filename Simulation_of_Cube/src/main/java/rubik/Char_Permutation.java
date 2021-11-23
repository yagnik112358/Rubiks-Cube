package rubik;

public class Char_Permutation {
	public String input="";
	public String move="";
	public int move_length;
	public String permutation(int num) {
	//	System.out.println("Permutation called"+num+" "+input.length()+"   move is"+move+""+power(input.length(),move_length));
		//int x=move_length;
		if((num<power(input.length(),move_length))&&move_length>0) {
			//System.out.println("inside if");
			int temp=num%input.length();
			char c=input.charAt(temp);
			move=move.concat(""+c);
			move_length=move_length-1;
			//System.out.println("inside if move =="+move);
			
			return this.permutation(num/input.length());
		}
		else {
			return move;
		}
	}
	public static int power(int x,int y) {
		int temp=1;
		for(int i=0;i<y;i++) {
			temp=temp*x;
		}
		return temp;
	}
	

}
