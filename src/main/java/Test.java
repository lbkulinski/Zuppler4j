import com.google.gson.*;
import com.zuppler4j.Availability;
import com.zuppler4j.Image;
import com.zuppler4j.TimeAvailability;
import com.zuppler4j.adapters.AvailabilityTypeAdapter;
import com.zuppler4j.adapters.ImageTypeAdapter;
import com.zuppler4j.adapters.TimeAvailabilityTypeAdapter;
import com.zuppler4j.adapters.menu.*;
import com.zuppler4j.menu.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A test class for the Zuppler4j API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version December 2, 2021
 */
public final class Test {
    /**
     * Returns the schema found at the specified {@link URI} {@link String}.
     *
     * @param uriString the {@link URI} {@link String} to be used in the operation
     * @return the schema found at the specified {@link URI} {@link String}
     */
    private static String getSchema(String uriString) {
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
                               .registerTypeAdapter(ItemSize.class, new ItemSizeTypeAdapter())
                               .registerTypeAdapter(Item.class, new ItemTypeAdapter())
                               .registerTypeAdapter(Category.class, new CategoryTypeAdapter())
                               .registerTypeAdapter(Menu.class, new MenuTypeAdapter())
                               .registerTypeAdapter(MenuItem.class, new MenuItemTypeAdapter())
                               .serializeNulls()
                               .create();

        String fileName = "jpg-menu.txt";

        Path path = Path.of(fileName);

        String json;

        try {
            json = Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();

            return;
        } //end try catch

        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

        if (!jsonObject.has("data")) {
            System.out.println("Error: The JSON response does not contain a \"data\" member");
        } //end if

        JsonObject dataObject = jsonObject.getAsJsonObject("data");

        if (!dataObject.has("menus")) {
            System.out.println("Error: The JSON response does not contain an \"menus\" member");
        } //end if

        JsonArray menusArray = dataObject.getAsJsonArray("menus");

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