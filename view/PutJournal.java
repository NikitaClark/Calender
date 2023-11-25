package cs3500.pa05.view;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.controller.HandleBarNewScreensDisplay;
import cs3500.pa05.model.DayJson;
import cs3500.pa05.model.SetupJson;
import cs3500.pa05.model.EventConstructor;
import cs3500.pa05.model.FileInterpreter;
import cs3500.pa05.model.TaskConstructor;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCharacterCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Represents a putJournal
 */
public class PutJournal {

  File file;

  /**
   * Initializes putJournal
   *
   * @param file the given bujo file
   */
  public PutJournal(File file) {
    this.file = file;
  }

  /**
   * Shows the main screen of the journal with all the events and tasks
   *
   * @param stage the given stage
   */
  public void setJournal(Stage stage) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      SetupJson bujoJson = objectMapper.readValue(file, SetupJson.class);
      FXMLLoader loader = new FXMLLoader(getClass().getResource("cal.fxml"));
      loader.setLocation(getClass().getClassLoader().getResource("cal.fxml"));
      Scene scene = loader.load();
      writeInfoEvents(bujoJson, loader);
      writeInfoTasks(bujoJson, loader);
      overView(loader);
      hotKeys(scene);
      stage.setScene(scene);
      stage.show();
    } catch (StreamReadException e) {
      throw new RuntimeException(e);
    } catch (DatabindException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  /**
   * Writes tasks on the main screen
   */
  private void writeInfoTasks(SetupJson bujoJson, FXMLLoader loader) {
    List<DayJson> dayJson = bujoJson.week().days();
    for (int i = 0; i < dayJson.size(); i++) {
      for (int j = 0; j < dayJson.get(i).tasks().size(); j++) {

        //get the id of the first task
        Text myTextBase = (Text) loader.getNamespace().get("task1"
            + dayJson.get(i).tasks().get(j).days().name());

        // Checks if the day has one task only
        if (myTextBase.getText().equals("task1")) {
          // Writes the given task
          myTextBase.setText(dayJson.get(i).tasks().get(j).name());

        } else {
          //get the id of the second task
          Text myText = (Text) loader.getNamespace().get("task2"
              + dayJson.get(i).tasks().get(j).days().name());
          // Writes the given task
          myText.setText(dayJson.get(i).tasks().get(j).name());
        }

        //writes tasks in the All Tasks section
        Text allTasks = (Text) loader.getNamespace().get("task" + (j + 1));

        allTasks.setText(dayJson.get(i).tasks().get(j).name());
      }
    }
  }

  /**
   * Writes events on the main screen
   */
  private void writeInfoEvents(SetupJson bujoJson, FXMLLoader loader) {
    List<DayJson> dayJson = bujoJson.week().days();
    for (int i = 0; i < dayJson.size(); i++) {
      for (int j = 0; j < dayJson.get(i).events().size(); j++) {

        //get the id of the first event
        Text myTextBase = (Text) loader.getNamespace().get("event1"
            + dayJson.get(i).events().get(j).days().name());

        if (myTextBase.getText().equals("event1")) {
          // Writes the given first event
          myTextBase.setText(dayJson.get(i).events().get(j).name() + " at "
              + dayJson.get(i).events().get(j).startTime());

        } else {
          //get the id of the second event
          Text myText = (Text) loader.getNamespace().get("event2"
              + dayJson.get(i).events().get(j).days().name());
          // Writes the given second event
          myText.setText(dayJson.get(i).events().get(j).name() + " at "
              + dayJson.get(i).events().get(j).startTime());

        }
      }
    }
  }

  /**
   * Changes the Week Overview
   *
   * @param scene gives a FXMLLoader
   */
  private void overView(FXMLLoader scene) {
    Path path = Path.of("src/main/resources/Week.bujo");
    FileInterpreter file = new FileInterpreter();
    file.openFileInterpreter(path);
    List<TaskConstructor> taskList = file.makeTaskList();
    List<EventConstructor> eventList = file.makeEventList();
    double taskCompleted = file.tasksCompleted();
    HandleBarNewScreensDisplay hbnsd = new HandleBarNewScreensDisplay();
    hbnsd.changeWeekOverview(taskList, eventList, taskCompleted, scene);
  }

  /**
   * User can use a combination of keys and use the menu bar features
   *
   * @param scene given scene for the user
   */
  private void hotKeys(Scene scene) {
    scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

      // HandleBarNewScreensDisplay display = new HandleBarNewScreensDisplay(stage);
      final KeyCharacterCombination eventShortCut = new KeyCharacterCombination("e",
          KeyCombination.CONTROL_DOWN);

      final KeyCharacterCombination taskShortCut = new KeyCharacterCombination("t",
          KeyCombination.CONTROL_DOWN);

      final KeyCharacterCombination saveShortCut = new KeyCharacterCombination("s",
          KeyCombination.CONTROL_DOWN);

      final KeyCharacterCombination openShortCut = new KeyCharacterCombination("o",
          KeyCombination.CONTROL_DOWN);

      final KeyCharacterCombination newWeekShortCut = new KeyCharacterCombination("n",
          KeyCombination.CONTROL_DOWN);

      final KeyCharacterCombination quoteShortCut = new KeyCharacterCombination("q",
          KeyCombination.CONTROL_DOWN);

      final KeyCharacterCombination deleteQuoteShortCut = new KeyCharacterCombination("d",
          KeyCombination.CONTROL_DOWN);

      @Override
      public void handle(KeyEvent event) {
        HandleBarNewScreensDisplay hbnsd = new HandleBarNewScreensDisplay();
        if (eventShortCut.match(event)) {

          hbnsd.handleNewEventClick();
        } else if (taskShortCut.match(event)) {

          hbnsd.handleNewTaskClick();
        } else if (quoteShortCut.match(event)) {

          hbnsd.hangleCreateQuote();
        } else if (deleteQuoteShortCut.match(event)) {

          hbnsd.handleDeleteQuote();
        } else if (saveShortCut.match(event)) {

          //save functionality
        } else if (openShortCut.match(event)) {

          //open functionality
        } else if (newWeekShortCut.match(event)) {

          //new week functionality
        }


      }
    });
  }
}