import java.awt.event.*;
import java.awt.*;

class NewGameListener implements ActionListener
{
	public void actionPerformed(ActionEvent evt)
	{
		for(int i = 0;i<3; i++)
		{
			for(int j = 0;j<3;j++)
			{
				Va.bt[i][j].setIcon(null);
				Va.bt[i][j].img = false;
				Va.bt[i][j].ui = -1;
				Va.user1 = Va.user2 = 0;
				Va.bt[i][j].setBackground(Color.green);
				Va.tie = 0;
				Va.user = 0;
			}
		}
		Va.msg.setText("player 1 turn ... ");
	}
}

				