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
import com.zuppler4j.menu.ItemOption;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import com.zuppler4j.Image;
import com.zuppler4j.adapters.ImageTypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

/**
 * A type adapter for the {@link ItemOption} class.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 27, 2021
 */
public final class ItemOptionTypeAdapter extends TypeAdapter<ItemOption> {
    /**
     * Constructs a new instance of the {@link ItemOptionTypeAdapter} class.
     */
    public ItemOptionTypeAdapter() {
    } //ItemOptionTypeAdapter
    
    /**
     * Serializes the specified {@link ItemOption} using the specified {@link JsonWriter}.
     *
     * @param jsonWriter the {@link JsonWriter} to be used in the operation
     * @param itemOption the {@link ItemOption} to be used in the operation
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonWriter} or {@link ItemOption} is {@code null}
     */
    public static void writeItemOption(JsonWriter jsonWriter, ItemOption itemOption) throws IOException {
        Objects.requireNonNull(jsonWriter, "the specified JsonWriter is null");

        Objects.requireNonNull(itemOption, "the specified ItemOption is null");

        jsonWriter.beginObject();

        jsonWriter.name("id");

        jsonWriter.value(itemOption.id());

        jsonWriter.name("name");

        jsonWriter.value(itemOption.name());

        jsonWriter.name("price");

        jsonWriter.value(itemOption.price());

        jsonWriter.name("active");

        jsonWriter.value(itemOption.active());

        jsonWriter.name("default");

        jsonWriter.value(itemOption.preselected());

        jsonWriter.name("description");

        jsonWriter.value(itemOption.description());

        jsonWriter.name("dishId");

        jsonWriter.value(itemOption.dishId());

        jsonWriter.name("group");

        jsonWriter.value(itemOption.group());

        jsonWriter.name("groupLabel");

        jsonWriter.value(itemOption.groupLabel());

        jsonWriter.name("image");

        Image image = itemOption.image();

        if (image == null) {
            jsonWriter.nullValue();
        } else {
            ImageTypeAdapter.writeImage(jsonWriter, itemOption.image());
        } //end if

        jsonWriter.name("pricedIn");

        jsonWriter.value(itemOption.pricedIn());

        jsonWriter.name("priority");

        jsonWriter.value(itemOption.priority());

        jsonWriter.name("weight");

        jsonWriter.value(itemOption.weight());

        jsonWriter.endObject();
    } //writeItemOption

    /**
     * Deserializes an {@link ItemOption} object using the specified {@link JsonReader}.
     *
     * @param jsonReader the {@link JsonReader} to be used in the operation
     * @return the deserialized {@link ItemOption} object
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonReader} is {@code null}
     */
    public static ItemOption readItemOption(JsonReader jsonReader) throws IOException {
        Objects.requireNonNull(jsonReader, "the specfied JsonReader is null");

        Integer id = null;

        String name = null;

        Double price = null;

        Boolean active = null;

        Boolean preselected = null;

        String description = null;

        Integer dishId = null;

        String group = null;

        String groupLabel = null;

        Image image = null;

        Boolean pricedIn = null;

        Integer priority = null;

        Integer weight = null;

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
                case "price" -> price = jsonReader.nextDouble();
                case "active" -> active = jsonReader.nextBoolean();
                case "default" -> preselected = jsonReader.nextBoolean();
                case "description" -> description = jsonReader.nextString();
                case "dishId" -> dishId = jsonReader.nextInt();
                case "group" -> group = jsonReader.nextString();
                case "groupLabel" -> groupLabel = jsonReader.nextString();
                case "image" -> image = ImageTypeAdapter.readImage(jsonReader);
                case "pricedIn" -> pricedIn = jsonReader.nextBoolean();
                case "priority" -> priority = jsonReader.nextInt();
                case "weight" -> weight = jsonReader.nextInt();
            } //end switch
        } //end while

        jsonReader.endObject();

        return new ItemOption(id, name, price, active, preselected, description, dishId, group, groupLabel, image,
                              pricedIn, priority, weight);
    } //readItemOption

    /**
     * Serializes the specified {@link ItemOption} using the specified {@link JsonWriter}.
     *
     * @param jsonWriter the {@link JsonWriter} to be used in the operation
     * @param itemOption the {@link ItemOption} to be used in the operation
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonWriter} or {@link ItemOption} is {@code null}
     */
    @Override
    public void write(JsonWriter jsonWriter, ItemOption itemOption) throws IOException {
        ItemOptionTypeAdapter.writeItemOption(jsonWriter, itemOption);
    } //write

    /**
     * Deserializes an {@link ItemOption} object using the specified {@link JsonReader}.
     *
     * @param jsonReader the {@link JsonReader} to be used in the operation
     * @return the deserialized {@link ItemOption} object
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonReader} is {@code null}
     */
    @Override
    public ItemOption read(JsonReader jsonReader) throws IOException {
        return ItemOptionTypeAdapter.readItemOption(jsonReader);
    } //read
}