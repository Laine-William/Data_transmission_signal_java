import java.awt.Graphics;
import javax.swing.JPanel;

public class GraphicPanelMiller extends JPanel {
	
private String binaryCode;
	
	public GraphicPanelMiller(String binaryCode) {
		
		this.binaryCode = binaryCode;
	}
	
	public void paintComponent (Graphics graphics) {
		
		super.paintComponent (graphics);
		
		graphics.drawLine (30, getHeight () / 2, getWidth () - 30, getHeight () / 2);
		graphics.drawLine (30, 30, 30, getHeight () - 30);
		
		graphics.drawString ("-nV", 10, getHeight () - 30);
		graphics.drawString ("nV", 10, 30);
		
		Point [] point = getPoints ();

		int abscissa1, abscissa2, ordonate1 = 30 , ordonate2 = getHeight () - 30, temporary;
		
		for (int i = 0; i < point.length; i++) {
			
			abscissa1 = 30 + i * (getWidth () - 60) / point.length;
			abscissa2 = 30 + (i + 1) * (getWidth () - 60) / point.length;
			
			if (point [i].getPositionY () == 1) {
			
				graphics.drawLine (abscissa1, ordonate1, (abscissa2 + abscissa1) / 2, ordonate1);
				
				graphics.drawLine ((abscissa2 + abscissa1) / 2, 30, (abscissa2 + abscissa1) / 2, getHeight () - 30);

				graphics.drawLine ((abscissa2 + abscissa1) / 2, ordonate2, abscissa2, ordonate2);
				
				temporary = ordonate1;
				ordonate1 = ordonate2;
				ordonate2 = temporary;

			} else {
				
				graphics.drawLine (abscissa1, ordonate1, abscissa2, ordonate1);
			}
			
			if (i < (point.length - 1) && point [i].getPositionY () == -1 && point [i + 1].getPositionY () == -1) {
				
				graphics.drawLine (abscissa2, 30, abscissa2, getHeight () - 30);
				
				temporary = ordonate1;
				ordonate1 = ordonate2;
				ordonate2 = temporary;
			}
		}
	}
	
	public Point [] getPoints () {
		  
		Point [] result = new Point [binaryCode.length ()];

		Point current;
		  
		int abscissa = 0;
		int ordonate;
		  
		for (int i = 0; i < binaryCode.length (); i++) {
			  
			if (binaryCode.charAt (i) == '1') {
				  
				ordonate = 1;

			} else {
				  
				ordonate = - 1;
			}
			  
			current = new Point (abscissa, ordonate);

			result [i] = current;

			abscissa++;
		}
		  
		return result;
	}
}