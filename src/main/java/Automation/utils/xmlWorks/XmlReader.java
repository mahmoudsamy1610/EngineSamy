package Automation.utils.xmlWorks;

import Automation.utils.loggers.JavaLogger;
import Automation.utils.loggers.EngineLogger;

import java.io.FileInputStream;

public class XmlReader {

    public static byte[] ReadXml (String XmlRetalivePath)  {
        JavaLogger.JavaInfo("Reading xml file from " + XmlRetalivePath );

        FileInputStream xmlFile ;
        try {
            xmlFile = new FileInputStream(XmlRetalivePath);
            byte[] xmlData = new byte[xmlFile.available()];
            xmlFile.read(xmlData);
            xmlFile.close();

            return xmlData;


        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed to read this XML file : " + XmlRetalivePath ,  E);
        }

        return new byte[0];
    }

    public static void main(String[] args) {
       ReadXml(null);
    }


}
