package cs3500.pa05.view;

import javafx.scene.Scene;

/**
 * Represents a welcome GUI view.
 */
public interface WelcomeGuiView {
  /**
   * Loads a scene from a welcome GUI layout.
   *
   * @return the layout
   * @throws IllegalStateException when scene
   *                               could not be loaded
   */
  Scene load() throws IllegalStateException;
}