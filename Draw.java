// Create by	  :	Glenn Paul Mira 
// Student Number : 	5245382
// Date		  :	January 21, 2015
// Description    :	Create JFrame for java drawing using shape
//			line, oval and rectangle.



import javax.swing.JFrame;

public class Draw
{
   public static void main( String args[] )
   {
      // create frame for Saver1JPanel
      DrawFrame frame = new DrawFrame( );
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

      frame.setSize( 500, 350 ); // set frame size
      frame.setVisible( true ); // display frame
   } // end main
} // end class Saver1