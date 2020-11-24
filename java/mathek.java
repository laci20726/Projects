import javax.swing.*;

public class mathek{

    

    public static void main ( String[] args ) {
        

        JFrame frame = new JFrame (" HelloWorldSwing ");
        frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        JLabel label = new JLabel (" Hello␣World ");
        double szam = 100;
        for (int i = 0; i < 100; i++) {
            szam -= 1;
            
            label.setText(String.valueOf(szam));
            frame.add ( label );
            frame.pack ();
            frame.setVisible ( true );
        }
        
    }
 }
