/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proceram;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author aladdin atba
 */
public class workerframe extends javax.swing.JFrame {

    
    Connection conn =null;
ResultSet rs = null;
PreparedStatement pst = null;
   SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");  
  
private void UpdateJTable(){
    String sql = "Select * from worker ";
    try{
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    
     jTable1.getColumnModel().getColumn(0).setPreferredWidth(270);
    
    
    }
    

private void UpdateFields(){
    
    jTextField1.setText(null);
    jTextField2.setText(null);
    jTextField4.setText(null);
  

  
   
}
    
    
    public workerframe() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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
        jPanel1.setMinimumSize(new java.awt.Dimension(802, 372));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 60)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("mains d'oeuvres ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 10, 500, 100);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 51));
        jButton1.setText("x");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(1023, 10, 60, 50);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 51));
        jButton2.setText("-");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(960, 10, 60, 50);

        jTextField4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jTextField4.setMaximumSize(new java.awt.Dimension(120, 40));
        jTextField4.setMinimumSize(new java.awt.Dimension(120, 40));
        jTextField4.setPreferredSize(new java.awt.Dimension(250, 40));
        jPanel1.add(jTextField4);
        jTextField4.setBounds(130, 230, 200, 50);

        jTextField2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jTextField2.setMaximumSize(new java.awt.Dimension(120, 40));
        jTextField2.setMinimumSize(new java.awt.Dimension(120, 40));
        jTextField2.setPreferredSize(new java.awt.Dimension(250, 40));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2);
        jTextField2.setBounds(130, 170, 200, 50);

        jDateChooser2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jPanel1.add(jDateChooser2);
        jDateChooser2.setBounds(130, 350, 200, 50);

        jTextField1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jTextField1.setMaximumSize(new java.awt.Dimension(120, 40));
        jTextField1.setMinimumSize(new java.awt.Dimension(120, 40));
        jTextField1.setPreferredSize(new java.awt.Dimension(250, 40));
        jPanel1.add(jTextField1);
        jTextField1.setBounds(130, 110, 200, 50);

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel4.setText("nom");
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 120, 87, 40);

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Program Files\\ceramics\\add client.png")); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(400, 90, 70, 70);

        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Program Files\\ceramics\\edite.png")); // NOI18N
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(480, 90, 70, 70);

        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Program Files\\ceramics\\delete.png")); // NOI18N
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(560, 90, 70, 70);

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel5.setText("prenom");
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 180, 87, 29);

        jTextField3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 30)); // NOI18N
        jTextField3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField3);
        jTextField3.setBounds(820, 110, 200, 50);

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 20)); // NOI18N
        jLabel2.setText("rechercher / nom :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(800, 70, 200, 50);

        jLabel12.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel12.setText("tel");
        jLabel12.setOpaque(true);
        jPanel1.add(jLabel12);
        jLabel12.setBounds(30, 240, 62, 30);

        jLabel8.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel8.setText("debut le ");
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 360, 100, 34);

        jTable1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setRowHeight(40);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(340, 170, 740, 230);

        jDateChooser1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jDateChooser1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jDateChooser1ComponentAdded(evt);
            }
        });
        jDateChooser1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jDateChooser1InputMethodTextChanged(evt);
            }
        });
        jPanel1.add(jDateChooser1);
        jDateChooser1.setBounds(450, 410, 200, 50);

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel6.setText("jusqu'au ");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(330, 420, 90, 25);

        jTextField5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jPanel1.add(jTextField5);
        jTextField5.setBounds(450, 470, 200, 50);

        jTextField6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField6);
        jTextField6.setBounds(130, 290, 200, 50);

        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 51, 51));
        jTextField7.setDisabledTextColor(new java.awt.Color(255, 51, 51));
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField7);
        jTextField7.setBounds(760, 470, 310, 80);

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel7.setText("somme ");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(660, 480, 80, 40);

        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel9.setText("nombres de jours de travails");
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(190, 480, 260, 40);

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel10.setText("prix / jrs");
        jLabel10.setOpaque(true);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 300, 100, 30);

        jButton6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jButton6.setText("Calculer");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(780, 410, 140, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Program Files\\ceramics\\macons photo frame.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-20, -30, 1120, 830);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1096, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

   
    }//GEN-LAST:event_formWindowActivated

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed


        
Compass cmp = new Compass();
cmp.setVisible(true);
this.dispose();



    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed



this.setState(JFrame.ICONIFIED);



    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

                     
                  if ( jDateChooser2.getDate()== null){
            
           
 try {
            jDateChooser2.setDate(formatter1.parse(java.time.LocalDate.now().toString()));

            
 } catch (ParseException ex) {
            Logger.getLogger(commandeframe.class.getName()).log(Level.SEVERE, null, ex);
        }   
                  }
           String mday = formatter1.format(jDateChooser2.getDate());

                        
                        
    ///////////////////////////////////////////////////////////////////////////                    
                        
         String sql = "insert into worker values(?,?,?,? ,? )";
        
         
         try{
            pst = conn.prepareStatement(sql);
            ///////////////////////////////////////////////////S
            ////1 
            pst.setString(1, jTextField1.getText() );
//////2 
            pst.setString(2, jTextField2.getText()  );
          /////3  
            pst.setString(3,  jTextField4.getText() );
            //////4 
            pst.setString(4, mday  );
    ////// 5
            pst.setString(5, jTextField6.getText()  );
    
 //////////////////////////////PrixParJour////////////////////////////////////////////           
            pst.execute();
            

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

            UpdateJTable();
            UpdateFields();




    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

                String DayString = formatter1.format(jDateChooser2.getDate());

        
        
    String sql = "Update  worker set tel ='" + jTextField4.getText()+ 
            "', nom= '"+jTextField1.getText()+""
            + "', prenom='"+jTextField2.getText()+
          
            
            "',date ='"+DayString+ 
                "', PrixParJour ='"+jTextField6.getText()+ 
            
            "' where tel  ='"+jTextField4.getText() +"'";
        
    ///////////////////////////////////////////////////S
  
 //////////////////////////////////////////////////////////////////////////           
            
    
    try{
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
       
        
            UpdateFields();

 UpdateJTable();


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed



String sql = "delete * from worker where tel ='" +jTextField4.getText()+ "'";
        try{
            pst = conn.prepareStatement(sql);
            pst.execute();
        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
   
            UpdateJTable();

            UpdateFields();



    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased

String temp = jTextField3.getText() + "%";
        String sql = "select * from worker where nom like'"+temp+"'";
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
        



    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

  int row = jTable1.getSelectedRow();
    
         jTextField1.setText(jTable1.getModel().getValueAt(row, 0).toString());
         jTextField2.setText(jTable1.getModel().getValueAt(row,1).toString());
         jTextField4.setText(jTable1.getModel().getValueAt(row, 2).toString());
         jTextField6.setText(jTable1.getModel().getValueAt(row, 4).toString());
       
   try {
            jDateChooser2.setDate(formatter1.parse(jTable1.getValueAt(row, 3).toString()));
        } catch (ParseException ex) {
            Logger.getLogger(commandeframe.class.getName()).log(Level.SEVERE, null, ex);
        }
  

    }//GEN-LAST:event_jTable1MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

         ImageIcon img = new ImageIcon("C:\\Program Files\\ceramics\\ProCeram.jpg");

       this.setIconImage(img.getImage());
        
        
        
 conn = ProCeram.ConnectDB();
    UpdateJTable();
    


    }//GEN-LAST:event_formWindowOpened

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased

        
         
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jDateChooser1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jDateChooser1ComponentAdded

       
        
    }//GEN-LAST:event_jDateChooser1ComponentAdded

    private void jDateChooser1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jDateChooser1InputMethodTextChanged

        
   
        
    }//GEN-LAST:event_jDateChooser1InputMethodTextChanged

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

  Date debut =  jDateChooser2.getDate();
        LocalDate localdebut= debut.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date jusq =    jDateChooser1.getDate();
        LocalDate localjusqu = jusq.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
   long  numdays = ChronoUnit.DAYS.between( localdebut , localjusqu );

   jTextField5.setText(String.valueOf(numdays+1));
             ////////////////////////////////////////
int nbrjrs = Integer.parseInt(jTextField5.getText());
int prix =  Integer.parseInt(jTextField6.getText());

int sommedetravaille = nbrjrs * prix ;

jTextField7.setText(String.valueOf(sommedetravaille));




    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

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
            java.util.logging.Logger.getLogger(workerframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(workerframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(workerframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(workerframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new workerframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
