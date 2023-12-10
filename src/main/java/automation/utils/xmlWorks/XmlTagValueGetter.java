package automation.utils.xmlWorks;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import automation.utils.loggers.JavaLogger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XmlTagValueGetter {


    public static List<String> FindXmlTagValues(String XmlRelativePath, String TagName) {
        JavaLogger.JavaInfo("Finding values of list of tags named : " + TagName + " ,in file : " + XmlRelativePath );


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
                JavaLogger.JavaError("Tag found : " + TagName + " , but has no tag values " + " ,in file : " + XmlRelativePath);
                throw new NullPointerException();
            }

        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed to find list of tags named : " + TagName + " ,in file : " + XmlRelativePath, E);
        }

        return values;
    }




    public static String FindXmlTagValue(String XmlRelativePath, String TagName) {
        JavaLogger.JavaInfo("Finding value of single tag named : " + TagName + " ,in file : " + XmlRelativePath );

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
                JavaLogger.JavaError("Tag found : " + TagName + " , but has no tag values " + " ,in file : " + XmlRelativePath);
                throw new NullPointerException();
            }

        } catch (Exception E) {
           JavaLogger.JavaExceptionError("Failed to find a tag named : " + TagName + " ,in file : " + XmlRelativePath, E);
        }

        return TagValue;
    }


        public static String GetAdjacentXmlTagValue(String XmlRelativePath , String ElementTagName , String DefinerTagName , String DefinerTageValue , String TargetTagName) {

        JavaLogger.JavaInfo("Finding xml tag value picked using adjacent tag value : " + DefinerTageValue + " ,in file : " + XmlRelativePath );

        try {
            Element TargetElement = XmlElementGetter.PickElementByTagValue(XmlRelativePath, ElementTagName, DefinerTagName, DefinerTageValue);
            Node TargetNode = TargetElement.getElementsByTagName(TargetTagName).item(0);
            String TargetNodeValue = TargetNode.getTextContent();
            return TargetNodeValue;
        }catch (Exception E){
                JavaLogger.JavaExceptionError("Failed Finding xml tag value picked using adjacent tag value : " + DefinerTageValue + " ,in file : " + XmlRelativePath , E );
            }
        return null;
        }





    public static void main(String[] args) {


    }


}







