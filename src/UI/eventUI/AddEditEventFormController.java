/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.eventUI;

import BackEnd.Event;
import UI.UIManager;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Wee Kiat
 */
public class AddEditEventFormController implements Initializable {

    @FXML
    private TextField tBEventName;

    private boolean Success;
    private Event evnt;
    @FXML
    private DatePicker DPStarrtDate;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Success = false;
        evnt = null;
        // TODO
    }    
    
    public void setEvent(Event e)
    {
        if (e == null)
            return;
        this.evnt = e;
        tBEventName.setText(evnt.getEventName());
    }
    
    @FXML
    private void OnOKClicked(MouseEvent event) {
        if (tBEventName.getText().length() <= 0 ||
                DPStarrtDate.getValue() == null){
            UIManager.ShowErrorAlert("Error", "Empty Fields", "Please fill in all the field(s) before proceeding");
            return;
        }
        LocalDate localDate = DPStarrtDate.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        if (evnt != null){
            evnt.setEventName(tBEventName.getText());
            evnt.setStartDate(Date.from(instant));
        }else
            evnt = new Event(tBEventName.getText(),Date.from(instant));
        
        Success = true;
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    public Event IsSuccess()
    {
        return Success ? evnt : null;
    }

}
