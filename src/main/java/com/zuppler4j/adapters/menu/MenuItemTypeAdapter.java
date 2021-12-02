package com.zuppler4j.adapters.menu;

import com.google.gson.TypeAdapter;
import com.zuppler4j.menu.MenuItem;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.List;
import com.zuppler4j.menu.ItemSize;
import com.zuppler4j.Availability;
import com.zuppler4j.adapters.AvailabilityTypeAdapter;
import com.zuppler4j.Image;
import com.zuppler4j.adapters.ImageTypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.util.ArrayList;

/**
 * A type adapter for the {@link MenuItem} class.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version December 2, 2021
 */
public final class MenuItemTypeAdapter extends TypeAdapter<MenuItem> {
    /**
     * Constructs an instance of the {@link MenuItemTypeAdapter} class.
     */
    public MenuItemTypeAdapter() {
    } //MenuItemTypeAdapter

    /**
     * Serializes the specified {@link MenuItem} using the specified {@link JsonWriter}.
     *
     * @param jsonWriter the {@link JsonWriter} to be used in the operation
     * @param menuItem the {@link MenuItem} to be used in the operation
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonWriter} or {@link MenuItem} is {@code null}
     */
    public static void writeMenuItem(JsonWriter jsonWriter, MenuItem menuItem) throws IOException {
        Objects.requireNonNull(jsonWriter, "the specified JsonWriter is null");

        Objects.requireNonNull(menuItem, "the specified MenuItem is null");

        jsonWriter.beginObject();

        jsonWriter.name("id");

        jsonWriter.value(menuItem.id());

        jsonWriter.name("name");

        jsonWriter.value(menuItem.name());

        jsonWriter.name("description");

        jsonWriter.value(menuItem.description());

        jsonWriter.name("sizes");

        List<ItemSize> sizes = menuItem.sizes();

        if (sizes == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.beginArray();

            for (ItemSize size : sizes) {
                if (size == null) {
                    jsonWriter.nullValue();
                } else {
                    ItemSizeTypeAdapter.writeItemSize(jsonWriter, size);
                } //end if
            } //end for

            jsonWriter.endArray();
        } //end if

        jsonWriter.name("alias");

        jsonWriter.value(menuItem.alias());

        jsonWriter.name("availability");

        Availability availability = menuItem.availability();

        if (availability == null) {
            jsonWriter.nullValue();
        } else {
            AvailabilityTypeAdapter.writeAvailability(jsonWriter, availability);
        } //end if

        jsonWriter.name("dietaryPreferences");

        List<String> dietaryPreferences = menuItem.dietaryPreferences();

        if (dietaryPreferences == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.beginArray();

            for (String dietaryPreference : dietaryPreferences) {
                jsonWriter.value(dietaryPreference);
            } //end for

            jsonWriter.endArray();
        } //end if

        jsonWriter.name("image");

        Image image = menuItem.image();

        if (image == null) {
            jsonWriter.nullValue();
        } else {
            ImageTypeAdapter.writeImage(jsonWriter, image);
        } //end if

        jsonWriter.name("spicy");

        jsonWriter.value(menuItem.spicy());

        jsonWriter.name("taxCategoryId");

        jsonWriter.value(menuItem.taxCategoryId());

        jsonWriter.name("veg");

        jsonWriter.value(menuItem.veg());

        jsonWriter.endObject();
    } //writeMenuItem

    /**
     * Deserializes a {@link MenuItem} object using the specified {@link JsonReader}.
     *
     * @param jsonReader the {@link JsonReader} to be used in the operation
     * @return the deserialized {@link MenuItem} object
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonReader} is {@code null}
     */
    public static MenuItem readMenuItem(JsonReader jsonReader) throws IOException {
        Objects.requireNonNull(jsonReader, "the specified JsonReader is null");

        Integer id = null;

        String name = null;

        String description = null;

        List<ItemSize> sizes = null;

        String alias = null;

        Availability availability = null;

        List<String> dietaryPreferences = null;

        Image image = null;

        Integer spicy = null;

        Integer taxCategoryId = null;

        Boolean veg = null;

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
                case "sizes" -> {
                    sizes = new ArrayList<>();

                    jsonReader.beginArray();

                    while (jsonReader.hasNext()) {
                        ItemSize size;

                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();

                            size = null;
                        } else {
                            size = ItemSizeTypeAdapter.readItemSize(jsonReader);
                        } //end if

                        sizes.add(size);
                    } //end while

                    jsonReader.endArray();
                } //case "sizes"
                case "alias" -> alias = jsonReader.nextString();
                case "availability" -> availability = AvailabilityTypeAdapter.readAvailability(jsonReader);
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
                case "image" -> image = ImageTypeAdapter.readImage(jsonReader);
                case "spicy" -> spicy = jsonReader.nextInt();
                case "taxCategoryId" -> taxCategoryId = jsonReader.nextInt();
                case "veg" -> veg = jsonReader.nextBoolean();
            } //end switch
        } //end while

        jsonReader.endObject();

        return new MenuItem(id, name, description, sizes, alias, availability, dietaryPreferences, image, spicy,
                            taxCategoryId, veg);
    } //readMenuItem

    /**
     * Serializes the specified {@link MenuItem} using the specified {@link JsonWriter}.
     *
     * @param jsonWriter the {@link JsonWriter} to be used in the operation
     * @param menuItem the {@link MenuItem} to be used in the operation
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonWriter} or {@link MenuItem} is {@code null}
     */
    @Override
    public void write(JsonWriter jsonWriter, MenuItem menuItem) throws IOException {
        MenuItemTypeAdapter.writeMenuItem(jsonWriter, menuItem);
    } //write

    /**
     * Deserializes a {@link MenuItem} object using the specified {@link JsonReader}.
     *
     * @param jsonReader the {@link JsonReader} to be used in the operation
     * @return the deserialized {@link MenuItem} object
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonReader} is {@code null}
     */
    @Override
    public MenuItem read(JsonReader jsonReader) throws IOException {
        return MenuItemTypeAdapter.readMenuItem(jsonReader);
    } //read
}