import com.google.gson.*;
import com.zuppler4j.Availability;
import com.zuppler4j.TimeAvailability;
import com.zuppler4j.menu.Menu;

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

    private static TimeAvailability getTimeAvailability(JsonObject timeAvailabilityObject) {
        Objects.requireNonNull(timeAvailabilityObject, "the specified time availability object is null");

        JsonElement openElement = timeAvailabilityObject.get("open");

        Integer open = null;

        if ((openElement != null) && !openElement.isJsonNull()) {
            open = openElement.getAsInt();
        } //end if

        JsonElement closeElement = timeAvailabilityObject.get("close");

        Integer close = null;

        if ((closeElement != null) && !closeElement.isJsonNull()) {
            close = closeElement.getAsInt();
        } //end if

        return new TimeAvailability(open, close);
    } //getTimeAvailability

    private static Availability getAvailability(JsonObject availabilityObject) {
        Objects.requireNonNull(availabilityObject, "the specified availability object is null");

        JsonElement customElement = availabilityObject.get("custom");

        Boolean custom = null;

        if ((customElement != null) && !customElement.isJsonNull()) {
            custom = customElement.getAsBoolean();
        } //end if

        JsonElement daysElement = availabilityObject.get("days");

        Integer days = null;

        if ((daysElement != null) && !daysElement.isJsonNull()) {
            days = daysElement.getAsInt();
        } //end if

        JsonElement priorityElement = availabilityObject.get("priority");

        Integer priority = null;

        if ((priorityElement != null) && !priorityElement.isJsonNull()) {
            priority = priorityElement.getAsInt();
        } //end if

        JsonElement servicesElement = availabilityObject.get("services");

        Integer services = null;

        if ((servicesElement != null) && !servicesElement.isJsonNull()) {
            services = servicesElement.getAsInt();
        } //end if

        JsonArray timeArray = availabilityObject.getAsJsonArray("time");

        List<TimeAvailability> time = null;

        if (timeArray != null) {
            time = new ArrayList<>();

            for (JsonElement timeAvailabilityElement : timeArray) {
                if (!timeAvailabilityElement.isJsonObject()) {
                    continue;
                } //end if

                JsonObject timeAvailabilityObject = timeAvailabilityElement.getAsJsonObject();

                TimeAvailability timeAvailability = Test.getTimeAvailability(timeAvailabilityObject);

                time.add(timeAvailability);
            } //end if

            time = Collections.unmodifiableList(time);
        } //end if

        return new Availability(custom, days, priority, services, time);
    } //getAvailability

    private static Menu getMenu(JsonObject menuObject) {
        Objects.requireNonNull(menuObject, "the specified menu object is null");

        JsonObject availabilityObject = menuObject.getAsJsonObject("availability");

        Availability availability = null;

        if (availabilityObject != null) {
            availability = Test.getAvailability(availabilityObject);
        } //end if

        return new Menu(null, null, null, null, availability, null,
                        null, null, null);
    } //getMenu

    private static Set<Menu> getMenus(String menusJson) {
        Objects.requireNonNull(menusJson, "the specified menus JSON is null");

        JsonElement jsonElement = JsonParser.parseString(menusJson);

        JsonObject jsonObject = jsonElement.getAsJsonObject();

        JsonObject dataObject = jsonObject.getAsJsonObject("data");

        if (dataObject == null) {
            return Set.of();
        } //end if

        JsonArray menusArray = dataObject.getAsJsonArray("menus");

        if (menusArray == null) {
            return Set.of();
        } //end if

        Set<Menu> menus = new HashSet<>();

        for (JsonElement menuElement : menusArray) {
            if (!menuElement.isJsonObject()) {
                continue;
            } //end if

            JsonObject menuObject = menuElement.getAsJsonObject();

            Menu menu = Test.getMenu(menuObject);

            menus.add(menu);
        } //end for

        return Collections.unmodifiableSet(menus);
    } //getMenus

    public static void main(String[] args) {
        String menusJson = Test.getMenusJson();

        Test.getMenus(menusJson)
            .stream()
            .map(Menu::availability)
            .forEach(System.out::println);
    } //main
}