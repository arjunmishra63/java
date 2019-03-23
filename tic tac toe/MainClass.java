import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MainClass extends JFrame
{
	JPanel board = new JPanel();
	JPanel top = new JPanel();
	Font fo = new Font("arial",0,30);
	JLabel bg = new JLabel(new ImageIcon(getClass().getResource("imgs/t2.jpg")));
	public MainClass()
	{
		super("Tic Tac Toe");
		setSize(600,640);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(new Color(200,200,255));
		bg.setBounds(0,0,600,640);
		add(bg);
		bg.setLayout(null);
		board.setBounds(100,120,400,400);
		board.setBorder(BorderFactory.createLineBorder(Color.red,3));
		bg.add(board);
		top.setBackground(new Color(200,200,255));
		top.setBounds(100,40,400,40);
		bg.add(top);
		top.add(Va.msg);
		Va.msg.setFont(fo);
		Va.reset.setFont((new Font("arial",0,20)));
		Va.reset.setBounds(250,540,100,30);
		bg.add(Va.reset);
		Va.reset.addActionListener( new NewGameListener());
		addButtons();
		setVisible(true);
	}
	//--------------------------------------------
	
	void addButtons()
	{
		board.setLayout(new GridLayout(3,3));
		Font fo = new Font("elephant",1,30);
		Border b = BorderFactory.createLineBorder(Color.red,3);
		TicListener listener = new TicListener();
		for(int i = 0;i<3;i++)
		{
			for(int j = 0;j<3; j++)
			{
				Va.bt[i][j]= new MButton();
				Va.bt[i][j].addActionListener(listener);
				Va.bt[i][j].setFont(fo);
				Va.bt[i][j].setForeground(Color.blue);
				Va.bt[i][j].setBackground(Color.green);
				Va.bt[i][j].setBorder(b);
				board.add(Va.bt[i][j]);
			}
		}
	}
	
	
	//-----------------------------------
	class TicListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			MButton bc = (MButton)evt.getSource();
			if(bc.img ||Va.user1 ==1|| Va.user2 ==1)
				return;
			
			if(Va.user==0)
				bc.setIcon(new ImageIcon(getClass().getResource("imgs/user1.png")));
			
			else
				bc.setIcon(new ImageIcon(getClass().getResource("imgs/user2.png")));
			
			bc.ui=Va.user;
			Va.tie++;
			Va.user = 1-Va.user;
			bc.img = true;
			Va.msg.setText("Player " + (Va.user+1) +" turn ....");
			checkWinner();
			if(Va.user1 == 1)
			{
				Va.msg.setText("player 1 is winner");
			}
			else if(Va.user2 == 1)
			{
				Va.msg.setText(" player 2 is winner");
			}
			if(Va.tie == 9 && Va.user == 0 && Va.user2 == 0)
			{
				Va.msg.setText("Sorry its a tie");
			}
		}
	}
	//--------------------------------	
		
	void checkWinner()
	{
		for(int i = 0;i<3; i++)
		{
			if(Va.bt[i][0].ui == 0&& Va.bt[i][1].ui == 0&& 
			Va.bt[i][2].ui==0)
			{
				Va.user1 = 1;
			}
			if(Va.bt[i][0].ui == 1&& Va.bt[i][1].ui == 1&& 
			Va.bt[i][2].ui==1)
			{
				Va.user2 = 1;
			}
			if(Va.user1 == 1 || Va.user2 == 1)
			{
				Va.bt[i][0].setBackground(Color.gray);
				Va.bt[i][1].setBackground(Color.gray);
				Va.bt[i][2].setBackground(Color.gray);
				return;
			}
		}
		
		for(int i = 0; i<3; i++)
		{
			if(Va.bt[0][i].ui == 0&& Va.bt[1][i].ui == 0&& 
			Va.bt[2][i].ui==0)
			{
				Va.user1 = 1;
			}
			if(Va.bt[0][i].ui == 1&& Va.bt[1][i].ui == 1&& 
			Va.bt[2][i].ui==1)
			{
				Va.user2 = 1;
			}
			if(Va.user1 == 1 || Va.user2 == 1)
			{
				Va.bt[0][i].setBackground(Color.gray);
				Va.bt[1][i].setBackground(Color.gray);
				Va.bt[2][i].setBackground(Color.gray);
				return;
			}
		}
		
		
	    if(Va.bt[0][0].ui == 0&& Va.bt[1][1].ui == 0&& 
			Va.bt[2][2].ui==0)
	        {
				Va.user1 = 1;
			}
		if(Va.bt[0][0].ui == 1&& Va.bt[1][1].ui == 1&& 
			Va.bt[2][2].ui==1)
			{
				Va.user2 = 1;
			}
		if(Va.user1 == 1 || Va.user2 == 1)
			{
				Va.bt[0][0].setBackground(Color.gray);
				Va.bt[1][1].setBackground(Color.gray);
				Va.bt[2][2].setBackground(Color.gray);
				return;
			}
			//----------------
			if(Va.bt[0][2].ui == 0&& Va.bt[1][1].ui == 0&& 
			Va.bt[2][0].ui==0)
			{
				Va.user1 = 1;
			}
		if(Va.bt[0][2].ui == 1&& Va.bt[1][1].ui == 1&& 
			Va.bt[2][0].ui==1)
			{
				Va.user2 = 1;
			}
		if(Va.user1 == 1 || Va.user2 == 1)
			{
				Va.bt[0][2].setBackground(Color.gray);
				Va.bt[1][1].setBackground(Color.gray);
				Va.bt[2][0].setBackground(Color.gray);
				return;
			}
	}
		
	//-----------------------------------------		    
	public static void main(String[] args)
	{
		setDefaultLookAndFeelDecorated(true);
		new MainClass();
	}
}

			
			
	
		
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				