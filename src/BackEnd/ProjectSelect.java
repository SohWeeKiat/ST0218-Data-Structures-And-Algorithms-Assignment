/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 *
 * @author Wee Kiat
 */
public class ProjectSelect implements Comparable{
    
    private final Project project;
    private BooleanProperty IsInsideEvent;
    
    public ProjectSelect(Project p,boolean inside)
    {
        project = p;
        IsInsideEvent = new SimpleBooleanProperty(inside);
    }
    
    public String getTitle()
    {
        return project.getTitle();
    }
    
    public String getSchool()
    {
        return project.getSchool();
    }
    
    public String getSupervisor()
    {
        return project.getSupervisor();
    }
    
    public String getNoOfStudents()
    {
        return project.getNoOfStudents();
    }
    
    public boolean getIsInsideEvent()
    {
        return IsInsideEvent.get();
    }

    public BooleanProperty IsInsideEventProperty()
    {
        return IsInsideEvent;
    }
    
    @Override
    public int compareTo(Object o) {
        if (this.IsInsideEvent.get())
            return 1;
        else if (((ProjectSelect)o).IsInsideEvent.get())
            return -1;
        return 0;
    }
}
