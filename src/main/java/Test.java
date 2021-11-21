import com.google.gson.*;
import com.zuppler4j.Availability;
import com.zuppler4j.Image;
import com.zuppler4j.TimeAvailability;
import com.zuppler4j.adapters.AvailabilityTypeAdapter;
import com.zuppler4j.adapters.ImageTypeAdapter;
import com.zuppler4j.adapters.TimeAvailabilityTypeAdapter;
import com.zuppler4j.adapters.menu.ItemModifierTypeAdapter;
import com.zuppler4j.adapters.menu.ItemOptionTypeAdapter;
import com.zuppler4j.menu.ItemModifier;
import com.zuppler4j.menu.ItemOption;

/**
 * A test class for the Zuppler4j API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 21, 2021
 */
public final class Test {
    /**
     * Runs the given tests.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson gson = gsonBuilder.registerTypeAdapter(Image.class, new ImageTypeAdapter())
                               .registerTypeAdapter(TimeAvailability.class, new TimeAvailabilityTypeAdapter())
                               .registerTypeAdapter(Availability.class, new AvailabilityTypeAdapter())
                               .registerTypeAdapter(ItemOption.class, new ItemOptionTypeAdapter())
                               .registerTypeAdapter(ItemModifier.class, new ItemModifierTypeAdapter())
                               .serializeNulls()
                               .create();

        String json = """
                      {
                          "custom": false,
                          "days": 0,
                          "priority": 1,
                          "services": 15,
                          "time": [
                              {
                                  "close": 0,
                                  "open": 0
                              },
                              {
                                  "close": 540,
                                  "open": 540
                              },
                              {
                                  "close": 540,
                                  "open": 540
                              },
                              {
                                  "close": 540,
                                  "open": 540
                              },
                              {
                                  "close": 540,
                                  "open": 540
                              },
                              {
                                  "close": 540,
                                  "open": 540
                              },
                              {
                                  "close": 540,
                                  "open": 540
                              },
                              {
                                  "close": null,
                                  "open": null
                              },
                              null
                          ]
                      }""";

        Availability availability = gson.fromJson(json, Availability.class);

        System.out.println(availability);

        System.out.println(gson.toJson(availability, Availability.class));
    } //main
}