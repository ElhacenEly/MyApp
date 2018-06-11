/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Elhacen
 */
public interface ServerInterface extends Remote {

   public  boolean  login(ClientInterface m) throws RemoteException;
   public  boolean  logout(ClientInterface m) throws RemoteException;
   public  String getdat()throws RemoteException;
   public  boolean  Send_Msg(String name,String Username,String msg) throws RemoteException;
     
}
