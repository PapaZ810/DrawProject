package draw.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;
import draw.controller.DrawController;

public class DrawAppPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private SpringLayout appLayout;
	
	private DrawController app;
	private DrawPanel canvas;
	
	private JPanel colorPanel;
	private JPanel menuPanel;
	
	private JScrollPane canvasPane;
	
	private JButton black;
	private JButton purple;
	private JButton blue;
	private JButton green;
	private JButton yellow;
	private JButton orange;
	private JButton red;
	private JButton white;
	private JButton randomColor;
	
	private JButton load;
	private JButton save;
	private JButton clear;
	private JSlider widthSlider;
	
	private final int MINIMUM_LINE = 1;
	private final int MAXIMUM_LINE = 25;
	
	public DrawAppPanel(DrawController app)
	{
		super();
		
		appLayout = new SpringLayout();
		
		this.app = app;
		canvas = new DrawPanel(app);
		
		colorPanel = new JPanel(new GridLayout(0, 1));
		menuPanel = new JPanel(new GridLayout(0, 1));
		
		canvasPane = new JScrollPane();
		
		black = new JButton("black");
		purple = new JButton("purple");
		blue = new JButton("blue");
		green = new JButton("green");
		yellow = new JButton("yellow");
		orange = new JButton("orange");
		red = new JButton("red");
		white = new JButton("white");
		randomColor = new JButton("random");
		
		load = new JButton("load new panel");
		save = new JButton("save panel");
		clear = new JButton("clear panel");
		
		widthSlider = new JSlider(MINIMUM_LINE, MAXIMUM_LINE);
		
		setupPanel();
		setupLayout();
		setupListeners();
		setupScrollPane();
		setupMenuPanels();
		setupSlider();
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, colorPanel, 0, SpringLayout.NORTH, canvasPane);
		appLayout.putConstraint(SpringLayout.SOUTH, colorPanel, 0, SpringLayout.SOUTH, canvasPane);
		appLayout.putConstraint(SpringLayout.WEST, colorPanel, 50, SpringLayout.EAST, canvasPane);
		appLayout.putConstraint(SpringLayout.EAST, colorPanel, 0, SpringLayout.WEST, menuPanel);
								
		appLayout.putConstraint(SpringLayout.WEST, menuPanel, 200, SpringLayout.EAST, canvasPane);
		appLayout.putConstraint(SpringLayout.SOUTH, menuPanel, 0, SpringLayout.SOUTH, canvasPane);
		appLayout.putConstraint(SpringLayout.EAST, menuPanel, -50, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, menuPanel, 0, SpringLayout.NORTH, canvasPane);
									
		appLayout.putConstraint(SpringLayout.NORTH, canvasPane, 25, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, canvasPane, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, canvasPane, -50, SpringLayout.SOUTH, this);
		
		black.setOpaque(true);
		black.setBorderPainted(false);
		purple.setOpaque(true);
		purple.setBorderPainted(false);
		blue.setOpaque(true);
		blue.setBorderPainted(false);
		green.setOpaque(true);
		green.setBorderPainted(false);
		yellow.setOpaque(true);
		yellow.setBorderPainted(false);
		orange.setOpaque(true);
		orange.setBorderPainted(false);
		red.setOpaque(true);
		red.setBorderPainted(false);
		white.setOpaque(true);
		white.setBorderPainted(false);
		randomColor.setOpaque(true);
		randomColor.setBorderPainted(false);
		load.setOpaque(true);
		load.setBorderPainted(false);
		save.setOpaque(true);
		save.setBorderPainted(false);
		clear.setOpaque(true);
		clear.setBorderPainted(false);
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(500, 400));
		this.setBackground(Color.DARK_GRAY);
		this.add(colorPanel);
		this.add(menuPanel);
	}
	
	private void setupMenuPanels()
	{
		colorPanel.setPreferredSize(new Dimension(50, 700));
		menuPanel.setPreferredSize(new Dimension(50,700));
				
		purple.setForeground(new Color(75, 0, 130));
		blue.setForeground(Color.BLUE);
		green.setForeground(Color.GREEN);
		orange.setForeground(Color.ORANGE);
		red.setForeground(Color.RED);
		yellow.setForeground(Color.YELLOW);
				
		colorPanel.add(black);
		colorPanel.add(purple);
		colorPanel.add(blue);
		colorPanel.add(green);
		colorPanel.add(yellow);
		colorPanel.add(orange);
		colorPanel.add(red);
		colorPanel.add(white);
		colorPanel.add(randomColor);
				
		menuPanel.add(widthSlider);
		menuPanel.add(load);
		menuPanel.add(save);
		menuPanel.add(clear);
	}

	private void setupScrollPane()
	{
		canvasPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		canvasPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		canvasPane.setViewportView(canvas);
	}
	
	private void setupSlider()
	{
		Hashtable<Integer, JLabel> scaleLabels = new Hashtable<Integer, JLabel>();
		scaleLabels.put(MINIMUM_LINE, new JLabel("<HTML>Small<BR>Line</HTML>"));
		scaleLabels.put(MAXIMUM_LINE, new JLabel("<HTML>Large<BR>Line</HTML>"));
		widthSlider.setLabelTable(scaleLabels);
		widthSlider.setSnapToTicks(true);
		widthSlider.setMajorTickSpacing(5);
		widthSlider.setMinorTickSpacing(1);
		widthSlider.setPaintTicks(true);
		widthSlider.setPaintLabels(true);
		widthSlider.setValue((MAXIMUM_LINE + MINIMUM_LINE) / 2);
	}
	
	private void setupListeners()
	{
		canvas.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				canvas.drawDot(e.getX(), e.getY(), widthSlider.getValue());
			}
			
			public void mousePressed(MouseEvent e)
			{
				
			}
			
			@Override
			public void mouseReleased(MouseEvent e)
			{
				canvas.resetPoint();
			}
			
			@Override
			public void mouseEntered(MouseEvent e)
			{
				canvas.resetPoint();
			}
			
			@Override
			public void mouseExited(MouseEvent e)
			{
				canvas.resetPoint();
			}
		});
		
		canvas.addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseDragged(MouseEvent e)
			{
				
			}
			
			public void mouseMoved(MouseEvent e)
			{
				
			}
		});
		
		save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				canvas.saveImage();
			}
		});
	}
}
