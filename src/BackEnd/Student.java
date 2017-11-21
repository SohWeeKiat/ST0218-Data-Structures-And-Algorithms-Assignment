package BackEnd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wee Kiat
 */
public class Student {
    
    private final String name;
    private final String admin_no;
    private final String course;
    private final char gender;
    private final Project currentFYP;
    
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
    
    public String getAdminNo()
    {
        return admin_no;
    }
    
    public String getCourse()
    {
        return course;
    }
    
    public char getGender()
    {
        return gender;
    }
    
    public String getCurrentProjectTitle()
    {
        if (currentFYP == null)
            return "";
        return currentFYP.getTitle();
    }
}
