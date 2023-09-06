package au.co.market2x.web.manager;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigurationManager {


    public static String market2xbookingsurl;
    public static String market2xcarrierssurl;



    public static String browser;
    public static String headless;

    public static String testEmail1;
    public static String testPass1;


    public static void loadTestConfig() {
        Properties prop = new Properties();
        InputStream propFile = (ConfigurationManager.class)
                .getClassLoader()
                .getResourceAsStream("config.properties");

        if (propFile != null) {
            try {
                prop.load(propFile);
                propFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new RuntimeException("Failed to load config.properties...");
        }

        Map<String, String> props = fieldMapper();
        Field[] fields = (ConfigurationManager.class).getFields();

        for (Field field : fields) {
            String fieldName = field.getName();
            String propKey = props.get(fieldName);

            try {
                if (!System.getProperty(propKey).equals("")) {
                    loadFromSystemProperties(propKey, field);
                } else {
                    System.out.println(String.format("Blank system property for \"%s\", " +
                            "loading from config file...", propKey));
                    loadFromConfigFile(propKey, field, prop);
                }
            } catch (NullPointerException e) {
                try {
                    //load local config file
                    loadFromConfigFile(propKey, field, prop);
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }


    private static Map<String, String> fieldMapper() {
        Map<String, String> props = new HashMap<>();

        props.put("market2xbookingsurl", "test.market2xbookings");
        props.put("market2xcarrierssurl", "test.market2xcarriers");


        props.put("browser", "test.browser");
        props.put("headless","test.headless");

        props.put("testEmail1", "test.email1");
        props.put("testPass1", "test.pass1");
        return props;
    }

    private static void loadFromSystemProperties(String key, Field field) throws IllegalAccessException, NullPointerException {
        String sysProp = System.getProperty(key);
        field.set(ConfigurationManager.class, sysProp);

        System.out.println(String.format("%s: %s loaded from System Properties", key, sysProp));
    }

    private static void loadFromConfigFile(String key, Field field, Properties prop) throws IllegalAccessException {
        String locProp = prop.getProperty(key);
        field.set(ConfigurationManager.class, locProp);
//        System.out.println(String.format("%s: %s loaded from config files", key, locProp));
    }
}


