/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eclipse;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author usuario
 */
public class Eclipse extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Ellipse ellipse = new Ellipse(10, 10, 100, 50);
        ellipse.setFill(Color.RED);
        // Applica una fade transition a elipse 
        FadeTransition ft = new FadeTransition(Duration.millis(3000), ellipse); 
        ft.setFromValue(1.0); 
        ft.setToValue(0.1); 
        ft.setCycleCount(Timeline.INDEFINITE); 
        ft.setAutoReverse(true);
        ft.play(); // Start animation 
    // Control animation 
        ellipse.setOnMousePressed(e -> ft.pause()); 
        ellipse.setOnMouseReleased(e -> ft.play());
        
        StackPane root = new StackPane();
        root.getChildren().add(ellipse);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
