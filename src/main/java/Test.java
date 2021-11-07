import com.google.gson.*;
import com.zuppler4j.Availability;
import com.zuppler4j.Image;
import com.zuppler4j.TimeAvailability;
import com.zuppler4j.menu.Category;
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
                                   active
                                   description
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
                                   items {
                                       id
                                   }
                                   minOrderQty
                                   name
                                   priority
                                   tags
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

    private static Integer getId(JsonObject menuObject) {
        Objects.requireNonNull(menuObject, "the specified menu object is null");

        JsonElement idElement = menuObject.get("id");

        Integer id = null;

        if ((idElement != null) && idElement.isJsonPrimitive()) {
            JsonPrimitive idPrimitive = idElement.getAsJsonPrimitive();

            if (idPrimitive.isNumber()) {
                id = idPrimitive.getAsInt();
            } //end if
        } //end if

        return id;
    } //getId

    private static String getName(JsonObject menuObject) {
        Objects.requireNonNull(menuObject, "the specified menu object is null");

        JsonElement nameElement = menuObject.get("name");

        String name = null;

        if ((nameElement != null) && nameElement.isJsonPrimitive()) {
            JsonPrimitive namePrimitive = nameElement.getAsJsonPrimitive();

            if (namePrimitive.isString()) {
                name = namePrimitive.getAsString();
            } //end if
        } //end if

        return name;
    } //getName

    private static String getDescription(JsonObject menuObject) {
        Objects.requireNonNull(menuObject, "the specified menu object is null");

        JsonElement descriptionElement = menuObject.get("description");

        String description = null;

        if ((descriptionElement != null) && descriptionElement.isJsonPrimitive()) {
            JsonPrimitive descriptionPrimitive = descriptionElement.getAsJsonPrimitive();

            if (descriptionPrimitive.isString()) {
                description = descriptionPrimitive.getAsString();
            } //end if
        } //end if

        return description;
    } //getDescription

    private static Image getImage(JsonObject jsonObject) {
        Objects.requireNonNull(jsonObject, "the specified JSON object is null");

        JsonElement imageElement = jsonObject.get("image");

        if ((imageElement == null) || !imageElement.isJsonObject()) {
            return null;
        } //end if

        JsonObject imageObject = imageElement.getAsJsonObject();

        JsonElement activeElement = imageObject.get("active");

        Boolean active = null;

        if ((activeElement != null) && activeElement.isJsonPrimitive()) {
            JsonPrimitive activePrimitive = activeElement.getAsJsonPrimitive();

            if (activePrimitive.isBoolean()) {
                active = activePrimitive.getAsBoolean();
            } //end if
        } //end if

        JsonElement mediumElement = imageObject.get("medium");

        String medium = null;

        if ((mediumElement != null) && mediumElement.isJsonPrimitive()) {
            JsonPrimitive mediumPrimitive = mediumElement.getAsJsonPrimitive();

            if (mediumPrimitive.isString()) {
                medium = mediumPrimitive.getAsString();
            } //end if
        } //end if

        JsonElement originalElement = imageObject.get("original");

        String original = null;

        if ((originalElement != null) && originalElement.isJsonPrimitive()) {
            JsonPrimitive originalPrimitive = originalElement.getAsJsonPrimitive();

            if (originalPrimitive.isString()) {
                original = originalPrimitive.getAsString();
            } //end if
        } //end if

        JsonElement thumbElement = imageObject.get("thumb");

        String thumb = null;

        if ((thumbElement != null) && thumbElement.isJsonPrimitive()) {
            JsonPrimitive thumbPrimitive = thumbElement.getAsJsonPrimitive();

            if (thumbPrimitive.isString()) {
                thumb = thumbPrimitive.getAsString();
            } //end if
        } //end if

        JsonElement tinyElement = imageObject.get("tiny");

        String tiny = null;

        if ((tinyElement != null) && tinyElement.isJsonPrimitive()) {
            JsonPrimitive tinyPrimitive = tinyElement.getAsJsonPrimitive();

            if (tinyPrimitive.isString()) {
                tiny = tinyPrimitive.getAsString();
            } //end if
        } //end if

        JsonElement xlargeElement = imageObject.get("xlarge");

        String xlarge = null;

        if ((xlargeElement != null) && xlargeElement.isJsonPrimitive()) {
            JsonPrimitive xlargePrimitive = xlargeElement.getAsJsonPrimitive();

            if (xlargePrimitive.isString()) {
                xlarge = xlargePrimitive.getAsString();
            } //end if
        } //end if

        JsonElement xxlargeElement = imageObject.get("xxlarge");

        String xxlarge = null;

        if ((xxlargeElement != null) && xxlargeElement.isJsonPrimitive()) {
            JsonPrimitive xxlargePrimitive = xxlargeElement.getAsJsonPrimitive();

            if (xxlargePrimitive.isString()) {
                xxlarge = xxlargePrimitive.getAsString();
            } //end if
        } //end if

        return new Image(active, medium, original, thumb, tiny, xlarge, xxlarge);
    } //getImage

    private static Category getCategory(JsonObject categoryObject) {
        Objects.requireNonNull(categoryObject, "the specified category object is null");

        JsonElement idElement = categoryObject.get("id");

        Integer id = null;

        if ((idElement != null) && idElement.isJsonPrimitive()) {
            JsonPrimitive idPrimitive = idElement.getAsJsonPrimitive();

            if (idPrimitive.isNumber()) {
                id = idPrimitive.getAsInt();
            } //end if
        } //end if

        JsonElement nameElement = categoryObject.get("name");

        String name = null;

        if ((nameElement != null) && nameElement.isJsonPrimitive()) {
            JsonPrimitive namePrimitive = nameElement.getAsJsonPrimitive();

            if (namePrimitive.isString()) {
                name = namePrimitive.getAsString();
            } //end if
        } //end if

        JsonElement descriptionElement = categoryObject.get("description");

        String description = null;

        if ((descriptionElement != null) && descriptionElement.isJsonPrimitive()) {
            JsonPrimitive descriptionPrimitive = descriptionElement.getAsJsonPrimitive();

            if (descriptionPrimitive.isString()) {
                description = descriptionPrimitive.getAsString();
            } //end if
        } //end if

        //TODO: parse the "items" member

        JsonElement activeElement = categoryObject.get("active");

        Boolean active = null;

        if ((activeElement != null) && activeElement.isJsonPrimitive()) {
            JsonPrimitive activePrimitive = activeElement.getAsJsonPrimitive();

            if (activePrimitive.isBoolean()) {
                active = activePrimitive.getAsBoolean();
            } //end if
        } //end if

        //

        Image image = Test.getImage(categoryObject);

        return new Category(id, name, description, null, active, image, null, null, null);
    } //getCategory

    private static List<Category> getCategories(JsonObject menuObject) {
        Objects.requireNonNull(menuObject, "the specified menu object is null");

        JsonElement categoriesElement = menuObject.get("categories");

        List<Category> categories = null;

        if ((categoriesElement != null) && categoriesElement.isJsonArray()) {
            JsonArray categoriesArray = categoriesElement.getAsJsonArray();

            categories = new ArrayList<>();

            for (JsonElement categoryElement : categoriesArray) {
                Category category = null;

                if (categoryElement.isJsonObject()) {
                    JsonObject categoryObject = categoryElement.getAsJsonObject();

                    category = Test.getCategory(categoryObject);
                } //end if

                categories.add(category);
            } //end for

            categories = Collections.unmodifiableList(categories);
        } //end if

        return categories;
    } //getCategories

    private static TimeAvailability getTimeAvailability(JsonObject timeAvailabilityObject) {
        Objects.requireNonNull(timeAvailabilityObject, "the specified time availability object is null");

        JsonElement openElement = timeAvailabilityObject.get("open");

        Integer open = null;

        if ((openElement != null) && openElement.isJsonPrimitive()) {
            JsonPrimitive openPrimitive = openElement.getAsJsonPrimitive();

            if (openPrimitive.isNumber()) {
                open = openPrimitive.getAsInt();
            } //end if
        } //end if

        JsonElement closeElement = timeAvailabilityObject.get("close");

        Integer close = null;

        if ((closeElement != null) && closeElement.isJsonPrimitive()) {
            JsonPrimitive closePrimitive = closeElement.getAsJsonPrimitive();

            if (closePrimitive.isNumber()) {
                close = closePrimitive.getAsInt();
            } //end if
        } //end if

        return new TimeAvailability(open, close);
    } //getTimeAvailability

    private static Availability getAvailability(JsonObject menuObject) {
        Objects.requireNonNull(menuObject, "the specified menu object is null");

        JsonElement availabilityElement = menuObject.get("availability");

        if ((availabilityElement == null) || !availabilityElement.isJsonObject()) {
            return null;
        } //end if

        JsonObject availabilityObject = availabilityElement.getAsJsonObject();

        JsonElement customElement = availabilityObject.get("custom");

        Boolean custom = null;

        if ((customElement != null) && customElement.isJsonPrimitive()) {
            JsonPrimitive customPrimitive = customElement.getAsJsonPrimitive();

            if (customPrimitive.isBoolean()) {
                custom = customPrimitive.getAsBoolean();
            } //end if
        } //end if

        JsonElement daysElement = availabilityObject.get("days");

        Integer days = null;

        if ((daysElement != null) && daysElement.isJsonPrimitive()) {
            JsonPrimitive daysPrimitive = daysElement.getAsJsonPrimitive();

            if (daysPrimitive.isNumber()) {
                days = daysPrimitive.getAsInt();
            } //end if
        } //end if

        JsonElement priorityElement = availabilityObject.get("priority");

        Integer priority = null;

        if ((priorityElement != null) && priorityElement.isJsonPrimitive()) {
            JsonPrimitive priorityPrimitive = priorityElement.getAsJsonPrimitive();

            if (priorityPrimitive.isNumber()) {
                priority = priorityPrimitive.getAsInt();
            } //end if
        } //end if

        JsonElement servicesElement = availabilityObject.get("services");

        Integer services = null;

        if ((servicesElement != null) && servicesElement.isJsonPrimitive()) {
            JsonPrimitive servicesPrimitive = servicesElement.getAsJsonPrimitive();

            if (servicesPrimitive.isNumber()) {
                services = servicesPrimitive.getAsInt();
            } //end if
        } //end if

        JsonElement timeElement = availabilityObject.get("time");

        List<TimeAvailability> time = null;

        if ((timeElement != null) && timeElement.isJsonArray()) {
            JsonArray timeArray = timeElement.getAsJsonArray();

            time = new ArrayList<>();

            for (JsonElement timeAvailabilityElement : timeArray) {
                TimeAvailability timeAvailability = null;

                if (timeAvailabilityElement.isJsonObject()) {
                    JsonObject timeAvailabilityObject = timeAvailabilityElement.getAsJsonObject();

                    timeAvailability = Test.getTimeAvailability(timeAvailabilityObject);
                } //end if

                time.add(timeAvailability);
            } //end if

            time = Collections.unmodifiableList(time);
        } //end if

        return new Availability(custom, days, priority, services, time);
    } //getAvailability

    private static Boolean getPreselected(JsonObject menuObject) {
        Objects.requireNonNull(menuObject, "the specified menu object is null");

        JsonElement preselectedElement = menuObject.get("default");

        Boolean preselected = null;

        if ((preselectedElement != null) && preselectedElement.isJsonPrimitive()) {
            JsonPrimitive preselectedPrimitive = preselectedElement.getAsJsonPrimitive();

            if (preselectedPrimitive.isBoolean()) {
                preselected = preselectedPrimitive.getAsBoolean();
            } //end if
        } //end if

        return preselected;
    } //getPreselected

    private static String getGroup(JsonObject menuObject) {
        Objects.requireNonNull(menuObject, "the specified menu object is null");

        JsonElement groupElement = menuObject.get("group");

        String group = null;

        if ((groupElement != null) && groupElement.isJsonPrimitive()) {
            JsonPrimitive groupPrimitive = groupElement.getAsJsonPrimitive();

            if (groupPrimitive.isString()) {
                group = groupPrimitive.getAsString();
            } //end if
        } //end if

        return group;
    } //getGroup

    private static Boolean getUseCategoryTabs(JsonObject menuObject) {
        Objects.requireNonNull(menuObject, "the specified menu object is null");

        JsonElement useCategoryTabsElement = menuObject.get("useCategoryTabs");

        Boolean useCategoryTabs = null;

        if ((useCategoryTabsElement != null) && useCategoryTabsElement.isJsonPrimitive()) {
            JsonPrimitive useCategoryTabsPrimitive = useCategoryTabsElement.getAsJsonPrimitive();

            if (useCategoryTabsPrimitive.isBoolean()) {
                useCategoryTabs = useCategoryTabsPrimitive.getAsBoolean();
            } //end if
        } //end if

        return useCategoryTabs;
    } //getUseCategoryTabs

    private static Menu getMenu(JsonObject menuObject) {
        Objects.requireNonNull(menuObject, "the specified menu object is null");

        Integer id = Test.getId(menuObject);

        String name = Test.getName(menuObject);

        String description = Test.getDescription(menuObject);

        List<Category> categories = Test.getCategories(menuObject);

        Availability availability = Test.getAvailability(menuObject);

        Boolean preselected = Test.getPreselected(menuObject);

        String group = Test.getGroup(menuObject);

        Image image = getImage(menuObject);

        Boolean useCategoryTabs = Test.getUseCategoryTabs(menuObject);

        return new Menu(id, name, description, categories, availability, preselected, group, image, useCategoryTabs);
    } //getMenu

    private static Set<Menu> getMenus(String menusJson) {
        Objects.requireNonNull(menusJson, "the specified menus JSON is null");

        JsonElement jsonElement = JsonParser.parseString(menusJson);

        if (!jsonElement.isJsonObject()) {
            return Set.of();
        } //end if

        JsonObject jsonObject = jsonElement.getAsJsonObject();

        JsonElement dataElement = jsonObject.get("data");

        if ((dataElement == null) || !dataElement.isJsonObject()) {
            return Set.of();
        } //end if

        JsonObject dataObject = dataElement.getAsJsonObject();

        JsonElement menusElement = dataObject.get("menus");

        if ((menusElement == null) || !menusElement.isJsonArray()) {
            return Set.of();
        } //end if

        JsonArray menusArray = menusElement.getAsJsonArray();

        Set<Menu> menus = new HashSet<>();

        for (JsonElement menuElement : menusArray) {
            Menu menu = null;

            if (menuElement.isJsonObject()) {
                JsonObject menuObject = menuElement.getAsJsonObject();

                menu = Test.getMenu(menuObject);
            } //end if

            menus.add(menu);
        } //end for

        return Collections.unmodifiableSet(menus);
    } //getMenus

    public static void main(String[] args) {
        String menusJson = Test.getMenusJson();

        Test.getMenus(menusJson)
            .stream()
            .map(Menu::categories)
            .forEach(categories -> categories.stream()
                                             .map(Category::image)
                                             .forEach(System.out::println));
    } //main
}