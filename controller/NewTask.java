package cs3500.pa05.controller;

import cs3500.pa05.model.DaysOfWeek;
import java.nio.file.Path;

/**
 * Represents a NewTask
 */
public class NewTask {


  private String name;

  private DaysOfWeek days;

  private boolean complete;

  private Path pathToSend;

  private int maximumTasks;


  /**
   * Initializes NewTask
   *
   * @param name       the name of the task
   * @param days       the day of the task
   * @param complete   whether the task has been completed
   * @param pathToSend the path of the bujo file
   */
  public NewTask(String name, DaysOfWeek days, boolean complete, Path pathToSend) {
    this.name = name;
    this.days = days;
    this.complete = complete;
    this.pathToSend = pathToSend;

  }


}
