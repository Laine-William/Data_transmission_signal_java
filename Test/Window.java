import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

import javax.swing.*;

public class Window extends JFrame implements ActionListener {
  
	private JTextArea jTextArea = new JTextArea (1, 15);

	JComboBox <String> jComboBox = new JComboBox <> ();

	JButton jButton = new JButton ("Dessiner");
  
	public Window () {
    
    	super ("Filtre la Bande passante ");

    	createBoxLayout ();

    	pack ();

    	setLocationRelativeTo (null);
    	setDefaultCloseOperation (EXIT_ON_CLOSE);
    	setVisible (true);
  	}
 
	public void createBoxLayout () {
	  
		JPanel jPanel = new JPanel ();
		jPanel.setLayout (new BoxLayout (jPanel, BoxLayout.Y_AXIS));

		JPanel point1 = new JPanel ();
		point1.setLayout(new BoxLayout(point1, BoxLayout.X_AXIS));
	  
		JPanel point2 = new JPanel ();
		point2.setLayout(new BoxLayout(point2, BoxLayout.X_AXIS));
	  
		JPanel point3 = new JPanel ();
	  
		point1 = getPoint1 (point1);
		point2 = getPoint2 (point2);
		point3 = getPoint3 (point3);
	  	  
		jPanel.add (point1);
		jPanel.add (point2);
		jPanel.add (point3);
	  
		jButton.addActionListener (this);
	  
		setContentPane (jPanel);
	}
  
	public JPanel getPoint1 (JPanel jPanel) {
	  
		JLabel jLabel = new JLabel ("Entrez le code binaire : ", SwingConstants.CENTER);
	  
		jPanel.add (Box.createRigidArea (new Dimension (10, 0)));
		jPanel.add (jLabel);

		jPanel.add (Box.createHorizontalGlue ());
		jPanel.add (Box.createRigidArea (new Dimension (10, 0)));
		jPanel.add (jTextArea);

		jPanel.add (Box.createRigidArea (new Dimension (10, 0)));
	  
		return jPanel;
	}
  
	public JPanel getPoint2 (JPanel jPanel) {
	  
		JLabel jLabel = new JLabel ("Choisissez le graphique a utiliser : ", SwingConstants.CENTER);
	  
		jComboBox.addItem ("NoReturnToZero");
		jComboBox.addItem ("Manchester");
		jComboBox.addItem ("ManchesterDifferentiel");
		jComboBox.addItem ("Miller");
	  
		jPanel.add (Box.createRigidArea (new Dimension (10, 0)));
		jPanel.add (jLabel);

		jPanel.add (Box.createHorizontalGlue ());
		jPanel.add (Box.createRigidArea (new Dimension (10, 0)));
		jPanel.add (jComboBox);

		jPanel.add (Box.createRigidArea (new Dimension (10, 0)));
	  
		return jPanel;
  	}
  
	public JPanel getPoint3 (JPanel jPanel) {
	  
		jPanel.add (jButton);
	  
		return jPanel;
	}

	public void actionPerformed (ActionEvent actionEvent) {
    
    if (actionEvent.getSource () == jButton) {
    
    	String textArea = jTextArea.getText ();
    	
		String codeName = (String)jComboBox.getSelectedItem ();
    
    	for (int i = 0; i < textArea.length (); i++) {
      
        	switch (textArea.charAt (i)) {
        
        		case '0' : 
				
					break;

        		case '1' : 
				
					break;
        		
				default : 
				
					throw new InputMismatchException ();
        		}
      		}
      
			if (codeName == "NoReturnToZero") {
    	  
    	  		SwingUtilities.invokeLater (() -> new WindowNoReturnToZero (this, textArea));
      
			} else if (codeName == "Manchester") {
    	  
				SwingUtilities.invokeLater (() -> new WindowManchester (this, textArea));
      
			} else if (codeName == "ManchesterDifferentiel") {
    	  
				SwingUtilities.invokeLater (() -> new WindowManchesterDifferentiel (this, textArea));
      
			} else {
    	  
				SwingUtilities.invokeLater (() -> new WindowMiller (this, textArea));
			}
		}
	}
}