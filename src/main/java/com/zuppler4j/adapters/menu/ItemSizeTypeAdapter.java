package com.zuppler4j.adapters.menu;

import com.google.gson.TypeAdapter;
import com.zuppler4j.menu.ItemSize;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.List;
import com.zuppler4j.menu.ItemModifier;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.util.ArrayList;

/**
 * A type adapter for the {@link ItemSize} class.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 22, 2021
 */
public final class ItemSizeTypeAdapter extends TypeAdapter<ItemSize> {
    /**
     * Constructs an instance of the {@link ItemSizeTypeAdapter} class.
     */
    public ItemSizeTypeAdapter() {
    } //ItemSizeTypeAdapter

    /**
     * Serializes the specified {@link ItemSize} using the specified {@link JsonWriter}.
     *
     * @param jsonWriter the {@link JsonWriter} to be used in the operation
     * @param itemSize the {@link ItemSize} to be used in the operation
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonWriter} or {@link ItemSize} is {@code null}
     */
    public static void writeItemSize(JsonWriter jsonWriter, ItemSize itemSize) throws IOException {
        Objects.requireNonNull(jsonWriter, "the specified JsonWriter is null");

        Objects.requireNonNull(itemSize, "the specified ItemSize is null");

        jsonWriter.beginObject();

        jsonWriter.name("id");

        jsonWriter.value(itemSize.id());

        jsonWriter.name("price");

        jsonWriter.value(itemSize.price());

        jsonWriter.name("sizeId");

        jsonWriter.value(itemSize.sizeId());

        jsonWriter.name("sizeName");

        jsonWriter.value(itemSize.sizeName());

        jsonWriter.name("modifiers");

        List<ItemModifier> modifiers = itemSize.modifiers();

        if (modifiers == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.beginArray();

            for (ItemModifier itemModifier : modifiers) {
                if (itemModifier == null) {
                    jsonWriter.nullValue();
                } else {
                    ItemModifierTypeAdapter.writeItemModifier(jsonWriter, itemModifier);
                } //end if
            } //end for

            jsonWriter.endArray();
        } //end if

        jsonWriter.name("active");

        jsonWriter.value(itemSize.active());

        jsonWriter.name("coupon");

        jsonWriter.value(itemSize.coupon());

        jsonWriter.name("minQty");

        jsonWriter.value(itemSize.minQty());

        jsonWriter.name("priority");

        jsonWriter.value(itemSize.priority());

        jsonWriter.name("servingLabel");

        jsonWriter.value(itemSize.servingLabel());

        jsonWriter.name("servingQty");

        jsonWriter.value(itemSize.servingQty());

        jsonWriter.endObject();
    } //writeItemSize

    /**
     * Deserializes an {@link ItemSize} object using the specified {@link JsonReader}.
     *
     * @param jsonReader the {@link JsonReader} to be used in the operation
     * @return the deserialized {@link ItemSize} object
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonReader} is {@code null}
     */
    public static ItemSize readItemSize(JsonReader jsonReader) throws IOException {
        Objects.requireNonNull(jsonReader, "the specified JsonReader is null");

        Integer id = null;

        Double price = null;

        Integer sizeId = null;

        String sizeName = null;

        List<ItemModifier> modifiers = null;

        Boolean active = null;

        Boolean coupon = null;

        Integer minQty = null;

        Integer priority = null;

        String servingLabel = null;

        Integer servingQty = null;

        jsonReader.beginObject();

        while (jsonReader.hasNext()) {
            String keyName = jsonReader.nextName();

            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();

                continue;
            } //end if

            switch (keyName) {
                case "id" -> id = jsonReader.nextInt();
                case "price" -> price = jsonReader.nextDouble();
                case "sizeId" -> sizeId = jsonReader.nextInt();
                case "sizeName" -> sizeName = jsonReader.nextString();
                case "modifiers" -> {
                    modifiers = new ArrayList<>();

                    jsonReader.beginArray();

                    while (jsonReader.hasNext()) {
                        ItemModifier itemModifier;

                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();

                            itemModifier = null;
                        } else {
                            itemModifier = ItemModifierTypeAdapter.readItemModifier(jsonReader);
                        } //end if

                        modifiers.add(itemModifier);
                    } //end while

                    jsonReader.endArray();
                } //case "modifiers"
                case "active" -> active = jsonReader.nextBoolean();
                case "coupon" -> coupon = jsonReader.nextBoolean();
                case "minQty" -> minQty = jsonReader.nextInt();
                case "priority" -> priority = jsonReader.nextInt();
                case "servingLabel" -> servingLabel = jsonReader.nextString();
                case "servingQty" -> servingQty = jsonReader.nextInt();
            } //end switch
        } //end while

        jsonReader.endObject();

        return new ItemSize(id, price, sizeId, sizeName, modifiers, active, coupon, minQty, priority, servingLabel,
                            servingQty);
    } //readItemSize

    /**
     * Serializes the specified {@link ItemSize} using the specified {@link JsonWriter}.
     *
     * @param jsonWriter the {@link JsonWriter} to be used in the operation
     * @param itemSize the {@link ItemSize} to be used in the operation
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonWriter} or {@link ItemSize} is {@code null}
     */
    @Override
    public void write(JsonWriter jsonWriter, ItemSize itemSize) throws IOException {
        ItemSizeTypeAdapter.writeItemSize(jsonWriter, itemSize);
    } //write

    /**
     * Deserializes an {@link ItemSize} object using the specified {@link JsonReader}.
     *
     * @param jsonReader the {@link JsonReader} to be used in the operation
     * @return the deserialized {@link ItemSize} object
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonReader} is {@code null}
     */
    @Override
    public ItemSize read(JsonReader jsonReader) throws IOException {
        return ItemSizeTypeAdapter.readItemSize(jsonReader);
    } //read
}