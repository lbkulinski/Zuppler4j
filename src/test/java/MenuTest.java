/*
 * MIT License
 *
 * Copyright (c) 2021 Logan Kulinski
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import com.google.gson.*;
import com.zuppler4j.Availability;
import com.zuppler4j.Image;
import com.zuppler4j.TimeAvailability;
import com.zuppler4j.adapters.AvailabilityTypeAdapter;
import com.zuppler4j.adapters.ImageTypeAdapter;
import com.zuppler4j.adapters.TimeAvailabilityTypeAdapter;
import com.zuppler4j.adapters.menu.*;
import com.zuppler4j.menu.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson gson = gsonBuilder.registerTypeAdapter(Image.class, new ImageTypeAdapter())
                               .registerTypeAdapter(TimeAvailability.class, new TimeAvailabilityTypeAdapter())
                               .registerTypeAdapter(Availability.class, new AvailabilityTypeAdapter())
                               .registerTypeAdapter(ItemOption.class, new ItemOptionTypeAdapter())
                               .registerTypeAdapter(ItemModifier.class, new ItemModifierTypeAdapter())
                               .registerTypeAdapter(ItemSize.class, new ItemSizeTypeAdapter())
                               .registerTypeAdapter(Item.class, new ItemTypeAdapter())
                               .registerTypeAdapter(Category.class, new CategoryTypeAdapter())
                               .registerTypeAdapter(Menu.class, new MenuTypeAdapter())
                               .registerTypeAdapter(MenuItem.class, new MenuItemTypeAdapter())
                               .serializeNulls()
                               .create();

        String postFieldsString = gson.toJson(postFields);

        HttpRequest.BodyPublisher bodyPublisher = HttpRequest.BodyPublishers.ofString(postFieldsString);

        HttpRequest request = HttpRequest.newBuilder(URI.create("https://restaurants-api5.zuppler.com/graphql"))
                                         .headers("Content-type", "application/json")
                                         .POST(bodyPublisher)
                                         .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse.BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString();

        HttpResponse<String> response = client.send(request, bodyHandler);

        String menusJson = response.body();

        if (menusJson == null) {
            return;
        } //end if

        JsonElement jsonElement = gson.fromJson(menusJson, JsonElement.class);

        if (!jsonElement.isJsonObject()) {
            return;
        } //end if

        JsonObject jsonObject = jsonElement.getAsJsonObject();

        if (!jsonObject.has("data")) {
            return;
        } //end if

        JsonElement dataElement = jsonObject.get("data");

        if (!dataElement.isJsonObject()) {
            return;
        } //end if

        JsonObject dataObject = dataElement.getAsJsonObject();

        if (!dataObject.has("menus")) {
            return;
        } //end if

        JsonElement menusElement = dataObject.get("menus");

        if (!menusElement.isJsonArray()) {
            return;
        } //end if

        JsonArray menusArray = menusElement.getAsJsonArray();

        List<Menu> menus = new ArrayList<>();

        for (JsonElement menuElement : menusArray) {
            Menu menu = gson.fromJson(menuElement, Menu.class);

            menus.add(menu);
        } //end for

        menus.stream()
             .map(Menu::categories)
             .flatMap(List::stream)
             .map(Category::items)
             .flatMap(List::stream)
             .map(Item::getMenuItem)
             .filter(Optional::isPresent)
             .map(Optional::get)
             .map(menuItem -> gson.toJson(menuItem, MenuItem.class))
             .forEach(System.out::println);
    } //main
}