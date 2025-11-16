package pru.test.data;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import java.io.InputStreamReader;
import java.io.InputStream;

public class JsonValueReader {
    private JsonObject rootObject;

    public JsonValueReader(String resourceFileName) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourceFileName);
            if (inputStream == null) {
                throw new RuntimeException("Resource not found: " + resourceFileName);
            }
            InputStreamReader reader = new InputStreamReader(inputStream);
            rootObject = new Gson().fromJson(reader, JsonObject.class);
            reader.close();
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON resource: " + resourceFileName, e);
        }
    }

    public JsonObject getJsonObject(String key) {
        if (rootObject == null) return null;
        JsonElement element = rootObject.get(key);
        if (element != null && element.isJsonObject()) {
            return element.getAsJsonObject();
        }
        return null;
    }
}
