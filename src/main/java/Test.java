import com.google.gson.*;
import com.zuppler4j.Availability;
import com.zuppler4j.Image;
import com.zuppler4j.TimeAvailability;
import com.zuppler4j.adapters.AvailabilityTypeAdapter;
import com.zuppler4j.adapters.ImageTypeAdapter;
import com.zuppler4j.adapters.TimeAvailabilityTypeAdapter;
import com.zuppler4j.adapters.menu.*;
import com.zuppler4j.menu.Category;
import com.zuppler4j.menu.Item;
import com.zuppler4j.menu.ItemModifier;
import com.zuppler4j.menu.ItemOption;

/**
 * A test class for the Zuppler4j API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 27, 2021
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
                               .registerTypeAdapter(Category.class, new CategoryTypeAdapter())
                               .serializeNulls()
                               .create();

        String json = """
                      {
                        "active": true,
                        "description": " *Only available Thursday 12/2  6pm-1am*",
                        "id": 201295,
                        "image": {
                          "active": false,
                          "medium": null,
                          "original": null,
                          "thumb": null,
                          "tiny": null,
                          "xlarge": null,
                          "xxlarge": null
                        },
                        "items": [
                          {
                            "active": true,
                            "coupon": false,
                            "couponCode": null,
                            "description": "Smoked Cajun Turkey Breast, sauteed kale, garlic mayo, provolone cheese with your choice of Hot or Mild Giardiniera.",
                            "dietaryPreferences": [],
                            "dishId": 3318450,
                            "featured": false,
                            "id": 1937878,
                            "image": {
                              "active": false,
                              "medium": null,
                              "original": null,
                              "thumb": null,
                              "tiny": null,
                              "xlarge": null,
                              "xxlarge": null
                            },
                            "maxPrice": 15.0,
                            "maxServingQty": 1.0,
                            "minPrice": 15.0,
                            "minQty": 0,
                            "minServingQty": 1.0,
                            "modifiersCount": 1001,
                            "multipleSizes": false,
                            "name": "Eleven I Eleven x JPG Smoked Cajun Turkey Sandwich",
                            "price": 15.0,
                            "priority": 0,
                            "resourceUrl": null,
                            "servingLabel": null,
                            "servingQty": 1.0,
                            "taxCategoryId": 1,
                            "upsell": false
                          },
                          {
                            "active": true,
                            "coupon": false,
                            "couponCode": null,
                            "description": "Please indicate size",
                            "dietaryPreferences": [],
                            "dishId": 21194287,
                            "featured": false,
                            "id": 3721357,
                            "image": {
                              "active": true,
                              "medium": "https://dbgcbnch6yz43.cloudfront.net/images/pictures/files/001/057/742/medium/97340947-0420-41C7-881A-F9880B28BD09.JPG",
                              "original": "https://dbgcbnch6yz43.cloudfront.net/images/pictures/files/001/057/742/original/97340947-0420-41C7-881A-F9880B28BD09.JPG",
                              "thumb": "https://dbgcbnch6yz43.cloudfront.net/images/pictures/files/001/057/742/thumb/97340947-0420-41C7-881A-F9880B28BD09.JPG",
                              "tiny": "https://dbgcbnch6yz43.cloudfront.net/images/pictures/files/001/057/742/tiny/97340947-0420-41C7-881A-F9880B28BD09.JPG",
                              "xlarge": "https://dbgcbnch6yz43.cloudfront.net/images/pictures/files/001/057/742/xlarge/97340947-0420-41C7-881A-F9880B28BD09.JPG",
                              "xxlarge": "https://dbgcbnch6yz43.cloudfront.net/images/pictures/files/001/057/742/xxlarge/97340947-0420-41C7-881A-F9880B28BD09.JPG"
                            },
                            "maxPrice": 35.0,
                            "maxServingQty": 1.0,
                            "minPrice": 35.0,
                            "minQty": 0,
                            "minServingQty": 1.0,
                            "modifiersCount": 1001,
                            "multipleSizes": false,
                            "name": "ElevenIEleven x JPG Shirt",
                            "price": 35.0,
                            "priority": 0,
                            "resourceUrl": null,
                            "servingLabel": null,
                            "servingQty": 1.0,
                            "taxCategoryId": null,
                            "upsell": false
                          }
                        ],
                        "minOrderQty": 0,
                        "name": "Eleven I Eleven x JPG Smoked Cajun Turkey Sandwich ",
                        "priority": 1,
                        "tags": null
                      }""";

        Category category = gson.fromJson(json, Category.class);

        System.out.println(category);

        System.out.println(gson.toJson(category, Category.class));
    } //main
}