package com;
 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Elhacen
 */
public class Admin implements java.io.Serializable {
    
    private static final long serialVersionUID = 1L;
    private String name;
    private String pass;
    
    public Admin(String name , String pass){
		this.name=name;
		this.pass=pass;
	}
   public String get_name(){
	   return  name;
	   
   }
   
   public String get_pass(){
	   return  pass;	   
   }
 public boolean verifier(String name , String pass)   {
     if(this.get_name().equals(name) && this.get_pass().equals(pass)) return  true;
     else return false;
 }
}
