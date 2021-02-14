
package proceram;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class clientframe extends javax.swing.JFrame {

    int rnum=0,cnum=0,counter=0 , numpro=0;
    double smetres=0, scartones =0;
    String model_name =null;
    boolean new_client =true ;
    Connection conn =null;
ResultSet rs = null;
PreparedStatement pst = null;
String stockm= null , stockcrt=null, nbrsclients=null ,nbrsfactures = null ;

  
String nomdesociete=null,  telephone_de_societe = null,
        adress_de_societe = null, site_web_de_societe= null;


    ///////////////////////////////////////////

private void settingsinfo(){
    
        String sql = "Select * from settings ";
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()){
                nbrsclients = rs.getString("nbrsclients");
                nbrsfactures = rs.getString("nbrsfactures");
                 nomdesociete = rs.getString("nomdesociete");
                telephone_de_societe = rs.getString("telephone_de_societe");
                adress_de_societe = rs.getString("adress_de_societe");
                site_web_de_societe = rs.getString("site_web_de_societe");
         
                
                
            }
        }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);

        }
    }
    
////////////////////////////////////


private void updatesettings(String strc, String strf){
    String sqll =null;
    
    if(strc == null){
         sqll = "Update  settings set nbrsfactures ='" + strf+ 
            "' where id  = '1' ";
    
    }else{
        sqll = "Update  settings set nbrsclients ='" + strc+ 
             "', nbrsfactures ='"+strf+
            "' where id  = '1' ";
           
    }
     try{
            pst = conn.prepareStatement(sqll);
            pst.executeUpdate();
           
        }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);

        }

    
         
    
    }
    
/////////////////////////////////////////
private void getstockinfo(String nom_de_model){
    /*pour obtenir le stock par metre et par cartones */
    
        String sql = "Select * from stocktable where model ='"+nom_de_model+"'";
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()){
                stockm = rs.getString("stockm");
                stockcrt = rs.getString("stockcrt");
            }
        }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);

        }

    }
    

///////////////////////////////////////////////////////////

private void valider_vers_stock(String nom_de_model,String sm, String scrt){
    
 String sql = "Update  stocktable set stockm ='" + sm+ 
             "', stockcrt='"+scrt+
            "' where model  = '"+nom_de_model+" ' ";
        
   ///////////////////////////////////////////////////////////////           
    try{
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    

////////////////////////////////////////////////

private void valider_vers_mohetawaalfatura(){
   
  
  for(int addad =0;addad < numpro;addad++){
////////////////////////////////////////
                 
         String sql = "insert into mohetawaalfatura values(?,?,?,?,?,?,?)";
         try{
            pst = conn.prepareStatement(sql);
            ///////////////////////////////////////////////////S
            ////1 numero
            pst.setString(1, jTable1.getValueAt(addad, 0).toString() );
//////2  nom de produit
            pst.setString(2, jTable1.getValueAt(addad, 1).toString()  );
          /////3  metrage
            pst.setString(3,  jTable1.getValueAt(addad, 2).toString() );
            //////4 nombres de collis
            pst.setString(4,  jTable1.getValueAt(addad, 3).toString() );
  /////5  prix
            pst.setString(5,  jTable1.getValueAt(addad, 4).toString() );
            //////6 la somme 
            pst.setString(6,  jTable1.getValueAt(addad, 5).toString() );
            ///// 7 code de la facture  
            pst.setString(7,  jTextField4.getText() );
            pst.execute();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
////////////////////////////////////////////////////////


                                }
         
    }
    

/////////////////////////////////////////

private void valider_vers_facture(){
   
  ////////////////////////////////////////
                 
         String sql = "insert into faturatable values(?,?,?,?,?,?)";
         try{
            pst = conn.prepareStatement(sql);
            ///////////////////////////////////////////////////S
            ////1 la date
            pst.setString(1, jLabel13.getText() );
//////2  somme 
            pst.setString(2, jTextField6.getText()  );
          /////3  versement
            pst.setString(3,  jTextField7.getText() );
            //////4 reste
            pst.setString(4,  jTextField9.getText() );
  /////3  numero de la facture
            pst.setString(5,  jTextField4.getText() );
            //////4 code de client
            pst.setString(6,  jTextField8.getText() );
   ///////////////////////

////////////////////////////////////////////////////////////////////////           
            pst.execute();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

       
         
         
    
    }
    


////////////////////////////////////
private void valider_vers_un_client(){
   
  ////////////////////////////////////////
                 
         String sql = "insert into client values(?,?,?,?)";
         try{
            pst = conn.prepareStatement(sql);
            //////////////////////////////////////////////////
            ////1 nom de client
            pst.setString(1, jTextField1.getText() );
//////2  prenom de client 
            pst.setString(2, jTextField2.getText()  );
          /////3  telephone
            pst.setString(3,  jTextField5.getText() );
            //////4 code de client /// id 
            pst.setString(4,  jTextField8.getText() );
   ////////////////////////////////////////////////////////////////////////           
            pst.execute();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

       
         
         
    
    }
    
    ////////////////////////
    public void calculating(){
       
    
              int sum = Integer.parseInt(jTextField6.getText());
        int versement = Integer.parseInt(jTextField7.getText());
        int reste = sum - versement;
        jTextField9.setText(String.valueOf(reste));
    
    }
  
    public clientframe() {
        initComponents();
    }

 public clientframe(int numprod ,String sommetotale , ArrayList tab , String comboboxstat) {
        initComponents();
        jTextField6.setText(sommetotale);
        
        for( rnum=0;rnum < numprod   ;rnum++ ){
     
              for( cnum=0; cnum < 6   ;cnum++ ){

            jTable1.setValueAt(tab.get(counter), rnum, cnum);
        
counter++;
              }}   
        numpro=numprod;
        
        jComboBox1.setSelectedItem(comboboxstat);
        
        
        
    }







    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jTextField10 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

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

        jTable1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "numero", "produit", "metrage", "nombres de collis", "prix", "somme"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setFillsViewportHeight(true);
        jTable1.setRowHeight(40);
        jTable1.setSelectionBackground(new java.awt.Color(51, 51, 255));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(400, 110, 740, 320);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 51, 51));
        jButton2.setText("x");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(1080, 10, 62, 50);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setText("-");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(1020, 10, 63, 50);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Facturer / clients");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 20, 410, 80);

        jLabel8.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel8.setText("telephone");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(30, 320, 130, 25);

        jLabel11.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel11.setText("somme/Facture");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(10, 360, 180, 39);

        jTextField9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jTextField9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jTextField9);
        jTextField9.setBounds(190, 460, 200, 40);

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel5.setText("prenom");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(40, 260, 100, 25);

        jTextField6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jTextField6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField6.setPreferredSize(new java.awt.Dimension(200, 40));
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField6);
        jTextField6.setBounds(190, 360, 200, 40);

        jTextField5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jTextField5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField5.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel1.add(jTextField5);
        jTextField5.setBounds(190, 310, 200, 40);

        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel9.setText("reste à payer ");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 460, 150, 25);

        jLabel13.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jPanel1.add(jLabel13);
        jLabel13.setBounds(790, 50, 210, 60);

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel4.setText("nom");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 210, 70, 25);

        jTextField7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jTextField7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField7.setPreferredSize(new java.awt.Dimension(200, 40));
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField7);
        jTextField7.setBounds(190, 410, 200, 40);

        jTextField2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField2.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel1.add(jTextField2);
        jTextField2.setBounds(190, 260, 200, 40);

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel10.setText("versement");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(10, 410, 180, 40);

        jTextField1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField1.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel1.add(jTextField1);
        jTextField1.setBounds(190, 210, 200, 40);

        jButton7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 28)); // NOI18N
        jButton7.setText("Valider");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(30, 520, 130, 70);

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel7.setText("Code de Client");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 160, 170, 40);

        jTextField8.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jTextField8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jTextField8);
        jTextField8.setBounds(190, 160, 200, 40);

        jLabel12.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel12.setText("Rechercher d'un Client :");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(360, 500, 270, 50);

        jTable3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable3.setRowHeight(40);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(620, 440, 520, 160);

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
        jTextField10.setBounds(410, 540, 200, 50);

        jTextField4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jTextField4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField4);
        jTextField4.setBounds(190, 110, 200, 40);

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel6.setText("facture N:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 110, 130, 40);

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel3.setText("date de :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(670, 50, 110, 50);

        jButton1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jButton1.setText("Valider / Retour");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(30, 520, 240, 70);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Program Files\\ceramics\\Compass back ground.jpg")); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, -400, 1280, 1190);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "vendre", "retour" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(510, 20, 59, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        

    }//GEN-LAST:event_formWindowActivated

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

caisseframe abdodo = new caisseframe();
         abdodo.setVisible(true);
             
this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed


this.setState(JFrame.ICONIFIED);



    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

      ImageIcon img = new ImageIcon("C:\\Program Files\\ceramics\\ProCeram.jpg");

       this.setIconImage(img.getImage());
        
        jLabel13.setText( java.time.LocalDate.now().toString() );  

         conn = ProCeram.ConnectDB();
           jTable1.getTableHeader().setFont(  new Font("SansSerif", Font.BOLD, 12));    
           
           
settingsinfo();
   
nbrsclients = String.valueOf( Integer.parseInt(nbrsclients)+1)    ;

jTextField8.setText(nbrsclients);
nbrsfactures   = String.valueOf( Integer.parseInt(nbrsfactures)+1)    ;
jTextField4.setText(nbrsfactures);


    }//GEN-LAST:event_formWindowOpened

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased

                     calculating();       
        


    }//GEN-LAST:event_jTextField6KeyReleased

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
         
                     calculating();       

    }//GEN-LAST:event_jTextField7KeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
                  
////////////////////////////////////////////////////////////////
        if (new_client == true){
        ///////si on a un nouveau client ////////////////
        
           valider_vers_un_client();
         updatesettings(nbrsclients,nbrsfactures);

           //////////////////
    }  else {
                 updatesettings(null,nbrsfactures);

    }
        
 ////////////////////////////////////////////////////////////       
  /*pour remplire la facture et les lines de la factures */      
         valider_vers_facture();
         valider_vers_mohetawaalfatura();
///////////////////////////////////////////////////////////////////
   /*pour metre a joure les donnees dans le stock */
 
     for(int k =0;k< numpro ;k++){
   
   model_name = jTable1.getValueAt(k,1).toString();
 getstockinfo( model_name );
    
  smetres=Double.parseDouble(stockm)- Double.parseDouble(jTable1.getValueAt(k,2).toString());
  stockm=String.valueOf((float)smetres);
  scartones=Double.parseDouble(stockcrt)- Double.parseDouble(jTable1.getValueAt(k,3).toString());
  stockcrt=String.valueOf((float)scartones);
 valider_vers_stock(   model_name  ,  stockm , stockcrt   );
 
     }
 //////////////////////////////////////////////////////////////
billsframe bf = 
new billsframe( numpro ,jTextField6.getText() 
        , gettable() , jTextField4.getText() ,
        jTextField1.getText()+" "+jTextField2.getText(),jTextField7.getText(),jTextField9.getText()

    , nomdesociete , telephone_de_societe , adress_de_societe , site_web_de_societe
) ;

  bf.setVisible(true );
  ////      
  
  this.dispose();
  
  
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

   

    }//GEN-LAST:event_jTable1MouseClicked

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

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked

 int row = jTable3.getSelectedRow();
    
         jTextField1.setText(jTable3.getModel().getValueAt(row,0).toString());
        jTextField2.setText(jTable3.getModel().getValueAt(row, 1).toString());
        jTextField5.setText(jTable3.getModel().getValueAt(row, 2).toString());
        jTextField8.setText(jTable3.getModel().getValueAt(row, 3).toString());
   
        new_client = false ;



    }//GEN-LAST:event_jTable3MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed


        if(jComboBox1.getSelectedItem()== "retour"){
    jButton7.setVisible(false);
    jButton1.setVisible(true);

        }else{
       jButton1.setVisible(false);
    jButton7.setVisible(true);
     
        }

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

          updatesettings(null,nbrsfactures);
 ////////////////////////////////////////////////////////////       
  /*pour remplire la facture et les lines de la factures */      
        
  jTextField6.setText("-"+jTextField6.getText());
  jTextField7.setText("-"+jTextField7.getText());
  jTextField9.setText("-"+jTextField9.getText());
  
         valider_vers_facture();
         valider_vers_mohetawaalfatura();
///////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////
   /*pour metre a joure les donnees dans le stock */
 
     for(int k =0;k< numpro ;k++){
   
   model_name = jTable1.getValueAt(k,1).toString();
 getstockinfo( model_name );
    
  smetres=Double.parseDouble(stockm)+ Double.parseDouble(jTable1.getValueAt(k,2).toString());
  stockm=String.valueOf((float)smetres);
  scartones=Double.parseDouble(stockcrt)+ Double.parseDouble(jTable1.getValueAt(k,3).toString());
  stockcrt=String.valueOf((float)scartones);
 valider_vers_stock(   model_name  ,  stockm , stockcrt   );
 
     }

 //////////////////////////////////////////////////////////////
billsframe bf = 
new billsframe( numpro ,jTextField6.getText() 
        , gettable() , jTextField4.getText() ,
        jTextField1.getText()+" "+jTextField2.getText(),jTextField7.getText(),jTextField9.getText()

    , nomdesociete , telephone_de_societe , adress_de_societe , site_web_de_societe
) ;

  bf.setVisible(true );
  ////      
  
  this.dispose();
  
     

//////////////////////////////////////////////////////////////




    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(clientframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clientframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clientframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clientframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new clientframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables


  ////////////////////
     private ArrayList gettable(){
 
    ArrayList numdata = new ArrayList();
            for (int count = 0; count < numpro ; count++) {
                for (int cl = 0; cl < 6; cl++) {
                    numdata.add(jTable1.getValueAt(count, cl).toString());
                }
            }

 return numdata;
 }
    


}
