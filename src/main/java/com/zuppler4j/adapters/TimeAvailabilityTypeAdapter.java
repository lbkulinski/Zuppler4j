package com.zuppler4j.adapters;

import com.google.gson.TypeAdapter;
import com.zuppler4j.TimeAvailability;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

/**
 * A type adapter for the {@link TimeAvailability} class.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 22, 2021
 */
public final class TimeAvailabilityTypeAdapter extends TypeAdapter<TimeAvailability> {
    /**
     * Constructs an instance of the {@link TimeAvailabilityTypeAdapter} class.
     */
    public TimeAvailabilityTypeAdapter() {
    } //TimeAvailabilityTypeAdapter

    /**
     * Serializes the specified {@link TimeAvailability} using the specified {@link JsonWriter}.
     *
     * @param jsonWriter the {@link JsonWriter} to be used in the operation
     * @param timeAvailability the {@link TimeAvailability} to be used in the operation
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonWriter} or {@link TimeAvailability} is {@code null}
     */
    public static void writeTimeAvailability(JsonWriter jsonWriter,
                                             TimeAvailability timeAvailability) throws IOException {
        Objects.requireNonNull(jsonWriter, "the specified JsonWriter is null");

        Objects.requireNonNull(timeAvailability, "the specified TimeAvailability is null");

        jsonWriter.beginObject();

        jsonWriter.name("open");

        jsonWriter.value(timeAvailability.open());

        jsonWriter.name("close");

        jsonWriter.value(timeAvailability.close());

        jsonWriter.endObject();
    } //writeTimeAvailability

    /**
     * Deserializes an {@link TimeAvailability} object using the specified {@link JsonReader}.
     *
     * @param jsonReader the {@link JsonReader} to be used in the operation
     * @return the deserialized {@link TimeAvailability} object
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonReader} is {@code null}
     */
    public static TimeAvailability readTimeAvailability(JsonReader jsonReader) throws IOException {
        Objects.requireNonNull(jsonReader, "the specified JsonReader is null");

        Integer open = null;

        Integer close = null;

        jsonReader.beginObject();

        while (jsonReader.hasNext()) {
            String keyName = jsonReader.nextName();

            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();

                continue;
            } //end if

            switch (keyName) {
                case "open" -> open = jsonReader.nextInt();
                case "close" -> close = jsonReader.nextInt();
            } //end switch
        } //end while

        jsonReader.endObject();

        return new TimeAvailability(open, close);
    } //readTimeAvailability

    /**
     * Serializes the specified {@link TimeAvailability} using the specified {@link JsonWriter}.
     *
     * @param jsonWriter the {@link JsonWriter} to be used in the operation
     * @param timeAvailability the {@link TimeAvailability} to be used in the operation
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonWriter} or {@link TimeAvailability} is {@code null}
     */
    @Override
    public void write(JsonWriter jsonWriter, TimeAvailability timeAvailability) throws IOException {
        TimeAvailabilityTypeAdapter.writeTimeAvailability(jsonWriter, timeAvailability);
    } //write

    /**
     * Deserializes an {@link TimeAvailability} object using the specified {@link JsonReader}.
     *
     * @param jsonReader the {@link JsonReader} to be used in the operation
     * @return the deserialized {@link TimeAvailability} object
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonReader} is {@code null}
     */
    @Override
    public TimeAvailability read(JsonReader jsonReader) throws IOException {
        return TimeAvailabilityTypeAdapter.readTimeAvailability(jsonReader);
    } //read
}