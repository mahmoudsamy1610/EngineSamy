package Autofox.tools;
import Automation.engine.Logger;

import java.io.IOException;
import java.util.InputMismatchException;

import static Automation.engine.PropertiesReader.LoadProperty;

public class AutofoxPropertyConnector {


    public static String ConnectToAutofoxProperty(String PropertyFileName){

        String ConnectorProperty = null;
        try{

            ConnectorProperty=  LoadProperty("src/main/resources/AutofoxResources/AutofoxPropertyPath.properties").getProperty(PropertyFileName);}

        catch (InputMismatchException IME) {IME.getMessage();
            System.out.println("Invalid input Autofox Connector property file path");}
        catch(Exception e){e.getMessage();
            System.out.println("Unknown Error while using Autofox properties connector");}

        return ConnectorProperty;
    }

}
