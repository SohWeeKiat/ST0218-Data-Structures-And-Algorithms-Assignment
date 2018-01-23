/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.studentUI;

import BackEnd.Project;
import BackEnd.Student;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author home
 */
public class SelectStudentFormController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Student student;
    private Project project;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        student = null;
    }    
    
    public void setProject(Project p)
    {
        this.project = p;
    }
    
    public Student getSelection()
    {
        return this.student;
    }
    
}
