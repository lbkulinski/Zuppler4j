package com.zuppler4j.menu;

import com.zuppler4j.Image;

/**
 * An item option of the Zuppler API.
 *
 * @apiNote The Zuppler GraphQL {@code ItemOption} object has a {@code default} field. It has been renamed to
 * {@code preselected} in Zuppler4j, as {@code default} is a keyword.
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version December 2, 2021
 * @param id the ID of this {@link ItemOption}
 * @param name the name of this {@link ItemOption}
 * @param price the price of this {@link ItemOption}
 * @param active the active flag of this {@link ItemOption}
 * @param preselected the preselected flag of this {@link ItemOption}
 * @param description the description of this {@link ItemOption}
 * @param dishId the dish ID of this {@link ItemOption}
 * @param group the group of this {@link ItemOption}
 * @param groupLabel the group label of this {@link ItemOption}
 * @param image the {@link Image} of this {@link ItemOption}
 * @param pricedIn the priced in flag of this {@link ItemOption}
 * @param priority the priority of this {@link ItemOption}
 * @param weight the weight of this {@link ItemOption}
 */
public record ItemOption(Integer id, String name, Double price, Boolean active, Boolean preselected,
                         String description, Integer dishId, String group, String groupLabel, Image image,
                         Boolean pricedIn, Integer priority, Integer weight) {
}