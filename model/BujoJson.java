package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents bujoJson
 *
 * @param events max events input by the user
 * @param tasks  max tasks unput by the user
 * @param week   the week from the bujo file
 */
public record BujoJson(
    @JsonProperty("max-events") int events,
    @JsonProperty("max-tasks") int tasks,

    @JsonProperty("week") WeekJson week) {
}
