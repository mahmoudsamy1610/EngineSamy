package Automation.engine.xmlWorks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class XmlReader {

    public static byte[] ReadXml (String XmlRetalivePath)  {

        FileInputStream xmlFile = null;
        try {
            xmlFile = new FileInputStream(XmlRetalivePath);
            byte[] xmlData = new byte[xmlFile.available()];
            xmlFile.read(xmlData);
            xmlFile.close();

            return xmlData;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
