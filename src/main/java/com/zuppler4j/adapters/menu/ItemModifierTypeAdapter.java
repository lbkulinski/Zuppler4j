package com.zuppler4j.adapters.menu;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonToken;
import com.zuppler4j.menu.ItemModifier;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;

import com.google.gson.stream.JsonReader;
import com.zuppler4j.menu.ItemOption;
import java.util.List;

/**
 * A type adapter for the {@link ItemModifier} class.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 21, 2021
 */
public final class ItemModifierTypeAdapter extends TypeAdapter<ItemModifier> {
    /**
     * Constructs an instance of the {@link ItemModifierTypeAdapter} class.
     */
    public ItemModifierTypeAdapter() {
    } //ItemModifierTypeAdapter

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

        jsonWriter.beginArray();

        for (ItemOption itemOption : itemModifier.options()) {
            if (itemOption == null) {
                jsonWriter.nullValue();
            } else {
                ItemOptionTypeAdapter.writeItemOption(jsonWriter, itemOption);
            } //end if
        } //end for

        jsonWriter.endArray();

        jsonWriter.name("active");

        jsonWriter.value(itemModifier.active());

        jsonWriter.name("allowGrouping");

        jsonWriter.value(itemModifier.allowGrouping());

        jsonWriter.name("dependsOn");

        jsonWriter.beginArray();

        for (String dependency : itemModifier.dependsOn()) {
            jsonWriter.value(dependency);
        } //end for

        jsonWriter.endArray();

        jsonWriter.endObject();
    } //writeItemModifier

    public ItemModifier readItemModifier(JsonReader jsonReader) throws IOException {
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

            JsonToken token = jsonReader.peek();

            if (token == JsonToken.NULL) {
                jsonReader.nextNull();

                continue;
            } //end if

            switch (keyName) {
                case "id" -> id = jsonReader.nextInt();
                case "name" -> name = jsonReader.nextString();
                case "description" -> description = jsonReader.nextString();
                case "options" -> {
                    jsonReader.beginArray();

                    jsonReader.endArray();
                }
            } //end switch
        } //end while

        jsonReader.endObject();

        return null;
    } //readItemModifier

    @Override
    public void write(JsonWriter jsonWriter, ItemModifier itemModifier) throws IOException {
        ItemModifierTypeAdapter.writeItemModifier(jsonWriter, itemModifier);
    } //write

    @Override
    public ItemModifier read(JsonReader jsonReader) throws IOException {
        return null;
    } //read
}