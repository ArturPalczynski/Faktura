
package faktura;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Faktura {

    public static void main(String[] args) {
       
                java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new MainWindow().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Faktura.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
                

        
    }
    
}
