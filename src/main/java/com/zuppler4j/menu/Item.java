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
import com.google.gson.Gson;
import java.util.Map;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpClient;
import java.io.UncheckedIOException;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.util.Optional;
import com.google.gson.GsonBuilder;
import com.zuppler4j.adapters.ImageTypeAdapter;
import com.zuppler4j.TimeAvailability;
import com.zuppler4j.adapters.TimeAvailabilityTypeAdapter;
import com.zuppler4j.Availability;
import com.zuppler4j.adapters.AvailabilityTypeAdapter;
import com.zuppler4j.adapters.menu.ItemOptionTypeAdapter;
import com.zuppler4j.adapters.menu.ItemModifierTypeAdapter;
import com.zuppler4j.adapters.menu.ItemSizeTypeAdapter;
import com.zuppler4j.adapters.menu.MenuItemTypeAdapter;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.JsonElement;

/**
 * A category's item of the Zuppler API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version December 2, 2021
 * @param id the ID of this {@link Item}
 * @param name the name of this {@link Item}
 * @param description the description of this {@link Item}
 * @param price the price of this {@link Item}
 * @param active the active flag of this {@link Item}
 * @param coupon the coupon flag of this {@link Item}
 * @param couponCode the coupon code of this {@link Item}
 * @param dietaryPreferences the {@link List} of dietary preferences of this {@link Item}
 * @param dishId the dish ID of this {@link Item}
 * @param featured the featured flag of this {@link Item}
 * @param image the {@link Image} of this {@link Item}
 * @param minPrice the minimum price of this {@link Item}
 * @param maxPrice the maximum price of this {@link Item}
 * @param minServingQty the minimum serving quantity of this {@link Item}
 * @param maxServingQty the maximum serving quantity of this {@link Item}
 * @param minQty the minimum quantity of this {@link Item}
 * @param modifiersCount the modifiers count of this {@link Item}
 * @param multipleSizes the multiple sizes flag of this {@link Item}
 * @param priority the priority of this {@link Item}
 * @param resourceUrl the resource URL of this {@link Item}
 * @param servingLabel the serving label of this {@link Item}
 * @param servingQty the serving quantity of this {@link Item}
 * @param taxCategoryId the tax category ID of this {@link Item}
 * @param upsell the upsell flag of this {@link Item}
 */
public record Item(Integer id, String name, String description, Double price, Boolean active, Boolean coupon,
                   String couponCode, List<String> dietaryPreferences, Integer dishId, Boolean featured, Image image,
                   Double minPrice, Double maxPrice, Double minServingQty, Double maxServingQty, Integer minQty,
                   Integer modifiersCount, Boolean multipleSizes, Integer priority, String resourceUrl,
                   String servingLabel, Double servingQty, Integer taxCategoryId, Boolean upsell) {
    /**
     * Constructs an instance of the {@link Item} class.
     *
     * @param id the ID to be used in construction
     * @param name the name to be used in construction
     * @param description the description to be used in construction
     * @param price the price to be used in construction
     * @param active the active flag to be used in construction
     * @param coupon the coupon flag to be used in construction
     * @param couponCode the coupon code to be used in construction
     * @param dietaryPreferences the {@link List} of dietary preferences to be used in construction
     * @param dishId the dish ID to be used in construction
     * @param featured the featured flag to be used in construction
     * @param image the {@link Image} to be used in construction
     * @param minPrice the minimum price to be used in construction
     * @param maxPrice the maximum price to be used in construction
     * @param minServingQty the minimum serving quantity to be used in construction
     * @param maxServingQty the maximum serving quantity to be used in construction
     * @param minQty the minimum quantity to be used in construction
     * @param modifiersCount the modifiers count to be used in construction
     * @param multipleSizes the multiple sizes flag to be used in construction
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

    /**
     * Returns the {@link MenuItem} JSON response for this {@link Item} using the specified {@link Gson} object.
     * 
     * @param gson the {@link Gson} object to be used in the operation
     * @return the {@link MenuItem} JSON response for this {@link Item} using the specified {@link Gson} object
     */
    private String getMenuItemJson(Gson gson) {
        String operationName = "ItemDetails";

        String query = """
                       query ItemDetails($item_id: Int!) {
                           item(item_id: $item_id) {
                               id
                               description
                               name
                               veg
                               spicy
                               sizes {
                                   id
                                   sizeId
                                   sizeName
                                   coupon
                                   priority
                                   active
                                   minQty
                                   price
                                   modifiers {
                                       id
                                       name
                                       description
                                       active
                                       priority
                                       multipleSelections
                                       multipleModifiers
                                       minSelections
                                       maxSelections
                                       allowGrouping
                                       options {
                                           id
                                           name
                                           description
                                           active
                                           priority
                                           weight
                                           group
                                           groupLabel
                                           image {
                                               active
                                               original
                                           }
                                       }
                                   }
                               }
                           }
                       }""";

        Map<String, Integer> variables = Map.of("item_id", this.id);

        Map<String, ?> postFields = Map.of("operationName", operationName,
                                           "query", query,
                                           "variables", variables);

        String postFieldsString = gson.toJson(postFields);

        HttpRequest.BodyPublisher bodyPublisher = HttpRequest.BodyPublishers.ofString(postFieldsString);

        String uriString = "https://restaurants-api5.zuppler.com/graphql";

        URI uri;

        try {
            uri = URI.create(uriString);
        } catch (IllegalArgumentException e) {
            return null;
        } //end try catch

        String[] headers = {"Content-type", "application/json"};

        HttpRequest request;

        try {
            request = HttpRequest.newBuilder(uri)
                                 .headers(headers)
                                 .POST(bodyPublisher)
                                 .build();
        } catch (IllegalArgumentException | IllegalStateException e) {
            return null;
        } //end try catch

        HttpClient client;

        try {
            client = HttpClient.newHttpClient();
        } catch (UncheckedIOException e) {
            return null;
        } //end try catch

        HttpResponse.BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString();

        HttpResponse<String> response;

        try {
            response = client.send(request, bodyHandler);
        } catch (IOException | InterruptedException | IllegalArgumentException | SecurityException e) {
            return null;
        } //end try catch

        return response.body();
    } //getMenuItemJson

    /**
     * Returns the {@link MenuItem} for this {@link Item} or {@link Optional#empty()} if it could not be obtained.
     * 
     * @return the {@link MenuItem} for this {@link Item} or {@link Optional#empty()} if it could not be obtained
     */
    public Optional<MenuItem> getMenuItem() {
        if (this.id == null) {
            return Optional.empty();
        } //end if

        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson gson = gsonBuilder.registerTypeAdapter(Image.class, new ImageTypeAdapter())
                               .registerTypeAdapter(TimeAvailability.class, new TimeAvailabilityTypeAdapter())
                               .registerTypeAdapter(Availability.class, new AvailabilityTypeAdapter())
                               .registerTypeAdapter(ItemOption.class, new ItemOptionTypeAdapter())
                               .registerTypeAdapter(ItemModifier.class, new ItemModifierTypeAdapter())
                               .registerTypeAdapter(ItemSize.class, new ItemSizeTypeAdapter())
                               .registerTypeAdapter(MenuItem.class, new MenuItemTypeAdapter())
                               .serializeNulls()
                               .create();

        String json = this.getMenuItemJson(gson);

        JsonObject jsonObject;

        try {
            jsonObject = gson.fromJson(json, JsonObject.class);
        } catch (JsonSyntaxException e) {
            return Optional.empty();
        } //end try catch

        if (!jsonObject.has("data")) {
            return Optional.empty();
        } //end if

        JsonElement dataElement = jsonObject.get("data");

        if (!dataElement.isJsonObject()) {
            return Optional.empty();
        } //end if

        JsonObject dataObject = jsonObject.getAsJsonObject("data");

        if (!dataObject.has("item")) {
            return Optional.empty();
        } //end if

        JsonElement itemElement = dataObject.get("item");

        if (!itemElement.isJsonObject()) {
            return Optional.empty();
        } //end if

        JsonObject itemObject = itemElement.getAsJsonObject();

        MenuItem menuItem;

        try {
            menuItem = gson.fromJson(itemObject, MenuItem.class);
        } catch (JsonSyntaxException e) {
            return Optional.empty();
        } //end try catch

        return Optional.of(menuItem);
    } //getMenuItem
}