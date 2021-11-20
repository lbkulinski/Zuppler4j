package com.zuppler4j.menu;

import com.zuppler4j.Image;

/**
 * An item option of the Zuppler API.
 *
 * @apiNote The Zuppler GraphQL {@code ItemOption} object has a {@code default} field. It has been renamed to
 * {@code preselected} in Zuppler4j, as {@code default} is a keyword.
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 20, 2021
 * @param id the ID of this item option
 * @param name the name of this item option
 * @param price the price of this item option
 * @param active the active flag of this item option
 * @param preselected the preselected flag of this item option
 * @param description the description of this item option
 * @param dishId the dish ID of this item option
 * @param group the group of this item option
 * @param groupLabel the group label of this item option
 * @param image the {@code Image} of this item option
 * @param pricedIn the priced in flag of this item option
 * @param priority the priority of this item option
 * @param weight the weight of this item option
 */
public record ItemOption(Integer id, String name, Double price, Boolean active, Boolean preselected,
                         String description, Integer dishId, String group, String groupLabel, Image image,
                         Boolean pricedIn, Integer priority, Integer weight) {
}