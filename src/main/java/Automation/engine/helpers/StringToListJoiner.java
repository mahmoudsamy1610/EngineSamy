package Automation.engine.helpers;

import Automation.engine.loggers.CoreJavaLogger;

import java.util.ArrayList;
import java.util.List;

public class StringToListJoiner {

    //Location is the location of the single string to be joind

    public static List<String> JoinStringToList(String StringToJoin, List<String> ListOfStrings, String Location) throws Exception {

        List<String> JoinedList = new ArrayList<>();
        String JoinedString = null;


        if (Location.equalsIgnoreCase("Suffix")) {
            CoreJavaLogger.CoreJavaInfo("Joining String : " + StringToJoin + " , After list of strings : " + ListOfStrings);

                for (String string : ListOfStrings) {
                    if (string != null && !string.isBlank() && StringToJoin != null && !StringToJoin.isBlank()) {
                    JoinedString = string + StringToJoin;
                    JoinedList.add(JoinedString);
                }else {
                        CoreJavaLogger.CoreJavaError("Failed Joining String : " + StringToJoin + " , After list of strings : " + ListOfStrings + " , because on or more value is null or blank");
                        throw new  NullPointerException() ;
                    }
            }



        } else if (Location.equalsIgnoreCase("Prefix")) {
            CoreJavaLogger.CoreJavaInfo("Joining String : " + StringToJoin + " , Before list of strings : " + ListOfStrings);


            for (String string : ListOfStrings) {
                if (string != null && !string.isBlank() && StringToJoin != null && !StringToJoin.isBlank()) {
                    JoinedString = StringToJoin + string;
                    JoinedList.add(JoinedString);
                } else {
                    CoreJavaLogger.CoreJavaError("Failed Joining String : " + StringToJoin + " , Before list of strings : " + ListOfStrings+ " , because on or more value is null or blank");
                    throw new  NullPointerException() ;
                }
            }
        }
        return JoinedList;
    }




    public static void main(String[] args) {

       List<String> list = List.of(new String[]{ "1", "2", "3"});

        try {
            System.out.println(JoinStringToList("asdasda" , list , "suffix")) ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
