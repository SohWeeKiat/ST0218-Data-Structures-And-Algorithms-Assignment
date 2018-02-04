/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.projectUI;

import BackEnd.Event;
import BackEnd.Project;
import BackEnd.ProjectSelect;
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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Wee Kiat
 */
public class SelectProjectFormController implements Initializable {

    @FXML
    private TableView<ProjectSelect> tVSelectProject;

    private Event evt;
    
    private final ObservableList<ProjectSelect> ProjectSelectList = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tVSelectProject.setEditable(true);
        TableColumn t = tVSelectProject.getColumns().get(0);
        t.setCellValueFactory(
            new Callback<TableColumn.CellDataFeatures<ProjectSelect,Boolean>,ObservableValue<Boolean>>(){
                @Override
                public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<ProjectSelect, Boolean> param)
                {   
                    return param.getValue().IsInsideEventProperty();
                }
            });
        t.setCellFactory( CheckBoxTableCell.forTableColumn(t) );
        tVSelectProject.setItems(ProjectSelectList);
    }    
    
    public void setEventAndList(Event e,ArrayList<ProjectSelect> p)
    {
        this.evt = e;
        ProjectSelectList.addAll(p);
    }

    @FXML
    private void OnOKClicked(MouseEvent event) {
        for(ProjectSelect ps : ProjectSelectList){
            Project p = ps.getProject();
            if (ps.getIsInsideEvent()){
                p.AddEvent(evt);
                evt.AddProject(p);
            }else{
                p.RemoveEvent(evt);
                evt.RemoveProject(p);
            }
        }
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
