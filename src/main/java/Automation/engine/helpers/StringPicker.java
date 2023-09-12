package Automation.engine.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPicker {


    public static String PickString(String InputString , String Definers) {

        try {

            Pattern InputPattern = Pattern.compile(Definers);
           Matcher StringMatcher = InputPattern.matcher(InputString);
            if (StringMatcher.find()) {
                String PickedString = StringMatcher.group();
                return PickedString;
            }
        } catch (IllegalArgumentException IAE) {
            IAE.getMessage();
        }

        return null;
    }


    public static String ExtractString(String InputString , int StartIndex , int EndIndex){

        //Start index is excluded , End index in included
        try {
            String ExtractedString = InputString.substring(StartIndex , EndIndex);

            return ExtractedString;

        } catch (IllegalArgumentException IAE) {
            IAE.getMessage();
        }
        return null;
    }




    public static void main(String[] args) {
        String input = PickString("helloIamtestingthismethod" , "am.*method");
        ExtractString(input , 3 ,8);
    }

}


/*
Example for picking
String longString = "This is a long string containing some text.";
 String extracted = extractSubstring(longString, "long.*text"); // Extract "long string containing some "


 */