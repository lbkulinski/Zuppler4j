package com.zuppler4j.menu;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * An item modifier of the Zuppler API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 20, 2021
 * @param id the ID of this item modifier
 * @param name the name of this item modifier
 * @param description the description of this item modifier
 * @param options the {@code List} of {@code ItemOption}s of this item modifier
 * @param active the active flag of this item modifier
 * @param allowGrouping the flag to allow grouping of this item modifier
 * @param dependsOn the {@code List} of dependencies of this item modifier
 * @param divider the divider of this item modifier
 * @param masterModifierId the master modifier ID of this item modifier
 * @param minSelections the minimum selections of this item modifier
 * @param maxSelections the maximum selections of this item modifier
 * @param modifierQuantity the modifier quantity of this item modifier
 * @param multipleModifiers the multiple modifiers flag of this item modifier
 * @param multipleSelections the multiple selections flag of this item modifier
 * @param priority the priority of this item modifier
 */
public record ItemModifier(Integer id, String name, String description, List<ItemOption> options, Boolean active,
                           Boolean allowGrouping, List<String> dependsOn, Integer divider, Integer masterModifierId,
                           Integer minSelections, Integer maxSelections, Boolean modifierQuantity,
                           Boolean multipleModifiers, Boolean multipleSelections, Integer priority) {
    /**
     * Constructs an instance of the {@code ItemModifier} class.
     *
     * @param id the ID to be used in construction
     * @param name the name to be used in construction
     * @param description the description to be used in construction
     * @param options the {@code List} of {@code ItemOption}s to be used in construction
     * @param active the active flag to be used in construction
     * @param allowGrouping the flag to allow grouping to be used in construction
     * @param dependsOn the {@code List} of dependencies to be used in construction
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