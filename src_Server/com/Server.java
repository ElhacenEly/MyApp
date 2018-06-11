/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com;

import java.awt.TrayIcon;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Elhacen
 */
public class Server extends UnicastRemoteObject implements ServerInterface{

    protected Server() throws RemoteException {
		super();
 		l.clear();
                //update_table();
                
	}
   public boolean login(ClientInterface m) throws RemoteException {
       if(!l.containsKey(m.getUsername())){
        l.put(m.getUsername(),m);
        System.out.println(m.getUsername()+" : est connecter !");
        update_table();	
        Connexion_Admin.trayIcon.displayMessage("Server Chat",
                "The client ["+m.getUsername()+"] is connected .", TrayIcon.MessageType.INFO);
        Send_lc(m.getUsername(),1);
        System.out.println(m.getUsername()+" : est connecter !");
        return true;
       }
        return false;
	    
   }
  
   


    public boolean logout(ClientInterface m) throws RemoteException {
                l.remove(m.getUsername());
		update_table();
                Send_lc(m.getUsername(),0);
		return true;
     }

   
    public boolean Send_Msg(String name,String Username, String msg) throws RemoteException {
         Enumeration usernames = l.keys();
		while(usernames.hasMoreElements()){
			String user=(String) usernames.nextElement();
                        if(user.equals(Username)){
			ClientInterface m=(ClientInterface)l.get(user);
                         System.out.println(name+" - > "+Username+" : "+msg);
		    	m.rec_msg(name, msg);
                        }
		 }
        return true;
    }
    
     public void  hashT2lcr(){
         lc = new Vector<>();
          Enumeration usernames = l.keys();
		while(usernames.hasMoreElements()){
			String user=(String) usernames.nextElement();
                          lc.add(user);
                                                              }
	    }
     
     public boolean Send_lc(String username,int t) {
               hashT2lcr();
                Enumeration usernames = l.keys();
 		while(usernames.hasMoreElements()){
                 String user=(String) usernames.nextElement();
                  ClientInterface m=(ClientInterface)l.get(user);
                  lc.remove(user);
                   try { 
                       m.list_client(lc);
                       if(!user.equals(username)){m.new_client_connected(username,t);}
                   } catch (Exception ex) {
                       Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                   }
                  lc.add(user);
                        }
		 
        return true;
    }
    
    public static void arreter() throws Exception{
    	try {
            int rep=JOptionPane.showConfirmDialog(null,"Do you really want to stop  Server ?","Server", 0,3);
          if(rep==0){
    	      Naming.unbind("Elhacen");
              server=null;
              Connexion_Admin.CA.setVisible(true);
              Connexion_Admin.SC.setVisible(false);
              Connexion_Admin.SC=null;
          }
 		} catch (Exception e) {
                     server=null;
			Naming.unbind("Elhacen");
		
          }
        
    }
   public  String getdat()throws RemoteException{
    	Date d =new Date();
    	String s=String.valueOf(d.getYear()+1900)+"-"+String.valueOf(d.getMonth()+1)+"-"+String.valueOf(d.getDate())+" "+String.valueOf(d.getHours())+":"+String.valueOf(d.getMinutes())+":"+String.valueOf(d.getSeconds());
         return s;
    }
   
    public void update_table(){
	    tc= new Table_Client();
           ServerControl.jTable1.setModel(tc);
      // MainServer.jTable1.repaint();
       //MainServer.jTable1.validate();
   }

    static Server server;
           public static  Hashtable l=new Hashtable();
           Table_Client tc;
            Vector< String> lc;
            Vector< String> lcs;
      
}
