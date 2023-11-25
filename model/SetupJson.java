package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @param maximumEvents max events by the user
 * @param maximumTasks  max tasks by the user
 * @param week          the wek fom the bujo file
 */
public record SetupJson(

    @JsonProperty("max-events") int maximumEvents,

    @JsonProperty("max-tasks") int maximumTasks,

    @JsonProperty("week") WeekJson week
) {
}
