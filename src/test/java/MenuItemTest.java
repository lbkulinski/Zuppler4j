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