import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
class MouseMagic extends JFrame
{
	JLabel label = new JLabel("Touch me to see the magic");
	int x=50,y=80;
	Random random = new Random();
	boolean stop = false;
	public MouseMagic()
	{
		super("MouseMagic");
		setSize(800,600);
		setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		label.setFont(new Font("arial",0,20));
		label.setForeground(Color.red);
		label.setBounds(x,y,220,30);
		add(label);
		label.addMouseListener(new MagicListener());
		addMouseListener(new StopListener());
		setVisible(true);
		
	}
	

	
	class MagicListener implements MouseListener
	{
		public void mouseEntered(MouseEvent evt)
		{
			if(!stop)
			{
				x = random.nextInt(580)+ 2;
				y = random.nextInt(500)+2;
				label.setLocation(x,y);
			}
			stop = false;
		}

		public void mouseExited(MouseEvent evt) {}
		public void mousePressed(MouseEvent evt) {}
		public void mouseClicked(MouseEvent evt) {}
		public void mouseReleased(MouseEvent evt) {}
		
	}
	
		class StopListener implements MouseListener
	{
		public void mouseEntered(MouseEvent evt) {}
		public void mouseExited(MouseEvent evt) {}
		public void mousePressed(MouseEvent evt)
		{
			stop = true;
		}
		
		public void mouseClicked(MouseEvent evt) {}
		public void mouseReleased(MouseEvent evt) {}
	}
	
	
	public static void main(String[] args)
	{
		new MouseMagic();
	}
}

		