package cs3500.pa05.model;

import java.nio.file.Path;

/**
 * Represents an event
 */
public class EventConstructor {

  private String name;

  private DaysOfWeek days;

  private String startTime;

  private int duration;

  private Path pathToSend;

  /**
   * Initializes the eventConstructor
   *
   * @param name       name of the event
   * @param days       day of the event
   * @param startTime  when the event starts
   * @param duration   how long is the event
   * @param pathToSend the path of the bujo file which stores
   *                   the event
   */
  public EventConstructor(String name, DaysOfWeek days, String startTime, int duration,
                          Path pathToSend) {
    this.name = name;
    this.days = days;
    this.startTime = startTime;
    this.duration = duration;
    this.pathToSend = pathToSend;

  }

  @Override
  public String toString() {
    return "name: " + this.name + ";\n" + "startTime:"
        + this.startTime;
  }
}
