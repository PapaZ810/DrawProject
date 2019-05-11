package draw.view;

import javax.swing.*;
import draw.controller.DrawController;

public class DrawFrame extends JFrame
{
	private static final long serialVersionUID = 3L;
	
	private DrawController app;
	private DrawAppPanel pane;
	private DrawPanel fPane;
	private JSplitPane splitPane;
	
	public DrawFrame(DrawController app)
	{
		super();
		
		this.app = app;
		pane = new DrawAppPanel(app);
		fPane = new DrawPanel(app);
		
		splitPane = new JSplitPane();
		
		setupFrame();
		setupSplitPane();
	}
	
	private void setupFrame()
	{
		this.setSize(1000, 800);
		this.setContentPane(splitPane);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void setupSplitPane()
	{
		splitPane.add(pane);
		splitPane.add(fPane);
	}
}
