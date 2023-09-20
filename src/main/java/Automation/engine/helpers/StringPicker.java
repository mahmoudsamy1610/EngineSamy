package Automation.engine.helpers;

import Automation.engine.loggers.JavaLogger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringPicker {


    public static String PickString(String InputString , String Definers) {
        JavaLogger.JavaInfo("Fetching string : " + Definers+ " , to pick up from string : " + InputString);

        try {
            Pattern InputPattern = Pattern.compile(Definers);
           Matcher StringMatcher = InputPattern.matcher(InputString);
            if (StringMatcher.find()) {
                String PickedString = StringMatcher.group();
                return PickedString;
            }
        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed fetching string : " + Definers+ " , to pick up from string : " + InputString , E);
        }

        return null;
    }

    /**
     * Example for picking.
     * <p>String longString = "This is a long string containing some text."
     * <p>String extracted = extractSubstring(longString, "long.*text"); // Extract "long string containing some "
     */


    public static String ExtractString(String InputString , int StartIndex , int EndIndex){
        //Start index is excluded , End index in included
        JavaLogger.JavaInfo("Extracting sub string starting from digit index : " + StartIndex+ " , to digit index : " + EndIndex);


        try {
            String ExtractedString = InputString.substring(StartIndex , EndIndex);

            return ExtractedString;

        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed extracting sub string starting from digit index : " + StartIndex+ " , to digit index : " + EndIndex + InputString , E);
        }
        return null;
    }




    public static void main(String[] args) {
        String input = PickString("helloIamtestingthismethod" , "am.*method");
        ExtractString(input , 3 ,50);
    }

}

