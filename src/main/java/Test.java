import com.google.gson.*;
import com.zuppler4j.Availability;
import com.zuppler4j.Image;
import com.zuppler4j.TimeAvailability;
import com.zuppler4j.adapters.AvailabilityTypeAdapter;
import com.zuppler4j.adapters.ImageTypeAdapter;
import com.zuppler4j.adapters.TimeAvailabilityTypeAdapter;
import com.zuppler4j.adapters.menu.ItemOptionTypeAdapter;
import com.zuppler4j.menu.ItemOption;

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
        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson gson = gsonBuilder.registerTypeAdapter(Image.class, ImageTypeAdapter.create())
                               .registerTypeAdapter(TimeAvailability.class, TimeAvailabilityTypeAdapter.create())
                               .registerTypeAdapter(Availability.class, AvailabilityTypeAdapter.create())
                               .registerTypeAdapter(ItemOption.class, ItemOptionTypeAdapter.create())
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
                              }
                          ]
                      }""";

        Availability availability = gson.fromJson(json, Availability.class);

        System.out.println(availability);
    } //main
}