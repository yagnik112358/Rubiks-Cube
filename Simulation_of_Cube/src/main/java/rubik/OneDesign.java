package rubik;
import java.awt.Color;
import java.awt.EventQueue;
//import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OneDesign {
	RubiksCube cube=new RubiksCube(3);
	private JFrame frame;
	Color backgroundColor;
	private final JButton SubmitButton = new JButton("New button");
	JButton []buttons = new JButton[7];
	JButton [][]ButtonsF = new JButton[3][3];
	JButton [][]buttonsR = new JButton[3][3];
	JButton [][]buttonsL = new JButton[3][3];
	JButton [][]buttonsB = new JButton[3][3];
	JButton [][]buttonsD = new JButton[3][3];
	JButton [][]buttonsU = new JButton[3][3];
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OneDesign window = new OneDesign();
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
	public OneDesign() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0,0,2000,1000);
		frame.setBackground(Color.BLACK);
		//JButton button=new JButton("Hello");
		frame.getContentPane().setLayout(null);
		/*JButton []buttons = new JButton[7];
		JButton [][]buttonsF = new JButton[3][3];
		JButton [][]buttonsR = new JButton[3][3];
		JButton [][]buttonsL = new JButton[3][3];
		JButton [][]buttonsB = new JButton[3][3];
		JButton [][]buttonsD = new JButton[3][3];
		JButton [][]buttonsU = new JButton[3][3];*/
		SubmitButton.setBounds(0,0,60,60);
		SubmitButton.setBackground(Color.DARK_GRAY);
		SubmitButton.setVisible(true);
		SubmitButtonActionListener sb=new SubmitButtonActionListener();
		SubmitButton.addActionListener(sb);
		frame.getContentPane().add(SubmitButton);
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
				ButtonsF[i][j].setBounds(i*50+800,j*50+450,40,40);
				ButtonsF[i][j].setVisible(true);
				ButtonsF[i][j].setBackground(Color.ORANGE);
				ButtonFActionListener bf=new ButtonFActionListener();
				ButtonsF[i][j].addActionListener(bf);
				frame.getContentPane().add(ButtonsF[i][j]);
			}
		}
		for(int i =0; i<3;i++) {
			for(int j=0;j<3;j++) {
				buttonsB[i][j]=new JButton();
				buttonsB[i][j].setBounds(i*50+1000,j*50+450,40,40);
				buttonsB[i][j].setVisible(true);
				ButtonBActionListener bb=new ButtonBActionListener();
				buttonsB[i][j].addActionListener(bb);
				buttonsB[i][j].setBackground(Color.GREEN);
				frame.getContentPane().add(buttonsB[i][j]);
			}
		}
		for(int i =0; i<3;i++) {
			for(int j=0;j<3;j++) {
				buttonsR[i][j]=new JButton();
				buttonsR[i][j].setBounds(i*50+1200,j*50+450,40,40);
				buttonsR[i][j].setVisible(true);
				ButtonRactionListener br=new ButtonRactionListener();
				buttonsR[i][j].addActionListener(br);
				buttonsR[i][j].setBackground(Color.RED);
				frame.getContentPane().add(buttonsR[i][j]);
			}
		}
		for(int i =0; i<3;i++) {
			for(int j=0;j<3;j++) {
				buttonsL[i][j]=new JButton();
				buttonsL[i][j].setBounds(i*50+1400,j*50+450,40,40);
				buttonsL[i][j].setVisible(true);
				ButtonLActionListener bl=new ButtonLActionListener();
				buttonsL[i][j].addActionListener(bl);
				buttonsL[i][j].setBackground(Color.BLUE);
				frame.getContentPane().add(buttonsL[i][j]);
			}
		}
		for(int i =0; i<3;i++) {
			for(int j=0;j<3;j++) {
				buttonsU[i][j]=new JButton();
				buttonsU[i][j].setBounds(i*50+1200,j*50+250,40,40);
				buttonsU[i][j].setVisible(true);
				ButtonUactionListener bu=new ButtonUactionListener();
				buttonsU[i][j].addActionListener(bu);
				buttonsU[i][j].setBackground(Color.WHITE);
				frame.getContentPane().add(buttonsU[i][j]);
			}
		}
		for(int i =0; i<3;i++) {
			for(int j=0;j<3;j++) {
				buttonsD[i][j]=new JButton();
				buttonsD[i][j].setBounds(i*50+1200,j*50+650,40,40);
				buttonsD[i][j].setVisible(true);
				buttonsD[i][j].setBackground(Color.YELLOW);
				ButtonDActionListener bd=new ButtonDActionListener();
				buttonsD[i][j].addActionListener(bd);
				frame.getContentPane().add(buttonsD[i][j]);
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
	public class ButtonBActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton src=(JButton)e.getSource();
			for(int i=0;i<buttonsB.length;i++) {
				for(int j=0;j<buttonsB[i].length;j++) {
					if(src==buttonsB[i][j]) {
						buttonsB[i][j].setBackground(backgroundColor);
					}
				}
			}
		}
	}
	public class ButtonUactionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton src=(JButton)e.getSource();
			for(int i=0;i<buttonsU.length;i++) {
				for(int j=0;j<buttonsU[i].length;j++) {
					if(src==buttonsU[i][j]) {
						buttonsU[i][j].setBackground(backgroundColor);
					}
				}
			}
		}
	}
	public class ButtonRactionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton src=(JButton)e.getSource();
			for(int i=0;i<buttonsR.length;i++) {
				for(int j=0;j<buttonsR[i].length;j++) {
					if(src==buttonsR[i][j]) {
						buttonsR[i][j].setBackground(backgroundColor);
					}
				}
			}
		}
	}
	public rubik.RubiksCubeColor Conversion(java.awt.Color  c) {
		rubik.RubiksCubeColor temp;
		temp= rubik.RubiksCubeColor.valueOf(c.toString());
		return temp;
	}
	public class ButtonLActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton src=(JButton)e.getSource();
			for(int i=0;i<buttonsL.length;i++) {
				for(int j=0;j<buttonsL[i].length;j++) {
					if(src==buttonsL[i][j]) {
						buttonsL[i][j].setBackground(backgroundColor);
					}
				}
			}
		}
	}
	public class ButtonFActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton src=(JButton)e.getSource();
			for(int i=0;i<ButtonsF.length;i++) {
				for(int j=0;j<ButtonsF[i].length;j++) {
					if(src==ButtonsF[i][j]) {
						try {
							System.out.println("in button f action listener");
							System.out.println(i+" "+j+" "+backgroundColor);
//							cube.setValuesCubic(i, j, 0,Conversion(backgroundColor));
						}
						catch(Exception e1) {
							e1.printStackTrace();
						}
						//ButtonsF[i][j].setBackground(backgroundColor);
					}
				}
			}
		}
	}
	public class ButtonDActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton src=(JButton)e.getSource();
			for(int i=0;i<buttonsD.length;i++) {
				for(int j=0;j<buttonsD[i].length;j++) {
					if(src==buttonsD[i][j]) {
						try {
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
