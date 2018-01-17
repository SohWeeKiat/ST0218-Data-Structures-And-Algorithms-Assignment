/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Wee Kiat
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/MainForm.fxml"));
        Parent root = (Parent)loader.load();
        MainFormController controller = (MainFormController)loader.getController();
        controller.setStage(primaryStage);
        
        primaryStage.setTitle("School Management");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
