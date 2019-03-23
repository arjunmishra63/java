import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class TicTacToe extends JFrame
{
  JButton [][] button=new JButton[3][3];
  JPanel  panel=new JPanel();
  JLabel turn=new JLabel("<html><h2 style='color:red'>First player turn</h2></html>");
  int user=0;
  public TicTacToe()
  {
	super("Tic Tac Toe");
	setSize(400,440);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(null);
	turn.setBounds(130,10,300,40);
	add(turn);
	panel.setBounds(50,60,300,300);
	add(panel);
	panel.setLayout(new GridLayout(3,3));
	TicTacToeListener listener=new TicTacToeListener();
	Font fo=new Font("arial",0,50);
	for(int i=0;i<3;i++)
   	{
          for(int j=0;j<3;j++)
	  {
	    button[i][j]=new JButton();
	    button[i][j].addActionListener(listener);
	    button[i][j].setFont(fo);
	    panel.add(button[i][j]);
	  }
	}
	setVisible(true);
  }
  class TicTacToeListener implements ActionListener
  {
    public void actionPerformed(ActionEvent evt)	
    {
	JButton bc=(JButton)evt.getSource();
	if(user==0)
	{
	  bc.setText("X");
	  turn.setText("<html><h2 style='color:red'>Second player turn</h2></html>");
	  user=1;
	}
	else
	{
	  bc.setText("0");
	  turn.setText("<html><h2 style='color:red'>First player turn</h2></html>");
	  user=0;
	}
	announceWinner(); 
    }
  }
  private void announceWinner()
  {
    for(int i=0;i<3;i++)
    {
      int uh1=0,uh2=0,uv1=0,uv2=0; 	
      for(int j=0;j<3;j++)
      {
	if(button[i][j].getText().equals("X"))
	  uh1++;
	else if(button[i][j].getText().equals("0"))
	  uh2++;
	if(button[j][i].getText().equals("X"))
	  uv1++;
	else if(button[j][i].getText().equals("0"))
	  uv2++;
      } 
      if(uh1==3 || uv1==3)
      { 	
	msg(i,"First",uv1);
	break;
      }	
      else if(uh2==3 || uv2==3)		
      {	
	msg(i,"Second",uv2);
	break;
      } 	
    }
    dg();	   	 	
  }
  void dg()
  {
    int ud1=0,ud2=0; 	
    for(int i=0;i<3;i++)
    {
	if(button[i][i].getText().equals("X"))
	  ud1++;
	if(button[i][i].getText().equals("0"))
	  ud2++;
	if(ud1==3)
	   JOptionPane.showMessageDialog(TicTacToe.this,"First player is winner"); 
	if(ud2==3)
	   JOptionPane.showMessageDialog(TicTacToe.this,"Second player is winner"); 
    }
    if(ud1!=3 && ud2!=3)
    { 		   	 		    	
    ud1=ud2=0; 	
    for(int i=0,j=2;i<3;i++,j--)
    {
	if(button[i][j].getText().equals("X"))
	  ud1++;
	if(button[i][j].getText().equals("0"))
	  ud2++;
	if(ud1==3)
	   JOptionPane.showMessageDialog(TicTacToe.this,"First player is winner"); 
	if(ud2==3)
	   JOptionPane.showMessageDialog(TicTacToe.this,"Second player is winner"); 
    }
    }
  }
  void msg(int i,String str,int align)
  {
     if(align!=3)
     {		
	for(int j=0;j<3;j++)
	  button[i][j].setBackground(Color.yellow);
     } 	
     else
     {
	for(int j=0;j<3;j++)
	  button[j][i].setBackground(Color.yellow);
     } 	
     dis();	
     JOptionPane.showMessageDialog(TicTacToe.this,str+" player is winner"); 	
  }
  void dis()
  {
     for(int k=0;k<3;k++)
     {
       for(int j=0;j<3;j++)
       {
	  button[k][j].setEnabled(false);
       }		
     }	
  }
  public static void main(String []args)
  {
	new TicTacToe();
  }
}



