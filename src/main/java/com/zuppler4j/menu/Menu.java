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
 * A menu of the Zuppler API.
 *
 * @apiNote The Zuppler GraphQL {@code Menu} object has a {@code default} field. It has been renamed to
 * {@code preselected} in Zuppler4j, as {@code default} is a keyword.
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version December 2, 2021
 * @param id the ID of this {@link Menu}
 * @param name the name of this {@link Menu}
 * @param description the description of this {@link Menu}
 * @param categories the {@link List} of {@link Category} objects of this {@link Menu}
 * @param availability the {@link Availability} of this {@link Menu}
 * @param preselected the preselected flag of this {@link Menu}
 * @param group the group of this {@link Menu}
 * @param image the {@link Image} of this {@link Menu}
 * @param useCategoryTabs the flag for using category tags of this {@link Menu}
 */
public record Menu(Integer id, String name, String description, List<Category> categories, Availability availability,
                   Boolean preselected, String group, Image image, Boolean useCategoryTabs) {
    /**
     * Constructs an instance of the {@link Menu} class.
     *
     * @param id the ID to be used in construction
     * @param name the name to be used in construction
     * @param description the description to be used in construction
     * @param categories the {@link List} of {@link Category} objects to be used in construction
     * @param availability the {@link Availability} to be used in construction
     * @param preselected the preselected flag to be used in construction
     * @param group the group to be used in construction
     * @param image the {@link Image} to be used in construction
     * @param useCategoryTabs the flag for using category tags to be used in construction
     */
    public Menu {
        if (categories != null) {
            categories = new ArrayList<>(categories);

            categories = Collections.unmodifiableList(categories);
        } //end if
    } //Menu
}