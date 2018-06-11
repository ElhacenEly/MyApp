package com;


import java.rmi.RemoteException;
import java.util.Enumeration;

import javax.swing.table.AbstractTableModel;

public class Table_Client extends AbstractTableModel {
	private final Client_inf[] cls;
 
    private final String[] entetes = {"Pseudonym", "@IP", "Login date"};
 
    public Table_Client() {
        super();
        cls = new Client_inf[Server.l.size()];
        Enumeration usernames = Server.l.keys();
        int i=0;
		while(usernames.hasMoreElements()){
			String user=(String) usernames.nextElement();
			ClientInterface m=(ClientInterface)Server.l.get(user);
			Client_inf cinf=null;
			try {
				cinf = new Client_inf(m.getUsername(),m.getip(),m.getdate());
			} catch (Exception e) {
				
			}
			if(cinf!=null)cls[i]=cinf;
                        else cls[i]=new Client_inf("-----","------ ","-------");
			i++;
			}
			    }
   
 
    public int getRowCount() {
        return cls.length;
    }
 
    public int getColumnCount() {
        return entetes.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return cls[rowIndex].getname();
            case 1:
                return cls[rowIndex].getip();
            case 2:
                return cls[rowIndex].getdate();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
 

   

}
