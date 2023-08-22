package Automation.engine.xmlWorks;

import Automation.engine.propertyWorks.PropertyGetter;

import java.io.FileOutputStream;
import java.io.IOException;

public class XmlDataReplacer {

    public static void ReplaceXmlData (String XmlRetalivePath , String PropertyFileName , String PropertyName , String TagName, String AttName ) throws IOException {

        byte[] XmlData = XmlReader.ReadXml(XmlRetalivePath) ;
        String xmlContent = new String(XmlData);

        // Replace attribute placeholders with values
        String PropertyValue = PropertyGetter.GetPropertyValue(PropertyFileName , PropertyName );
        String PlaceHolder =  XmlParser.FindXmlData(XmlRetalivePath , TagName, AttName ) ;

        String ReplacedValue = xmlContent.replace(PlaceHolder, PropertyValue);

        // Write the modified XML content back to the file
        FileOutputStream outputFile = new FileOutputStream(XmlRetalivePath);
        outputFile.write(ReplacedValue.getBytes());
        outputFile.close();
    }

}
