import javax.swing.SwingUtilities;

public class Test {
  
  public static void main (String [] arguments) {
    
    SwingUtilities.invokeLater (() -> new Window ());
  }
}