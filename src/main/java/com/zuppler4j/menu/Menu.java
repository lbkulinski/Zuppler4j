package com.zuppler4j.menu;

import java.util.List;
import com.zuppler4j.Availability;
import com.zuppler4j.Image;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A menu of the Zuppler API.
 *
 * @apiNote The Zuppler GraphQL {@code Menu} object has a {@code default} field. It has been renamed to
 * {@code preselected} in Zuppler4j, as {@code default} is a keyword.
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 7, 2021
 * @param id the ID of this menu
 * @param name the name of this menu
 * @param description the description of this menu
 * @param categories the {@code List} of {@code Category} objects of this menu
 * @param availability the {@code Availability} of this menu
 * @param preselected the preselected flag of this menu
 * @param group the group of this menu
 * @param image the image of this menu
 * @param useCategoryTabs the flag for using category tags of this menu
 */
public record Menu(Integer id, String name, String description, List<Category> categories, Availability availability,
                   Boolean preselected, String group, Image image, Boolean useCategoryTabs) {
    /**
     * Constructs an instance of the {@code Menu} class.
     *
     * @param id the ID to be used in construction
     * @param name the name to be used in construction
     * @param description the description to be used in construction
     * @param categories the {@code List} of {@code Category} objects to be used in construction
     * @param availability the {@code Availability} to be used in construction
     * @param preselected the preselected flag to be used in construction
     * @param group the group to be used in construction
     * @param image the image to be used in construction
     * @param useCategoryTabs the flag for using category tags to be used in construction
     */
    public Menu {
        if (categories != null) {
            categories = new ArrayList<>(categories);

            categories = Collections.unmodifiableList(categories);
        } //end if
    } //Menu
}