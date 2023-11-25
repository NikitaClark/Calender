package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Reprsents week json
 *
 * @param days days in the week
 */
public record WeekJson(

    @JsonProperty("week-view") List<DayJson> days
) {
}
