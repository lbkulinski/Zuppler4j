package com.zuppler4j;

/**
 * A time availability of the Zuppler API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 6, 2021
 * @param open the open time of this time availability
 * @param close the close time of this time availability
 */
public record TimeAvailability(Integer open, Integer close) {
}