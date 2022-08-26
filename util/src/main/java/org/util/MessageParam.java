package org.util;

public class MessageParam {
    public static String parse(Object obj) {
        return GsonProvider.toJsonStr(obj);
    }
}
