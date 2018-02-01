/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.studentUI;

import BackEnd.Student;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author home
 */
public class AddEditStudentFormController implements Initializable {

    @FXML
    private TextField tBName;
    @FXML
    private TextField tBAdminNo;
    @FXML
    private TextField tBCourse;
    @FXML
    private RadioButton rBMale;
    @FXML
    private RadioButton rBFemale;

    private Student student;
    @FXML
    private ToggleGroup GenderGroup;
    
    private boolean Success;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        student = null;
        Success = false;
    }

    public void SetStudent(Student s)
    {
        if (s == null)
            return;
        this.student = s;
        
        tBName.setText(student.getName());
        tBAdminNo.setText(student.getAdminNo());
        tBCourse.setText(student.getCourse());
        if (student.getGender() == 'F')
            rBFemale.setSelected(true);
    }

    @FXML
    private void OnOkClicked(MouseEvent event) {
        if (tBName.getText().length() <= 0 ||
                tBAdminNo.getText().length() <= 0 ||
                tBCourse.getText().length() <= 0){
            //error
            return;
        }
        if (student != null){
            student.setName(tBName.getText());
            student.setAdminNo(tBAdminNo.getText());
            student.setCourse(tBCourse.getText());
            student.setGender(rBMale.isSelected());
        }else{
            student = new Student(tBName.getText(),
                    tBAdminNo.getText(),
                    tBCourse.getText(),
                    rBMale.isSelected() ? 'M' : 'F');
        }
        Success = true;
       ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    public Student IsSuccess()
    {
        return Success ? student : null;
    }
}
