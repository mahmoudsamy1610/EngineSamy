package Automation.engine.helpers;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import io.qameta.allure.testng.Tag;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;

public class XmlReader {



    public static String ReadXml(String XmlRelativePath, String TagName, String AttName) {
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(XmlRelativePath);

            doc.getDocumentElement().normalize();
            NodeList testNodes = doc.getElementsByTagName(TagName);

            for (int i = 0; i < testNodes.getLength(); i++) {
                Element element = (Element) testNodes.item(i);

                String AttNameValue = element.getAttribute(AttName);
                System.out.println( "<" + TagName + "> " + AttName  + " : " + AttNameValue);

                return AttNameValue;
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("an Error occurred while reading this xml");
        }

        return  null ;
    }



}







