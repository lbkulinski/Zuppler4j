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

package com.zuppler4j.adapters;

import com.google.gson.TypeAdapter;
import com.zuppler4j.Image;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

/**
 * A type adapter for the {@link Image} class.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 22, 2021
 */
public final class ImageTypeAdapter extends TypeAdapter<Image> {
    /**
     * Constructs an instance of the {@link ImageTypeAdapter} class.
     */
    public ImageTypeAdapter() {
    } //ImageTypeAdapter

    /**
     * Serializes the specified {@link Image} using the specified {@link JsonWriter}.
     *
     * @param jsonWriter the {@link JsonWriter} to be used in the operation
     * @param image the {@link Image} to be used in the operation
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonWriter} or {@link Image} is {@code null}
     */
    public static void writeImage(JsonWriter jsonWriter, Image image) throws IOException {
        Objects.requireNonNull(jsonWriter, "the specified JsonWriter is null");

        Objects.requireNonNull(image, "the specified Image is null");

        jsonWriter.beginObject();

        jsonWriter.name("active");

        jsonWriter.value(image.active());

        jsonWriter.name("medium");

        jsonWriter.value(image.medium());

        jsonWriter.name("original");

        jsonWriter.value(image.original());

        jsonWriter.name("thumb");

        jsonWriter.value(image.thumb());

        jsonWriter.name("tiny");

        jsonWriter.value(image.tiny());

        jsonWriter.name("xlarge");

        jsonWriter.value(image.xlarge());

        jsonWriter.name("xxlarge");

        jsonWriter.value(image.xxlarge());

        jsonWriter.endObject();
    } //writeImage

    /**
     * Deserializes an {@link Image} object using the specified {@link JsonReader}.
     *
     * @param jsonReader the {@link JsonReader} to be used in the operation
     * @return the deserialized {@link Image} object
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonReader} is {@code null}
     */
    public static Image readImage(JsonReader jsonReader) throws IOException {
        Objects.requireNonNull(jsonReader, "the specified JsonReader is null");

        Boolean active = null;

        String medium = null;

        String original = null;

        String thumb = null;

        String tiny = null;

        String xlarge = null;

        String xxlarge = null;

        jsonReader.beginObject();

        while (jsonReader.hasNext()) {
            String keyName = jsonReader.nextName();

            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();

                continue;
            } //end if

            switch (keyName) {
                case "active" -> active = jsonReader.nextBoolean();
                case "medium" -> medium = jsonReader.nextString();
                case "original" -> original = jsonReader.nextString();
                case "thumb" -> thumb = jsonReader.nextString();
                case "tiny" -> tiny = jsonReader.nextString();
                case "xlarge" -> xlarge = jsonReader.nextString();
                case "xxlarge" -> xxlarge = jsonReader.nextString();
            } //end switch
        } //end while

        jsonReader.endObject();

        return new Image(active, medium, original, thumb, tiny, xlarge, xxlarge);
    } //readImage

    /**
     * Serializes the specified {@link Image} using the specified {@link JsonWriter}.
     *
     * @param jsonWriter the {@link JsonWriter} to be used in the operation
     * @param image the {@link Image} to be used in the operation
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonWriter} or {@link Image} is {@code null}
     */
    @Override
    public void write(JsonWriter jsonWriter, Image image) throws IOException {
        ImageTypeAdapter.writeImage(jsonWriter, image);
    } //write

    /**
     * Deserializes an {@link Image} object using the specified {@link JsonReader}.
     *
     * @param jsonReader the {@link JsonReader} to be used in the operation
     * @return the deserialized {@link Image} object
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonReader} is {@code null}
     */
    @Override
    public Image read(JsonReader jsonReader) throws IOException {
        return ImageTypeAdapter.readImage(jsonReader);
    } //read
}