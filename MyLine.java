// Create by	  :	Glenn Paul Mira 
// Student Number : 	5245382
// Date		  :	January 10, 2015
// Declaration of class MyLine.

import java.awt.Color;
import java.awt.Graphics;

public class MyLine extends MyShape
{

   // five-argument constructor 
   public MyLine( int x1, int y1, int x2, int y2, Color color )
   {
	super( x1, y1, x2, y2, color);
   } // end MyLine constructor

   // constructor with no arguments, default all coordinates to 0 and color to BLACK. 
   public MyLine()
   {
 	this( 0, 0, 0, 0, Color.BLACK );
   } // end MyLine no argument constructor	

   //Draw the line in the specified color
   public void draw( Graphics g )
   {
	g.setColor( getColor() );
	g.drawLine( getX1(), getY1(), getX2(), getY2() );
   } // end method draw
} // end class MyLine