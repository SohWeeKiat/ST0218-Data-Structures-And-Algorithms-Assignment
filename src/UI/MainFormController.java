/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BackEnd.Event;
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
import javafx.scene.control.Tab;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

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
    @FXML
    private TableView<Event> tVEvents;
    
    private Stage window;
    
    private final ObservableList<Student> StudentList = FXCollections.observableArrayList();
    private final ObservableList<Project> ProjectList = FXCollections.observableArrayList();
    private final ObservableList<Student> StudentInProject = FXCollections.observableArrayList();
    private final ObservableList<Student> EventList = FXCollections.observableArrayList();
    
    private School school;
 
    @FXML
    private TableView<?> tVProjects2;

    public void setStage(Stage s)
    {
        window = s;
    }
    
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

    private void RefreshTableView(TableView<?> tV)
    {
        tV.getColumns().get(0).setVisible(false);
        tV.getColumns().get(0).setVisible(true);
    }
    
    @FXML
    private void OnOutputToFileClick(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Text Documents (*.txt)", "*.txt"));

        File selectedFile = fileChooser.showSaveDialog(window);
        if (selectedFile == null) 
            return;

        boolean result = new ProjectFile(selectedFile.getAbsolutePath()).OutputFile(
                new ArrayList<>(tVProjects.getSelectionModel().getSelectedItems()));
        UIManager.ShowInfoAlert("Information", "Output to file", (result ? "Successfully saved" : "Failed to save" )+ " file");
    }

    @FXML
    private void OnOpenClick(ActionEvent event){
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new ExtensionFilter("Text Documents (*.txt)", "*.txt"));

            File selectedFile = fileChooser.showOpenDialog(window);
            if (selectedFile == null) 
                return;

            school = new School(selectedFile.getAbsolutePath());
            StudentList.addAll(school.getStudents());
            ProjectList.addAll(school.getProjects());
    }

    @FXML
    private void OnAddStudentClicked(MouseEvent event) {
        Student s = UIManager.AddStudentUI(getClass());
        if (s == null)
            return;
        StudentList.add(s);
        school.addStudent(s);
    }

    @FXML
    private void OnDeleteStudentClicked(MouseEvent event) {
        if (tVStudents.getSelectionModel().getSelectedIndex() < 0)
            return;
        if (!UIManager.ShowConfirmationAlert("Confirmation", "Delete Student", "Are you sure you want delete this student?"
                + "\nHe/she will be removed from the FYP roject if he is inside 1."))
            return;
        Student s = tVStudents.getSelectionModel().getSelectedItem();
        StudentList.remove(s);
        school.removeStudent(s);
    }

    @FXML
    private void OnEditStudentClicked(MouseEvent event) {
        if (tVStudents.getSelectionModel().getSelectedIndex() < 0)
            return;
        Student s = UIManager.EditStudentUI(getClass(),
                tVStudents.getSelectionModel().getSelectedItem());
        if (s == null)
            return;
        RefreshTableView(tVStudents);
    }

    @FXML
    private void OnAddProjectClicked(MouseEvent event) {
        Project p = UIManager.AddProjectUI(getClass());
        if (p == null)
            return;
        ProjectList.add(p);
        school.addProject(p);
    }

    @FXML
    private void OnEditProjectClicked(MouseEvent event) {
        if (tVProjects.getSelectionModel().getSelectedIndex() < 0)
            return;
        Project p = UIManager.EditProjectUI(getClass(),
                tVProjects.getSelectionModel().getSelectedItem());
        if (p == null)
            return;
        RefreshTableView(tVProjects);
    }

    @FXML
    private void OnDeleteProjectClicked(MouseEvent event) {
        if (tVProjects.getSelectionModel().getSelectedIndex() < 0)
            return;
        if (!UIManager.ShowConfirmationAlert("Confirmation", "Delete Project", "Are you sure you want delete this project?"))
            return;
        Project p = tVProjects.getSelectionModel().getSelectedItem();
        ProjectList.remove(p);
        school.removeProject(p);
    }
    
    @FXML
    private void OnAddEventClicked(MouseEvent event) {
        Event e = UIManager.AddEventUI(getClass());
        if (e == null)
            return;
    }

    @FXML
    private void OnEditEventClicked(MouseEvent event) {
        if (tVEvents.getSelectionModel().getSelectedIndex() < 0)
            return;
        Event e = UIManager.EditEventUI(getClass(),
                tVEvents.getSelectionModel().getSelectedItem());
        if (e == null)
            return;
        RefreshTableView(tVEvents);
    }

    @FXML
    private void OnDeleteEventClicked(MouseEvent event) {
        if (tVEvents.getSelectionModel().getSelectedIndex() < 0)
            return;
        if (!UIManager.ShowConfirmationAlert("Confirmation", "Delete Project", "Are you sure you want delete this project?"))
            return;
        Event e = tVEvents.getSelectionModel().getSelectedItem();
        EventList.remove(e);
        //school.removeProject(p);
    }

}
