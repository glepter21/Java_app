// Create by	  :	Glenn Paul Mira 
// Student Number : 	5245382
// Date		  :	January 21, 2015
// Description    :	Create JPanel for drawing of shape rectangle,
//			line and oval.


import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawPanel extends JPanel
{
   private MyShape shapes[];	// array of shapes, to store all the user draw 
   private int shapeCount;	// count number of shapes[]
   private int shapeType;	// type of shape 
   private MyShape currentShape; // current shape the user is drawing	
   private Color currentColor;	// current drawing color
   private Boolean filledShape;	// draw is filled or not
   private JLabel statusLabel; 	// status bar, display the mouse current coordinates position

   private int x1, y1, x2, y2, mousePoint;

   // single argument constructor 
   public DrawPanel( JLabel label )   
   {
	statusLabel = label;
	shapes = new MyShape[100];	
	setShapeCount( 0 );
	setShapeType( 0 ); 
	currentShape = null;
	setColor( Color.BLACK );
	setBackground( Color.WHITE );	// set background color
	setFilledShape( false );

	MouseHandler handler = new MouseHandler();
	addMouseListener( handler );
	addMouseMotionListener( handler );

   } // end single argument constructor

   public void paintComponent( Graphics g )
   {
	super.paintComponent( g );
	// this will draw current shape
	for ( int i = 1; i <= mousePoint; i++ )
	   currentShape.draw( g );

	// this will draw save shape in array "shapes[]"
 	for ( int i = 0; i < shapeCount; i++ )
 		shapes[ i ].draw( g );
   } // end method paintComponent
   
   // set Shape Type
   public void setShapeType( int type )
   {
	shapeType =  type;
   } // end method setShapeType

   // return ShapeType
   public int getShapeType()
   {
	return shapeType;
   } // end method getShapeType

   // set current Color
   public void setColor( Color color ) 
   {
	currentColor = color;
   } // end method setColor

   // return currentColor
   public Color getColor()
   {
	return currentColor;
   } // end method getColor

   // set filled shape
   public void setFilledShape( Boolean filled )
   {
	filledShape = filled;	
   } // end method setFilledShape

   // return filled shape
   public Boolean getFilledShape()
   {
	return filledShape;
   } // end method getFilledShape

   // set shape count
   public void setShapeCount( int count ) 
   {
	shapeCount = count;
   } // end method shape count

   // return shape count
   public int getShapeCount()
   {
	return shapeCount;
   } // end method getShapeCount

   // return statusLabel
   public JLabel getStatusLabel()
   {
	return statusLabel;
   } // end method getStatusLabel

   public void clearLastShape()
   {
	shapeCount = shapeCount <= 0 ? 0 : shapeCount - 1;
	mousePoint = 0;
	repaint();
   } // end method clearLastShape

   public void clearDrawing()
   {
	setShapeCount( 0 );
	mousePoint = 0;
	repaint();
   } // end method clearDrawing

   private class MouseHandler extends MouseAdapter implements MouseListener, MouseMotionListener 
   {
	// MouseListener event handlers
	public void mousePressed( MouseEvent event )
 	{
    	   // initialize mouse point position
	   x1 = event.getX();	// get x position of mouse
	   y1 = event.getY();	// get y position of mouse
	   statusLabel.setText( String.format( "(%d, %d)", event.getX(), event.getY() ) ); 
	   mousePoint = 1;

	} // end method mousePressed

	// handle event when mouse release after dragging
	public void mouseReleased( MouseEvent event )
	{
	   x2 = event.getX();	// get x position of mouse
	   y2 = event.getY();	// get y position of mouse
	   
	   selectShape();
	   shapes[ shapeCount ] = currentShape;
	   if ( shapeCount <= 100 )
	      shapeCount++;
	   statusLabel.setText( String.format( "(%d, %d )", 
	      event.getX(), event.getY() ) ); 
	   currentShape = null;
	   mousePoint = 0;
	   repaint();
	} // end method mouseRealeased

	// MouseMotionListener event handlers
	// handle event when user drags mouse with button pressed
	public void mouseDragged( MouseEvent event )
	{
	   x2 = event.getX();	// get x position of mouse
	   y2 = event.getY();	// get y position of mouse
	   mousePoint += 1;

	   selectShape();
	   statusLabel.setText( String.format( "(%d, %d)", event.getX(), event.getY() ) ); 
	   repaint();
  	} // end method mouseDragged

	// handle event when user moves mouse
	public void mouseMoved( MouseEvent event )
	{
	   statusLabel.setText( String.format( "(%d, %d)", event.getX(), event.getY() ) ); 
	} // end method mouseMoved

   } // end private inner class MouseHandler

   public void selectShape()
   {
	   switch ( getShapeType() )
	   {
		case 0:
		   currentShape = new MyLine( x1, y1, x2, y2, getColor() );
		   break;
		case 1:
		   currentShape = new MyOval( x1, y1, x2, y2, getColor(), getFilledShape() );  
		   break;
		case 2:
		   currentShape = new MyRect( x1, y1, x2, y2, getColor(), getFilledShape() );  
		   break;
	   } // end switch
   } // end method select shape

} // end class DrawPanel