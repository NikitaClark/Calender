package cs3500.pa05.controller;

import cs3500.pa05.model.TaskJson;
import cs3500.pa05.model.DaysOfWeek;
import cs3500.pa05.model.FileSave;
import cs3500.pa05.model.TaskConstructor;
import cs3500.pa05.view.PutJournal;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Represents a TaskCollecter
 * Controller for newTask.fxml
 */
public class TaskCollector {
  private String taskNameString;

  private String taskDayString;

  private String taskTimeString;

  @FXML
  private Button addTaskButton = new Button("Add");

  @FXML
  private TextField taskName = new TextField("");

  @FXML
  private TextField deleteTask = new TextField("");

  @FXML
  private TextField taskDay = new TextField("");

  @FXML
  private TextField taskTime = new TextField("");


  private ObservableList<TaskConstructor> observableTask;

  private List<TaskConstructor> tasks;

  private Path pathToSend;

  private Stage stage = new Stage();

  private HandleBarNewScreensDisplay mainDisplay = new HandleBarNewScreensDisplay(stage);

  /**
   * Initializes TaskCollector
   * Empty Constructor
   */
  public TaskCollector() {

  }

  /**
   * Initializes TaskCollector
   *
   * @param stage the given stage
   */
  public TaskCollector(Stage stage) {
    this.stage = stage;
  }

  /**
   * Initializes TaskCollector
   */
  @FXML
  private void initialize() {
    pathToSend = Path.of("src/main/resources/Week.bujo");
    tasks = new ArrayList<>();
    observableTask = FXCollections.observableArrayList();
  }


  /**
   * Obtains the information from the user when the
   * add button is pressed
   *
   * @param event the event by the user
   */
  @FXML
  private void onButtonDown(ActionEvent event) {

    this.taskNameString = taskName.getText();
    this.taskDayString = taskDay.getText().toUpperCase();
    this.taskTimeString = taskTime.getText();
    TaskConstructor task =
        new TaskConstructor(taskNameString + " @ " + taskTimeString,
            DaysOfWeek.valueOf(taskDayString), false,
            pathToSend);
    tasks.add(task);
    observableTask.add(task);
    Path path = Path.of(new File("src/main/resources/Week.bujo").toURI());
    TaskJson taskJson = new TaskJson(this.taskNameString, toDays(), false, path);
    FileSave save = new FileSave();
    save.saveFileTasks(taskJson);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    PutJournal journal = new PutJournal(new File("src/main/resources/Week.bujo"));
    journal.setJournal(stage);

  }

  /**
   * @return Days of Week enum from string
   */
  public DaysOfWeek toDays() {
    if (this.taskDayString.equals(DaysOfWeek.MONDAY.name())) {
      return DaysOfWeek.MONDAY;
    } else if (this.taskDayString.equals(DaysOfWeek.TUESDAY.name())) {
      return DaysOfWeek.TUESDAY;
    } else if (this.taskDayString.equals(DaysOfWeek.WEDNESDAY.name())) {
      return DaysOfWeek.WEDNESDAY;
    } else if (this.taskDayString.equals(DaysOfWeek.THURSDAY.name())) {
      return DaysOfWeek.THURSDAY;
    } else if (this.taskDayString.equals(DaysOfWeek.FRIDAY.name())) {
      return DaysOfWeek.FRIDAY;
    } else if (this.taskDayString.equals(DaysOfWeek.SATURDAY.name())) {
      return DaysOfWeek.SATURDAY;
    } else {
      return DaysOfWeek.SUNDAY;
    }
  }

  /**
   * Gets the name of the task that user wants to delete
   *
   * @param event eent by the user
   */
  @FXML
  public void userDeleteTask(ActionEvent event) {
    this.taskNameString = deleteTask.getText();
    Node node = (Node) event.getSource();
    Stage stage = (Stage) node.getScene().getWindow();
    stage.close();
    FileSave file = new FileSave();
    file.deleteTask(this.taskNameString);
  }


  /**
   * @return the task list
   */
  public List<TaskConstructor> getTasks() {
    return this.tasks;
  }


}


