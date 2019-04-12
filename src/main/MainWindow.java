package main;

import MenuUtil.MenuUtilities;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("fxmfiles/mainWindow.fxml"));
        StackPane stackPane = loader.load();

        Scene scene = new Scene(stackPane);


        MainWindowController controller = (MainWindowController) loader.getController();
        controller.setStage(primaryStage);


        stackPane.getChildren().add(MenuUtilities.prepareMenu());
        stackPane.setAlignment(Pos.TOP_LEFT);

        primaryStage.setTitle("CR - Produkcja");
        primaryStage.setOnCloseRequest((e) -> { MainWindowController.closeProgram();});
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setMinWidth(300);
        primaryStage.setMinHeight(300);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("main/Icon.png"));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
