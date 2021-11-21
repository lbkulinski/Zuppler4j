package com.zuppler4j.adapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonToken;
import com.zuppler4j.Availability;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import com.google.gson.stream.JsonReader;
import com.zuppler4j.TimeAvailability;
import java.util.List;
import java.util.ArrayList;

/**
 * A type adapter for the {@link Availability} class.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 21, 2021
 */
public final class AvailabilityTypeAdapter extends TypeAdapter<Availability> {
    /**
     * Constructs an instance of the {@link AvailabilityTypeAdapter} class.
     */
    public AvailabilityTypeAdapter() {
    } //AvailabilityTypeAdapter

    /**
     * Serializes the specified {@link Availability} using the specified {@link JsonWriter}.
     *
     * @param jsonWriter the {@link JsonWriter} to be used in the operation
     * @param availability the {@link Availability} to be used in the operation
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonWriter} or {@link Availability} is {@code null}
     */
    public static void writeAvailability(JsonWriter jsonWriter, Availability availability) throws IOException {
        Objects.requireNonNull(jsonWriter, "the specified JsonWriter is null");

        Objects.requireNonNull(availability, "the specified Availability is null");

        jsonWriter.beginObject();

        jsonWriter.name("custom");

        jsonWriter.value(availability.custom());

        jsonWriter.name("days");

        jsonWriter.value(availability.days());

        jsonWriter.name("priority");

        jsonWriter.value(availability.priority());

        jsonWriter.name("services");

        jsonWriter.value(availability.services());

        jsonWriter.name("time");

        jsonWriter.beginArray();

        for (TimeAvailability timeAvailability : availability.time()) {
            if (timeAvailability == null) {
                jsonWriter.nullValue();
            } else {
                TimeAvailabilityTypeAdapter.writeTimeAvailability(jsonWriter, timeAvailability);
            } //end if
        } //end for

        jsonWriter.endArray();

        jsonWriter.endObject();
    } //writeAvailability

    /**
     * Deserializes an {@link Availability} object using the specified {@link JsonReader}.
     *
     * @param jsonReader the {@link JsonReader} to be used in the operation
     * @return the deserialized {@link Availability} object
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonReader} is {@code null}
     */
    public static Availability readAvailability(JsonReader jsonReader) throws IOException {
        Objects.requireNonNull(jsonReader, "the specified JsonReader is null");

        Boolean custom = null;

        Integer days = null;

        Integer priority = null;

        Integer services = null;

        List<TimeAvailability> time = null;

        jsonReader.beginObject();

        while (jsonReader.hasNext()) {
            String name = jsonReader.nextName();

            JsonToken token = jsonReader.peek();

            if (token == JsonToken.NULL) {
                jsonReader.nextNull();

                continue;
            } //end if

            switch (name) {
                case "custom" -> custom = jsonReader.nextBoolean();
                case "days" -> days = jsonReader.nextInt();
                case "priority" -> priority = jsonReader.nextInt();
                case "services" -> services = jsonReader.nextInt();
                case "time" -> {
                    time = new ArrayList<>();

                    jsonReader.beginArray();

                    while (jsonReader.hasNext()) {
                        token = jsonReader.peek();

                        TimeAvailability timeAvailability;

                        if (token == JsonToken.NULL) {
                            jsonReader.nextNull();

                            timeAvailability = null;
                        } else {
                            timeAvailability = TimeAvailabilityTypeAdapter.readTimeAvailability(jsonReader);
                        } //end if

                        time.add(timeAvailability);
                    } //end while

                    jsonReader.endArray();
                } //case "time"
            } //end switch
        } //end while

        jsonReader.endObject();

        return new Availability(custom, days, priority, services, time);
    } //readAvailability

    /**
     * Serializes the specified {@link Availability} using the specified {@link JsonWriter}.
     *
     * @param jsonWriter the {@link JsonWriter} to be used in the operation
     * @param availability the {@link Availability} to be used in the operation
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonWriter} or {@link Availability} is {@code null}
     */
    @Override
    public void write(JsonWriter jsonWriter, Availability availability) throws IOException {
        AvailabilityTypeAdapter.writeAvailability(jsonWriter, availability);
    } //write

    /**
     * Deserializes an {@link Availability} object using the specified {@link JsonReader}.
     *
     * @param jsonReader the {@link JsonReader} to be used in the operation
     * @return the deserialized {@link Availability} object
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if the specified {@link JsonReader} is {@code null}
     */
    @Override
    public Availability read(JsonReader jsonReader) throws IOException {
        return AvailabilityTypeAdapter.readAvailability(jsonReader);
    } //read
}