package com.zuppler4j.menu;

import java.util.List;

/**
 * An item modifier of the Zuppler API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 6, 2021
 * @param id the ID of this item modifier
 * @param name the name of this item modifier
 * @param description the description of this item modifier
 * @param options the {@code List} of {@code ItemOption}s of this item modifier
 * @param active the active flag of this item modifier
 * @param allowGrouping the flag to allow grouping of this item modifier
 * @param dependsOn the {@code List} of dependents of this item modifier
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
}