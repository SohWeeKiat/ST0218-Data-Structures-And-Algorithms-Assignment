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
    
    public void addStudent(Student s)
    {
        this.students.add(s);
    }
    
    public void removeStudent(Student s)
    {
        Project p = s.getProject();
        if (p != null)
            p.RemoveStudent(s);
        this.students.remove(s);
    }
    
    public void addProject(Project p)
    {
        this.projects.add(p);
    }
    
    public void removeProject(Project p)
    {
        for(Student s : p.getStudents())
            s.RemoveProject();
        this.projects.remove(p);
    }
}
