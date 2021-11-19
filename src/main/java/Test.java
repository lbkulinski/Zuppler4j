import com.google.gson.reflect.TypeToken;
import com.zuppler4j.Image;
import java.lang.reflect.Type;
import com.zuppler4j.adapters.ImageTypeAdapter;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

/**
 * A test class for the Zuppler4j API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 19, 2021
 */
public final class Test {
    /**
     * Runs the given tests.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TypeToken<Image> imageTypeToken = new TypeToken<>() {};

        Type imageType = imageTypeToken.getType();

        ImageTypeAdapter imageTypeAdapter = new ImageTypeAdapter();

        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson gson = gsonBuilder.registerTypeAdapter(imageType, imageTypeAdapter)
                               .serializeNulls()
                               .create();

        String json = """
                      {
                          "active": false,
                          "medium": null,
                          "original": null,
                          "thumb": null,
                          "tiny": null,
                          "xlarge": null,
                          "xxlarge": null
                      }""";

        Image image = gson.fromJson(json, imageType);

        System.out.println(image);

        System.out.println(gson.toJson(image));
    } //main
}