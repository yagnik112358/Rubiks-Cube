package rubik;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Gui {

	private JFrame frame;
	public RubiksCube cube=new RubiksCube(3);
	static Color backgroundColor;
	public JLabel label=new JLabel();
	public JButton SubmitButton = new JButton("SUBMIT");
	JButton []buttons = new JButton[7];
	JButton [][]ButtonsF = new JButton[3][3];
	JButton [][]ButtonsR = new JButton[3][3];
	JButton [][]ButtonsL = new JButton[3][3];
	JButton [][]ButtonsB = new JButton[3][3];
	JButton [][]ButtonsD = new JButton[3][3];
	JButton [][]ButtonsU = new JButton[3][3];
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
//					System.out.println("Color"+RubiksCubeColor.BLACK.RGBValues((Color.BLACK).getRed(),(Color.BLACK).getGreen(),(Color.BLACK).getBlue()));
					System.out.println("color conversion"+(window.Conversion(Color.BLACK)));
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 2000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		SubmitButton.setBounds(800,800,90,60);
		SubmitButton.setBackground(Color.magenta);
		SubmitButton.setVisible(true);
		SubmitButtonActionListener sb=new SubmitButtonActionListener();
		SubmitButton.addActionListener(sb);
		frame.getContentPane().add(SubmitButton);
		label.setBounds(1000, 100, 1000, 20);
		Font font=Font.getFont("Times New Roman");
//		font=Font.BOLD;
		label.setFont(font);
		String s=cube.SolveRubiksCube();
		label.setText(s);
		frame.getContentPane().add(label);
		for(int i=0;i<7;i++) {
			buttons[i]=new JButton();
			buttons[i].setBounds(200,i*70+250,60,60);
			buttons[i].setVisible(true);
			ButtonsActionListener bd=new ButtonsActionListener();
			buttons[i].addActionListener(bd);
			frame.getContentPane().add(buttons[i]);
		}
		buttons[0].setBackground(Color.WHITE);
		buttons[1].setBackground(Color.YELLOW);
		buttons[2].setBackground(Color.BLUE);
		buttons[3].setBackground(Color.GREEN);
		buttons[4].setBackground(Color.RED);
		buttons[5].setBackground(Color.ORANGE);
		buttons[6].setBackground(Color.BLACK);
		
		for(int i =0; i<3;i++) {
			for(int j=0;j<3;j++) {
				ButtonsF[i][j]=new JButton();
				ButtonsF[i][j].setBounds(i*50+1200,j*50+450,40,40);
				ButtonsF[i][j].setVisible(true);
				ButtonsF[i][j].setBackground(Color.RED);
				FrontActionListener bf=new FrontActionListener();
				ButtonsF[i][j].addActionListener(bf);
				frame.getContentPane().add(ButtonsF[i][j]);
			}
		}
		for(int i =0; i<3;i++) {
			for(int j=0;j<3;j++) {
				ButtonsB[i][j]=new JButton();
				ButtonsB[i][j].setBounds(i*50+800,j*50+450,40,40);
				ButtonsB[i][j].setVisible(true);
				BackActionListener bb=new BackActionListener();
				ButtonsB[i][j].addActionListener(bb);
				ButtonsB[i][j].setBackground(Color.ORANGE);
				frame.getContentPane().add(ButtonsB[i][j]);
			}
		}
		for(int i =0; i<3;i++) {
			for(int j=0;j<3;j++) {
				ButtonsR[i][j]=new JButton();
				ButtonsR[i][j].setBounds(i*50+1400,j*50+450,40,40);
				ButtonsR[i][j].setVisible(true);
				RightActionListener br=new RightActionListener();
				ButtonsR[i][j].addActionListener(br);
				ButtonsR[i][j].setBackground(Color.BLUE);
				frame.getContentPane().add(ButtonsR[i][j]);
			}
		}
		for(int i =0; i<3;i++) {
			for(int j=0;j<3;j++) {
				ButtonsL[i][j]=new JButton();
				ButtonsL[i][j].setBounds(i*50+1000,j*50+450,40,40);
				ButtonsL[i][j].setVisible(true);
				LeftActionListener bl=new LeftActionListener();
				ButtonsL[i][j].addActionListener(bl);
				ButtonsL[i][j].setBackground(Color.GREEN);
				frame.getContentPane().add(ButtonsL[i][j]);
			}
		}
		for(int i =0; i<3;i++) {
			for(int j=0;j<3;j++) {
				ButtonsU[i][j]=new JButton();
				ButtonsU[i][j].setBounds(i*50+1200,j*50+250,40,40);
				ButtonsU[i][j].setVisible(true);
				UpActionListener bu=new UpActionListener();
				ButtonsU[i][j].addActionListener(bu);
				ButtonsU[i][j].setBackground(Color.WHITE);
				frame.getContentPane().add(ButtonsU[i][j]);
			}
		}
		for(int i =0; i<3;i++) {
			for(int j=0;j<3;j++) {
				ButtonsD[i][j]=new JButton();
				ButtonsD[i][j].setBounds(i*50+1200,j*50+650,40,40);
				ButtonsD[i][j].setVisible(true);
				ButtonsD[i][j].setBackground(Color.YELLOW);
				DownActionListener bd=new DownActionListener();
				ButtonsD[i][j].addActionListener(bd);
				frame.getContentPane().add(ButtonsD[i][j]);
			}
		}

			
		/*for(int i =0; i<7;i++) {
			for(int j=0;j<7;j++) {
				int k =(i*7+j);
			buttons[k]=new JButton();
			buttons[k].setBounds(i*40,k*40,40,40);
	//		buttons[i].setAlignmentX(i);
			buttons[k].setVisible(true);
			buttons[k].setBackground(Color.GRAY);
			//buttons[i].setSize(40,40);
		//	buttons[i].setAlignmentY(i*10+j);
			frame.getContentPane().add(buttons[i*7+j]);
			}
		}*/
//		frame.getContentPane().add(button);
//		btnNewButton.setBounds(35, 126, 162, 36);
//		frame.getContentPane().add(btnNewButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public class BackActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton src=(JButton)e.getSource();
			for(int i=0;i<ButtonsB.length;i++) {
				for(int j=0;j<ButtonsB[i].length;j++) {
					if(src==ButtonsB[i][j]) {
						try {
							cube.cubes[i][j][2]=cube.setValueCubicGui(i, j, 2, Side.BACK, Conversion(backgroundColor));
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						ButtonsB[i][j].setBackground(backgroundColor);
					}
				}
			}
		}
	}
	public class UpActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton src=(JButton)e.getSource();
			for(int i=0;i<ButtonsU.length;i++) {
				for(int j=0;j<ButtonsU[i].length;j++) {
					if(src==ButtonsU[i][j]) {
						try {
							cube.cubes[i][2][j]=cube.setValueCubicGui(i, 2, j, Side.UP, Conversion(backgroundColor));
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						ButtonsU[i][j].setBackground(backgroundColor);
					}
				}
			}
		}
	}
	public class RightActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton src=(JButton)e.getSource();
			for(int i=0;i<ButtonsR.length;i++) {
				for(int j=0;j<ButtonsR[i].length;j++) {
					if(src==ButtonsR[i][j]) {
						try {
							cube.cubes[2][i][j]=cube.setValueCubicGui(2, i, j, Side.RIGHT, Conversion(backgroundColor));
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						ButtonsR[i][j].setBackground(backgroundColor);
					}
				}
			}
		}
	}
	public RubiksCubeColor Conversion(Color  c) {
		RubiksCubeColor temp=RubiksCubeColor.RGBValues(c.getRed(), c.getGreen(), c.getBlue());	
		for(RubiksCubeColor r : RubiksCubeColor.values()) {
			if(r.isEqual(temp)) {
				System.out.println(" inside conversion");
				return r;
			}
		}
		return temp;
		
		//temp=RubiksCubeColor.valueOf(c.toString());
	//	return temp;
	}
	public class LeftActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton src=(JButton)e.getSource();
			for(int i=0;i<ButtonsL.length;i++) {
				for(int j=0;j<ButtonsL[i].length;j++) {
					if(src==ButtonsL[i][j]) {
						try {
							cube.cubes[0][i][j]=cube.setValueCubicGui(0, i, j, Side.LEFT, Conversion(backgroundColor));
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						ButtonsL[i][j].setBackground(backgroundColor);
					}
				}
			}
		}
	}
	public class FrontActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton src=(JButton)e.getSource();
			for(int i=0;i<ButtonsF.length;i++) {
				for(int j=0;j<ButtonsF[i].length;j++) {
					if(src==ButtonsF[i][j]) {
						try {
							//System.out.println("in button f action listener");
							//System.out.println(i+" "+j+" "+backgroundColor);
							cube.cubes[i][j][0]=cube.setValueCubicGui(i, j, 0, Side.FRONT,Conversion(backgroundColor));
							//cube.displayRubiksCube();
						}
						catch(Exception e1) {
							e1.printStackTrace();
						}
						ButtonsF[i][j].setBackground(backgroundColor);
					}
				}
			}
		}
	}
	public class DownActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton src=(JButton)e.getSource();
			for(int i=0;i<ButtonsD.length;i++) {
				for(int j=0;j<ButtonsD[i].length;j++) {
					if(src==ButtonsD[i][j]) {
						try {
							//System.out.println("in button d action listener");
							cube.cubes[i][0][j]=cube.setValueCubicGui(i, 0, j, Side.DOWN, Conversion(backgroundColor));
//							cube.setValuesCubic(i, 0, j,Conversion(backgroundColor));
						}
						catch(Exception e1) {
							e1.printStackTrace();
						}
						
						//buttonsD[i][j].setBackground(backgroundColor);
					}
				}
			}
		}
	}
	public class ButtonsActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton src=(JButton)e.getSource();
			for(int i=0;i<buttons.length;i++) {
				if(src==buttons[i]) {
					backgroundColor=buttons[i].getBackground();
//					System.out.print(Conversion(backgroundColor));
				}
			}
		}
	}
	public class SubmitButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			cube.displayRubiksCube();
		}
	}


}


