/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com;

import java.awt.Point;
import java.awt.TrayIcon;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import sun.font.TrueTypeFont;

/**
 *
 * @author Elhacen
 */
public class Client  extends UnicastRemoteObject implements ClientInterface{

    protected Client(ServerInterface c , String username) throws RemoteException{
      cs=c;
      this.username=username.trim();
      this.date=c.getdat();
      
   }

    
    public String getUsername() throws RemoteException {
        return username;
     }

      public String getdate() throws RemoteException {
        return date;
     }

	public String getip() throws RemoteException {
		try {
			return ipclientm(java.net.InetAddress.getLocalHost().toString());
		} catch (Exception e) {
			return "-----?-----";
		
                }	
	}
	
	public String ipclientm(String ip){
    	boolean ok=false;
    	while(!ok){
    	int i=ip.indexOf("/")+1;
       if(i!=0)ip=ip.substring(i);
       else ok=true;
    	}
    	return ip;
    }
    
    public void rec_msg(String from, String msg) throws RemoteException {
        affiche_msg(from,msg);
         Connexion_Client.trayIcon.displayMessage(username,
                "New message from "+from, TrayIcon.MessageType.INFO);
     }
    
      public void new_client_connected(String name,int t) throws RemoteException {
            if(t==1)Connexion_Client.trayIcon.displayMessage(username,
                name+" is connected .", TrayIcon.MessageType.INFO);
            else Connexion_Client.trayIcon.displayMessage(username,
                name+" is deconnected .", TrayIcon.MessageType.INFO);
              Msgs.put(name,head);
     
      }
     public void list_client(Vector names) throws RemoteException {
            Main_Client.jList1.setListData(names);   
            for(int i=0;i<names.size();i++){
               Msgs.put(names.get(i),head);
            }
     }
     
     public static void affiche_msg(String name , String msg){
        /* String g="";
         g=Msgs.get(name).toString();
         g=g+"<div id=\"msg\"><div id=\"title\">"+name+"</div>" +""+msg+"</div>";
         Msgs.remove(name);
         Msgs.put(name,g);
          Main_Client.jEditorPane1.setText(g);   */
         //if(!name.equals(D_N_M))  
         head=head+"<div id=\"msg\"><div id=\"title\">"+name+"</div>"+msg+"</div>";
         //else head=head+msg;
         Main_Client.jEditorPane1.setText(head); 
         Main_Client.jScrollPane3.getViewport().setViewPosition(new Point(0,250000));
                          //D_N_M=name;
          
     }
     
     
        static ServerInterface cs; 
	static String username;
	private String ip;
        private String date;
        private static String D_N_M="";

        
         public static  Hashtable Msgs=new Hashtable();
        private static String head ="<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"<style> \n" +
"#msg {\n" +
"    padding: 2px 2px 2px 2px;\n" +
"    margin :2px auto 0 2px;\n" +
"    width: 300px;\n" +
"    font-family: Tahoma,Geneva,sans-serif;\n" +
"     font-size:12px;\n" +
"	\n" +
"}\n" +
"#title {\n" +
"    font-size:10px;\n" +
"    font-weight: bold;\n" +
"    font-style: normal;\n" +
"   border-bottom: 1px solid #a1a1a1;\n" +
"    margin :2px 0px 0px 0px;\n" +
"}\n" +
"\n" +
"</style>\n" +
"</head>\n" +
"<body>";
}
