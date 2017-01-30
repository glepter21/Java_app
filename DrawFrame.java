// Create by	  :	Glenn Paul Mira 
// Student Number : 	5245382
// Date		  :	January 21, 2015
// Description    :	Create JFrame for java drawing using shape
//			line, oval and rectangle.

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.FlowLayout;

public class DrawFrame extends JFrame
{
   private JButton undoButton;
   private JButton clearButton;
   private JComboBox colorComboBox;
   private final String colorNames[] = { "Black", "Blue", "Cyan",
	"Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
	"Orange", "Pink", "Red", "White", "Yellow" };
   private final Color color[] = { Color.BLACK, Color.BLUE, Color.CYAN,
	Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA,
	Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW };
   private JComboBox shapeComboBox;
   private final String shapeNames[] = { "Line", "Oval", "Rectangle"};
   private JCheckBox checkBox;

   private JPanel panel;
   private JLabel label;

   private DrawPanel drawPanel;
   
   // set up GUI
   public DrawFrame()
   {
	super( "Java Drawing" );
	setLayout( new BorderLayout() );

	JLabel label = new JLabel( "(0, 0)");
	drawPanel = new DrawPanel( label );

	undoButton = new JButton( "Undo" );
	clearButton = new JButton( "Clear" );

	// create undoButton event handling
	undoButton.addActionListener( 
	   new ActionListener()	// anonymous inner class
	   {
		public void actionPerformed( ActionEvent event )
		{
		   drawPanel.clearLastShape();
		} // end method actionPerformed
	   } // end anonymous inner class
	); // end call to addActionListener

	// create clearButton event handling
	clearButton.addActionListener( 
	   new ActionListener()	// anonymous inner class
	   {
		public void actionPerformed( ActionEvent event )
		{
		   drawPanel.clearDrawing();
		} // end method actionPerformed
	   } // end anonymous inner class
	); // end call to addActionListener

	colorComboBox = new JComboBox( colorNames );
	colorComboBox.setMaximumRowCount( 10 );
	colorComboBox.addItemListener(
	   new ItemListener() 	// anonymous inner class
	   {
		// handle comboBox event
		public void itemStateChanged( ItemEvent event )
		{
		   if ( event.getStateChange() == ItemEvent.SELECTED )
			drawPanel.setColor( color[ colorComboBox.getSelectedIndex() ] );	
		} // end method itemStateChanged
	   } // end anonymous inner class
        ); // end call to addItemListener

	shapeComboBox = new JComboBox( shapeNames );
	shapeComboBox.setMaximumRowCount( 3 );
	shapeComboBox.addItemListener(
	   new ItemListener() 	// anonymous inner class
	   {
		// handle shapeComboBox event
		public void itemStateChanged( ItemEvent event )
		{
		   if ( event.getStateChange() == ItemEvent.SELECTED )
			drawPanel.setShapeType( shapeComboBox.getSelectedIndex() );
		} // end method itemStateChanged
	   } // end anonymous inner class
        ); // end call to addItemListener

 	checkBox = new JCheckBox( "Filled" );
	// register listener for JCheckBoxes
	CheckBoxHandler checkHandler = new CheckBoxHandler();
	checkBox.addItemListener( checkHandler );

 	panel =  new JPanel();
	panel.setLayout( new FlowLayout( FlowLayout.CENTER ) );
	panel.add( undoButton );
	panel.add( clearButton );
	panel.add( colorComboBox );
	panel.add( shapeComboBox );
	panel.add( checkBox );

	// add to frame
 	add(panel, BorderLayout.NORTH );
	add(drawPanel, BorderLayout.CENTER );
	add(label, BorderLayout.SOUTH );

   } // end constructor

   // private inner class for ItemListener event handling
   private class CheckBoxHandler implements ItemListener
   {
	private Boolean filled = false;	// controls bold font style
	// repond to checkbox events
	public void itemStateChanged( ItemEvent event )
        {
  	   if ( event.getSource() == checkBox )
 	   {
	      filled = checkBox.isSelected() ? true : false;
	      drawPanel.setFilledShape( filled );
	   } // end if
	} // end method itemStateChanged
   } // end class CheckBoxHandler
} // end class DrawFrame