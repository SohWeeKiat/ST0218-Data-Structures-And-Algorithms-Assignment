/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BackEnd.Student;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author home
 */
public class UIManager {
    
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
        
        FXMLLoader loader = new FXMLLoader(c.getResource("/UI/AddEditStudentForm.fxml"));
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
}
