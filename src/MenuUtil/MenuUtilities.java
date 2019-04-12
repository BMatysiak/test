package MenuUtil;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import main.MainWindowController;

public class MenuUtilities {

    public static MenuBar prepareMenu(){

        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");

        MenuItem fileAdd = new MenuItem("Add");
        fileAdd.setGraphic(new ImageView("main/closeIcon.png"));

        MenuItem fileClose = new MenuItem("Save and Exit");
        fileClose.setOnAction(event -> MainWindowController.closeProgram());
        fileClose.setGraphic(new ImageView("main/addIcon.png"));
        fileMenu.getItems().add(fileClose);
        fileMenu.getItems().add(fileAdd);
        menuBar.getMenus().add(fileMenu);

        return menuBar;

    }
}
