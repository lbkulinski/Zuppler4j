import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public final class MenuItemTest {
    public static void main(String[] args) throws Exception {
        String operationName = "ItemDetails";

        String query = """
                       query ItemDetails($item_id: Int!) {
                           item(item_id: $item_id) {
                               id
                               description
                               name
                               veg
                               spicy
                               sizes {
                                   id
                                   sizeId
                                   sizeName
                                   coupon
                                   priority
                                   active
                                   minQty
                                   price
                                   modifiers {
                                       id
                                       name
                                       description
                                       active
                                       priority
                                       multipleSelections
                                       multipleModifiers
                                       minSelections
                                       maxSelections
                                       allowGrouping
                                       options {
                                           id
                                           name
                                           description
                                           active
                                           priority
                                           weight
                                           group
                                           groupLabel
                                           image {
                                               active
                                               original
                                           }
                                       }
                                   }
                               }
                           }
                       }""";

        Map<String, Integer> variables = Map.of("item_id", 774524);

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