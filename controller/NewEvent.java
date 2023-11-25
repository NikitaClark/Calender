package cs3500.pa05.controller;

import cs3500.pa05.model.DaysOfWeek;
import cs3500.pa05.model.FileSave;
import java.nio.file.Path;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Represents a NewEvent
 */
public class NewEvent {

  private String name;

  private DaysOfWeek days;

  private String startTime;

  private int duration;


  @FXML
  private TextField nameField = new TextField("");

  @FXML
  private TextField deleteEvent = new TextField("");

  @FXML
  private TextField dayField = new TextField("");

  @FXML
  private TextField timeField = new TextField("");

  @FXML
  private TextField durationField = new TextField("");


  /**
   * Initalizes new Event
   */
  public NewEvent() {

  }

  /**
   * Obtains information from the user
   *
   * @param events event by the user
   */
  @FXML
  public void userField(ActionEvent events) {
    try {
      this.name = nameField.getText();
      this.days = toDays();
      this.startTime = timeField.getText();
      this.duration = Integer.parseInt(durationField.getText());

      Node node = (Node) events.getSource();
      Stage stage = (Stage) node.getScene().getWindow();
      stage.close();

      HandleBarNewScreensDisplay event = new HandleBarNewScreensDisplay(stage);
      event.changeEvent(this.name, this.days, this.startTime, this.duration, events);
    } catch (Exception e) {
      System.out.println("Could not read the TextFields");
    }
  }

  /**
   * Gets the info from the user about which event to delete
   *
   * @param event event written by the user
   */
  @FXML
  public void userDeleteField(ActionEvent event) {
    this.name = deleteEvent.getText();
    Node node = (Node) event.getSource();
    Stage stage = (Stage) node.getScene().getWindow();
    stage.close();
    FileSave file = new FileSave();
    file.deleteEvent(this.name);
  }

  /**
   * @return Transform the given string into the DayOfWeek
   */
  public DaysOfWeek toDays() {
    if (dayField.getText().toUpperCase().equals(DaysOfWeek.MONDAY.name())) {
      return DaysOfWeek.MONDAY;
    } else if (dayField.getText().toUpperCase().equals(DaysOfWeek.TUESDAY.name())) {
      return DaysOfWeek.TUESDAY;
    } else if (dayField.getText().toUpperCase().equals(DaysOfWeek.WEDNESDAY.name())) {
      return DaysOfWeek.WEDNESDAY;
    } else if (dayField.getText().toUpperCase().equals(DaysOfWeek.THURSDAY.name())) {
      return DaysOfWeek.THURSDAY;
    } else if (dayField.getText().toUpperCase().equals(DaysOfWeek.FRIDAY.name())) {
      return DaysOfWeek.FRIDAY;
    } else if (dayField.getText().toUpperCase().equals(DaysOfWeek.SATURDAY.name())) {
      return DaysOfWeek.SATURDAY;
    } else {
      return DaysOfWeek.SUNDAY;
    }
  }


}