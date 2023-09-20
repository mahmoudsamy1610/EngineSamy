package Automation.utils.propertyWorks;

public class PropertiesConnector {

    public static String ConnectToProperty(String PropertyFileName) {
        //Loggers cannot be used here , as the Logger methods is using the properties library classes

        System.out.print("\u001B[34m"); //Blue
        System.out.println("Manual Logger Info : Streaming property file : " + PropertyFileName);
        System.out.print("\u001B[0m"); //default

        try {
            String Property;
            Property = PropertiesReader.ReadProperty("src/main/resources/AutomationResources/PropertyFiles/PropertyPath.properties").getProperty(PropertyFileName);
            if (Property != null) {
                return Property;
            } else {
                System.out.print("\u001B[35m"); //Purple
                System.out.println("Manual Logger Error : Provided property file name is invalid : " + PropertyFileName);
                System.out.print("\u001B[0m"); //default
                throw new NullPointerException();
            }

        } catch (Exception E) {
            E.printStackTrace();
            System.out.print("\u001B[35m"); //Purple
            System.out.println("Manual Logger Error : Provided property connector path is invalid : " + PropertyFileName);
            System.out.print("\u001B[0m"); //default
            return null;
        }
    }

    public static void main(String[] args) {
       System.out.println(ConnectToProperty("Environment1"));
    }

}
