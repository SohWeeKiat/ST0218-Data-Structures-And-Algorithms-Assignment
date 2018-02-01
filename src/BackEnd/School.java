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
    private final ArrayList<Event> events;
    
    public School(String Path)
    {
        students = new ArrayList<>();
        projects = new ArrayList<>();
        events = new ArrayList<>();
        new ProjectFile(Path).ParseFile(this);
    }
    
    public School()
    {
        students = new ArrayList<>();
        projects = new ArrayList<>();
        events = new ArrayList<>();
    }
    
    public ArrayList<Student> getStudents()
    {
        return students;
    }
    
    public ArrayList<Project> getProjects()
    {
        return projects;
    }
    
    public ArrayList<Event> getEvents()
    {
        return events;
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
            s.setProject(null);
        this.projects.remove(p);
    }
    
    public void addEvent(Event e)
    {
        this.events.add(e);
    }
    
    public void removeEvent(Event e)
    {
        this.events.remove(e);
    }
    
    public ArrayList<StudentSelect> getAvailStudentsToSelect(Project p)
    {
        ArrayList<StudentSelect> selectable = new ArrayList<>();
        for(Student s : p.getStudents())
            selectable.add(new StudentSelect(s,true));
        for(Student s : students){
            if (s.getProject() == null)
                selectable.add(new StudentSelect(s,false));
        }
        return selectable;
    }
    
    public ArrayList<ProjectSelect> getAvailProjectsToSelect(Event e)
    {
        ArrayList<ProjectSelect> selectable = new ArrayList<>();
        for(Project p : projects)
            selectable.add(new ProjectSelect(p,e.HasProject(p)));
        return selectable;
    }
    
    public ArrayList<Student> SearchStudents(String query)
    {
        query = query.toLowerCase();
        ArrayList<Student> SList = new ArrayList<>();
        for(Student s : students){
            if (s.toString().toLowerCase().contains(query))
                SList.add(s);
        }
        return SList;
    }
    
    public ArrayList<Project> SearchProjects(String query)
    {
        query = query.toLowerCase();
        ArrayList<Project> PList = new ArrayList<>();
        for(Project p : projects){
            if (p.toString().toLowerCase().contains(query))
                PList.add(p);
        }
        return PList;
    }
}
