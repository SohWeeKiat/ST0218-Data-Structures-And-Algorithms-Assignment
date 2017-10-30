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
    
    public Student(String name,String admin_no,String course,char gender)
    {
        this.name = name;
        this.admin_no = admin_no;
        this.course = course;
        this.gender = gender;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getAdmin_no()
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
}
