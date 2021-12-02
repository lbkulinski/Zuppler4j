package com.zuppler4j;

import java.util.List;

/**
 * An availability of the Zuppler API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version December 2, 2021
 * @param custom the custom flag of this {@link Availability}
 * @param days the days of this {@link Availability}
 * @param priority the priority of this {@link Availability}
 * @param services the services of this {@link Availability}
 * @param time the {@link List} of {@link TimeAvailability} objects of this {@link Availability}
 */
public record Availability(Boolean custom, Integer days, Integer priority, Integer services,
                           List<TimeAvailability> time) {
}