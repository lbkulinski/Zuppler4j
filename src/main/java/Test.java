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
                        "id": 83768,
                        "name": "Sandwiches",
                        "description": "We also offer any of our Sandwiches without bread and option to be served on a bed of lettuce or arugula. Try the Artichoke, Caprese or Tuna for a delicious and unique Salad.",
                        "items": [
                          {
                            "id": 774516,
                            "name": "Mr. G",
                            "description": "house speciality; sharp imported provolone, hot sopresatta, prosciutto di parma, volpi genoa salami, JPG truffle mustard balsamic vinaigrette, hot oil, marinated roman style artichokes, fresh basil, lettuce with red wine vinegar and oregano",
                            "price": 12.0,
                            "active": true,
                            "coupon": false,
                            "couponCode": null,
                            "dietaryPreferences": [],
                            "dishId": 719678,
                            "featured": false,
                            "image": {
                              "active": false,
                              "medium": null,
                              "original": null,
                              "thumb": null,
                              "tiny": null,
                              "xlarge": null,
                              "xxlarge": null
                            },
                            "minPrice": 12.0,
                            "maxPrice": 12.0,
                            "minServingQty": 1.0,
                            "maxServingQty": 1.0,
                            "minQty": 0,
                            "modifiersCount": 6,
                            "multipleSizes": false,
                            "priority": 0,
                            "resourceUrl": null,
                            "servingLabel": null,
                            "servingQty": 1.0,
                            "taxCategoryId": 1,
                            "upsell": false
                          },
                          {
                            "id": 1320260,
                            "name": "Turkey",
                            "description": "Braised Turkey breast, provolone, mayo, lettuce, tomato and roasted red peppers",
                            "price": 10.0,
                            "active": true,
                            "coupon": false,
                            "couponCode": null,
                            "dietaryPreferences": [],
                            "dishId": 719738,
                            "featured": false,
                            "image": {
                              "active": false,
                              "medium": null,
                              "original": null,
                              "thumb": null,
                              "tiny": null,
                              "xlarge": null,
                              "xxlarge": null
                            },
                            "minPrice": 10.0,
                            "maxPrice": 10.0,
                            "minServingQty": 1.0,
                            "maxServingQty": 1.0,
                            "minQty": 0,
                            "modifiersCount": 6,
                            "multipleSizes": false,
                            "priority": 0,
                            "resourceUrl": null,
                            "servingLabel": null,
                            "servingQty": 1.0,
                            "taxCategoryId": 1,
                            "upsell": false
                          },
                          {
                            "id": 774517,
                            "name": "Italian",
                            "description": "hot capicola, volpi genoa salami, hard salami, mortadella, provolone, tomato and lettuce with red wine vinegar and oregano",
                            "price": 10.0,
                            "active": true,
                            "coupon": false,
                            "couponCode": null,
                            "dietaryPreferences": [],
                            "dishId": 719679,
                            "featured": false,
                            "image": {
                              "active": false,
                              "medium": null,
                              "original": null,
                              "thumb": null,
                              "tiny": null,
                              "xlarge": null,
                              "xxlarge": null
                            },
                            "minPrice": 10.0,
                            "maxPrice": 10.0,
                            "minServingQty": 1.0,
                            "maxServingQty": 1.0,
                            "minQty": 0,
                            "modifiersCount": 6,
                            "multipleSizes": false,
                            "priority": 0,
                            "resourceUrl": null,
                            "servingLabel": null,
                            "servingQty": 1.0,
                            "taxCategoryId": 1,
                            "upsell": false
                          },
                          {
                            "id": 774521,
                            "name": "Roast Beef",
                            "description": "Roast Beef, mayo, arugula and hot giardiniera served on Publican Quality Ciabatta \\n",
                            "price": 12.0,
                            "active": true,
                            "coupon": false,
                            "couponCode": null,
                            "dietaryPreferences": [],
                            "dishId": 719683,
                            "featured": false,
                            "image": {
                              "active": false,
                              "medium": null,
                              "original": null,
                              "thumb": null,
                              "tiny": null,
                              "xlarge": null,
                              "xxlarge": null
                            },
                            "minPrice": 12.0,
                            "maxPrice": 12.0,
                            "minServingQty": 1.0,
                            "maxServingQty": 1.0,
                            "minQty": 0,
                            "modifiersCount": 6,
                            "multipleSizes": false,
                            "priority": 0,
                            "resourceUrl": null,
                            "servingLabel": null,
                            "servingQty": 1.0,
                            "taxCategoryId": 1,
                            "upsell": false
                          },
                          {
                            "id": 774518,
                            "name": "Prosciutto",
                            "description": "prosciutto di parma, fresh mozzarella, fresh basil, tomato and lettuce with red wine vinegar and oregano",
                            "price": 11.0,
                            "active": true,
                            "coupon": false,
                            "couponCode": null,
                            "dietaryPreferences": [],
                            "dishId": 719680,
                            "featured": false,
                            "image": {
                              "active": false,
                              "medium": null,
                              "original": null,
                              "thumb": null,
                              "tiny": null,
                              "xlarge": null,
                              "xxlarge": null
                            },
                            "minPrice": 11.0,
                            "maxPrice": 11.0,
                            "minServingQty": 1.0,
                            "maxServingQty": 1.0,
                            "minQty": 0,
                            "modifiersCount": 6,
                            "multipleSizes": false,
                            "priority": 0,
                            "resourceUrl": null,
                            "servingLabel": null,
                            "servingQty": 1.0,
                            "taxCategoryId": 1,
                            "upsell": false
                          },
                          {
                            "id": 774519,
                            "name": "Spicy",
                            "description": "hot capicola, pepperoni, hot sopresatta, provolone, tomato and lettuce with red wine vinegar and oregano",
                            "price": 10.0,
                            "active": true,
                            "coupon": false,
                            "couponCode": null,
                            "dietaryPreferences": [],
                            "dishId": 719681,
                            "featured": false,
                            "image": {
                              "active": false,
                              "medium": null,
                              "original": null,
                              "thumb": null,
                              "tiny": null,
                              "xlarge": null,
                              "xxlarge": null
                            },
                            "minPrice": 10.0,
                            "maxPrice": 10.0,
                            "minServingQty": 1.0,
                            "maxServingQty": 1.0,
                            "minQty": 0,
                            "modifiersCount": 6,
                            "multipleSizes": false,
                            "priority": 0,
                            "resourceUrl": null,
                            "servingLabel": null,
                            "servingQty": 1.0,
                            "taxCategoryId": 1,
                            "upsell": false
                          },
                          {
                            "id": 774520,
                            "name": "Tuna",
                            "description": "made to order! you choose: mayonnaise, roasted red peppers, celery, onion, artichoke, hot or mild giadiniera, lettuce, provolone and tomato",
                            "price": 11.0,
                            "active": true,
                            "coupon": false,
                            "couponCode": null,
                            "dietaryPreferences": [],
                            "dishId": 719682,
                            "featured": false,
                            "image": {
                              "active": false,
                              "medium": null,
                              "original": null,
                              "thumb": null,
                              "tiny": null,
                              "xlarge": null,
                              "xxlarge": null
                            },
                            "minPrice": 11.0,
                            "maxPrice": 11.0,
                            "minServingQty": 1.0,
                            "maxServingQty": 1.0,
                            "minQty": 0,
                            "modifiersCount": 8,
                            "multipleSizes": false,
                            "priority": 0,
                            "resourceUrl": null,
                            "servingLabel": null,
                            "servingQty": 1.0,
                            "taxCategoryId": 1,
                            "upsell": false
                          },
                          {
                            "id": 774522,
                            "name": "American",
                            "description": "krakus ham, american cheese, mayonnaise, lettuce and tomato",
                            "price": 10.0,
                            "active": true,
                            "coupon": false,
                            "couponCode": null,
                            "dietaryPreferences": [],
                            "dishId": 719684,
                            "featured": false,
                            "image": {
                              "active": false,
                              "medium": null,
                              "original": null,
                              "thumb": null,
                              "tiny": null,
                              "xlarge": null,
                              "xxlarge": null
                            },
                            "minPrice": 10.0,
                            "maxPrice": 10.0,
                            "minServingQty": 1.0,
                            "maxServingQty": 1.0,
                            "minQty": 0,
                            "modifiersCount": 6,
                            "multipleSizes": false,
                            "priority": 0,
                            "resourceUrl": null,
                            "servingLabel": null,
                            "servingQty": 1.0,
                            "taxCategoryId": 1,
                            "upsell": false
                          },
                          {
                            "id": 774524,
                            "name": "Artichoke",
                            "description": "marinated roman style artichoke, fresh mozzarella, fresh basil, roasted red peppers, balsamic vinegar, tomato and lettuce with red wine vinegar and oregano",
                            "price": 11.0,
                            "active": true,
                            "coupon": false,
                            "couponCode": null,
                            "dietaryPreferences": [],
                            "dishId": 719686,
                            "featured": false,
                            "image": {
                              "active": false,
                              "medium": null,
                              "original": null,
                              "thumb": null,
                              "tiny": null,
                              "xlarge": null,
                              "xxlarge": null
                            },
                            "minPrice": 11.0,
                            "maxPrice": 11.0,
                            "minServingQty": 1.0,
                            "maxServingQty": 1.0,
                            "minQty": 0,
                            "modifiersCount": 6,
                            "multipleSizes": false,
                            "priority": 0,
                            "resourceUrl": null,
                            "servingLabel": null,
                            "servingQty": 1.0,
                            "taxCategoryId": 1,
                            "upsell": false
                          },
                          {
                            "id": 774525,
                            "name": "Caprese",
                            "description": "fresh mozzarella, fresh basil, tomato and lettuce with red wine vinegar and oregano",
                            "price": 10.0,
                            "active": true,
                            "coupon": false,
                            "couponCode": null,
                            "dietaryPreferences": [],
                            "dishId": 719687,
                            "featured": false,
                            "image": {
                              "active": false,
                              "medium": null,
                              "original": null,
                              "thumb": null,
                              "tiny": null,
                              "xlarge": null,
                              "xxlarge": null
                            },
                            "minPrice": 10.0,
                            "maxPrice": 10.0,
                            "minServingQty": 1.0,
                            "maxServingQty": 1.0,
                            "minQty": 0,
                            "modifiersCount": 6,
                            "multipleSizes": false,
                            "priority": 0,
                            "resourceUrl": null,
                            "servingLabel": null,
                            "servingQty": 1.0,
                            "taxCategoryId": 1,
                            "upsell": false
                          },
                          {
                            "id": 774526,
                            "name": "Tufano Antipasto",
                            "description": "fontinella cheese, volpi genoa salami, tomato, cucumber, sliced black olive, roasted red peppers, pepperoncini, marinated artichoke, diced red onion and lettuce with red wine vinegar and oregano",
                            "price": 11.0,
                            "active": true,
                            "coupon": false,
                            "couponCode": null,
                            "dietaryPreferences": [],
                            "dishId": 719688,
                            "featured": false,
                            "image": {
                              "active": false,
                              "medium": null,
                              "original": null,
                              "thumb": null,
                              "tiny": null,
                              "xlarge": null,
                              "xxlarge": null
                            },
                            "minPrice": 11.0,
                            "maxPrice": 11.0,
                            "minServingQty": 1.0,
                            "maxServingQty": 1.0,
                            "minQty": 0,
                            "modifiersCount": 6,
                            "multipleSizes": false,
                            "priority": 0,
                            "resourceUrl": null,
                            "servingLabel": null,
                            "servingQty": 1.0,
                            "taxCategoryId": 1,
                            "upsell": false
                          },
                          {
                            "id": 774527,
                            "name": "Porchetta",
                            "description": "Porchetta, fresh arugula, lemon caper aioli served on Publican Quality Ciabatta\\n",
                            "price": 12.0,
                            "active": true,
                            "coupon": false,
                            "couponCode": null,
                            "dietaryPreferences": [],
                            "dishId": 719689,
                            "featured": false,
                            "image": {
                              "active": false,
                              "medium": null,
                              "original": null,
                              "thumb": null,
                              "tiny": null,
                              "xlarge": null,
                              "xxlarge": null
                            },
                            "minPrice": 12.0,
                            "maxPrice": 12.0,
                            "minServingQty": 1.0,
                            "maxServingQty": 1.0,
                            "minQty": 0,
                            "modifiersCount": 6,
                            "multipleSizes": false,
                            "priority": 0,
                            "resourceUrl": null,
                            "servingLabel": null,
                            "servingQty": 1.0,
                            "taxCategoryId": 1,
                            "upsell": false
                          },
                          {
                            "id": 795068,
                            "name": "Muffuletta",
                            "description": "sharp imported provolone, krakus ham, volpi genoa salami, mortadella and JPG mild muffuletta mix served on D'amato's sesame roll",
                            "price": 12.0,
                            "active": true,
                            "coupon": false,
                            "couponCode": null,
                            "dietaryPreferences": [],
                            "dishId": 743491,
                            "featured": false,
                            "image": {
                              "active": false,
                              "medium": null,
                              "original": null,
                              "thumb": null,
                              "tiny": null,
                              "xlarge": null,
                              "xxlarge": null
                            },
                            "minPrice": 12.0,
                            "maxPrice": 12.0,
                            "minServingQty": 1.0,
                            "maxServingQty": 1.0,
                            "minQty": 0,
                            "modifiersCount": 6,
                            "multipleSizes": false,
                            "priority": 0,
                            "resourceUrl": null,
                            "servingLabel": null,
                            "servingQty": 1.0,
                            "taxCategoryId": 1,
                            "upsell": false
                          }
                        ],
                        "active": true,
                        "image": {
                          "active": false,
                          "medium": null,
                          "original": null,
                          "thumb": null,
                          "tiny": null,
                          "xlarge": null,
                          "xxlarge": null
                        },
                        "minOrderQty": 0,
                        "priority": 2,
                        "tags": null
                      }""";

        Category category = gson.fromJson(json, Category.class);

        System.out.println(category);

        System.out.println(gson.toJson(category, Category.class));
    } //main
}