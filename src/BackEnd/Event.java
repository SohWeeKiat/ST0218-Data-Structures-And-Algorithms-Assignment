/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.io.Serializable;

/**
 *
 * @author Wee Kiat
 */
public class Event implements Serializable{
    
    private String EventName;
    
    public String getEventName()
    {
        return this.EventName;
    }
}
