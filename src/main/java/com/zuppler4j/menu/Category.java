package com.zuppler4j.menu;

import java.util.List;
import com.zuppler4j.Image;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A category of the Zuppler API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 22, 2021
 * @param id the ID of this category
 * @param name the name of this category
 * @param description the description of this category
 * @param items the {@link List} of {@link Item}s of this category
 * @param active the active flag of this category
 * @param image the {@link Image} of this category
 * @param minOrderQty the minimum order quantity of this category
 * @param priority the priority of this category
 * @param tags the {@link List} of tags of this category
 */
public record Category(Integer id, String name, String description, List<Item> items, Boolean active, Image image,
                       Integer minOrderQty, Integer priority, List<String> tags) {
    /**
     * Constructs an instance of the {@code Category} class.
     *
     * @param id the ID to be used in construction
     * @param name the name to be used in construction
     * @param description the description to be used in construction
     * @param items the {@link List} of {@link MenuItem}s to be used in construction
     * @param active the active flag to be used in construction
     * @param image the {@link Image} to be used in construction
     * @param minOrderQty the minimum order quantity to be used in construction
     * @param priority the priority to be used in construction
     * @param tags the {@link List} of tags to be used in construction
     */
    public Category {
        if (items != null) {
            items = new ArrayList<>(items);

            items = Collections.unmodifiableList(items);
        } //end if

        if (tags != null) {
            tags = new ArrayList<>(tags);

            tags = Collections.unmodifiableList(tags);
        } //end if
    } //Category
}