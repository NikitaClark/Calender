package cs3500.pa05.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.model.BujoJson;
import cs3500.pa05.model.EventJson;
import cs3500.pa05.model.DaysOfWeek;
import cs3500.pa05.model.EventConstructor;
import cs3500.pa05.model.FileSave;
import cs3500.pa05.model.TaskConstructor;
import cs3500.pa05.view.GuiFileFinder;
import cs3500.pa05.view.PutJournal;
import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Represents HandleBarNewScreensDisplay
 */
public class HandleBarNewScreensDisplay {

  private Stage stage;

  /**
   * Initalizes HandleBarNewScreensDisplay
   */
  public HandleBarNewScreensDisplay() {

  }

  /**
   * Initalizes HandleBarNewScreensDisplay
   *
   * @param stage the given stage
   */
  public HandleBarNewScreensDisplay(Stage stage) {
    this.stage = stage;
  }


  /**
   * Loads new Event so that the user can enter new Event
   */
  @FXML
  public void handleNewEventClick() {
    // Event handling code for the menu item here

    GuiFileFinder guiFileFinder = new GuiFileFinder();
    // Load the "newEvent.fxml" scene
    Scene noEventsScene = guiFileFinder.loadSceneFromFxml("newEvent.fxml");

    // Create a new stage for the new window
    Stage noEventsStage = new Stage();
    noEventsStage.setTitle("New Event");
    noEventsStage.setScene(noEventsScene);


    // Show the new window
    noEventsStage.show();
  }


  /**
   * Loads new task so that the user can enter new task
   */
  @FXML
  public void handleNewTaskClick() {
    // Event handling code for the menu item here
    GuiFileFinder guiFileFinder = new GuiFileFinder();

    // Load the "newTask.fxml" scene
    Scene noEventsScene = guiFileFinder.loadSceneFromFxml("newTask.fxml");

    // Create a new stage for the new window
    Stage noEventsStage = new Stage();
    noEventsStage.setTitle("New Task");
    noEventsStage.setScene(noEventsScene);


    // Show the new window
    noEventsStage.showAndWait();
    //updateGui();


  }


  /**
   * Loads delete Event so that the user can delete an Event
   */
  @FXML
  public void handleDeleteEvent() {
    // Event handling code for the menu item here
    GuiFileFinder guiFileFinder = new GuiFileFinder();
    // GuiFileFinder guiFileFinder = new GuiFileFinder(this);
    // Load the "newTask.fxml" scene
    Scene noEventsScene = guiFileFinder.loadSceneFromFxml("deleteEvent.fxml");

    // Create a new stage for the new window
    Stage noEventsStage = new Stage();
    noEventsStage.setTitle("To Many Events");
    noEventsStage.setScene(noEventsScene);

    // Show the new window
    noEventsStage.show();
  }

  /**
   * Loads delete taskso that the user can delete a Task
   */
  @FXML
  public void handleDeleteTask() {
    // Event handling code for the menu item here
    GuiFileFinder guiFileFinder = new GuiFileFinder();
    // GuiFileFinder guiFileFinder = new GuiFileFinder(this);
    // Load the "newTask.fxml" scene
    Scene noEventsScene = guiFileFinder.loadSceneFromFxml("deleteTask.fxml");

    // Create a new stage for the new window
    Stage noEventsStage = new Stage();
    noEventsStage.setTitle("To Many Events");
    noEventsStage.setScene(noEventsScene);

    // Show the new window
    noEventsStage.show();
  }

  /**
   * Loads no Tasks
   */
  @FXML
  public void handleNoTasks() {
    // Event handling code for the menu item here
    GuiFileFinder guiFileFinder = new GuiFileFinder();
    //  GuiFileFinder guiFileFinder = new GuiFileFinder(this);
    // Load the "newTask.fxml" scene
    Scene noEventsScene = guiFileFinder.loadSceneFromFxml("notasks.fxml");

    // Create a new stage for the new window
    Stage noEventsStage = new Stage();
    noEventsStage.setTitle("To Many Tasks");
    noEventsStage.setScene(noEventsScene);

    // Show the new window
    noEventsStage.show();
  }

  /**
   * Loads no events
   */

  @FXML
  public void handleNoEvents() {
    // Event handling code for the menu item here
    GuiFileFinder guiFileFinder = new GuiFileFinder();
    //  GuiFileFinder guiFileFinder = new GuiFileFinder(this);
    // Load the "newTask.fxml" scene
    Scene noEventsScene = guiFileFinder.loadSceneFromFxml("noevents.fxml");

    // Create a new stage for the new window
    Stage noEventsStage = new Stage();
    noEventsStage.setTitle("To Many Tasks");
    noEventsStage.setScene(noEventsScene);

    // Show the new window
    noEventsStage.show();
  }

  /**
   * Loads delete quote so that the user can delete a quote
   */
  @FXML
  public void handleDeleteQuote() {
    // Event handling code for the menu item here
    GuiFileFinder guiFileFinder = new GuiFileFinder();
    //  GuiFileFinder guiFileFinder = new GuiFileFinder(this);

    // Load the "newTask.fxml" scene
    Scene noEventsScene = guiFileFinder.loadSceneFromFxml("deleteQuote.fxml");

    // Create a new stage for the new window
    Stage noEventsStage = new Stage();
    noEventsStage.setTitle("New Task");
    noEventsStage.setScene(noEventsScene);

    // Show the new window
    noEventsStage.show();
  }

  /**
   * Loads new quote so that the user can enter new quote
   */
  @FXML
  public void hangleCreateQuote() {
    // Event handling code for the menu item here
    GuiFileFinder guiFileFinder = new GuiFileFinder();
    // GuiFileFinder guiFileFinder = new GuiFileFinder(this);

    // Load the "newTask.fxml" scene
    Scene noEventsScene = guiFileFinder.loadSceneFromFxml("newQuote.fxml");

    // Create a new stage for the new window
    Stage noEventsStage = new Stage();
    noEventsStage.setTitle("New Quote");
    noEventsStage.setScene(noEventsScene);

    // Show the new window
    noEventsStage.show();


  }


  /**
   * Updates the Gui
   *
   * @param name      name of the event
   * @param days      day of the event
   * @param startTime when the event starts
   * @param duration  how long is the event
   * @param event     the event by the user
   */
  @FXML
  public void changeEvent(String name, DaysOfWeek days, String startTime, int duration,
                          ActionEvent event) {
    try {
      Path path = Path.of(new File("src/main/resources/Week.bujo").toURI());
      EventJson eventJson = new EventJson(name, days, startTime, duration, path);
      if ((int) getQuantityEvents(eventJson).get(days.name()) > 2) {
        handleNoEvents();
      } else {
        FileSave save = new FileSave();
        save.saveFile(eventJson);
        Stage stageJournal = (Stage) ((Node) event.getSource()).getScene().getWindow();
        PutJournal journal = new PutJournal(new File("src/main/resources/Week.bujo"));
        journal.setJournal(stageJournal);
      }
    } catch (Exception e) {
      System.out.println("Cannot read the JSON");
    }
  }

  /**
   * @param eventJson the event from the bujo file
   * @return the events per day
   */
  private Map getQuantityEvents(EventJson eventJson) {
    Map<String, Integer> dayCounts = new HashMap<>();
    try {
      // Read the JSON file
      File file = new File("src/main/resources/Week.bujo");
      ObjectMapper objectMapper = new ObjectMapper();
      BujoJson bujoJson = objectMapper.readValue(file, BujoJson.class);
      List<EventJson> eventJsonList = bujoJson.week().days().get(0).events();
      eventJsonList.add(eventJson);
      for (EventJson dayNode : eventJsonList) {
        String day = dayNode.days().toString();
        dayCounts.put(day, dayCounts.getOrDefault(day, 0) + 1);
      }
    } catch (Exception e) {
      System.out.println("Cannot read the JSON");
    }
    return dayCounts;
  }


  /**
   * Updates week overview
   *
   * @param taskList      list of task
   * @param eventList     list of events
   * @param taskCompleted percentage of tasks completed
   * @param scene         the given scene
   */
  @FXML
  public void changeWeekOverview(List<TaskConstructor> taskList, List<EventConstructor> eventList,
                                 double taskCompleted,
                                 FXMLLoader scene) {
    Text myTextEvents = (Text) scene.getNamespace().get("totalEvents");
    myTextEvents.setText(String.valueOf(eventList.size()));

    Text myTextTasks = (Text) scene.getNamespace().get("totalTasks");
    myTextTasks.setText(String.valueOf(taskList.size()));

    Text myTextCompleted = (Text) scene.getNamespace().get("tasksCompleted");
    myTextCompleted.setText(taskCompleted + "%");
  }


}


