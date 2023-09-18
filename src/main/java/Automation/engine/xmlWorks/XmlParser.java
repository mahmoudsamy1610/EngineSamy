package Automation.engine.xmlWorks;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import Automation.engine.loggers.CoreJavaLogger;
import Automation.engine.loggers.EngineLogger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XmlParser {



    public static List<String> FindXmlAttributes(String XmlRelativePath, String TagName, String AttName) {
        CoreJavaLogger.CoreJavaInfo("Fetching list of attributes named : " + AttName + " ,using : " + TagName + " ,in file : " + XmlRelativePath );

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
                CoreJavaLogger.CoreJavaError("Cannot find attribute name : " + AttName + " ,from tag : " + TagName + " ,in file : " + XmlRelativePath);
                throw new NullPointerException();
            }



        } catch (Exception E) {
            CoreJavaLogger.CoreJavaExceptionError("Failed to find list of attributes named : " + AttName + " ,using : " + TagName + " ,in file : " + XmlRelativePath, E);
        }

        return AttNameValues;
    }


    public static String FindXmlAttribute(String XmlRelativePath, String TagName, String AttName){
        CoreJavaLogger.CoreJavaInfo("Fetching single attribute named : " + AttName + " ,using : " + TagName + " ,in file : " + XmlRelativePath );

        try {
            File xmlFile = new File(XmlRelativePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            Node node = doc.getElementsByTagName(TagName).item(0);
            Node attributeNode = null;


            if (node != null) {
                if (node.hasAttributes()) {
                    attributeNode = node.getAttributes().getNamedItem(AttName);
                    if (attributeNode != null) {
                        return attributeNode.getNodeValue();
                    } else {
                        CoreJavaLogger.CoreJavaError("Cannot find attribute name : " + AttName + " ,from tag : " + TagName + " ,in file : " + XmlRelativePath);
                        throw new NullPointerException();
                    }
                }
            }

        } catch (Exception E) {
            CoreJavaLogger.CoreJavaExceptionError("Failed to find attribute named : " + AttName + " ,using : " + TagName + " ,in file : " + XmlRelativePath, E);
        }

        return null;
    }



    public static List<String> FindXmlTags(String XmlRelativePath, String TagName) {
        CoreJavaLogger.CoreJavaInfo("Finding values of list of tags named : " + TagName + " ,in file : " + XmlRelativePath );


        List<String> values = new ArrayList<>();

        try {
            File xmlFile = new File(XmlRelativePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            NodeList nodeList = doc.getElementsByTagName(TagName);
            Node node = null;

            for (int i = 0; i < nodeList.getLength(); i++) {
                node = nodeList.item(i);
                values.add(node.getTextContent());
            }

            if (node.getTextContent().isBlank()) {
                CoreJavaLogger.CoreJavaError("Tag found : " + TagName + " , but has no tag values " + " ,in file : " + XmlRelativePath);
                throw new NullPointerException();
            }

        } catch (Exception E) {
            CoreJavaLogger.CoreJavaExceptionError("Failed to find list of tags named : " + TagName + " ,in file : " + XmlRelativePath, E);
        }

        return values;
    }




    public static String FindXmlTag(String XmlRelativePath, String TagName) {
        CoreJavaLogger.CoreJavaInfo("Finding value of single tag named : " + TagName + " ,in file : " + XmlRelativePath );

        String TagValue = null;
        try {
            File xmlFile = new File(XmlRelativePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            NodeList nodeList = doc.getElementsByTagName(TagName);

            if (nodeList != null) {
                TagValue = nodeList.item(0).getTextContent();
            }else {
                CoreJavaLogger.CoreJavaError("Tag found : " + TagName + " , but has no tag values " + " ,in file : " + XmlRelativePath);
                throw new NullPointerException();
            }

        } catch (Exception E) {
           CoreJavaLogger.CoreJavaExceptionError("Failed to find a tag named : " + TagName + " ,in file : " + XmlRelativePath, E);
        }

        return TagValue;
    }






    public static void main(String[] args) {
        try {
            FindXmlTag("src/test/resources/testSuites/Run.xml" , "suite-filea");
        }catch (Exception E){E.printStackTrace();}

    }


}







