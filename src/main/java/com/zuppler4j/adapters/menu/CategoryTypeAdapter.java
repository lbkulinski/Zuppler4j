package com.zuppler4j.adapters.menu;

import com.google.gson.TypeAdapter;
import com.zuppler4j.menu.Category;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.List;
import com.zuppler4j.menu.Item;
import com.zuppler4j.Image;
import com.zuppler4j.adapters.ImageTypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.util.ArrayList;

/**
 * A type adapter for the {@link Category} class.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 27, 2021
 */
public final class CategoryTypeAdapter extends TypeAdapter<Category> {
    /**
     * Constructs an instance of the {@link CategoryTypeAdapter} class.
     */
    public CategoryTypeAdapter() {
    } //CategoryTypeAdapter

    public static void writeCategory(JsonWriter jsonWriter, Category category) throws IOException {
        Objects.requireNonNull(jsonWriter, "the specified JsonWriter is null");

        Objects.requireNonNull(category, "the specified Category is null");

        jsonWriter.beginObject();

        jsonWriter.name("id");

        jsonWriter.value(category.id());

        jsonWriter.name("name");

        jsonWriter.value(category.name());

        jsonWriter.name("description");

        jsonWriter.value(category.description());

        jsonWriter.name("items");

        List<Item> items = category.items();

        if (items == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.beginArray();

            for (Item item : items) {
                if (item == null) {
                    jsonWriter.nullValue();
                } else {
                    ItemTypeAdapter.writeItem(jsonWriter, item);
                } //end if
            } //end for

            jsonWriter.endArray();
        } //end if

        jsonWriter.name("active");

        jsonWriter.value(category.active());

        jsonWriter.name("image");

        Image image = category.image();

        if (image == null) {
            jsonWriter.nullValue();
        } else {
            ImageTypeAdapter.writeImage(jsonWriter, image);
        } //end if

        jsonWriter.name("minOrderQty");

        jsonWriter.value(category.minOrderQty());

        jsonWriter.name("priority");

        jsonWriter.value(category.priority());

        jsonWriter.name("tags");

        List<String> tags = category.tags();

        if (tags == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.beginArray();

            for (String tag : tags) {
                jsonWriter.value(tag);
            } //end for

            jsonWriter.endArray();
        } //end if

        jsonWriter.endObject();
    } //writeCategory

    public static Category readCategory(JsonReader jsonReader) throws IOException {
        Integer id = null;

        String name = null;

        String description = null;

        List<Item> items = null;

        Boolean active = null;

        Image image = null;

        Integer minOrderQty = null;

        Integer priority = null;

        List<String> tags = null;

        jsonReader.beginObject();

        while (jsonReader.hasNext()) {
            String keyName = jsonReader.nextName();

            if (jsonReader.peek() == JsonToken.NULL) {
                continue;
            } //end if

            switch (keyName) {
                case "id" -> id = jsonReader.nextInt();
                case "name" -> name = jsonReader.nextString();
                case "description" -> description = jsonReader.nextString();
                case "items" -> {
                    items = new ArrayList<>();

                    jsonReader.beginArray();

                    while (jsonReader.hasNext()) {
                        Item item;

                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();

                            item = null;
                        } else {
                            item = ItemTypeAdapter.readItem(jsonReader);
                        } //end if

                        items.add(item);
                    } //end while

                    jsonReader.endArray();
                } //case "items"
                case "active" -> active = jsonReader.nextBoolean();
                case "image" -> image = ImageTypeAdapter.readImage(jsonReader);
                case "minOrderQty" -> minOrderQty = jsonReader.nextInt();
                case "priority" -> priority = jsonReader.nextInt();
                case "tags" -> {
                    tags = new ArrayList<>();

                    jsonReader.beginArray();

                    while (jsonReader.hasNext()) {
                        String tag;

                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();

                            tag = null;
                        } else {
                            tag = jsonReader.nextString();
                        } //end if

                        tags.add(tag);
                    } //end while

                    jsonReader.endArray();
                } //case "tags"
            } //end switch
        } //end while

        jsonReader.endObject();

        return new Category(id, name, description, items, active, image, minOrderQty, priority, tags);
    } //readCategory

    @Override
    public void write(JsonWriter jsonWriter, Category category) throws IOException {
        CategoryTypeAdapter.writeCategory(jsonWriter, category);
    } //write

    @Override
    public Category read(JsonReader jsonReader) throws IOException {
        return CategoryTypeAdapter.readCategory(jsonReader);
    } //read
}