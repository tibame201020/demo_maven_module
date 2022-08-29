package org.util;

import java.util.ResourceBundle;

public class BundleFileReader {

    public static String readProp(String bundleFileName, String key) {
        try {
            // get value from properties file
            ResourceBundle resourceBundle = ResourceBundle.getBundle(bundleFileName);
            return resourceBundle.getString(key);
        } catch (Exception e) {
            // properties file did not have the key
            return key;
        }
    }

}
