package Automation.utils.helpers;

import Automation.utils.loggers.JavaLogger;

public class StringConcatenator {

    public static String Concatenate(String MainString , String... Strings) {

        StringBuilder Output = new StringBuilder();
        String FullOutput = null;
        JavaLogger.JavaInfo("Concatenating the following strings : " + Output + " , on the main string : " + MainString);


        try {
            for (String string : Strings) {
                Output.append(string);
            }
            FullOutput = MainString + Output;
        } catch (Exception E) {
            E.printStackTrace();
        }

        if (Output.toString() == null || Output.toString().isBlank()) {
            JavaLogger.JavaError("Failed Concatenating as the following strings : " + Output + " ,is emtpy or null");
            throw new NullPointerException();

        }if (MainString.isBlank() || MainString == null){
            JavaLogger.JavaError("Failed Concatenating as the following string : " + MainString + " ,is emtpy or null");
            throw new NullPointerException();

        }
        return FullOutput;
    }




    public static void main(String[] args) {

        System.out.println(Concatenate("asad" ));

    }


}
