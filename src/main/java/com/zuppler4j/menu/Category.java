package com.zuppler4j.menu;

import java.util.List;
import com.zuppler4j.Image;

/**
 * A category of the Zuppler API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 6, 2021
 * @param id the ID of this category
 * @param name the name of this category
 * @param description the description of this category
 * @param items the {@code List} of {@code MenuItem}s of this category
 * @param active the active flag of this category
 * @param image the {@code Image} of this category
 * @param minOrderQty the minimum order quantity of this category
 * @param priority the priority of this category
 * @param tags the {@code List} of tags of this category
 */
public record Category(Integer id, String name, String description, List<MenuItem> items, Boolean active, Image image,
                       Integer minOrderQty, Integer priority, List<String> tags) {
}