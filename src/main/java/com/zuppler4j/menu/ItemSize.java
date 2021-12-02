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
 * An item size of the Zuppler API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version December 2, 2021
 * @param id the ID of this {@link ItemSize}
 * @param price the price of this {@link ItemSize}
 * @param sizeId the size ID of this {@link ItemSize}
 * @param sizeName the size name of this {@link ItemSize}
 * @param modifiers the {@link List} of {@link ItemModifier}s of this {@link ItemSize}
 * @param active the active flag of this {@link ItemSize}
 * @param coupon the coupon flag of this {@link ItemSize}
 * @param minQty the minimum quantity of this {@link ItemSize}
 * @param priority the priority of this {@link ItemSize}
 * @param servingLabel the serving label of this {@link ItemSize}
 * @param servingQty the serving quantity of this {@link ItemSize}
 */
public record ItemSize(Integer id, Double price, Integer sizeId, String sizeName, List<ItemModifier> modifiers,
                       Boolean active, Boolean coupon, Integer minQty, Integer priority, String servingLabel,
                       Integer servingQty) {
    /**
     * Constructs an instance of the {@link ItemSize} class.
     *
     * @param id the ID to be used in construction
     * @param price the price to be used in construction
     * @param sizeId the size ID to be used in construction
     * @param sizeName the size name to be used in construction
     * @param modifiers the {@link List} of {@link ItemModifier}s to be used in construction
     * @param active the active flag to be used in construction
     * @param coupon the coupon flag to be used in construction
     * @param minQty the minimum quantity to be used in construction
     * @param priority the priority to be used in construction
     * @param servingLabel the serving label to be used in construction
     * @param servingQty the serving quantity to be used in construction
     */
    public ItemSize {
        if (modifiers != null) {
            modifiers = new ArrayList<>(modifiers);

            modifiers = Collections.unmodifiableList(modifiers);
        } //end if
    } //ItemSize
}