/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxhw5_3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/**
 *
 * @author Carlos Garcia
 */
public class JavaFXHW5_3 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        FXMLDocumentController controller = loader.getController();
        Scene scene = new Scene(root);
        
        scene.setOnKeyPressed(event ->
        {
            if(event.getCode() == KeyCode.S)
            {
                controller.launch();
            }
            else if(event.getCode() == KeyCode.R)
            {
                controller.reset();
            }
        });
        stage.setTitle("Catching key and mouse events!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}