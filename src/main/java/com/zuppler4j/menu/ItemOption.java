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

import com.zuppler4j.Image;

/**
 * An item option of the Zuppler API.
 *
 * @apiNote The Zuppler GraphQL {@code ItemOption} object has a {@code default} field. It has been renamed to
 * {@code preselected} in Zuppler4j, as {@code default} is a keyword.
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version December 2, 2021
 * @param id the ID of this {@link ItemOption}
 * @param name the name of this {@link ItemOption}
 * @param price the price of this {@link ItemOption}
 * @param active the active flag of this {@link ItemOption}
 * @param preselected the preselected flag of this {@link ItemOption}
 * @param description the description of this {@link ItemOption}
 * @param dishId the dish ID of this {@link ItemOption}
 * @param group the group of this {@link ItemOption}
 * @param groupLabel the group label of this {@link ItemOption}
 * @param image the {@link Image} of this {@link ItemOption}
 * @param pricedIn the priced in flag of this {@link ItemOption}
 * @param priority the priority of this {@link ItemOption}
 * @param weight the weight of this {@link ItemOption}
 */
public record ItemOption(Integer id, String name, Double price, Boolean active, Boolean preselected,
                         String description, Integer dishId, String group, String groupLabel, Image image,
                         Boolean pricedIn, Integer priority, Integer weight) {
}