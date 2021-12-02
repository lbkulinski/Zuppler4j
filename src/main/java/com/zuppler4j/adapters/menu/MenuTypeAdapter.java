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

package com.zuppler4j.adapters.menu;

import com.google.gson.TypeAdapter;
import com.zuppler4j.menu.Menu;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.List;
import com.zuppler4j.menu.Category;
import com.zuppler4j.Availability;
import com.zuppler4j.adapters.AvailabilityTypeAdapter;
import com.zuppler4j.Image;
import com.zuppler4j.adapters.ImageTypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.util.ArrayList;

/**
 * A type adapter for the {@link Menu} class.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version December 1, 2021
 */
public final class MenuTypeAdapter extends TypeAdapter<Menu> {
    /**
     * Constructs an instance of the {@link Menu} class.
     */
    public MenuTypeAdapter() {
    } //MenuTypeAdapter

    /**
     * Serializes the specified {@link Menu} using the specified {@link JsonWriter}.
     *
     * @param jsonWriter the {@link JsonWriter} to be used in the operation
     * @param menu the {@link Menu} to be used in the operation
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonWriter} or {@link Menu} is {@code null}
     */
    public static void writeMenu(JsonWriter jsonWriter, Menu menu) throws IOException {
        Objects.requireNonNull(jsonWriter, "the specified JsonWriter is null");

        Objects.requireNonNull(menu, "the specified Menu is null");

        jsonWriter.beginObject();

        jsonWriter.name("id");

        jsonWriter.value(menu.id());

        jsonWriter.name("name");

        jsonWriter.value(menu.name());

        jsonWriter.name("description");

        jsonWriter.value(menu.description());

        jsonWriter.name("categories");

        List<Category> categories = menu.categories();

        if (categories == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.beginArray();

            for (Category category : categories) {
                if (category == null) {
                    jsonWriter.nullValue();
                } else {
                    CategoryTypeAdapter.writeCategory(jsonWriter, category);
                } //end if
            } //end for

            jsonWriter.endArray();
        } //end if

        jsonWriter.name("availability");

        Availability availability = menu.availability();

        if (availability == null) {
            jsonWriter.nullValue();
        } else {
            AvailabilityTypeAdapter.writeAvailability(jsonWriter, availability);
        } //end if

        jsonWriter.name("default");

        jsonWriter.value(menu.preselected());

        jsonWriter.name("group");

        jsonWriter.value(menu.group());

        jsonWriter.name("image");

        Image image = menu.image();

        if (image == null) {
            jsonWriter.nullValue();
        } else {
            ImageTypeAdapter.writeImage(jsonWriter, image);
        } //end if

        jsonWriter.name("useCategoryTabs");

        jsonWriter.value(menu.useCategoryTabs());

        jsonWriter.endObject();
    } //writeMenu

    /**
     * Deserializes a {@link Menu} object using the specified {@link JsonReader}.
     *
     * @param jsonReader the {@link JsonReader} to be used in the operation
     * @return the deserialized {@link Menu} object
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonReader} is {@code null}
     */
    public static Menu readMenu(JsonReader jsonReader) throws IOException {
        Objects.requireNonNull(jsonReader, "the specified JsonReader is null");

        Integer id = null;

        String name = null;

        String description = null;

        List<Category> categories = null;

        Availability availability = null;

        Boolean preselected = null;

        String group = null;

        Image image = null;

        Boolean useCategoryTabs = null;

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
                case "categories" -> {
                    categories = new ArrayList<>();

                    jsonReader.beginArray();

                    while (jsonReader.hasNext()) {
                        Category category;

                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();

                            category = null;
                        } else {
                            category = CategoryTypeAdapter.readCategory(jsonReader);
                        } //end if

                        categories.add(category);
                    } //end while

                    jsonReader.endArray();
                } //case "categories"
                case "availability" -> availability = AvailabilityTypeAdapter.readAvailability(jsonReader);
                case "default" -> preselected = jsonReader.nextBoolean();
                case "group" -> group = jsonReader.nextString();
                case "image" -> image = ImageTypeAdapter.readImage(jsonReader);
                case "useCategoryTabs" -> useCategoryTabs = jsonReader.nextBoolean();
            } //end switch
        } //end while

        jsonReader.endObject();

        return new Menu(id, name, description, categories, availability, preselected, group, image, useCategoryTabs);
    } //readMenu

    /**
     * Serializes the specified {@link Menu} using the specified {@link JsonWriter}.
     *
     * @param jsonWriter the {@link JsonWriter} to be used in the operation
     * @param menu the {@link Menu} to be used in the operation
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonWriter} or {@link Menu} is {@code null}
     */
    @Override
    public void write(JsonWriter jsonWriter, Menu menu) throws IOException {
        MenuTypeAdapter.writeMenu(jsonWriter, menu);
    } //write

    /**
     * Deserializes a {@link Menu} object using the specified {@link JsonReader}.
     *
     * @param jsonReader the {@link JsonReader} to be used in the operation
     * @return the deserialized {@link Menu} object
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonReader} is {@code null}
     */
    @Override
    public Menu read(JsonReader jsonReader) throws IOException {
        return MenuTypeAdapter.readMenu(jsonReader);
    } //read
}