// Create by	  :	Glenn Paul Mira 
// Student Number : 	5245382
// Date		  :	January 10, 2015
// Description    :	MyShape abstract superclass

import java.awt.Color;
import java.awt.Graphics;

public abstract class MyShape
{
   private int x1; // x coordinate of first endpoint
   private int y1; // y coordinate of first endpoint
   private int x2; // x coordinate of second endpoint
   private int y2; // y coordinate of second endpoint
   private Color myColor; // color of this shape

   // five-argument constructor
   public MyShape(int x1, int y1, int x2, int y2, Color myColor )
   {
	this.x1 = x1;
	this.y1 = y1;
	this.x2 = x2;
	this.y2 = y2;
	this.myColor = myColor;
   } // end five-argument constructor

   // constructor with no arguments, default all coordinates to 0 and color to BLACK.
   public MyShape()
   {
 	this( 0, 0, 0, 0, Color.BLACK);
   } // end MyShape no argument constructor	

   // set X1
   public void setX1( int x )
   {
	x1 = ( x >= 0 ) ? x : 0;
   } // end method setX1

   // set Y1
   public void setY1( int y )   
   {
	y1 = ( y >= 0 ) ? y : 0;
   } // end method setY1

   // set X2
   public void setX2( int x )
   {
	x2 = ( x >= 0 ) ? x : 0;
   } // end method setX2

   // set Y2
   public void setY2( int y ) 
   {
	y2 = ( y >= 0 ) ? y : 0;
   } // end method setY2

   // set color
   public void setColor( Color color )
   {
	myColor = color;
   } // end method setColor

   // return X1
   public int getX1()
   {
	return x1;
   } // end method getX1

   // return Y1
   public int getY1()
   {
	return y1;
   } // end method getY1
  
   // return X2
   public int getX2()
   {
	return x2;
   } // end method getX2
 
   // return Y2
   public int getY2()
   {
	return y2;
   } // end method getY2

   // return color
   public Color getColor()
   {
	return myColor;
   } // end method getColor

   // return String representation
   public String toString()
   {
	return String.format( "[%d, %d, %d, %d, %s]", getX1(), getY1(), getX2(), getY2(), getColor() );
   } // end method toString

   // abstract method
   public abstract void draw( Graphics g );

} // end class  MyShape

