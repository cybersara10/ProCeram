/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proceram;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class commandeframe extends javax.swing.JFrame {

    Connection conn =null;
ResultSet rs = null;
PreparedStatement pst = null;
String nbrcom = null ;
 SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");  

///////////////////////////////////////////////////////



////////////////////////////////////////////////////

   
private void UpdateClients(){
    String sql = "Select * from client ";
    try{
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        jTable3.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    
    
    
    }

///////////////////////////////////////////////////////

private void settingsinfo(){
    
        String sql = "Select * from settings ";
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()){
                nbrcom = rs.getString("nbrcom");
            }
        }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);

        }
    }
    
///////////////////////////////////////

private void updatesettings(String strc){
  
     String   sqll = "Update  settings set nbrcom ='" + strc+ 
            "' where id  = '1' ";
           
     try{
            pst = conn.prepareStatement(sqll);
            pst.executeUpdate();
           
        }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);

        }

    
         
    
    }
    
/////////////////////////////////////////
////////////////////////////////////
private void UpdateJTable3(){
       
        String sql = "select * from commandes ";
    
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

    
    }




private void UpdateJTable(){
       
       String  temp = jTextField1.getText() + "%";
        String sql = "select * from commandes where code like'"+temp+"'";
    
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

    
    }

    
    public commandeframe() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jTextField10 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton8 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("x");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(1243, 30, 50, 50);

        jTable3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable3.setRowHeight(40);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(410, 120, 870, 150);

        jTextField10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jTextField10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField10KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField10);
        jTextField10.setBounds(690, 60, 200, 50);

        jLabel12.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel12.setText("Rechercher d'un Client :");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(410, 60, 270, 50);

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Program Files\\ceramics\\delete.png")); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(560, 290, 60, 60);

        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Program Files\\ceramics\\add.png")); // NOI18N
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(420, 290, 60, 60);

        jTextField8.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField8);
        jTextField8.setBounds(1040, 290, 220, 50);

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel10.setText("rechercher / model :");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(830, 300, 240, 40);

        jTextField1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 20)); // NOI18N
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jTextField1);
        jTextField1.setBounds(180, 130, 200, 50);

        jTextField2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 20)); // NOI18N
        jTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jTextField2);
        jTextField2.setBounds(180, 190, 200, 50);

        jTextField3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 20)); // NOI18N
        jTextField3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jTextField3);
        jTextField3.setBounds(180, 250, 200, 50);

        jTextField4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 20)); // NOI18N
        jTextField4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jTextField4);
        jTextField4.setBounds(180, 310, 200, 50);

        jTextField5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 20)); // NOI18N
        jTextField5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jTextField5);
        jTextField5.setBounds(180, 370, 200, 50);

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel3.setText("comm. N:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 200, 130, 40);

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel4.setText("Code de Client");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 140, 130, 40);

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel5.setText("nom de model");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 250, 130, 40);

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel6.setText("Quantité");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 310, 130, 40);

        jButton7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon("C:\\Program Files\\ceramics\\print btn.png")); // NOI18N
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(700, 290, 60, 60);

        jDateChooser1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jPanel1.add(jDateChooser1);
        jDateChooser1.setBounds(180, 500, 200, 50);

        jButton8.setIcon(new javax.swing.ImageIcon("C:\\Program Files\\ceramics\\refresh-icon323dsa3.png")); // NOI18N
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(630, 290, 60, 60);

        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Program Files\\ceramics\\edite.png")); // NOI18N
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(490, 290, 60, 60);

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel7.setText("Versement");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 370, 130, 40);

        jLabel8.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel8.setText("date de :");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 500, 130, 40);

        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel9.setText("Reste a payer");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 430, 130, 40);

        jTextField6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 20)); // NOI18N
        jTextField6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jTextField6);
        jTextField6.setBounds(180, 430, 200, 50);

        jTable1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setRowHeight(40);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(400, 360, 900, 250);

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Les commandes ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 20, 440, 80);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("-");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(1190, 30, 50, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Program Files\\ceramics\\Compass back ground.jpg")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, -10, 1320, 740);
        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(300, 70, 2, 2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

      

    }//GEN-LAST:event_formWindowActivated

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Compass com = new Compass();
        com.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed



this.setState(JFrame.ICONIFIED);
       


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased

        String temp = jTextField10.getText() + "%";
        String sql = "select * from client where nom like'"+temp+"'";
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_jTextField10KeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

 ImageIcon img = new ImageIcon("C:\\Program Files\\ceramics\\ProCeram.jpg");

       this.setIconImage(img.getImage());
conn =ProCeram.ConnectDB();

UpdateClients();
UpdateJTable3();



    }//GEN-LAST:event_formWindowOpened

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked

  int row = jTable3.getSelectedRow();
   
  jTextField1.setText(jTable3.getValueAt(row, 3).toString());
        
UpdateJTable(  );

    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

int row = jTable1.getSelectedRow();
   
  jTextField2.setText(jTable1.getValueAt(row, 0).toString());
  jTextField3.setText(jTable1.getValueAt(row, 2).toString());
  jTextField4.setText(jTable1.getValueAt(row, 3).toString());
  jTextField5.setText(jTable1.getValueAt(row, 4).toString());
  jTextField6.setText(jTable1.getValueAt(row, 5).toString());
  
  
  
   try {
            jDateChooser1.setDate(formatter1.parse(jTable1.getValueAt(row, 6).toString()));
        } catch (ParseException ex) {
            Logger.getLogger(commandeframe.class.getName()).log(Level.SEVERE, null, ex);
        }
  

  






    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        String DayString = formatter1.format(jDateChooser1.getDate());

        
  String sql = "Update  commandes  set cid ='" + jTextField2.getText()+ 
            "', code= '"+jTextField1.getText()+   
            "', produit= '"+jTextField3.getText()+
            "', cartones= '"+jTextField4.getText()+
            "', versement = '"+jTextField5.getText()+
            "',reste ='"+jTextField6.getText()+ 
            "',ladate ='"+DayString+ 
            "' where cid  = '"+jTextField2.getText()+" ' ";
        
    ///////////////////////////////////////////////////S
  
 //////////////////////////////////////////////////////////////////////////           
            
    
    try{
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "modifiee");
            }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

                    UpdateJTable( );




    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
    String temp = jTextField8.getText() + "%";
        String sql = "select * from commandes where produit like'"+temp+"'";
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTextField8KeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

       
        

String sql = "delete * from commandes where cid ='" +jTextField2.getText()+ "'";
        try{
            pst = conn.prepareStatement(sql);
            pst.execute();        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
   
                    UpdateJTable( );

     

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

         settingsinfo();
        nbrcom = String.valueOf( Integer.parseInt(nbrcom)+1 )  ;        
String DateString = formatter1.format(jDateChooser1.getDate());
       
         String sql = "insert into commandes values  (?,?,?,?,?,?,? )";
        
         
         try{
            pst = conn.prepareStatement(sql);
            ///////////////////////////////////////////////////S
            ////commande id
            pst.setString(1, nbrcom );
//////2 code de client
            pst.setString(2, jTextField1.getText()  );
          /////3  produit
             pst.setString(3, jTextField3.getText() );
/////    nombre de cartones    
            pst.setString(4,  jTextField4.getText() );
             ////versement
            pst.setString(5, jTextField5.getText() );
//////2 reste 
            pst.setString(6, jTextField6.getText()  );
          /////3  la date
             pst.setString(7, DateString );
      
 //////////////////////////////////////////////////////////////////////////           
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "enregistre");

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

            UpdateJTable();
          
            updatesettings(nbrcom);


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

UpdateClients();
UpdateJTable3();
jTextField1.setText(null);
jTextField2.setText(null);
jTextField3.setText(null);
jTextField4.setText(null);
jTextField5.setText(null);
jTextField6.setText(null);
jTextField8.setText(null);
jTextField10.setText(null);

 try {
            jDateChooser1.setDate(formatter1.parse(java.time.LocalDate.now().toString()));
        } catch (ParseException ex) {
            Logger.getLogger(commandeframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        try {
            jTable1.print();
        } catch (PrinterException ex) {
            Logger.getLogger(commandeframe.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(commandeframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(commandeframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(commandeframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(commandeframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new commandeframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
