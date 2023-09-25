package Automation.utils.helpers;

import Automation.utils.loggers.JavaLogger;

import java.util.ArrayList;
import java.util.List;
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

    /**
     * Example for extracting.
     * <p>String input = PickString("helloIamtestingthismethod" , "am.*method");
     * <p> ExtractString(input , 3 ,50); --->  result = estingt
     */

    public static List<String> ExtractStringsOfVariableLength(List <String> InputStrings , int StartIndex ) {
        //Start index is excluded , End index in included

        List<String> ExtractedStrings = new ArrayList<>();
        String ExtractedString = null ;

        try {
            for (String InputString : InputStrings) {
                int Length = InputString.length();
                ExtractedString = InputString.substring(StartIndex, Length);
                ExtractedStrings.add(ExtractedString);
                JavaLogger.JavaInfo("Extracting sub strings starting from digit index : " + StartIndex + " , to end of text of :  " + InputString);

            }

        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed extracting sub string starting from digit index : " + StartIndex + " , to end of text "+ InputStrings.toString(), E);
        }
        return ExtractedStrings;
    }

    public static String ExtractStringOfVariableLength(String InputString , int StartIndex ){
        //Start index is excluded , End index in included
        JavaLogger.JavaInfo("Extracting sub string starting from digit index : " + StartIndex+ " , to digit index to its end " );


        try {
            int Length = InputString.length();
            String ExtractedString = InputString.substring(StartIndex , Length);
            return ExtractedString;

        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed extracting sub string starting from digit index : " + StartIndex+ " , to its end " + InputString , E);
        }
        return null;
    }



    public static void main(String[] args) {
        //String input = PickString("helloIamtestingthismethod" , "am.*method");
        List <String> inputs = List.of(new String[]{"[poaosfjskfnds]", "uydiasdnbsakld a" , "uastdaysdnaksd"});
        System.out.println( ExtractStringsOfVariableLength(inputs , 3 ));
    }

}

