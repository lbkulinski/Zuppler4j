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
import com.zuppler4j.Image;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A category of the Zuppler API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version December 2, 2021
 * @param id the ID of this {@link Category}
 * @param name the name of this {@link Category}
 * @param description the description of this {@link Category}
 * @param items the {@link List} of {@link Item}s of this {@link Category}
 * @param active the active flag of this {@link Category}
 * @param image the {@link Image} of this {@link Category}
 * @param minOrderQty the minimum order quantity of this {@link Category}
 * @param priority the priority of this {@link Category}
 * @param tags the {@link List} of tags of this {@link Category}
 */
public record Category(Integer id, String name, String description, List<Item> items, Boolean active, Image image,
                       Integer minOrderQty, Integer priority, List<String> tags) {
    /**
     * Constructs an instance of the {@link Category} class.
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