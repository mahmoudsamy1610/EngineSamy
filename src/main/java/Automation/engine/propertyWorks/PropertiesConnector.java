package Automation.engine.propertyWorks;
import java.util.InputMismatchException;

import static Automation.engine.propertyWorks.PropertiesReader.ReadProperty;

public class PropertiesConnector {

    public static String ConnectToProperty(String PropertyFileName){

        try {
            String Property;
            Property = ReadProperty("src/main/resources/AutomationResources/PropertyFiles/PropertyPath.properties").getProperty(PropertyFileName);
            return Property;

        }catch(Exception e){e.getMessage();
            System.out.println("Unknown Error while using Engine properties connector");}

        return null;
    }

}
