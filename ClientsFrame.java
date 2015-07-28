/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//added to GITHUB
package faktura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Gosia
 */
public class ClientsFrame extends javax.swing.JFrame {

    
    Scanner scanner;
    MainWindow mainFrame;
    
    
    public ClientsFrame() throws FileNotFoundException {
        
        scanner = new Scanner(new File("D://klienci.txt")).useDelimiter("\n");
        
        initComponents();
        
        DefaultListModel model = new DefaultListModel();
      
        
        while(scanner.hasNext()){
        model.addElement(scanner.next());
        }

        jList1.setModel(model);
        scanner.close();
 
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kontrahenci");
        setBounds(new java.awt.Rectangle(400, 100, 0, 0));

        jList1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listSelection(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jButton1.setText("Szukaj");

        jButton2.setText("Usuń");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // popbrać zawartość wybranego obiektu z listy klietów i wpisać ją do excela
    private void listSelection(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSelection
        
        DefaultListModel model1 = new DefaultListModel();
        model1 = (DefaultListModel) jList1.getModel();
        Customer tCustomer = new Customer();
        
        if(evt.getClickCount() == 2){
            
            
                ////////////////////////////////////////////////////////////////////////////////////
                //kod niżej wykonuje się po dwukotnym wciśnięciu lewego przycisku myszki
                int index = jList1.locationToIndex(evt.getPoint()) ;
                String[] sTable = new String[5];
                sTable = model1.get(index).toString().split("#");

                tCustomer.setName(sTable[0]);
                tCustomer.setSurename(sTable[1]);
                tCustomer.setAddress(sTable[2]);
                tCustomer.setFirm(sTable[3]);
                tCustomer.setNip(sTable[4]);


                mainFrame.fillTextFields(sTable);
                
                this.dispose();
                

/*                        
            //wywołujemy metodę saveExcelCustomer z klasy Excel 
            Excel addingFromDatabase = new Excel();
            try {
                addingFromDatabase.saveExcelCustomer(tCustomer);
                
                ///////////////////////////////////////////////////////////////////////////////////
            } catch (IOException ex) {
                Logger.getLogger(ClientsFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BiffException ex) {
                Logger.getLogger(ClientsFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (WriteException ex) {
                Logger.getLogger(ClientsFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
*/           
        }
       

        
    }//GEN-LAST:event_listSelection

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        File tFile = new File("D://klienci.txt");
        DefaultListModel lModel = new DefaultListModel();
        
        lModel = (DefaultListModel) jList1.getModel();
        
        int lineIndex = 0;
        lineIndex  = jList1.getSelectedIndex();
        
        try{
        
        if(lineIndex == -1){
            
            JOptionPane.showMessageDialog(this.getContentPane(), "Zaznacz wpis do usunięcia! ");
            
        }else{
            //usuwamy z listy pozycję która jest zaznaczona
            lModel.removeElementAt(lineIndex);
        }
        }catch(ArrayIndexOutOfBoundsException exeption){    
        
            System.out.println("Error");
        
        }

        try {
            
            //usuwamy zaznaczoną linijkę z pliku
            removeLine(tFile, lineIndex);
            
            
        } catch (IOException ex) {
            Logger.getLogger(ClientsFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ClientsFrame().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ClientsFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void removeLine(File file, int lineNumber) throws IOException{

	BufferedReader bReader = new BufferedReader(new FileReader(file));
        ArrayList<String> aList = new ArrayList<>();
        String line;
        int index  = 0;

        
        while((line = bReader.readLine()) != null){

            aList.add(line.trim());

        }
        
        try{
        aList.remove(lineNumber);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error");
        }
        
        
        
        //aList.remove(aList.size());
        //System.out.println(aList.size());
/*            
        for(int p=0;p<aList.size();p++){
            
            
            System.out.print(aList.get(p));
            System.out.print(System.lineSeparator());
            
        }
*/   
       bReader.close();

       
       File tempFile = new File("D://tempC.txt");

       FileWriter fW = new FileWriter(tempFile);
       
       for(String s:aList){
           
           fW.append(s);
           fW.append(System.lineSeparator());
           
       }
       
       fW.close();
       
       copyFiles(tempFile, file);

       tempFile.delete();
    
    }
    public void copyFiles(File source,File destination) throws FileNotFoundException, IOException{
        
        InputStream is=null;
        OutputStream os = null;
        try{
        is = new FileInputStream(source);
        os = new FileOutputStream(destination);
                
        byte[] buffer = new byte[1024];
        int lenght;
        
        while((lenght = is.read(buffer)) > 0){
            
            os.write(buffer, 0, lenght);
            
            }
        }finally {
        is.close();
        os.close();
     }

        
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

