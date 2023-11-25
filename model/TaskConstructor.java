package cs3500.pa05.model;

import java.nio.file.Path;

/**
 * Represents a TaskConstructor
 */
public class TaskConstructor {
  private String name;

  private DaysOfWeek days;

  private boolean complete;

  private Path pathToSend;


  /**
   * Initializes TaskConstructor
   *
   * @param name       the name of the task
   * @param days       the day of the task
   * @param complete   whether the task has been completed
   * @param pathToSend the path of the bujo file
   */
  public TaskConstructor(String name, DaysOfWeek days, boolean complete, Path pathToSend) {
    this.name = name;
    this.days = days;
    this.complete = complete;
    this.pathToSend = pathToSend;

  }

  /**
   * @return string value of TaskConstructor
   */
  @Override
  public String toString() {
    return "name: " + this.name + ";\n" + "complete:"
        + this.complete;
  }

  /**
   * @return DaysOfWeek enum
   */
  public DaysOfWeek getDays() {
    return this.days;
  }

  /**
   * @return name of the task
   */
  public String getName() {
    return this.name;
  }


  /**
   * @return path to send task
   */
  public Path getPathToSend() {
    return this.pathToSend;
  }


  /**
   * @return whether task is completed
   */
  public boolean getCompleted() {
    return this.complete;
  }
}
