package Automation.engine.helpers;

import java.util.List;

public class ArrayElementFinder {

        public static String FindArrayElement(List<String> List, String ElementToFind) {
            for (String element : List) {
                if (element.equals(ElementToFind)) {
                    return element;
                }
            }
            System.out.println("not included in the array");
            return null ;
        }




    }
