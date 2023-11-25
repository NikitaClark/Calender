package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.DaysOfWeek;
import java.nio.file.Path;

/**
 * /**
 * Initializes the EventJson
 *
 * @param name       name of the event
 * @param days       day of the event
 * @param startTime  when the event starts
 * @param duration   how long is the event
 * @param pathToSend the path of the bujo file which stores
 *                   the event
 */

public record EventJson(
    @JsonProperty("name") String name,

    @JsonProperty("days") DaysOfWeek days,

    @JsonProperty("start-time") String startTime,

    @JsonProperty("duration") int duration,

    @JsonProperty("path-to-send") Path pathToSend
) {


}
