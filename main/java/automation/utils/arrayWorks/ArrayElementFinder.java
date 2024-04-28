package automation.utils.arrayWorks;

import automation.utils.loggers.JavaLogger;

import java.util.List;

public class ArrayElementFinder {

        public static String FindArrayElement(List<String> List, String ElementToFind) {
            JavaLogger.JavaInfo("Picking a specific array element : " + ElementToFind);

            try {
                for (String element : List) {
                    if (element.equals(ElementToFind)) {
                        return element;
                    }else {
                        JavaLogger.JavaError("Array element is not found : " + ElementToFind);
                        throw new NullPointerException();
                    }
                }
            }catch (Exception E){
                JavaLogger.JavaExceptionError("Failed Picking a specific array element : " + ElementToFind , E);
            }

            return null ;
        }


    }
