import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public final class MenuTest {
    public static void main(String[] args) throws Exception {
        String operationName = "RestaurantMenu";

        String query = """
                       query RestaurantMenu($restaurant_id: Int) {
                           menus(restaurantId: $restaurant_id) {
                               id
                               name
                               description
                               default
                               useCategoryTabs
                               group
                               image {
                                   active
                                   medium
                                   original
                                   thumb
                                   tiny
                                   xlarge
                                   xxlarge
                               }
                               availability {
                                   custom
                                   days
                                   services
                                   priority
                                   time {
                                       close
                                       open
                                   }
                               }
                               categories {
                                   id
                                   name
                                   description
                                   priority
                                   active
                                   image {
                                       active
                                       medium
                                       original
                                       thumb
                                       tiny
                                       xlarge
                                       xxlarge
                                   }
                                   minOrderQty
                                   priority
                                   tags
                                   items {
                                       active
                                       coupon
                                       couponCode
                                       description
                                       dietaryPreferences
                                       dishId
                                       featured
                                       id
                                       image {
                                           active
                                           medium
                                           original
                                           thumb
                                           tiny
                                           xlarge
                                           xxlarge
                                       }
                                       maxPrice
                                       maxServingQty
                                       minPrice
                                       minQty
                                       minServingQty
                                       modifiersCount
                                       multipleSizes
                                       name
                                       price
                                       priority
                                       resourceUrl
                                       servingLabel
                                       servingQty
                                       taxCategoryId
                                       upsell
                                   }
                               }
                           }
                       }""";

        Map<String, Integer> variables = Map.of("restaurant_id", 4561);

        Map<String, ?> postFields = Map.of("operationName", operationName,
                                           "query", query,
                                           "variables", variables);

        Gson gson = new Gson();

        String postFieldsString = gson.toJson(postFields);

        HttpRequest.BodyPublisher bodyPublisher = HttpRequest.BodyPublishers.ofString(postFieldsString);

        HttpRequest request = HttpRequest.newBuilder(URI.create("https://restaurants-api5.zuppler.com/graphql"))
                                         .headers("Content-type", "application/json")
                                         .POST(bodyPublisher)
                                         .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse.BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString();

        HttpResponse<String> response = client.send(request, bodyHandler);

        System.out.println(response.body());
    } //main
}