import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public final class Test {
    private static final long RESTAURANT_ID = 4561L;

    private static String getSchema() {
        String uriString = "https://restaurants-api5.zuppler.com/graphql";

        URI uri = URI.create(uriString);

        String[] headers = {"Content-type", "application/json"};

        String operationName = "IntrospectionQuery";

        String query = """
                       query IntrospectionQuery {
                         __schema {
                           queryType {
                             name
                           }
                           mutationType {
                             name
                           }
                           subscriptionType {
                             name
                           }
                           types {
                             ...FullType
                           }
                           directives {
                             name
                             description
                             locations
                             args {
                               ...InputValue
                             }
                           }
                         }
                       }
                                              
                       fragment FullType on __Type {
                         kind
                         name
                         description
                         fields(includeDeprecated: true) {
                           name
                           description
                           args {
                             ...InputValue
                           }
                           type {
                             ...TypeRef
                           }
                           isDeprecated
                           deprecationReason
                         }
                         inputFields {
                           ...InputValue
                         }
                         interfaces {
                           ...TypeRef
                         }
                         enumValues(includeDeprecated: true) {
                           name
                           description
                           isDeprecated
                           deprecationReason
                         }
                         possibleTypes {
                           ...TypeRef
                         }
                       }
                                              
                       fragment InputValue on __InputValue {
                         name
                         description
                         type {
                           ...TypeRef
                         }
                         defaultValue
                       }
                                              
                       fragment TypeRef on __Type {
                         kind
                         name
                         ofType {
                           kind
                           name
                           ofType {
                             kind
                             name
                             ofType {
                               kind
                               name
                               ofType {
                                 kind
                                 name
                                 ofType {
                                   kind
                                   name
                                   ofType {
                                     kind
                                     name
                                     ofType {
                                       kind
                                       name
                                     }
                                   }
                                 }
                               }
                             }
                           }
                         }
                       }""";

        Map<String, ?> fields = Map.of("operationName", operationName,
                                       "query", query);

        Gson gson = new Gson();

        String requestBody = gson.toJson(fields);

        HttpRequest.BodyPublisher bodyPublisher = HttpRequest.BodyPublishers.ofString(requestBody);

        HttpRequest request = HttpRequest.newBuilder(uri)
                                         .headers(headers)
                                         .POST(bodyPublisher)
                                         .build();

        HttpResponse.BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString();

        HttpResponse<String> response;

        try {
            response = HttpClient.newHttpClient()
                                 .send(request, bodyHandler);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();

            return null;
        } //end try catch

        return response.body();
    } //getSchema

    private static String getMenusJson() {
        String uriString = "https://restaurants-api5.zuppler.com/graphql";

        URI uri = URI.create(uriString);

        String[] headers = {"Content-type", "application/json"};

        String operationName = "GetRestaurantMenus";

        String query = """
                       query GetRestaurantMenus($restaurant_id: Int!) {
                           menus(restaurantId: $restaurant_id) {
                               id
                               name
                               description
                               availability {
                                   custom
                                   days
                                   priority
                                   services
                                   time {
                                       open
                                       close
                                   }
                               }
                               categories {
                                   name
                                   items {
                                       id
                                   }
                               }
                               default
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
                               useCategoryTabs
                           }
                       }""";

        Map<String, ?> variables = Map.of("restaurant_id", RESTAURANT_ID);

        Map<String, ?> fields = Map.of("operationName", operationName,
                                       "query", query,
                                       "variables", variables);

        Gson gson = new Gson();

        String requestBody = gson.toJson(fields);

        HttpRequest.BodyPublisher bodyPublisher = HttpRequest.BodyPublishers.ofString(requestBody);

        HttpRequest request = HttpRequest.newBuilder(uri)
                                         .headers(headers)
                                         .POST(bodyPublisher)
                                         .build();

        HttpResponse.BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString();

        HttpResponse<String> response;

        try {
            response = HttpClient.newHttpClient()
                                 .send(request, bodyHandler);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();

            return null;
        } //end try catch

        return response.body();
    } //getMenusJson

    private static Map<String, Set<String>> getCategoryIdsMap() {
        String menusJson = Test.getMenusJson();

        if (menusJson == null) {
            return Map.of();
        } //end if

        JsonElement jsonElement = JsonParser.parseString(menusJson);

        JsonObject jsonObject = jsonElement.getAsJsonObject();

        JsonObject data = jsonObject.getAsJsonObject("data");

        JsonArray menus = data.getAsJsonArray("menus");

        Map<String, Set<String>> categoryIdsMap = new HashMap<>();

        for (JsonElement menuElement : menus) {
            JsonObject menu = menuElement.getAsJsonObject();

            JsonArray categories = menu.getAsJsonArray("categories");

            for (JsonElement categoryElement : categories) {
                JsonObject category = categoryElement.getAsJsonObject();

                String name = category.get("name")
                                      .getAsString();

                JsonArray items = category.getAsJsonArray("items");

                Set<String> ids = new HashSet<>();

                for (JsonElement itemElement : items) {
                    JsonObject item = itemElement.getAsJsonObject();

                    String id = item.get("id")
                                    .getAsString();

                    ids.add(id);
                } //end for

                categoryIdsMap.put(name, ids);
            } //end for
        } //end for

        return Collections.unmodifiableMap(categoryIdsMap);
    } //getCategoryIdsMap

    private static String getItemDetailJson(String itemId) {
        String uriString = "https://restaurants-api5.zuppler.com/graphql";

        URI uri = URI.create(uriString);

        String[] headers = {"Content-type", "application/json"};

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

        Map<String, ?> variables = Map.of("item_id", Integer.parseInt(itemId));

        Map<String, ?> fields = Map.of("operationName", operationName,
                                       "query", query,
                                       "variables", variables);

        Gson gson = new Gson();

        String requestBody = gson.toJson(fields);

        HttpRequest.BodyPublisher bodyPublisher = HttpRequest.BodyPublishers.ofString(requestBody);

        HttpRequest request = HttpRequest.newBuilder(uri)
                                         .headers(headers)
                                         .POST(bodyPublisher)
                                         .build();

        HttpResponse.BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString();

        HttpResponse<String> response;

        try {
            response = HttpClient.newHttpClient()
                                 .send(request, bodyHandler);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();

            return null;
        } //end try catch

        return response.body();
    } //getItemDetailJson

    public static void main(String[] args) {
        System.out.println(Test.getMenusJson());
    } //main
}