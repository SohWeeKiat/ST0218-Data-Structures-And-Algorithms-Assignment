/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.studentUI;

import BackEnd.Project;
import BackEnd.Student;
import BackEnd.StudentSelect;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author home
 */
public class SelectStudentFormController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Project project;
    
    @FXML
    private TableView<StudentSelect> tVStudentSelection;
    
    private final ObservableList<StudentSelect> StudentSelectList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tVStudentSelection.setEditable(true);
        TableColumn t = tVStudentSelection.getColumns().get(0);
        t.setCellValueFactory(
            new Callback<CellDataFeatures<StudentSelect,Boolean>,ObservableValue<Boolean>>(){
                @Override
                public ObservableValue<Boolean> call(CellDataFeatures<StudentSelect, Boolean> param)
                {   
                    return param.getValue().IsInsideProjectProperty();
                }
            });
        t.setCellFactory( CheckBoxTableCell.forTableColumn(t) );
        tVStudentSelection.setItems(StudentSelectList);
    }    
    
    public void setProjectAndList(Project p,ArrayList<StudentSelect> s)
    {
        project = p;
        StudentSelectList.addAll(s);
    }

    @FXML
    private void OnOKClicked(MouseEvent event) {
        for(StudentSelect SS : StudentSelectList){
            Student s = SS.getStudent();
            if (SS.getIsInsideProject()){
                project.AddStudent(s);
                s.setProject(project);
            }else{
                project.RemoveStudent(s);
                s.setProject(null);
            }
        }
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
