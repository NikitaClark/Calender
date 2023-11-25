package cs3500.pa05.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.view.PutJournal;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javafx.stage.Stage;


/**
 * Represent FileSave
 */
public class FileSave {

  private List<EventConstructor> addedEvents;

  private List<TaskConstructor> addedTasks;

  private List<String> quoteList;

  private String weekName;

  private int maximumEvents;

  private int maximumTasks;


  /**
   * Saves the event to the bujo file
   *
   * @param eventJson the given event
   */
  public void saveFile(EventJson eventJson) {
    try {
      // Read the JSON file
      File file = new File("src/main/resources/Week.bujo");
      Path path = Path.of(file.toURI());
      ObjectMapper objectMapper = new ObjectMapper();
      BujoJson bujoJson = objectMapper.readValue(file, BujoJson.class);

      // Create a new event object
      EventJson newEvent = new EventJson(
          eventJson.name(), eventJson.days(),
          eventJson.startTime(),
          eventJson.duration(),
          path
      );

      // Get the week object
      WeekJson week = bujoJson.week();

      // Get the days list
      List<DayJson> days = new ArrayList<>(week.days());

      // Get the first day object (SUNDAY)
      DayJson firstDay = days.get(0);

      // Get the events list of the first day
      List<EventJson> events = new ArrayList<>(firstDay.events());

      // Add the new event to the events list
      events.add(newEvent);

      // Set the modified events list to the first day object
      DayJson updatedFirstDay = new DayJson(
          firstDay.days(),
          events,
          firstDay.tasks()
      );

      // Update the days list with the modified first day object
      days.set(0, updatedFirstDay);

      // Set the updated days list to the week object
      WeekJson updatedWeek = new WeekJson(days);

      // Set the updated week object to the BujoJson
      BujoJson updatedBujoJson = new BujoJson(
          bujoJson.events(),
          bujoJson.tasks(),
          updatedWeek
      );

      // Write the modified BujoJson back to the file
      objectMapper.writeValue(file, updatedBujoJson);

      System.out.println("Information added to the file successfully.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Saves task to bujo file
   *
   * @param taskJson the given task
   */
  public void saveFileTasks(TaskJson taskJson) {
    try {
      // Read the JSON file
      File file = new File("src/main/resources/Week.bujo");
      Path path = Path.of(file.toURI());
      ObjectMapper objectMapper = new ObjectMapper();
      SetupJson bujoJson = objectMapper.readValue(file, SetupJson.class);

      // Create a new event object
      TaskJson newEvent = new TaskJson(
          taskJson.name(), taskJson.days(),
          false,
          path
      );

      // Get the week object
      WeekJson week = bujoJson.week();

      // Get the days list
      List<DayJson> days = new ArrayList<>(week.days());

      // Get the first day object (SUNDAY)
      DayJson firstDay = days.get(0);

      // Get the events list of the first day
      List<TaskJson> events = new ArrayList<>(firstDay.tasks());

      // Add the new event to the events list
      events.add(newEvent);

      // Set the modified events list to the first day object
      DayJson updatedFirstDay = new DayJson(
          firstDay.days(),
          firstDay.events(),
          events
      );

      // Update the days list with the modified first day object
      days.set(0, updatedFirstDay);

      // Set the updated days list to the week object
      WeekJson updatedWeek = new WeekJson(days);

      // Set the updated week object to the BujoJson
      SetupJson updatedBujoJson = new SetupJson(
          bujoJson.maximumEvents(),
          bujoJson.maximumTasks(),
          updatedWeek
      );

      // Write the modified BujoJson back to the file
      objectMapper.writeValue(file, updatedBujoJson);

      System.out.println("Information added to the file successfully.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Deletes the given event
   *
   * @param name the event to be deleted
   */
  public void deleteEvent(String name) {
    try {
      // Read the JSON file
      File file = new File("src/main/resources/Week.bujo");
      Path path = Path.of(file.toURI());
      ObjectMapper objectMapper = new ObjectMapper();
      SetupJson bujoJson = objectMapper.readValue(file, SetupJson.class);
      List<EventJson> eventJsonList = bujoJson.week().days().get(0).events();
      for (EventJson eventJson : eventJsonList) {
        if (eventJson.name().equals(name)) {
          eventJsonList.remove(eventJson);
          break;
        }
      }
      // Write the modified BujoJson back to the file
      objectMapper.writeValue(file, bujoJson);
      PutJournal journal = new PutJournal(file);
      Stage stage = new Stage();
      journal.setJournal(stage);
    } catch (Exception e) {
      System.out.println("Cannot read the JSON");
    }

  }

  /**
   * Deletes the given task
   *
   * @param taskName the task to be deleted
   */
  public void deleteTask(String taskName) {
    try {
      // Read the JSON file
      File file = new File("src/main/resources/Week.bujo");
      Path path = Path.of(file.toURI());
      ObjectMapper objectMapper = new ObjectMapper();
      SetupJson bujoJson = objectMapper.readValue(file, SetupJson.class);
      List<TaskJson> tasksJsonList = bujoJson.week().days().get(0).tasks();
      for (TaskJson taskJson : tasksJsonList) {
        if (taskJson.name().equals(taskName)) {
          tasksJsonList.remove(taskJson);
          break;
        }
      }
      // Write the modified BujoJson back to the file
      objectMapper.writeValue(file, bujoJson);
      PutJournal journal = new PutJournal(file);
      Stage stage = new Stage();
      journal.setJournal(stage);
    } catch (Exception e) {
      System.out.println("Cannot read the JSON");
    }
  }
}