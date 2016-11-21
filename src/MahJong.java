import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class MahJong extends JFrame implements WindowListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MahJong()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		setSize(1200, 1000);
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
		// TODO Auto-generated method stub
		
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
