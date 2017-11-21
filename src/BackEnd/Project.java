package BackEnd;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wee Kiat
 */
public class Project {
    
    private int Number;
    private final String title;
    private final String school;
    private final String supervisor;
    
    private final ArrayList<Student> students;
    
    public Project(String title,String school, String supervisor)
    {
        this.title = title;
        this.school = school;
        this.supervisor = supervisor;
        this.students = new ArrayList<>();
    }
    
    public String getNumber()
    {
        return Integer.toString(Number);
    }
    
    public void setNumber(int Number)
    {
        this.Number = Number;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public String getSchool()
    {
        return school;
    }
    
    public String getSupervisor()
    {
        return supervisor;
    }
    
    public String getNoOfStudents()
    {
        return Integer.toString(students.size());
    }
    
    public ArrayList<Student> getStudents()
    {
        return students;
    }
    
    public void AddStudent(Student s)
    {
        students.add(s);
    }
}
