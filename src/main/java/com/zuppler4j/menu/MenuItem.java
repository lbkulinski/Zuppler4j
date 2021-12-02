/*
 * MIT License
 *
 * Copyright (c) 2021 Logan Kulinski
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.zuppler4j.menu;

import java.util.List;
import com.zuppler4j.Availability;
import com.zuppler4j.Image;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A menu item of the Zuppler API.
 *
 * @apiNote {@code veg} could mean vegetarian or vegan. It is not specified.
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version December 2, 2021
 * @param id the ID of this {@link MenuItem}
 * @param name the name of this {@link MenuItem}
 * @param description the description of this {@link MenuItem}
 * @param sizes the {@link List} of {@link ItemSize}s of this {@link MenuItem}
 * @param alias the alias of this {@link MenuItem}
 * @param availability the {@link Availability} of this {@link MenuItem}
 * @param dietaryPreferences the {@link List} of dietary preferences of this {@link MenuItem}
 * @param image the {@link Image} of this {@link MenuItem}
 * @param spicy the spiciness of this {@link MenuItem}
 * @param taxCategoryId the tax category ID of this {@link MenuItem}
 * @param veg the veg flag of this {@link MenuItem}
 */
public record MenuItem(Integer id, String name, String description, List<ItemSize> sizes, String alias,
                       Availability availability, List<String> dietaryPreferences, Image image, Integer spicy,
                       Integer taxCategoryId, Boolean veg) {
    /**
     * Constructs an instance of the {@link MenuItem} class.
     *
     * @param id the ID to be used in construction
     * @param name the name to be used in construction
     * @param description the description to be used in construction
     * @param sizes the {@link List} of {@link ItemSize}s to be used in construction
     * @param alias the alias to be used in construction
     * @param availability the {@link Availability} to be used in construction
     * @param dietaryPreferences the {@link List} of dietary preferences to be used in construction
     * @param image the {@link Image} to be used in construction
     * @param spicy the spiciness to be used in construction
     * @param taxCategoryId the tax category ID to be used in construction
     * @param veg the veg flag to be used in construction
     */
    public MenuItem {
        if (sizes != null) {
            sizes = new ArrayList<>(sizes);

            sizes = Collections.unmodifiableList(sizes);
        } //end if

        if (dietaryPreferences != null) {
            dietaryPreferences = new ArrayList<>(dietaryPreferences);

            dietaryPreferences = Collections.unmodifiableList(dietaryPreferences);
        } //end if
    } //MenuItem
}