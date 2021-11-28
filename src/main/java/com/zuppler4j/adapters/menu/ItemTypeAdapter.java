package com.zuppler4j.adapters.menu;

import com.google.gson.TypeAdapter;
import com.zuppler4j.menu.Item;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.List;
import com.zuppler4j.Image;
import com.zuppler4j.adapters.ImageTypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.util.ArrayList;

/**
 * A type adapter for the {@link Item} class.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 27, 2021
 */
public final class ItemTypeAdapter extends TypeAdapter<Item> {
    /**
     * Constructs an instance of the {@link Item} class.
     */
    public ItemTypeAdapter() {
    } //ItemTypeAdapter

    /**
     * Serializes the specified {@link Item} using the specified {@link JsonWriter}.
     *
     * @param jsonWriter the {@link JsonWriter} to be used in the operation
     * @param item the {@link Item} to be used in the operation
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonWriter} or {@link Item} is {@code null}
     */
    public static void writeItem(JsonWriter jsonWriter, Item item) throws IOException {
        Objects.requireNonNull(jsonWriter, "the specified JsonWriter is null");

        Objects.requireNonNull(item, "the specified Item is null");

        jsonWriter.beginObject();

        jsonWriter.name("id");

        jsonWriter.value(item.id());

        jsonWriter.name("name");

        jsonWriter.value(item.name());

        jsonWriter.name("description");

        jsonWriter.value(item.description());

        jsonWriter.name("price");

        jsonWriter.value(item.price());

        jsonWriter.name("active");

        jsonWriter.value(item.active());

        jsonWriter.name("coupon");

        jsonWriter.value(item.coupon());

        jsonWriter.name("couponCode");

        jsonWriter.value(item.couponCode());

        jsonWriter.name("dietaryPreferences");

        List<String> dietaryPreferences = item.dietaryPreferences();

        if (dietaryPreferences == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.beginArray();

            for (String dietaryPreference : item.dietaryPreferences()) {
                jsonWriter.value(dietaryPreference);
            } //end for

            jsonWriter.endArray();
        } //end if

        jsonWriter.name("dishId");

        jsonWriter.value(item.dishId());

        jsonWriter.name("featured");

        jsonWriter.value(item.featured());

        jsonWriter.name("image");

        Image image = item.image();

        if (image == null) {
            jsonWriter.nullValue();
        } else {
            ImageTypeAdapter.writeImage(jsonWriter, image);
        } //end if

        jsonWriter.name("minPrice");

        jsonWriter.value(item.minPrice());

        jsonWriter.name("maxPrice");

        jsonWriter.value(item.maxPrice());

        jsonWriter.name("minServingQty");

        jsonWriter.value(item.minServingQty());

        jsonWriter.name("maxServingQty");

        jsonWriter.value(item.maxServingQty());

        jsonWriter.name("minQty");

        jsonWriter.value(item.minQty());

        jsonWriter.name("modifiersCount");

        jsonWriter.value(item.modifiersCount());

        jsonWriter.name("multipleSizes");

        jsonWriter.value(item.multipleSizes());

        jsonWriter.name("priority");

        jsonWriter.value(item.priority());

        jsonWriter.name("resourceUrl");

        jsonWriter.value(item.resourceUrl());

        jsonWriter.name("servingLabel");

        jsonWriter.value(item.servingLabel());

        jsonWriter.name("servingQty");

        jsonWriter.value(item.servingQty());

        jsonWriter.name("taxCategoryId");

        jsonWriter.value(item.taxCategoryId());

        jsonWriter.name("upsell");

        jsonWriter.value(item.upsell());

        jsonWriter.endObject();
    } //writeItem

    /**
     * Deserializes an {@link Item} object using the specified {@link JsonReader}.
     *
     * @param jsonReader the {@link JsonReader} to be used in the operation
     * @return the deserialized {@link Item} object
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonReader} is {@code null}
     */
    public static Item readItem(JsonReader jsonReader) throws IOException {
        Objects.requireNonNull(jsonReader, "the specified JsonReader is null");

        Integer id = null;

        String name = null;

        String description = null;

        Double price = null;

        Boolean active = null;

        Boolean coupon = null;

        String couponCode = null;

        List<String> dietaryPreferences = null;

        Integer dishId = null;

        Boolean featured = null;

        Image image = null;

        Double minPrice = null;

        Double maxPrice = null;

        Double minServingQty = null;

        Double maxServingQty = null;

        Integer minQty = null;

        Integer modifiersCount = null;

        Boolean multipleSizes = null;

        Integer priority = null;

        String resourceUrl = null;

        String servingLabel = null;

        Double servingQty = null;

        Integer taxCategoryId = null;

        Boolean upsell = null;

        jsonReader.beginObject();

        while (jsonReader.hasNext()) {
            String keyName = jsonReader.nextName();

            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();

                continue;
            } //end if

            switch (keyName) {
                case "id" -> id = jsonReader.nextInt();
                case "name" -> name = jsonReader.nextString();
                case "description" -> description = jsonReader.nextString();
                case "price" -> price = jsonReader.nextDouble();
                case "active" -> active = jsonReader.nextBoolean();
                case "coupon" -> coupon = jsonReader.nextBoolean();
                case "couponCode" -> couponCode = jsonReader.nextString();
                case "dietaryPreferences" -> {
                    dietaryPreferences = new ArrayList<>();

                    jsonReader.beginArray();

                    while (jsonReader.hasNext()) {
                        String dietaryPreference;

                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();

                            dietaryPreference = null;
                        } else {
                            dietaryPreference = jsonReader.nextString();
                        } //end if

                        dietaryPreferences.add(dietaryPreference);
                    } //end while

                    jsonReader.endArray();
                } //case "dietaryPreferences"
                case "dishId" -> dishId = jsonReader.nextInt();
                case "featured" -> featured = jsonReader.nextBoolean();
                case "image" -> image = ImageTypeAdapter.readImage(jsonReader);
                case "minPrice" -> minPrice = jsonReader.nextDouble();
                case "maxPrice" -> maxPrice = jsonReader.nextDouble();
                case "minServingQty" -> minServingQty = jsonReader.nextDouble();
                case "maxServingQty" -> maxServingQty = jsonReader.nextDouble();
                case "minQty" -> minQty = jsonReader.nextInt();
                case "modifiersCount" -> modifiersCount = jsonReader.nextInt();
                case "multipleSizes" -> multipleSizes = jsonReader.nextBoolean();
                case "priority" -> priority = jsonReader.nextInt();
                case "resourceUrl" -> resourceUrl = jsonReader.nextString();
                case "servingLabel" -> servingLabel = jsonReader.nextString();
                case "servingQty" -> servingQty = jsonReader.nextDouble();
                case "taxCategoryId" -> taxCategoryId = jsonReader.nextInt();
                case "upsell" -> upsell = jsonReader.nextBoolean();
            } //end switch
        } //end while

        jsonReader.endObject();

        return new Item(id, name, description, price, active, coupon, couponCode, dietaryPreferences, dishId, featured,
                        image, minPrice, maxPrice, minServingQty, maxServingQty, minQty, modifiersCount, multipleSizes,
                        priority, resourceUrl, servingLabel, servingQty, taxCategoryId, upsell);
    } //readItem

    /**
     * Serializes the specified {@link Item} using the specified {@link JsonWriter}.
     *
     * @param jsonWriter the {@link JsonWriter} to be used in the operation
     * @param item the {@link Item} to be used in the operation
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonWriter} or {@link Item} is {@code null}
     */
    @Override
    public void write(JsonWriter jsonWriter, Item item) throws IOException {
        ItemTypeAdapter.writeItem(jsonWriter, item);
    } //write

    /**
     * Deserializes an {@link Item} object using the specified {@link JsonReader}.
     *
     * @param jsonReader the {@link JsonReader} to be used in the operation
     * @return the deserialized {@link Item} object
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonReader} is {@code null}
     */
    @Override
    public Item read(JsonReader jsonReader) throws IOException {
        return ItemTypeAdapter.readItem(jsonReader);
    } //read
}