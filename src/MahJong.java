/*
 * Daniel Bigelow
 * CS3230
 * 11/21/16
 */
import java.awt.Color;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class MahJong extends JFrame implements WindowListener
{
	
	private static final long serialVersionUID = 1L;

	public MahJong()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Image img = getToolkit().getImage(getClass().getResource("images/B.png"));
		this.setIconImage(img);
		this.setTitle("MahJong");
		this.setBackground(new Color(11, 112, 15));
		setSize(1100, 1000);
		setResizable(false);
		add(new MahJongBoard());
		setVisible(true);
	}
	
	

	public static void main(String[] args) 
	{
		new MahJong();
		

	}

	@Override
	public void windowOpened(WindowEvent e)
	{
		// TODO Auto-generated method stud
		
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e)
	{
		
		
	}

	@Override
	public void windowIconified(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
