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
import com.zuppler4j.menu.ItemModifier;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.List;
import com.zuppler4j.menu.ItemOption;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.util.ArrayList;

/**
 * A type adapter for the {@link ItemModifier} class.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 27, 2021
 */
public final class ItemModifierTypeAdapter extends TypeAdapter<ItemModifier> {
    /**
     * Constructs an instance of the {@link ItemModifierTypeAdapter} class.
     */
    public ItemModifierTypeAdapter() {
    } //ItemModifierTypeAdapter

    /**
     * Serializes the specified {@link ItemModifier} using the specified {@link JsonWriter}.
     *
     * @param jsonWriter the {@link JsonWriter} to be used in the operation
     * @param itemModifier the {@link ItemModifier} to be used in the operation
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonWriter} or {@link ItemModifier} is {@code null}
     */
    public static void writeItemModifier(JsonWriter jsonWriter, ItemModifier itemModifier) throws IOException {
        Objects.requireNonNull(jsonWriter, "the specified JsonWriter is null");

        Objects.requireNonNull(itemModifier, "the specified ItemModifier is null");

        jsonWriter.beginObject();

        jsonWriter.name("id");

        jsonWriter.value(itemModifier.id());

        jsonWriter.name("name");

        jsonWriter.value(itemModifier.name());

        jsonWriter.name("description");

        jsonWriter.value(itemModifier.description());

        jsonWriter.name("options");

        List<ItemOption> options = itemModifier.options();

        if (options == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.beginArray();

            for (ItemOption itemOption : options) {
                if (itemOption == null) {
                    jsonWriter.nullValue();
                } else {
                    ItemOptionTypeAdapter.writeItemOption(jsonWriter, itemOption);
                } //end if
            } //end for

            jsonWriter.endArray();
        } //end if

        jsonWriter.name("active");

        jsonWriter.value(itemModifier.active());

        jsonWriter.name("allowGrouping");

        jsonWriter.value(itemModifier.allowGrouping());

        jsonWriter.name("dependsOn");

        List<String> dependsOn = itemModifier.dependsOn();

        if (dependsOn == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.beginArray();

            for (String dependency : dependsOn) {
                jsonWriter.value(dependency);
            } //end for

            jsonWriter.endArray();
        } //end if

        jsonWriter.endObject();
    } //writeItemModifier

    /**
     * Deserializes an {@link ItemModifier} object using the specified {@link JsonReader}.
     *
     * @param jsonReader the {@link JsonReader} to be used in the operation
     * @return the deserialized {@link ItemModifier} object
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonReader} is {@code null}
     */
    public static ItemModifier readItemModifier(JsonReader jsonReader) throws IOException {
        Objects.requireNonNull(jsonReader, "the specified JsonReader is null");

        Integer id = null;

        String name = null;

        String description = null;

        List<ItemOption> options = null;

        Boolean active = null;

        Boolean allowGrouping = null;

        List<String> dependsOn = null;

        Integer divider = null;

        Integer masterModifierId = null;

        Integer minSelections = null;

        Integer maxSelections = null;

        Boolean modifierQuantity = null;

        Boolean multipleModifiers = null;

        Boolean multipleSelections = null;

        Integer priority = null;

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
                case "options" -> {
                    options = new ArrayList<>();

                    jsonReader.beginArray();

                    while (jsonReader.hasNext()) {
                        ItemOption itemOption;

                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();

                            itemOption = null;
                        } else {
                            itemOption = ItemOptionTypeAdapter.readItemOption(jsonReader);
                        } //end if

                        options.add(itemOption);
                    } //end while

                    jsonReader.endArray();
                } //case "options"
                case "active" -> active = jsonReader.nextBoolean();
                case "allowGrouping" -> allowGrouping = jsonReader.nextBoolean();
                case "dependsOn" -> {
                    dependsOn = new ArrayList<>();

                    jsonReader.beginArray();

                    while (jsonReader.hasNext()) {
                        String dependency;

                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();

                            dependency = null;
                        } else {
                            dependency = jsonReader.nextString();
                        } //end if

                        dependsOn.add(dependency);
                    } //end while

                    jsonReader.endArray();
                } //case "dependsOn"
                case "divider" -> divider = jsonReader.nextInt();
                case "masterModifierId" -> masterModifierId = jsonReader.nextInt();
                case "minSelections" -> minSelections = jsonReader.nextInt();
                case "maxSelections" -> maxSelections = jsonReader.nextInt();
                case "modifierQuantity" -> modifierQuantity = jsonReader.nextBoolean();
                case "multipleModifiers" -> multipleModifiers = jsonReader.nextBoolean();
                case "multipleSelections" -> multipleSelections = jsonReader.nextBoolean();
                case "priority" -> priority = jsonReader.nextInt();
            } //end switch
        } //end while

        jsonReader.endObject();

        return new ItemModifier(id, name, description, options, active, allowGrouping, dependsOn, divider,
                                masterModifierId, minSelections, maxSelections, modifierQuantity, multipleModifiers,
                                multipleSelections, priority);
    } //readItemModifier

    /**
     * Serializes the specified {@link ItemModifier} using the specified {@link JsonWriter}.
     *
     * @param jsonWriter the {@link JsonWriter} to be used in the operation
     * @param itemModifier the {@link ItemModifier} to be used in the operation
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonWriter} or {@link ItemModifier} is {@code null}
     */
    @Override
    public void write(JsonWriter jsonWriter, ItemModifier itemModifier) throws IOException {
        ItemModifierTypeAdapter.writeItemModifier(jsonWriter, itemModifier);
    } //write

    /**
     * Deserializes an {@link ItemModifier} object using the specified {@link JsonReader}.
     *
     * @param jsonReader the {@link JsonReader} to be used in the operation
     * @return the deserialized {@link ItemModifier} object
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonReader} is {@code null}
     */
    @Override
    public ItemModifier read(JsonReader jsonReader) throws IOException {
        return ItemModifierTypeAdapter.readItemModifier(jsonReader);
    } //read
}