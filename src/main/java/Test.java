import com.google.gson.*;
import com.zuppler4j.Availability;
import com.zuppler4j.Image;
import com.zuppler4j.TimeAvailability;
import com.zuppler4j.adapters.AvailabilityTypeAdapter;
import com.zuppler4j.adapters.ImageTypeAdapter;
import com.zuppler4j.adapters.TimeAvailabilityTypeAdapter;
import com.zuppler4j.adapters.menu.ItemModifierTypeAdapter;
import com.zuppler4j.adapters.menu.ItemOptionTypeAdapter;
import com.zuppler4j.adapters.menu.ItemSizeTypeAdapter;
import com.zuppler4j.adapters.menu.ItemTypeAdapter;
import com.zuppler4j.menu.Item;
import com.zuppler4j.menu.ItemModifier;
import com.zuppler4j.menu.ItemOption;

/**
 * A test class for the Zuppler4j API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 22, 2021
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
                               .registerTypeAdapter(ItemModifier.class, new ItemSizeTypeAdapter())
                               .registerTypeAdapter(Item.class, new ItemTypeAdapter())
                               .serializeNulls()
                               .create();

        String json = """
                      {
                          "active": true,
                          "coupon": false,
                          "couponCode": null,
                          "description": "house speciality; sharp imported provolone, hot sopresatta, prosciutto di parma, volpi genoa salami, JPG truffle mustard balsamic vinaigrette, hot oil, marinated roman style artichokes, fresh basil, lettuce with red wine vinegar and oregano",
                          "dietaryPreferences": [],
                          "dishId": 719678,
                          "featured": false,
                          "id": 774516,
                          "image": {
                              "active": false,
                              "medium": null,
                              "original": null,
                              "thumb": null,
                              "tiny": null,
                              "xlarge": null,
                              "xxlarge": null
                          },
                          "maxPrice": 12.0,
                          "maxServingQty": 1.0,
                          "minPrice": 12.0,
                          "minQty": 0,
                          "minServingQty": 1.0,
                          "modifiersCount": 6,
                          "multipleSizes": false,
                          "name": "Mr. G",
                          "price": 12.0,
                          "priority": 0,
                          "resourceUrl": null,
                          "servingLabel": null,
                          "servingQty": 1.0,
                          "taxCategoryId": 1,
                          "upsell": false
                      }""";

        Item item = gson.fromJson(json, Item.class);

        System.out.println(item);

        System.out.println(gson.toJson(item, Item.class));
    } //main
}