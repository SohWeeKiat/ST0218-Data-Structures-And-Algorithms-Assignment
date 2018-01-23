/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.projectUI;

import BackEnd.Project;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author home
 */
public class AddEditProjectFormController implements Initializable {

    @FXML
    private TextField tBTitle;
    @FXML
    private TextField tBSchool;
    @FXML
    private TextField tBSupervisor;

    private boolean Success;
    private Project project;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Success = false;
        project = null;
        // TODO
    }    
    
    public void setProject(Project p)
    {
        this.project = p;
        
        tBTitle.setText(project.getTitle());
        tBSchool.setText(project.getSchool());
        tBSupervisor.setText(project.getSupervisor());
    }
    
    @FXML
    private void OnOKClicked(MouseEvent event) {
        if (tBTitle.getText().length() <= 0 ||
                tBSchool.getText().length() <= 0 ||
                tBSupervisor.getText().length() <= 0){
            
            //fail
            return;
        }
        if (project != null){
            project.setTitle(tBTitle.getText());
            project.setSchool(tBSchool.getText());
            project.setSupervisor(tBSupervisor.getText());
        }else{
            project = new Project(tBTitle.getText(), tBSchool.getText(), tBSupervisor.getText());
        }
        Success = true;
       ((Node)(event.getSource())).getScene().getWindow().hide(); 
    }
    
    public Project IsSuccess()
    {
        return Success ? project : null;
    }

}
