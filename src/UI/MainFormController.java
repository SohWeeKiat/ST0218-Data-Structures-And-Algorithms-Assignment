/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BackEnd.Project;
import BackEnd.ProjectFile;
import BackEnd.School;
import BackEnd.Student;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * FXML Controller class
 *
 * @author Wee Kiat
 */
public class MainFormController implements Initializable {

    @FXML
    private TableView<Student> tVStudents;
    @FXML
    private TableView<Project> tVProjects;
    @FXML
    private TableView<Student> tVStudentsInProj;

    private final ObservableList<Student> StudentList = FXCollections.observableArrayList();
    private final ObservableList<Project> ProjectList = FXCollections.observableArrayList();
    private final ObservableList<Student> StudentInProject = FXCollections.observableArrayList();
    private School s;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tVProjects.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        tVStudents.setItems(StudentList);
        tVProjects.setItems(ProjectList);
        tVStudentsInProj.setItems(StudentInProject);

        tVProjects.setRowFactory(tv -> {
            TableRow<Project> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && !row.isEmpty()) {
                    Project rowData = row.getItem();
                    StudentInProject.clear();
                    StudentInProject.addAll(rowData.getStudents());
                }
            });
            return row;
        });
    }

    @FXML
    private void OnOutputToFileClick(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Text Documents (*.txt)", "*.txt"));

        File selectedFile = fileChooser.showSaveDialog(null);
        if (selectedFile == null) 
            return;

        boolean result = new ProjectFile(selectedFile.getAbsolutePath()).OutputFile(
                new ArrayList<>(tVProjects.getSelectionModel().getSelectedItems()));
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Output to file");
        alert.setContentText((result ? "Successfully saved" : "Failed to save" )+ " file");
        alert.showAndWait();
    }

    @FXML
    private void OnOpenClick(ActionEvent event){
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new ExtensionFilter("Text Documents (*.txt)", "*.txt"));

            File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile == null) 
                return;

            s = new School(selectedFile.getAbsolutePath());
            StudentList.addAll(s.getStudents());
            ProjectList.addAll(s.getProjects());
    }
}
