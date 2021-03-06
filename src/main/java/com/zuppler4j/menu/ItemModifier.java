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
import java.util.ArrayList;
import java.util.Collections;

/**
 * An item modifier of the Zuppler API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version December 2, 2021
 * @param id the ID of this {@link ItemModifier}
 * @param name the name of this {@link ItemModifier}
 * @param description the description of this {@link ItemModifier}
 * @param options the {@link List} of {@link ItemOption}s of this {@link ItemModifier}
 * @param active the active flag of this {@link ItemModifier}
 * @param allowGrouping the flag to allow grouping of this {@link ItemModifier}
 * @param dependsOn the {@link List} of dependencies of this {@link ItemModifier}
 * @param divider the divider of this {@link ItemModifier}
 * @param masterModifierId the master modifier ID of this {@link ItemModifier}
 * @param minSelections the minimum selections of this {@link ItemModifier}
 * @param maxSelections the maximum selections of this {@link ItemModifier}
 * @param modifierQuantity the modifier quantity of this {@link ItemModifier}
 * @param multipleModifiers the multiple modifiers flag of this {@link ItemModifier}
 * @param multipleSelections the multiple selections flag of this {@link ItemModifier}
 * @param priority the priority of this {@link ItemModifier}
 */
public record ItemModifier(Integer id, String name, String description, List<ItemOption> options, Boolean active,
                           Boolean allowGrouping, List<String> dependsOn, Integer divider, Integer masterModifierId,
                           Integer minSelections, Integer maxSelections, Boolean modifierQuantity,
                           Boolean multipleModifiers, Boolean multipleSelections, Integer priority) {
    /**
     * Constructs an instance of the {@link ItemModifier} class.
     *
     * @param id the ID to be used in construction
     * @param name the name to be used in construction
     * @param description the description to be used in construction
     * @param options the {@link List} of {@link ItemOption}s to be used in construction
     * @param active the active flag to be used in construction
     * @param allowGrouping the flag to allow grouping to be used in construction
     * @param dependsOn the {@link List} of dependencies to be used in construction
     * @param divider the divider to be used in construction
     * @param masterModifierId the master modifier ID to be used in construction
     * @param minSelections the minimum selections to be used in construction
     * @param maxSelections the maximum selections to be used in construction
     * @param modifierQuantity the modifier quantity to be used in construction
     * @param multipleModifiers the multiple modifiers flag to be used in construction
     * @param multipleSelections the multiple selections flag to be used in construction
     * @param priority the priority to be used in construction
     */
    public ItemModifier {
        if (options != null) {
            options = new ArrayList<>(options);

            options = Collections.unmodifiableList(options);
        } //end if

        if (dependsOn != null) {
            dependsOn = new ArrayList<>(dependsOn);

            dependsOn = Collections.unmodifiableList(dependsOn);
        } //end if
    } //ItemModifier
}