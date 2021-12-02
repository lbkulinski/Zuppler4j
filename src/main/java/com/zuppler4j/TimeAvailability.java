package com.zuppler4j;

/**
 * A time availability of the Zuppler API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version December 2, 2021
 * @param open the open time of this {@link TimeAvailability}
 * @param close the close time of this {@link TimeAvailability}
 */
public record TimeAvailability(Integer open, Integer close) {
}