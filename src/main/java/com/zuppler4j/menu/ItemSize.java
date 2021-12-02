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