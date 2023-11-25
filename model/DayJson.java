package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * @param days   days of the week
 * @param events the events for the day
 * @param tasks  the tasks for the day
 */
public record DayJson(
    @JsonProperty("day") DaysOfWeek days,
    @JsonProperty("events") List<EventJson> events,

    @JsonProperty("tasks") List<TaskJson> tasks
) {


}
