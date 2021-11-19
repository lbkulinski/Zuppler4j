import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.zuppler4j.Image;

import java.io.IOException;
import java.lang.reflect.Type;

public final class ImageTypeAdapter extends TypeAdapter<Image> {
    @Override
    public void write(JsonWriter jsonWriter, Image image) throws IOException {
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
    } //write

    @Override
    public Image read(JsonReader jsonReader) throws IOException {
        Boolean active = null;

        String medium = null;

        String original = null;

        String thumb = null;

        String tiny = null;

        String xlarge = null;

        String xxlarge = null;

        jsonReader.beginObject();

        while (jsonReader.hasNext()) {
            String name = jsonReader.nextName();

            JsonToken token = jsonReader.peek();

            if (token == JsonToken.NULL) {
                jsonReader.nextNull();

                continue;
            } //end if

            switch (name) {
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
    } //read

    public static void main(String[] args) {
        TypeToken<Image> imageTypeToken = new TypeToken<>() {};

        Type imageType = imageTypeToken.getType();

        ImageTypeAdapter imageTypeAdapter = new ImageTypeAdapter();

        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson gson = gsonBuilder.registerTypeAdapter(imageType, imageTypeAdapter)
                               .serializeNulls()
                               .create();

        String json = """
                      {
                          "active": false,
                          "medium": "test",
                          "original": null,
                          "thumb": null,
                          "tiny": null,
                          "xlarge": null,
                          "xxlarge": null
                      }""";

        Image image = gson.fromJson(json, imageType);

        System.out.println(image);

        System.out.println(gson.toJson(image));
    }
}