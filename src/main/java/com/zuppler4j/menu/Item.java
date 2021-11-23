package com.zuppler4j.menu;

import java.util.List;
import com.zuppler4j.Image;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A category's item of the Zuppler API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 22, 2021
 * @param id the ID of this item
 * @param name the name of this item
 * @param description the description of this item
 * @param active the active flag of this item
 * @param coupon the coupon flag of this item
 * @param couponCode the coupon code of this item
 * @param dietaryPreferences the {@link List} of dietary preferences of this item
 * @param dishId the dish ID of this item
 * @param featured the featured flag of this item
 * @param image the {@link Image} of this item
 * @param maxPrice the maximum price of this item
 * @param maxServingQty the maximum serving quantity of this item
 * @param minPrice the minimum price of this item
 * @param minQty the minimum quantity of this item
 * @param minServingQty the minimum serving quantity of this item
 * @param modifiersCount the modifiers count of this item
 * @param multipleSizes the multiple sizes flag of this item
 * @param price the price of this item
 * @param priority the priority of this item
 * @param resourceUrl the resource URL of this item
 * @param servingLabel the serving label of this item
 * @param servingQty the serving quantity of this item
 * @param taxCategoryId the tax category ID of this item
 * @param upsell the upsell flag of this item
 */
public record Item(Integer id, String name, String description, Boolean active, Boolean coupon, String couponCode,
                   List<String> dietaryPreferences, Integer dishId, Boolean featured, Image image, Double maxPrice,
                   Double maxServingQty, Double minPrice, Integer minQty, Double minServingQty, Integer modifiersCount,
                   Boolean multipleSizes, Double price, Integer priority, String resourceUrl, String servingLabel,
                   Double servingQty, Integer taxCategoryId, Boolean upsell) {
    /**
     * Constructs an instance of the {@link Item} class.
     *
     * @param id the ID to be used in construction
     * @param name the name to be used in construction
     * @param description the description to be used in construction
     * @param active the active flag to be used in construction
     * @param coupon the coupon flag to be used in construction
     * @param couponCode the coupon code to be used in construction
     * @param dietaryPreferences the {@link List} of dietary preferences to be used in construction
     * @param dishId the dish ID to be used in construction
     * @param featured the featured flag to be used in construction
     * @param image the {@link Image} to be used in construction
     * @param maxPrice the maximum price to be used in construction
     * @param maxServingQty the maximum serving quantity to be used in construction
     * @param minPrice the minimum price to be used in construction
     * @param minQty the minimum quantity to be used in construction
     * @param minServingQty the minimum serving quantity to be used in construction
     * @param modifiersCount the modifiers count to be used in construction
     * @param multipleSizes the multiple sizes flag to be used in construction
     * @param price the price to be used in construction
     * @param priority the priority to be used in construction
     * @param resourceUrl the resource URL to be used in construction
     * @param servingLabel the serving label to be used in construction
     * @param servingQty the serving quantity to be used in construction
     * @param taxCategoryId the tax category ID to be used in construction
     * @param upsell the upsell flag to be used in construction
     */
    public Item {
        if (dietaryPreferences != null) {
            dietaryPreferences = new ArrayList<>(dietaryPreferences);

            dietaryPreferences = Collections.unmodifiableList(dietaryPreferences);
        } //end if
    } //Item
}