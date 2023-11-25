package cs3500.pa05.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a FileInterpretor which
 * will read the file
 */
public class FileInterpreter {
  private int maximumEvents;

  private int maximumTasks;

  private Path fileSelected;

  private List<TaskConstructor> totalTasks = new ArrayList<>();

  private List<EventConstructor> totalEvents = new ArrayList<>();

  private double percentTaskCompleted = 0.0;

  private ObjectMapper mapper = new ObjectMapper();

  private StringBuilder content = new StringBuilder();

  private SetupJson json;

  /**
   * Initializes the FileInterpretor
   */
  public FileInterpreter() {

  }
  //count for the amount of tasks validated against the maximum numbers for a day

  /**
   * @param path the path of the bujo file which
   *             stores the events and taks for
   *             the week
   */
  public void openFileInterpreter(Path path) {
    try {

      //BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
      Scanner myReader = new Scanner(path);
      //StringBuilder content = new StringBuilder();
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        content.append(data);
        System.out.println(data);
      }
      //myReader.close();

      this.json = this.mapper.readValue(new File(path.toUri()), SetupJson.class);
      System.out.println(json.toString());
      // System.out.println(json.maximumEvents());
      //System.out.println(json.maximumTasks());
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      //e.printStackTrace();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }


  /**
   * Converts List of TaskJson to List
   * of TaskConstructor
   *
   * @return list of the tasks
   */
  public List<TaskConstructor> makeTaskList() {
    List<DayJson> days = json.week().days();

    for (DayJson day : days) {
      List<TaskJson> tasks = day.tasks();

      for (TaskJson task : tasks) {
        TaskConstructor taskConstructor =
            new TaskConstructor(task.name(), task.days(), task.complete(), task.pathToSend());
        totalTasks.add(taskConstructor);

      }
    }

    return totalTasks;
  }

  /**
   * Converts List of EventJson to List of EventConstructor
   *
   * @return list of events
   */
  public List<EventConstructor> makeEventList() {
    List<DayJson> days = json.week().days();

    for (DayJson day : days) {
      List<EventJson> events = day.events();

      for (EventJson event : events) {
        EventConstructor eventConstructor =
            new EventConstructor(event.name(), event.days(), event.startTime(), event.duration(),
                event.pathToSend());
        totalEvents.add(eventConstructor);

      }
    }

    return totalEvents;
  }


  /**
   * Calculates the percentage of tasks completed
   *
   * @return the percentage of tasks completed
   */
  public double tasksCompleted() {
    double total = this.totalTasks.size();
    List<TaskConstructor> completedTasks = new ArrayList<>();
    for (TaskConstructor task : totalTasks) {
      if (task.getCompleted()) {
        completedTasks.add(task);
      }

    }

    double completed = completedTasks.size();

    this.percentTaskCompleted = (completed / total) * 100;

    return percentTaskCompleted;
  }

  /**
   * @return Setup Json which represents a bujo file
   */
  public SetupJson getJson() {
    return this.json;
  }

  /**
   * @return the content form the bujo file
   */
  public StringBuilder getContent() {
    return this.content;
  }

  /**
   * @return the total tasks from the file
   */
  public List<TaskConstructor> getTotalTasks() {
    return this.totalTasks;
  }

  /**
   * @return the total events from the file
   */
  public List<EventConstructor> getTotalEvents() {
    return this.totalEvents;
  }

  /**
   * @return the percentgae of tasks completed
   */
  public double getPercentTaskCompleted() {
    return this.percentTaskCompleted;
  }

  /**
   * @param json the json representing the bujo file
   */
  public void setJson(SetupJson json) {
    this.json = json;
  }

}
