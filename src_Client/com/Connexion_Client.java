package com;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.jtattoo.plaf.texture.TextureLookAndFeel;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.rmi.Naming;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Elhacen
 */
public class Connexion_Client extends javax.swing.JFrame {
    private final int HAUTEUR;
    private final int LARGEUR;
    private final Dimension staille;
 
    /**
     * Creates new form Connexion
     */
    public Connexion_Client() {
        initComponents();
        trayIcon = new TrayIcon(image.loadImage("/images/icon.png").getImage());
        staille = Toolkit.getDefaultToolkit().getScreenSize() ;
        HAUTEUR=this.getHeight();
        LARGEUR=this.getWidth();
	setBounds((staille.width-LARGEUR)/2,(staille.height-HAUTEUR)/2-50,this.getWidth(),this.getHeight()) ;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bt_Connexion = new javax.swing.JButton();
        erreur = new javax.swing.JLabel();
        ip = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client Chat");
        setIconImage(image.loadImage("/images/icon.png").getImage());
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/username.gif"))); // NOI18N
        jLabel1.setText(":");

        username.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ip.png"))); // NOI18N
        jLabel2.setText(":");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Connexion");

        bt_Connexion.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        bt_Connexion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        bt_Connexion.setText("Log In");
        bt_Connexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ConnexionActionPerformed(evt);
            }
        });

        erreur.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        erreur.setForeground(new java.awt.Color(204, 0, 0));
        erreur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        ip.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("?");
        jLabel4.setToolTipText("<html>Entered the IP address of Server Screen .<br> Exampl : <b>192.168.1.1 </b></html>");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username)
                            .addComponent(bt_Connexion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(ip))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(erreur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_Connexion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(erreur, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_ConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ConnexionActionPerformed
        erreur.setIcon(image.loadImage("/images/loading.gif"));
        String url;
        if(ip.getText().trim().equals("1277.0.0.1") || ip.getText().trim().equals("") ){
        url = "rmi://localhost/Elhacen";}
        else {url = "rmi://"+ip.getText().trim()+"/Elhacen"; }
        try {
            server = (ServerInterface)Naming.lookup(url);
            client = new Client(server,username.getText());
            MC= new Main_Client(username.getText());
      	    server.login(client);
             this.setVisible(false);
            MC.setVisible(true);
            erreur.setIcon(null);
          
           }
        catch(Exception e){
            System.out.println(e.getMessage());
            erreur.setIcon(null);
            erreur.setText("Erreur !");
        }
   
		
    }//GEN-LAST:event_bt_ConnexionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       try {
        	Properties props = new Properties();
        	 props.put("logoString", "Elhacen Ely"); 
             props.put("licenseKey", "INSERT YOUR LICENSE KEY HERE");
             TextureLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
        } catch (Exception ex) {
         } 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               CC= new Connexion_Client();
               CC.setVisible(true);
                createAndShowGUI();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Connexion;
    private javax.swing.JLabel erreur;
    private javax.swing.JTextField ip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
   static ServerInterface server;
   static Main_Client MC;
  static Connexion_Client CC;
  static Client client;
    static ImageHelper image ;
   
     
     
    
    
      static TrayIcon trayIcon;
    
   private static void createAndShowGUI() {
        //Check the SystemTray support
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        
        final SystemTray tray = SystemTray.getSystemTray();
        
        MenuItem About = new MenuItem("About");
         
        
        //Add components to popup menu
        popup.add(About);
        
        


        
        
        trayIcon.setPopupMenu(popup);
         
        trayIcon.setToolTip("Chat Client");
        
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }
        
        trayIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
           
            }  
        });
        
        About.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Aboutshow();
                   
            } 
        });
        
        
        
        
        
        
        
        
        
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuItem item = (MenuItem)e.getSource();
                //TrayIcon.MessageType type = null;
                System.out.println(item.getLabel());
                if ("Error".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.ERROR;
                    trayIcon.displayMessage("Sun TrayIcon Demo",
                            "This is an error message", TrayIcon.MessageType.ERROR);
                    
                } else if ("Warning".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.WARNING;
                    trayIcon.displayMessage("Sun TrayIcon Demo",
                            "This is a warning message", TrayIcon.MessageType.WARNING);
                    
                } else if ("Info".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.INFO;
                    trayIcon.displayMessage("Sun TrayIcon Demo",
                            "This is an info message", TrayIcon.MessageType.INFO);
                    
                } else if ("None".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.NONE;
                    trayIcon.displayMessage("Sun TrayIcon Demo",
                            "This is an ordinary message", TrayIcon.MessageType.NONE);
                }
            }
        };
        
     
         
        trayIcon.setImageAutoSize(true);
    }
 
    
    static PopupMenu popup = new PopupMenu();
    
    public static void Aboutshow(){
    	
    	String s="<html></head><body><div align=center><font size='6' color='#0000FF' face='Times New Roman'><B><U>Author:</U></B></font></div><div align=center><font size='5' color='#000000' face='Times New Roman'><B>Elhacen Ely</B></font></div><div align=center><font size='4' face='Times New Roman'><B>e.elhacen@yahoo.com</B></font></div></body></html>";
    	JOptionPane.showMessageDialog(null,s,"About",1);
    }
}