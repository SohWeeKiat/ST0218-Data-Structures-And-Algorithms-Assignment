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
public class School {
    
    private final ArrayList<Student> students;
    private final ArrayList<Project> projects;
    
    public School(String Path)
    {
        students = new ArrayList<>();
        projects = new ArrayList<>();
        new ProjectFile(Path).ParseFile(this);
    }
    
    public ArrayList<Student> getStudents()
    {
        return students;
    }
    
    public ArrayList<Project> getProjects()
    {
        return projects;
    }
}
