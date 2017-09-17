package util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJsonUtil {

    public static JSONArray getJsonArray (JSONObject jsonObject, String arrayNodeName) {
        try {
            return jsonObject.getJSONArray(arrayNodeName);
        } catch (JSONException e) {
            throw new IllegalStateException("Given JSON node is not an array or doesn't exist");
        }
    }

}
