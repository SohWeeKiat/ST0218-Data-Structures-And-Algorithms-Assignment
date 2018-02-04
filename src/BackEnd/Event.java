/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import BackEnd.util.LinkList;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Wee Kiat
 */
public class Event implements Serializable{
    
    private String event_name;
    private Date start_date;
    private transient LinkList projects;
    
    public Event()
    {
        this.event_name = null;
        this.projects = new LinkList();
    }
    
    public Event(String e,Date d)
    {
        this.event_name = e;
        this.start_date = d;
        this.projects = new LinkList();
    }
    
    public String getEventName()
    {
        return this.event_name;
    }
    
    public void setEventName(String n)
    {
        this.event_name = n;
    }
    
    public String getStartDate()
    {
        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
        return dt1.format(start_date);
    }
    
    public void setStartDate(Date d)
    {
        this.start_date = d;
    }
    
    public String getProjectCount()
    {
        return Integer.toString(projects.getNoOfElement());
    }
    
    public LinkList getProjects()
    {
        return projects;
    }
    
    public void AddProject(Project p)
    {
        if (!HasProject(p))
            projects.addLast(p);
    }
    
    public void RemoveProject(Project p)
    {
        for(int i = 0;i < projects.getNoOfElement();i++){
            if (projects.get(i) == p){
                projects.remove(i);
                break;
            }
        }
    }
    
    public boolean HasProject(Project p)
    {
        for(int i = 0;i < projects.getNoOfElement();i++){
            if (projects.get(i) == p)
                return true;
        }
        return false;
    }
    
    @Override
    public String toString()
    {
        return event_name;
    }
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException 
    {
        in.defaultReadObject();
        this.projects = new LinkList();
        int count = in.readInt();
        for(int i = 0;i < count;i++)
            projects.addLast(in.readObject());
    }
    
    private void writeObject(ObjectOutputStream out) throws IOException
    {
        out.defaultWriteObject();
        out.writeInt(this.projects.getNoOfElement());
        for(int i = 0;i < this.projects.getNoOfElement();i++)
            out.writeObject(projects.get(i));
    }
}
