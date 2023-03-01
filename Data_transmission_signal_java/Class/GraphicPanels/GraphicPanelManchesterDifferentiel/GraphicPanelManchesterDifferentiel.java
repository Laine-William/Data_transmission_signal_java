import java.awt.Graphics;
import javax.swing.JPanel;

public class GraphicPanelManchesterDifferentiel extends JPanel {
	
private String binaryCode;
	
	public GraphicPanelManchesterDifferentiel (String binaryCode) {
		
		this.binaryCode = binaryCode;
	}
	
	public void paintComponent(Graphics graphics) {
		
		super.paintComponent(graphics);
		
		graphics.drawLine(30, getHeight()/2, getWidth() - 30, getHeight()/2);  
		graphics.drawLine(30, 30, 30, getHeight() - 30);
		
		graphics.drawString("-nV", 10, getHeight() - 30);
		graphics.drawString("nV", 10, 30);
		
		Point[] point = getPoints();
		int abs1, abs2, ord1 = 30, ord2 = getHeight() - 30, tmp;
		
		for(int i = 0; i < point.length; ++i) {
			
			abs1 = 30 + i*(getWidth()-60)/point.length;
			abs2 = 30 + (i+1)*(getWidth()-60)/point.length;
			
			if(point[i].getPositionY() == -1) {
				
				graphics.drawLine(abs1, 30, abs1, getHeight() - 30);
				tmp = ord1;
				ord1 = ord2;
				ord2 = tmp;
			}
			
			graphics.drawLine(abs1, ord1, (abs2+abs1)/2, ord1);
			graphics.drawLine((abs2+abs1)/2, 30, (abs2+abs1)/2, getHeight() - 30);
			graphics.drawLine((abs2+abs1)/2, ord2, abs2, ord2);
				
			tmp = ord1;
			ord1 = ord2;
			ord2 = tmp;
		}
	}
	
	public Point[] getPoints() {
		  
		  Point[] result = new Point[binaryCode.length()];
		  Point courant;
		  int abscisse = 0;
		  int ordonnee;
		  
		  for(int i = 0; i < binaryCode.length(); ++i) {
			  
			  if(binaryCode.charAt(i) == '1') {
				  
				  ordonnee = 1;
			  } else {
				  
				  ordonnee = -1;
			  }
			  
			  courant = new Point(abscisse, ordonnee);
			  result[i] = courant;
			  ++abscisse;
		  }
		  
		  return result;
	  }
}