/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;
import java.io.Serializable;
import java.util.Vector;
/**
 *
 * @author NIRKA
 */

public class Subject implements Serializable {
    private Vector v;
    private String name;
    private Integer maxMark;
     public Subject()
     {
          v=new Vector();
     }
    public Subject(String name,Integer maxMark)
    {
        this.name =name;
        v=new Vector();
        this.maxMark = maxMark;
        if(maxMark < 0)
            maxMark=100;
    }
    
    public Integer getMaxMark()
    {
        return this.maxMark;
    }
    public Integer getMark()
    {
        Integer sum=0;
        for(int i=0;i<v.size();i++)
        {
            Event ev = (Event)v.elementAt(i);
            if(ev.isHappened())
                sum+=ev.getMark();
        }
        return sum;
    }
    @Override
    public String toString()
    {
       return this.name;
    }
    
    @Override
    public boolean equals(Object o)
    {
       return this.hashCode() == o.hashCode();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.v != null ? this.v.hashCode() : 0);
        hash = 41 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 41 * hash + (this.maxMark != null ? this.maxMark.hashCode() : 0);
        return hash;
    }
    public Integer getNumberEvents()
    {
       
        return this.v.size();

    }
    public Event getEventAt(int index)
    {
        return (Event)this.v.elementAt(index);
    }
    
    public void addEvent(Event e)
    {
        v.addElement(e);
    }
}
