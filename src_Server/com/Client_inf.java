package com;



public class Client_inf {
    private String nom;
    private String ip;
    private String date;
 
    public Client_inf(String nom, String ip, String date) {
        super();
        this.nom = nom;
        this.ip = ip;
        this.date = date;
    }
    
    public String getname(){
    	return " "+this.nom;
    }
    
    public String getip(){
    	return " "+this.ip;
    }
    
    public String getdate(){
    	return " "+this.date;
    }
   
}
