package Automation.engine.xmlWorks;

import Automation.engine.loggers.CoreJavaLogger;
import Automation.engine.loggers.EngineLogger;

import java.io.FileInputStream;

public class XmlReader {

    public static byte[] ReadXml (String XmlRetalivePath)  {
        CoreJavaLogger.CoreJavaInfo("Reading xml file from " + XmlRetalivePath );

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
