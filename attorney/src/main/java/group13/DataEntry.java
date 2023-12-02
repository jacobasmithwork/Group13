package group13;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class DataEntry extends Application{
    
    public DataEntry(){
        //init gui

    }

    public static void main(String[] args){
        //handle gui
        // new DataEntry();
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();

            // loader.setLocation(this.getClass().getResource("DataEntryScreen.fxml"));
            loader.setLocation(this.getClass().getResource("DataEntryScreen.fxml"));

            Parent parent = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(parent);
            primaryStage.setTitle("Attorney Application");
            primaryStage.setScene(scene);
            primaryStage.getIcons().add(new Image("https://cdn-icons-png.flaticon.com/512/2710/2710029.png"));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}