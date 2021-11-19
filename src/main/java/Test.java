import com.google.gson.*;
import com.zuppler4j.Image;
import com.zuppler4j.TimeAvailability;
import com.zuppler4j.adapters.ImageTypeAdapter;
import com.zuppler4j.adapters.TimeAvailabilityAdapter;

/**
 * A test class for the Zuppler4j API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 19, 2021
 */
public final class Test {
    /**
     * Runs the given tests.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ImageTypeAdapter imageTypeAdapter = new ImageTypeAdapter();

        TimeAvailabilityAdapter timeAvailabilityAdapter = new TimeAvailabilityAdapter();

        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson gson = gsonBuilder.registerTypeAdapter(Image.class, imageTypeAdapter)
                               .registerTypeAdapter(TimeAvailability.class, timeAvailabilityAdapter)
                               .serializeNulls()
                               .create();

        String json = """
                      [
                          {
                              "active": false,
                              "medium": null,
                              "original": null,
                              "thumb": null,
                              "tiny": null,
                              "xlarge": null,
                              "xxlarge": null
                          },
                          {
                              "open": 1,
                              "close": 2
                          }
                      ]""";

        JsonElement jsonElement = gson.fromJson(json, JsonArray.class);

        System.out.println(jsonElement.toString());
    } //main
}