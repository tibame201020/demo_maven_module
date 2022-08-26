package org.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Map;

public class GsonProvider {

    private final static Gson GSON = new Gson();

    public static Gson getGSON() {
        return GSON;
    }

    public static String toJsonStr(Object obj) {
        return GSON.toJson(obj);
    }

    public static JsonObject mapToJsonObject(Map<String, Object> map) {
        return GSON.fromJson(toJsonStr(map), JsonObject.class);
    }

    public static <T> T mapToObject(Map<String, Object> map, Class<T> c) {
        return GSON.fromJson(toJsonStr(map), c);
    }
}
