// Create by	  :	Glenn Paul Mira 
// Student Number : 	5245382
// Date		  :	January 11, 2015
// Description    :	MyBoundedShape abstract superclass

import java.awt.Color;
import java.awt.Graphics;

public abstract class MyBoundedShape extends MyShape
{
   private boolean shapeFilled; // boolean shapeFilled flag
   private int upperLeftX;  	// upper left X
   private int upperLeftY;  	// upper left Y
   private int width;	   	// width
   private int height;	   	// height
	
   // six-argument constructor 
   public MyBoundedShape( int x1, int y1, int x2, int y2, Color color, boolean filled )
   {
	super( x1, y1, x2, y2, color);

	shapeFilled = filled;	 	// store boolen value
	setUpperLeftX( x1, x2 ); 	// set upper left X
	setUpperLeftY( y1, y2 );  	// set upper left Y
	setWidth( x1, x2 ); 	  	// set width
	setHeight( y1, y2 );	 	// set Height
   } // end six-argument constructor

   // constructor with no arguments, default all coordinates to 0, color to BLACK and shape filled to false.
   public MyBoundedShape()
   {
 	this( 0, 0, 0, 0, Color.BLACK, false );
   } // end MyBoudedShape no argument constructor	

   // set upper left x
   public void setUpperLeftX( int x1, int x2 )
   {
	upperLeftX = ( x1 < x2 ) ? x1 : x2; 
   } // end method UpperLeftX

   // return upper left X
   public int getUpperLeftX()
   {
	return upperLeftX;
   } // end method getUpperLeftX

   // set upper left Y
   public void setUpperLeftY(int y1, int y2)  
   {
	upperLeftY = ( y1 < y2 ) ? y1 : y2;
   } // end method setUpperLeftY   

   // return upper left Y
   public int getUpperLeftY()
   {
	return upperLeftY;
   } // end method getUpperLeftY
 
   // set width
   public void setWidth( int x1, int x2 ) 
   {
	width = ( x1 < x2 ) ? x2-x1 : x1-x2;
   } // end method setWidth

   // return width
   public int getWidth()
   {
	return width;
   } // end method getWidth    

   // set height
   public void setHeight( int y1, int y2 ) 
   {
	height = ( y1 < y2 ) ? y2-y1 : y1-y2;
   } // end method height

   // return height
   public int getHeight()
   {
	return height;
   } // end method getHeight

   // set shape Filled
   public void setShapeFilled( boolean filled )
   {
	shapeFilled = filled;
   } // end method setShapeFilled

   // return shape Filled
   public boolean getShapeFilled()
   {
	return shapeFilled;
   } // end getShapeFilled

      // abstract method
   public abstract void draw( Graphics g );

} // end class MyBoundedShape