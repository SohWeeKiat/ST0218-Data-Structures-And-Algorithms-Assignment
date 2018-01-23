/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.eventUI;

import BackEnd.Event;
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
 * @author Wee Kiat
 */
public class AddEditEventFormController implements Initializable {

    @FXML
    private TextField tBEventName;

    private boolean Success;
    private Event evnt;
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
        this.evnt = e;
        tBEventName.setText(evnt.getEventName());
    }
    
    @FXML
    private void OnOKClicked(MouseEvent event) {
        if (tBEventName.getText().length() <= 0){
            //error
            return;
        }
        if (event != null)
            evnt.setEventName(tBEventName.getText());
        else
            evnt = new Event(tBEventName.getText());
        
        Success = true;
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    public Event IsSuccess()
    {
        return Success ? evnt : null;
    }

}
