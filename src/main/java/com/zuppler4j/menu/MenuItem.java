package com.zuppler4j.menu;

import java.util.List;
import com.zuppler4j.Availability;
import com.zuppler4j.Image;

/**
 * A menu item of the Zuppler API.
 *
 * @apiNote {@code veg} could mean vegetarian or vegan. It is not specified.
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 6, 2021
 * @param id the ID of this menu item
 * @param name the name of this menu item
 * @param description the description of this menu item
 * @param sizes the {@code List} of {@code ItemSize}s of this menu item
 * @param alias the alias of this menu item
 * @param availability the {@code Availability} of this menu item
 * @param dietaryPreferences the {@code List} of dietary preferences of this menu item
 * @param image the {@code Image} of this menu item
 * @param spicy the spiciness of this menu item
 * @param taxCategoryId the tax category ID of this menu item
 * @param veg the veg flag of this menu item
 */
public record MenuItem(Integer id, String name, String description, List<ItemSize> sizes, String alias,
                       Availability availability, List<String> dietaryPreferences, Image image, Integer spicy,
                       Integer taxCategoryId, Boolean veg) {
}