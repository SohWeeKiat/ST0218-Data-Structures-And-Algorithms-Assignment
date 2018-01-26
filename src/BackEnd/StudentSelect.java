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
public class StudentSelect{
    
    private BooleanProperty IsInsideProject;
    private final Student student;
    
    public StudentSelect(Student s,boolean inside)
    {
        student = s;
        IsInsideProject = new SimpleBooleanProperty(inside);
    }
    
    public String getName()
    {
        return student.getName();
    }
    
    public String getAdminNo()
    {
        return student.getAdminNo();
    }
    
    public String getCourse()
    {
        return student.getCourse();
    }
    
    public char getGender()
    {
        return student.getGender();
    }

    public boolean getIsInsideProject()
    {
        return IsInsideProject.get();
    }

    public BooleanProperty IsInsideProjectProperty()
    {
        return IsInsideProject;
    }
    
    public Student getStudent()
    {
        return student;
    }
}
