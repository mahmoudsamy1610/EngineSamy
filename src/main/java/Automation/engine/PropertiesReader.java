package Automation.engine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static Properties LoadProperty(String path )   {



        try {
            Properties properties  = new Properties();
            properties.load(new FileInputStream(path));
            return properties;
        } catch (FileNotFoundException e) {
            System.out.println("Invalid Path for properties file");
        } catch (IOException ioe) {
            ioe.getMessage();
            System.out.println("Unknown input/output Error while finding properties");
        }

        return null ;
    }



}
