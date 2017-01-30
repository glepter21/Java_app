// Create by	  :	Glenn Paul Mira 
// Student Number : 	5245382
// Date		  :	January 10, 2015
// Description    :  	Declaration of class MyRect

import java.awt.Color;
import java.awt.Graphics;

public class MyRect extends MyBoundedShape
{
   // six-argument constructor with input values
   public MyRect( int x1, int y1, int x2, int y2, Color color, boolean filled )
   {
	super( x1, y1, x2, y2, color, filled );

	setShapeFilled( filled ); 	// store boolen value
	setUpperLeftX( x1, x2 );	// set upper left X
	setUpperLeftY( y1, y2 );	// set upper left Y
	setWidth( x1, x2 );		// set width
	setHeight( y1, y2 );		// set Height
   } // end MyRect constructor

   // constructor with no arguments, default all coordinates to 0, color to BLACK and shape filled to false. 
   public MyRect()
   {
 	this( 0, 0, 0, 0, Color.BLACK, false );
   } // end MyRect no argument constructor	

   // Draw rectangle in the specified color
   public void draw( Graphics g )
   {
	g.setColor( getColor() );
	if ( getShapeFilled() )	// if shape to be filled or not	
	   g.fillRect( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
	else
	   g.drawRect( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
   } // end method draw
} // end class MyRect