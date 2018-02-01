/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import UI.eventUI.AddEditEventFormController;
import UI.projectUI.AddEditProjectFormController;
import UI.studentUI.AddEditStudentFormController;
import BackEnd.Event;
import BackEnd.Project;
import BackEnd.ProjectSelect;
import BackEnd.Student;
import BackEnd.StudentSelect;
import UI.projectUI.SelectProjectFormController;
import UI.studentUI.SelectStudentFormController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author home
 */
public class UIManager {
    
    public static void ShowInfoAlert(String title,String header, String content)
    {
        ShowAlert(title,header,content,Alert.AlertType.INFORMATION);
    }
    
    public static void ShowErrorAlert(String title,String header, String content)
    {
        ShowAlert(title,header,content,Alert.AlertType.ERROR);
    }
    
    public static boolean ShowConfirmationAlert(String title,String header, String content)
    {
        return ShowAlert(title,header,content,Alert.AlertType.CONFIRMATION);
    }
    
    private static boolean ShowAlert(String title,String header, String content, Alert.AlertType type)
    {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
        return alert.getResult() == ButtonType.OK;
    }
    
    /*********************************************/
    
    public static Student AddStudentUI(Class<?> c)
    {
        return AddEditStudentUI(c,false,null);
    }
    
    public static Student EditStudentUI(Class<?> c,Student s)
    {
        return AddEditStudentUI(c,true,s);
    }
    
    private static Student AddEditStudentUI(Class<?> c, boolean Edit, Student s)
    {
        return SpawnUI(c,"/UI/studentUI/AddEditStudentForm.fxml",
                Edit ? "Edit Student" : "Add Student",
                (Object t) -> ((AddEditStudentFormController)t).SetStudent(s),
                (Object t) -> ((AddEditStudentFormController)t).IsSuccess());
    }
    
    /*********************************************/
    
    public static Project AddProjectUI(Class<?> c)
    {
        return AddEditProjectUI(c,false,null);
    }
    
    public static Project EditProjectUI(Class<?> c,Project p)
    {
        return AddEditProjectUI(c,true,p);
    }
    
     private static Project AddEditProjectUI(Class<?> c,boolean Edit, Project p)
    {
        return SpawnUI(c,"/UI/projectUI/AddEditProjectForm.fxml",
                Edit ? "Edit Project" : "Add Project",
                (Object t) -> ((AddEditProjectFormController)t).setProject(p),
                (Object t) -> ((AddEditProjectFormController)t).IsSuccess());
    }
    
     /*********************************************/
     
    public static Event AddEventUI(Class<?> c)
    {
        return AddEditEventUI(c,false,null);
    }
    
    public static Event EditEventUI(Class<?> c,Event e)
    {
        return AddEditEventUI(c,true,e);
    }
    
    private static Event AddEditEventUI(Class<?> c,boolean Edit, Event e)
    {
        return SpawnUI(c,"/UI/eventUI/AddEditEventForm.fxml",
                Edit ? "Edit Event" : "Add Eevent",
                (Object t) -> ((AddEditEventFormController)t).setEvent(e),
                (Object t) -> ((AddEditEventFormController)t).IsSuccess());
    }
    
    /*********************************************/
    
    public static void SelectStudentUI(Class<?> c,Project p,ArrayList<StudentSelect> list)
    {
        SpawnUI(c,"/UI/studentUI/SelectStudentForm.fxml",
                "Select Student",
                (Object t) -> ((SelectStudentFormController)t).setProjectAndList(p,list));
    }
    
    public static void SelectProjectUI(Class<?> c,Event e,ArrayList<ProjectSelect> list)
    {
        SpawnUI(c,"/UI/projectUI/SelectProjectForm.fxml",
                "Select Project",(Object t) -> ((SelectProjectFormController)t).setEventAndList(e, list));
    }
  
    /*********************************************/
    
    private static void SpawnUI(Class<?> c,String Path, String WindowTitle,Consumer<Object> func)
    {
        Stage stage = new Stage();
        
        FXMLLoader loader = new FXMLLoader(c.getResource(Path));
        Parent root = null;
        try {
            root = (Parent)loader.load();
        } catch (IOException ex) {
        }
        func.accept(loader.getController());
        
        Scene scene = new Scene(root);
        stage.setTitle(WindowTitle);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL); 
        stage.showAndWait();
    }
    
    private static <T> T SpawnUI(Class<?> c,String Path, String WindowTitle,Consumer<Object> func, Function<Object, T> return_func)
    {
        Stage stage = new Stage();
        
        FXMLLoader loader = new FXMLLoader(c.getResource(Path));
        Parent root = null;
        try {
            root = (Parent)loader.load();
        } catch (IOException ex) {
        }
        func.accept(loader.getController());
        
        Scene scene = new Scene(root);
        stage.setTitle(WindowTitle);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL); 
        stage.showAndWait();
        
        return return_func.apply(loader.getController());
    }
}