import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WindowManchester extends JDialog {
	
  private String binaryCode;
  
  public WindowManchester (JFrame frame, String binaryCode) {
    
    super (frame, "Manchester");

    this.binaryCode = binaryCode;

    createCurveManchester ();

    setSize (500, 500);
    setLocationRelativeTo (frame);
    setDefaultCloseOperation (DISPOSE_ON_CLOSE);
    setVisible (true);
  }
  
  public void createCurveManchester () {
    
	  JPanel jPanel = new JPanel ();
	  jPanel.setLayout (new BoxLayout (jPanel, BoxLayout.Y_AXIS));
	
	  JPanel point1 = new JPanel ();

	  JLabel jLabel = new JLabel ("Code binaire traduit : " + binaryCode);
	  point1.add (jLabel);

	  JPanel point2 = new GraphicPanelManchester (binaryCode);
	
	
	  jPanel.add (point1);
	  jPanel.add (point2);
	  
    jPanel.add (Box.createVerticalGlue ());
    
    setContentPane (jPanel);
  }
}