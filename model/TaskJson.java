package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.DaysOfWeek;
import java.nio.file.Path;

/**
 * Initializes TaskConstructor
 *
 * @param name       the name of the task
 * @param days       the day of the task
 * @param complete   whether the task has been completed
 * @param pathToSend the path of the bujo file
 */
public record TaskJson(
    @JsonProperty("name") String name,

    @JsonProperty("days") DaysOfWeek days,

    @JsonProperty("complete") boolean complete,

    @JsonProperty("path-to-send") Path pathToSend
) {
}
