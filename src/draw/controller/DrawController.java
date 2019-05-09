package draw.controller;

import javax.swing.JOptionPane;

import draw.view.DrawFrame;

public class DrawController
{
	private DrawFrame frame;
	
	public DrawController()
	{
		frame = new DrawFrame(this);
	}
	
	
	
	public void handleErrors(Exception error)
	{
		JOptionPane.showMessageDialog(frame, error.getMessage());
	}
	
	public void start()
	{
		
	}
}
