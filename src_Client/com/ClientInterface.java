package com;

import java.rmi.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;


public interface ClientInterface extends Remote {
   
   public String getUsername() throws RemoteException;
   public String getip() throws RemoteException;
   public String getdate() throws RemoteException;
   public void rec_msg(String from,String msg) throws RemoteException;
   public void list_client(Vector names) throws RemoteException;
   public void new_client_connected(String name,int t) throws RemoteException;
   
}
