/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NIRKA
 */
public class DAO implements DataBase {

    String location;
    public DAO(String location)
    {
        this.location = location;
    }
    public Vector Read() {
        FileInputStream fis=null;
        Vector vec=new Vector();
        try {
            fis=new FileInputStream(location);
        } catch (FileNotFoundException ex) {
            
            //Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return vec;
        }
        
        ObjectInputStream ois = null; 
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException ex) {
            return vec;
            //Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(true)
            {
                try {
                    vec.add(ois.readObject());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
           // Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vec;
    }

    public void Update(Vector vec) {
        
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(location);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        ObjectOutputStream oos = null; 
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i=0;i<vec.size();i++)
        {
           try {
            oos.writeObject(vec.elementAt(i));
            } catch (IOException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
        }
        
        try {
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Create() {
        
    }

    public void Delete(Object o) {
       Vector vec=this.Read();
       for(int i=0;i<vec.size();i++)
           if(vec.elementAt(i).equals(o))
           {
               vec.removeElementAt(i);
           }
       this.Update(vec);
    }
    
}
