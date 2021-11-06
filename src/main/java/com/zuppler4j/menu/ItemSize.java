package com.zuppler4j.menu;

import java.util.List;

/**
 * An item size of the Zuppler API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 6, 2021
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
}