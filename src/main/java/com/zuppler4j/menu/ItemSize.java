package com.zuppler4j.menu;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * An item size of the Zuppler API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 7, 2021
 * @param id the ID of this item size
 * @param price the price of this item size
 * @param sizeId the size ID of this item size
 * @param sizeName the size name of this item size
 * @param modifiers the {@code List} of {@code ItemModifier}s of this item size
 * @param active the active flag of this item size
 * @param coupon the coupon flag of this item size
 * @param minQty the minimum quantity of this item size
 * @param priority the priority of this item size
 * @param servingLabel the serving label of this item size
 * @param servingQty the serving quantity of this item size
 */
public record ItemSize(Integer id, Float price, Integer sizeId, String sizeName, List<ItemModifier> modifiers,
                       Boolean active, Boolean coupon, Integer minQty, Integer priority, String servingLabel,
                       Integer servingQty) {
    /**
     * Constructs an instance of the {@code ItemSize} class.
     *
     * @param id the ID to be used in construction
     * @param price the price to be used in construction
     * @param sizeId the size ID to be used in construction
     * @param sizeName the size name to be used in construction
     * @param modifiers the {@code List} of {@code ItemModifier}s to be used in construction
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