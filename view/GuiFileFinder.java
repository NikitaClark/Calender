package cs3500.pa05.view;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
//

/**
 * Represents a simple welcome GUI view.
 */
public class GuiFileFinder implements WelcomeGuiView {
  private FXMLLoader loader;

  /**
   * Is a loader that will take care of accessing the file
   * and setting the FXMLLoader parameters to the location of the file.
   */
  public GuiFileFinder() {
    // look up and store the layout
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("cal.fxml"));
    // this.loader.setController(controller);
  }


  /**
   * Loads a scene from a welcome GUI layout.
   *
   * @return the layout
   */
  public Scene load() {
    // load the layout
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }

  /**
   * Loads a scene from a specific FXML file.
   *
   * @param fxmlFileName the name of the FXML file to load
   * @return the loaded scene
   */
  public Scene loadSceneFromFxml(String fxmlFileName) {
    // look up and store the layout from the specified FXML file
    FXMLLoader customLoader = new FXMLLoader();
    customLoader.setLocation(getClass().getClassLoader().getResource(fxmlFileName));
    //customLoader.setController(controller);

    // load the layout from the specified FXML file
    try {
      return customLoader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout from " + fxmlFileName);
    }
  }


}