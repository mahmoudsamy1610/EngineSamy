package Automation.utils.propertyWorks;


public class PropertyGetter {

        public static String GetPropertyValue(String PropertyFileName , String PropertyKey ) {
            //Loggers cannot be used here , as the Logger methods is using the properties library classes
            int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
            String ClassName = new Throwable().getStackTrace()[1].getClassName();

            System.out.print("\u001B[34m"); //
            System.out.println("Manual Logger - Info : "+ ClassName+" - "+Line+ " : catching property key : " + PropertyKey+ " , from property file : " + PropertyFileName);
            System.out.print("\u001B[0m"); //default

            String PropertyValue = null;

            try {
                String  PropertyFilePath = PropertiesConnector.ConnectToProperty(PropertyFileName);
                PropertyValue =  PropertiesReader.ReadProperty(PropertyFilePath).getProperty(PropertyKey);
                
            } catch(Exception e){e.getMessage();
                System.out.println("Manual Logger - Error" + ClassName+" - "+Line+  " : Unknown Error while catching engine properties Path for " + PropertyFileName);}

            if (PropertyValue != null) {
                return PropertyValue;
            }else {
                System.out.print("\u001B[35m"); //Purple
                System.out.println("Manual Logger Error : "+ ClassName+" - "+Line+ " : Cannot find property key : " + PropertyKey+ " , from property file : " + PropertyFileName);
                System.out.print("\u001B[0m"); //default
                throw new NullPointerException();
            }
        }

    public static void main(String[] args) {
        try {
            System.out.println(GetPropertyValue("Environment", "HomeDev1"));
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

}
