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
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * A test class for the Zuppler4j API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version December 1, 2021
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
                               .registerTypeAdapter(Menu.class, new MenuTypeAdapter())
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

        JsonObject data = jsonObject.getAsJsonObject("data");

        if (!data.has("menus")) {
            System.out.println("Error: The JSON response does not contain a \"menus\" member");
        } //end if

        JsonArray menus = data.getAsJsonArray("menus");

        for (JsonElement element : menus) {
            Menu menu = gson.fromJson(element, Menu.class);

            String menuJson = gson.toJson(menu, Menu.class);

            System.out.println(menuJson);
        } //end for
    } //main
}