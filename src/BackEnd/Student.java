package BackEnd;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wee Kiat
 */
public class Student implements Serializable{
    
    private String name;
    private String admin_no;
    private String course;
    private char gender;
    private Project currentFYP;
    
    public Student()
    {
        this.name = null;
        this.admin_no = null;
        this.course = null;
        this.gender = 'M';
        this.currentFYP = null;
    }
    
    public Student(String name,String admin_no,String course,char gender)
    {
        this.name = name;
        this.admin_no = admin_no;
        this.course = course;
        this.gender = gender;
        this.currentFYP = null;
    }
    
    public Student(String name,String admin_no,String course,char gender,Project CurrentFYP)
    {
        this.name = name;
        this.admin_no = admin_no;
        this.course = course;
        this.gender = gender;
        this.currentFYP = CurrentFYP;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String n)
    {
        this.name = n;
    }
    
    public String getAdminNo()
    {
        return admin_no;
    }
    
    public void setAdminNo(String n)
    {
        this.admin_no = n;
    }
    
    public String getCourse()
    {
        return course;
    }
    
    public void setCourse(String c)
    {
        this.course = c;
    }
    
    public char getGender()
    {
        return gender;
    }

    public void setGender(boolean IsMale)
    {
        this.gender = IsMale ? 'M' : 'F';
    }
        
    public String getCurrentProjectTitle()
    {
        if (currentFYP == null)
            return "";
        return currentFYP.getTitle();
    }
    
    public Project getProject()
    {
        return currentFYP;
    }
    
    public void setProject(Project p)
    {
        currentFYP = p;
    }
    
    @Override
    public String toString()
    {
        return name + admin_no + course;
    }
}
