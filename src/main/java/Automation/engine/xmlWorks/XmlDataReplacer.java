package Automation.engine.xmlWorks;

import Automation.engine.propertyWorks.PropertyGetter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XmlDataReplacer {

    /*
    public static void ReplaceXmlData (String XmlRetalivePath , String PropertyFileName , String PropertyName , String TagName, String AttName ) throws IOException {

        //This method is no longer used .. as we need to send list of strings to line 22 instead of one string .. which will need a wrapping method with for loop


        byte[] XmlData = XmlReader.ReadXml(XmlRetalivePath) ;
        String xmlContent = new String(XmlData);

        // Replace attribute placeholders with values
        String PropertyValue = PropertyGetter.GetPropertyValue(PropertyFileName , PropertyName );
       List<String> PlaceHolder =  XmlParser.FindXmlData(XmlRetalivePath , TagName, AttName ) ;

        String ReplacedValue = xmlContent.replace(PlaceHolder, PropertyValue);

        // Write the modified XML content back to the file
        FileOutputStream outputFile = new FileOutputStream(XmlRetalivePath);
        outputFile.write(ReplacedValue.getBytes());
        outputFile.close();
    }



        */

}
