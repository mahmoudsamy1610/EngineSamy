package Automation.engine.xmlWorks;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class XmlParser {



    public static List<String> FindXmlAttributes(String XmlRelativePath, String TagName, String AttName) {

        List<String> AttNameValues = null;
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

    public static void main(String[] args) {

        FindXmlAttributes("src/test/resources/testSuites/Login.xml" , "test" , "name");
    }


}







