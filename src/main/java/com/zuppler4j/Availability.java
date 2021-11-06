package com.zuppler4j;

import java.util.List;

/**
 * An availability of the Zuppler API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 6, 2021
 * @param custom the custom flag of this availability
 * @param days the days of this availability
 * @param priority the priority of this availability
 * @param services the services of this availability
 * @param time the {@code List} of {@code TimeAvailability} objects of this availability
 */
public record Availability(Boolean custom, Integer days, Integer priority, Integer services,
                           List<TimeAvailability> time) {
}