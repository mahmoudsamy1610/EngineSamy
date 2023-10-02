package Automation.utils.xmlWorks;

import Automation.utils.loggers.JavaLogger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlElementGetter {

    public static List<Element> GetXmlElements(String XmlRelativePath, String ElementTagName) {

        JavaLogger.JavaInfo("Getting all Xml Elements of tag  : " + ElementTagName + " ,in file : " + XmlRelativePath);

        List<Element> DesiredElements = new ArrayList<>();

        try {
            File xmlFile = new File(XmlRelativePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList ElementNodeList = doc.getElementsByTagName(ElementTagName);


            for (int i = 0; i < ElementNodeList.getLength(); i++) {
              Node  ElementNode = ElementNodeList.item(i);
                if (ElementNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element DesiredElement = (Element) ElementNode;
                    DesiredElements.add(DesiredElement);
                }else {
                    JavaLogger.JavaError("Provided name to get xml Element is not correct : " + ElementTagName + " ,in file : " + XmlRelativePath);
                    throw new IOException();
                }
            }

        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed to find all Xml nodes that have Tag : " + ElementTagName + " ,in file : " + XmlRelativePath, E);
        }

        return DesiredElements;
    }


    public static Element PickElementByTagValue(String XmlRelativePath, String ElementTagName, String DefinerTagName, String DefinerTagValue) {

        JavaLogger.JavaInfo("Getting specific xml Element of tag  : " + ElementTagName + " ,in file : " + XmlRelativePath + " , using tag value : " + DefinerTagValue);

        List<Element> AllElements = XmlElementGetter.GetXmlElements(XmlRelativePath, ElementTagName);
        Element TargetElement = null;    
        
        try {
            for (Element Element : AllElements) {
                Node DefinerNode = Element.getElementsByTagName(DefinerTagName).item(0);
                String DefinerValue = DefinerNode.getTextContent();
                if (DefinerValue.equalsIgnoreCase(DefinerTagValue)) {
                    TargetElement = Element ;
                }
            }
        }catch (Exception E){
            JavaLogger.JavaExceptionError(" Failed Getting specific xml Element of tag  : " + ElementTagName + " ,in file : " + XmlRelativePath + " , using tag value : " + DefinerTagValue , E);

        }
        return TargetElement;
    }

    public static void main(String[] args) {
        String url = "pom.xml" ;
        String tagName = "profile";
        String definerName = "file" ;
        String definerValue = "src/test/resources/runFiles/RunConfig.run.xml" ;


    }

}