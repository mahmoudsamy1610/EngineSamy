package Automation.utils.xmlWorks;

import Automation.utils.loggers.JavaLogger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlAttValueGetter {
    public static List<String> FindXmlAttributeValues(String XmlRelativePath, String TagName, String AttName) {
        JavaLogger.JavaInfo("Fetching list of attributes named : " + AttName + " ,using : " + TagName + " ,in file : " + XmlRelativePath );

        List<String> AttNameValues = null;

        try {
            AttNameValues = new ArrayList<>();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(XmlRelativePath);
            doc.getDocumentElement().normalize();
            NodeList testNodes = doc.getElementsByTagName(TagName);
            String AttNameValue = null;

            if (testNodes != null) {
                for (int i = 0; i < testNodes.getLength(); i++) {
                    Element element = (Element) testNodes.item(i);
                    AttNameValue = element.getAttribute(AttName);
                    AttNameValues.add(AttNameValue);
                }
            }
            if (AttNameValue.isBlank()) {
                JavaLogger.JavaError("Cannot find attribute name : " + AttName + " ,from tag : " + TagName + " ,in file : " + XmlRelativePath);
                throw new NullPointerException();
            }



        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed to find list of attributes named : " + AttName + " ,using : " + TagName + " ,in file : " + XmlRelativePath, E);
        }

        return AttNameValues;
    }

    public static String FindXmlAttributeValue(String XmlRelativePath, String TagName, String AttName){
        JavaLogger.JavaInfo("Fetching single attribute named : " + AttName + " ,using tag name : " + TagName + " ,in file : " + XmlRelativePath);

        try {
            File xmlFile = new File(XmlRelativePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            Node node = doc.getElementsByTagName(TagName).item(0);
            Node attributeNode ;


            if (node != null) {
                if (node.hasAttributes()) {
                    attributeNode = node.getAttributes().getNamedItem(AttName);
                    if (attributeNode != null) {
                        return attributeNode.getNodeValue();
                    } else {
                        JavaLogger.JavaError("Cannot find attribute name : " + AttName + " ,from tag : " + TagName + " ,in file : " + XmlRelativePath);
                        throw new NullPointerException();
                    }
                }
            }

        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed to find attribute named : " + AttName + " ,using : " + TagName + " ,in file : " + XmlRelativePath, E);
        }

        return null;
    }


    public static String GetAttributeValueByAttName(String XmlRelativePath, String TagName, String AttName,String AttValue, String TargetAttName) {
        JavaLogger.JavaInfo("Getting value of  : " + TargetAttName + " ,using tag name : " + TagName + " ,in file : " + XmlRelativePath);

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(XmlRelativePath);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName(TagName);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    if (element.hasAttribute(AttName)
                            && element.getAttribute(AttName).equals(AttValue)) {
                        return element.getAttribute(TargetAttName);
                    }
                }
            }
        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed Getting value of  : " + TargetAttName + " ,using tag name : " + TagName + " ,in file : " + XmlRelativePath, E);
        }
        return null;
    }




    public static void main(String[] args) {
        //System.out.println( GetAttributeValueByAttName("src/test/resources/runFiles/RunConfig.run.xml","property" , "name" , "ExecutionType" , "value"));
    }

}
