package org.util;

import com.google.gson.JsonObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;

public class Converter {
    private static final Log log = LogFactory.getLog(Converter.class);

    public static Map<String, Object> resultSetToMap(ResultSet rs, boolean useCamelCase) {
        Map<String, Object> dataMap = new HashMap<>();

        try {
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int colNums = rsMetaData.getColumnCount();
            for (int i = 1; i <= colNums; i++) {
                String columnName = rsMetaData.getColumnName(i);
                Object value = rs.getObject(columnName);

                if (useCamelCase) {
                    dataMap.put(StringUtils.uncapitalize(columnNameToProp(columnName)), value);
                } else {
                    dataMap.put(columnName, value);
                }
            }
        } catch (Exception e) {
            log.error(e);
            return null;
        }

        return dataMap;
    }

    public static JsonObject resultSetToJson(ResultSet rs, boolean useCamelCase) {
        return GsonProvider.mapToJsonObject(resultSetToMap(rs, useCamelCase));
    }

    public static String resultSetToJsonStr(ResultSet rs, boolean useCamelCase) {
        return GsonProvider.toJsonStr(resultSetToMap(rs, useCamelCase));
    }

    public static <T> T resultSetToObject(ResultSet rs, Class<T> c) {
        return GsonProvider.mapToObject(resultSetToMap(rs, true), c);
    }

    private static String columnNameToProp(String columnName) {
        String[] colArray = columnName.split("_");
        StringBuffer fieldName = new StringBuffer();
        for (String str :
                colArray) {
            if (str.length() == 1) {
                fieldName.append(str.toLowerCase());
            } else {
                fieldName.append(StringUtils.capitalize(str.toLowerCase()));
            }
        }

        return fieldName.toString();
    }
}
