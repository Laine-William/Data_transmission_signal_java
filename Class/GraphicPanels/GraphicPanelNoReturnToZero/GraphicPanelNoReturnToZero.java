import java.awt.Graphics;
import javax.swing.JPanel;

public class GraphicPanelNoReturnToZero extends JPanel {
	
	private String binaryCode;
	
	public GraphicPanelNoReturnToZero (String binaryCode) {
		
		this.binaryCode = binaryCode;
	}
	
	public void paintComponent (Graphics graphics) {
		
		super.paintComponent (graphics);
		
		graphics.drawLine (30, getHeight () / 2, getWidth () - 30, getHeight () / 2);  
		graphics.drawLine (30, 30, 30, getHeight () - 30);
		
		graphics.drawString ("-nV", 10, getHeight () - 30);
		graphics.drawString ("nV", 10, 30);
		
		Point [] point = getPoints ();

		int abscissa1, abscissa2, ordonate;
		
		for (int i = 0; i < point.length; i++) {
			
			abscissa1 = 30 + i * (getWidth () - 60) / point.length;
			abscissa2 = 30 + (i + 1) * (getWidth () - 60) / point.length;

			if (point [i].getPositionY () == 1) {
			
				ordonate = 30;

			} else {
				
				ordonate = getHeight () - 30;
			}

			graphics.drawLine (abscissa1, ordonate, abscissa2, ordonate);
			
			if (i != (point.length - 1) && point [i].getPositionY () != point [i + 1].getPositionY ()) {
				
				graphics.drawLine (abscissa2, 30, abscissa2, getHeight () - 30);
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