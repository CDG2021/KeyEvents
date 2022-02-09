/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxhw5_3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Carlos Garcia
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private ImageView lunarIV;
   
    @FXML
    private ImageView bgImage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Create Images
        Image landerImage = new Image("lunar_lander.png");
        Image space = new Image("lunar_surface.png");
        
        //set Image view's
        lunarIV.setImage(landerImage);
        bgImage.setImage(space);
        
        //Default Position
        TranslateTransition defaultPos = new TranslateTransition(new Duration(2000), lunarIV);
        defaultPos.setFromX(0);
        defaultPos.setFromY(320);
        defaultPos.setToX(235);
        defaultPos.setToY(320);
        defaultPos.play();
        
        lunarIV.setOnMouseEntered(event ->
        {
            Glow glow = new Glow();
            glow.setLevel(0.8);
            lunarIV.setEffect(glow);
        }
        );
        lunarIV.setOnMouseExited(event ->
        {
            Glow deGlow = new Glow();
            deGlow.setLevel(0);
            lunarIV.setEffect(deGlow);
        });
        bgImage.setOnMouseClicked(event ->
        {
            double x = event.getSceneX();
            double y = event.getSceneY();
            TranslateTransition transfPos = new TranslateTransition(new Duration(2000), lunarIV);
            transfPos.setToX(x);
            transfPos.setToY(y);
            transfPos.play();
                    
        }
        );
        
    }    
    
    public void launch(){
        //Transition liftOff
        TranslateTransition liftOff = new TranslateTransition(new Duration(2000), lunarIV);
        liftOff.setToX(235);
        liftOff.setToY(-100);
        liftOff.play();
    }
    public void reset(){
        //Default Position
        TranslateTransition defaultPos = new TranslateTransition(new Duration(2000), lunarIV);
        defaultPos.setFromX(0);
        defaultPos.setFromY(320);
        defaultPos.setToX(235);
        defaultPos.setToY(320);
        defaultPos.play();
    }
}
