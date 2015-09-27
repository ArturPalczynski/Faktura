package faktura;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class MainWindow extends javax.swing.JFrame {

    JTable table;

    int counter = 1;
    ArrayList<Customer> customerList;
    File plikKlient = new File("D://klienci.txt");
    FileWriter writer;
    MyTableModel modelTable = new MyTableModel();

    public MainWindow() throws IOException {

        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldImie = new javax.swing.JTextField();
        fieldNazwosko = new javax.swing.JTextField();
        fieldAddress = new javax.swing.JTextField();
        fieldNazwaFrimy = new javax.swing.JTextField();
        fieldNIP = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Faktura");
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                FocusHendler(evt);
            }
        });

        jLabel2.setText("Nazwisko:");

        jLabel3.setText("Adres:");

        jLabel4.setText("Nazwa Firmy:");

        jLabel5.setText("NIP:");

        fieldImie.setColumns(10);
        fieldImie.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        fieldImie.setFocusCycleRoot(true);
        fieldImie.setNextFocusableComponent(fieldNazwosko);
        fieldImie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldImieActionPerformed(evt);
            }
        });

        fieldNazwosko.setColumns(10);
        fieldNazwosko.setMinimumSize(new java.awt.Dimension(6, 26));
        fieldNazwosko.setNextFocusableComponent(fieldAddress);
        fieldNazwosko.setPreferredSize(new java.awt.Dimension(86, 25));
        fieldNazwosko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNazwoskoActionPerformed(evt);
            }
        });

        fieldAddress.setColumns(10);
        fieldAddress.setNextFocusableComponent(fieldNazwaFrimy);
        fieldAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldAddressActionPerformed(evt);
            }
        });

        fieldNazwaFrimy.setColumns(10);
        fieldNazwaFrimy.setNextFocusableComponent(fieldNIP);
        fieldNazwaFrimy.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                fieldNazwaFrimyCaretUpdate(evt);
            }
        });
        fieldNazwaFrimy.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                fieldNazwaFrimyComponentShown(evt);
            }
        });
        fieldNazwaFrimy.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldNazwaFrimyFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldNazwaFrimyFocusLost(evt);
            }
        });

        fieldNIP.setColumns(10);
        fieldNIP.setNextFocusableComponent(jButton1);
        fieldNIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNIPActionPerformed(evt);
            }
        });

        jLabel1.setText("Imię:");

        jButton1.setText("Dodaj klienta do bazy");
        jButton1.setNextFocusableComponent(jButton6);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Zapisz");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Dodaj wiersz");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Pokaż Fakture");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Lista Kotrahentów");
        jButton6.setNextFocusableComponent(fieldImie);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTable2.setModel(modelTable);
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(35);

        jButton4.setText("Usuń wiersz");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(29, 29, 29)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fieldNazwaFrimy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fieldNIP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addGap(47, 47, 47)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(fieldImie, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fieldNazwosko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {fieldAddress, fieldImie, fieldNIP, fieldNazwaFrimy, fieldNazwosko});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldImie, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(fieldNazwosko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(fieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNazwaFrimy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton5)
                    .addComponent(jButton4))
                .addGap(23, 23, 23))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {fieldAddress, fieldImie, fieldNIP, fieldNazwaFrimy, fieldNazwosko});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldImieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldImieActionPerformed

    }//GEN-LAST:event_fieldImieActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Customer tempCustomer = new Customer();
        Excel excel = new Excel();
        customerList = new ArrayList<>();

        if (fieldImie.getText().equals("") || fieldNazwosko.getText().equals("")
                || fieldAddress.getText().equals("") || fieldNazwaFrimy.getText().equals("")
                || fieldNIP.getText().equals("")) {

            JOptionPane.showMessageDialog(this.getContentPane(), "Wypełnij wszystkie pola!");

        } else {

            String tempImie = fieldImie.getText();
            String tempNazwisko = fieldNazwosko.getText();
            String tempAddress = fieldAddress.getText();
            String tempNazwa = fieldNazwaFrimy.getText();
            String tempnip = fieldNIP.getText();

            tempCustomer.setName(tempImie);
            tempCustomer.setSurename(tempNazwisko);
            tempCustomer.setAddress(tempAddress);
            tempCustomer.setFirm(tempNazwa);
            tempCustomer.setNip(tempnip);

            customerList.add(tempCustomer);
            try {
                writer = new FileWriter(plikKlient, true);
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {

                writer.append(customerList.get(0).getName() + "#"
                        + customerList.get(0).getSureName()
                        + "#" + customerList.get(0).getAddress() + "#"
                        + customerList.get(0).getFirm() + "#"
                        + customerList.get(0).getNIP() + "#\n");

                //writer.flush();
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Excel newExcel = new Excel();
        Customer client = new Customer();

        client.setName(fieldImie.getText());
        client.setSurename(fieldNazwosko.getText());
        client.setAddress(fieldAddress.getText());
        client.setFirm(fieldNazwaFrimy.getText());
        client.setNip(fieldNIP.getText());

        try {
            newExcel.SaveExcel(client, jTable2);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //funkcja która sprawdza czy wpisane dane klienta znajdują się już w bazie danych kontrahentów
            // jeśli nie ma tam wpisu to dodaje go do bazy, jeśli jest to to nie robi nic
            //sprawdzany będzie nip

            checkForExistingItem(fieldNIP.getText());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    public void checkForExistingItem(String n) throws FileNotFoundException, IOException {

        Scanner sC = new Scanner(plikKlient);
        FileWriter fileWriter = new FileWriter(plikKlient, true);
        boolean status = false;

        sC.useDelimiter("#");

        while (sC.hasNext()) {

            if (sC.next().equals(n)) {
                System.out.println("Pasuje");
                status = true;
                break;
            }
        }

        if (status == false) {

            fileWriter.append(fieldImie.getText() + "#"
                    + fieldNazwosko.getText() + "#"
                    + fieldAddress.getText() + "#"
                    + fieldNazwaFrimy.getText() + "#"
                    + fieldNIP.getText() + "#\n");

        }

        fileWriter.close();
        sC.close();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        modelTable.addRow();
        jTable2.getColumnModel().getColumn(0).setMaxWidth(35);

    }//GEN-LAST:event_jButton3ActionPerformed

    //dodatkowy frame na liste klientów
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        ClientsFrame clFrame = null;
        try {
            clFrame = new ClientsFrame();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        clFrame.setVisible(true);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void FocusHendler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FocusHendler

    }//GEN-LAST:event_FocusHendler

    private void fieldNazwaFrimyCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_fieldNazwaFrimyCaretUpdate

    }//GEN-LAST:event_fieldNazwaFrimyCaretUpdate

    private void fieldNazwaFrimyComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_fieldNazwaFrimyComponentShown

    }//GEN-LAST:event_fieldNazwaFrimyComponentShown

    private void fieldNazwaFrimyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldNazwaFrimyFocusGained

    }//GEN-LAST:event_fieldNazwaFrimyFocusGained

    private void fieldNazwaFrimyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldNazwaFrimyFocusLost

    }//GEN-LAST:event_fieldNazwaFrimyFocusLost

    private void fieldNIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNIPActionPerformed

    }//GEN-LAST:event_fieldNIPActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        Desktop desktop = Desktop.getDesktop();

        File outputFile = new File("C://OutputExcel.xlsx");
        try {
            desktop.open(outputFile);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void fieldNazwoskoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNazwoskoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNazwoskoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        modelTable.removeRow();
        jTable2.getColumnModel().getColumn(0).setMaxWidth(35);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void fieldAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldAddressActionPerformed

    public static void fillTextFields(String[] s) {

        fieldImie.setText(s[0]);
        fieldNazwosko.setText(s[1]);
        fieldAddress.setText(s[2]);
        fieldNazwaFrimy.setText(s[3]);
        fieldNIP.setText(s[4]);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextField fieldAddress;
    private static javax.swing.JTextField fieldImie;
    private static javax.swing.JTextField fieldNIP;
    private static javax.swing.JTextField fieldNazwaFrimy;
    private static javax.swing.JTextField fieldNazwosko;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
