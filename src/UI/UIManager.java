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
import BackEnd.Student;
import UI.studentUI.SelectStudentFormController;
import java.io.IOException;
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
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    public static void ShowErrorAlert(String title,String header, String content)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    public static boolean ShowConfirmationAlert(String title,String header, String content)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
        return alert.getResult() == ButtonType.OK;
    }
    
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
        Stage stage = new Stage();
        
        FXMLLoader loader = new FXMLLoader(c.getResource("/UI/studentUI/AddEditStudentForm.fxml"));
        Parent root = null;
        try {
            root = (Parent)loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        AddEditStudentFormController controller = (AddEditStudentFormController)loader.getController();
        if (Edit)
            controller.SetStudent(s);
        
        Scene AddEditStudentScene = new Scene(root);
        stage.setTitle(Edit ? "Edit Student" : "Add Student");
        stage.setScene(AddEditStudentScene);
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL); 
        stage.showAndWait();
        
        return controller.IsSuccess();
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
        Stage stage = new Stage();
        
        FXMLLoader loader = new FXMLLoader(c.getResource("/UI/projectUI/AddEditProjectForm.fxml"));
        Parent root = null;
        try {
            root = (Parent)loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        AddEditProjectFormController controller = (AddEditProjectFormController)loader.getController();
        if (Edit)
            controller.setProject(p);
        
        Scene AddEditProjectScene = new Scene(root);
        stage.setTitle(Edit ? "Edit Project" : "Add Project");
        stage.setScene(AddEditProjectScene);
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL); 
        stage.showAndWait();
        
        return controller.IsSuccess();
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
        Stage stage = new Stage();
        
        FXMLLoader loader = new FXMLLoader(c.getResource("/UI/eventUI/AddEditEventForm.fxml"));
        Parent root = null;
        try {
            root = (Parent)loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        AddEditEventFormController controller = (AddEditEventFormController)loader.getController();
        if (Edit)
            controller.setEvent(e);
        
        Scene AddEditEventScene = new Scene(root);
        stage.setTitle(Edit ? "Edit Event" : "Add Eevent");
        stage.setScene(AddEditEventScene);
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL); 
        stage.showAndWait();
        
       return controller.IsSuccess();
    }
    
    public static Student SelectStudentUI(Class<?> c,Project p)
    {
        Stage stage = new Stage();
        
        FXMLLoader loader = new FXMLLoader(c.getResource("/UI/studentUI/SelectStudentForm.fxml"));
        Parent root = null;
        try {
            root = (Parent)loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        SelectStudentFormController controller = (SelectStudentFormController)loader.getController();
     
        Scene AddEditEventScene = new Scene(root);
        stage.setTitle("Select Student");
        stage.setScene(AddEditEventScene);
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL); 
        stage.showAndWait();
        
       return controller.getSelection();
    }
}
