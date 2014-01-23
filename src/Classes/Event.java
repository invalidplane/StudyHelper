/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author NIRKA
 */



public class Event implements Serializable {
    public enum typeEvent {Module, Exam, Home_work, Task }
    private static Integer idCounter = 0;
    
    private Integer id;
    private typeEvent type;
    private Date date;
    private String descrition;
    private Integer mark;
    private Integer maxMark;
    private Boolean isHapennedEvent;
    public Event(Date d,typeEvent type,String description,Integer maxMark)
    {
        this.date=d;
        this.isHapennedEvent=false;
        this.type=type;
        this.descrition=description;
        this.mark=0;
        this.maxMark=maxMark;
        idCounter++;
        id=idCounter;
    }
    public Event()
    {
         this.isHapennedEvent=false;
         this.mark=0;

        this.maxMark=100;
        idCounter++;
        id=idCounter;
    }
    
    @Override
    public String toString()
    {
       return this.type.toString();
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public Integer getMark()
    {
        return this.mark;
    }
    public Integer getMaxMark()
    {
        return this.maxMark;
    }    
    public typeEvent getTypeEvent()
    {
        return this.type;
    }
    public String getDescription()
    {
       return this.descrition;
    }
    public Date getDate()
    {
        return this.date;
    }
    public Boolean isHappened()
    {
        return isHapennedEvent;
    }
    // </editor-fold>
    public Integer getId()
    {
        return this.id;
    }
    // <editor-fold defaultstate="collapsed" desc="Setters  ">
   public  void setTypeEvent(typeEvent type)
    {
        this.type=type;
    }
    public void setDate(Date date)
    {
        this.date=date;
    }
    public void setMark(Integer mark) throws Exception
    {
        
        if(mark < 0)
            throw new Exception("Bad mark "+mark+" ,mark can be >0" );
        if(mark > maxMark)
        {
             throw new Exception("Bad mark "+mark+" ,mark can be <max mark( "+maxMark+" )" );
        }
        this.isHapennedEvent=true;
        this.mark=mark;
    }
    public void setDescription(String description)
    {
        this.descrition=description;
    }
    // </editor-fold>
}
