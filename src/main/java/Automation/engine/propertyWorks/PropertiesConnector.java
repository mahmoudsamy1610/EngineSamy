package Automation.engine.propertyWorks;
import java.util.InputMismatchException;

import static Automation.engine.propertyWorks.PropertiesReader.LoadProperty;

public class PropertiesConnector {

    public static String ConnectToProperty(String PropertyFileName){

        try {
            String Property;
            Property = LoadProperty("src/main/resources/AutomationResources/PropertyFiles/PropertyPath.properties").getProperty(PropertyFileName);
            return Property;
        }


        catch (InputMismatchException IME) {IME.getMessage();
            System.out.println("Invalid input Engine Connector property file path");}
        catch(Exception e){e.getMessage();
            System.out.println("Unknown Error while using Engine properties connector");}

        return null;
    }

}
