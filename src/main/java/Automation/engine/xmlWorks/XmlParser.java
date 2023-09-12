package Automation.engine.xmlWorks;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import Automation.engine.propertyWorks.PropertyGetter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XmlParser {



    public static List<String> FindXmlAttributes(String XmlRelativePath, String TagName, String AttName) {

        List<String> AttNameValues = new ArrayList<>();
        try {
            AttNameValues = new ArrayList<>();


            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(XmlRelativePath);

            doc.getDocumentElement().normalize();
            NodeList testNodes = doc.getElementsByTagName(TagName);

            for (int i = 0; i < testNodes.getLength(); i++) {
                Element element = (Element) testNodes.item(i);
                String AttNameValue = element.getAttribute(AttName);
                //System.out.println("<" + TagName + "> " + AttName + " : " + AttNameValue);
                AttNameValues.add(AttNameValue);

            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("an Error occurred while reading this xml");
        }

        return AttNameValues;
    }


    public static String FindXmlAttribute(String XmlRelativePath, String TagName, String AttName){

        try {
            File xmlFile = new File(XmlRelativePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            Node node = doc.getElementsByTagName(TagName).item(0);

            if (node != null) {
                if (node.hasAttributes()) {
                    Node attributeNode = node.getAttributes().getNamedItem(AttName);
                    if (attributeNode != null) {
                        return attributeNode.getNodeValue();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null; // Tag, attribute, or XML file not found or error occurred
    }



    public static List<String> FindXmlTags(String XmlRelativePath, String TagName) {
        List<String> values = new ArrayList<>();

        try {
            File xmlFile = new File(XmlRelativePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            NodeList nodeList = doc.getElementsByTagName(TagName);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                values.add(node.getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return values;
    }




    public static String FindXmlTag(String XmlRelativePath, String TagName) {

        String TagValue = null;
        try {
            File xmlFile = new File(XmlRelativePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            NodeList nodeList = doc.getElementsByTagName(TagName);

            TagValue = nodeList.item(0).getTextContent();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return TagValue;
    }






    public static void main(String[] args) {
        String PomRelativePath = PropertyGetter.GetPropertyValue("RunOptions" , "PomRelativePath");

       System.out.println(FindXmlTag(PomRelativePath , "parallel"  ));
    }


}







