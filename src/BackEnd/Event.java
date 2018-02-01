/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import BackEnd.util.LinkList;
import java.io.Serializable;

/**
 *
 * @author Wee Kiat
 */
public class Event implements Serializable{
    
    private String event_name;
    private LinkList projects;
    
    public Event(String e)
    {
        this.event_name = e;
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
}
