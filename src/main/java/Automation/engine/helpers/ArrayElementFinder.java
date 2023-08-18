package Automation.engine.helpers;
import Automation.engine.jsonWorks.GetJsonDuplicateKeys;

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


    public static void main(String[] args) {
        String ElementToFind = "Login4" ;
        List<String> ArrayList = GetJsonDuplicateKeys.GetJsonDuplicateKeys("TimeSavingModule" , "Suite");
        System.out.println(ArrayList);
        System.out.println(FindArrayElement(ArrayList , ElementToFind));

    }

    }
