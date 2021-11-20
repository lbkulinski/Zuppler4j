import com.google.gson.*;
import com.zuppler4j.Availability;
import com.zuppler4j.Image;
import com.zuppler4j.TimeAvailability;
import com.zuppler4j.adapters.AvailabilityAdapter;
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

        AvailabilityAdapter availabilityAdapter = new AvailabilityAdapter();

        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson gson = gsonBuilder.registerTypeAdapter(Image.class, imageTypeAdapter)
                               .registerTypeAdapter(TimeAvailability.class, timeAvailabilityAdapter)
                               .registerTypeAdapter(Availability.class, availabilityAdapter)
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