package Automation.engine.helpers;

import java.util.ArrayList;
import java.util.List;

public class StringToListJoiner {

    //Location is the location of the single string to be joind

    public static List<String> JoinStringToList(String StringToJoin, List<String> ListOfStrings, String Location) {

        List<String> JoinedList = new ArrayList<>();


        if (Location.equalsIgnoreCase("Suffix")) {

            String JoinedString;
            JoinedList = new ArrayList<>();

            for (String string : ListOfStrings) {

                JoinedString = string + StringToJoin;
                JoinedList.add(JoinedString);

            }

        } else if (Location.equalsIgnoreCase("Prefix")) {

            String JoinedString;


            for (String string : ListOfStrings) {

                JoinedString = StringToJoin + string;
                JoinedList.add(JoinedString);

            }

        }
        return JoinedList;
    }




    public static void main(String[] args) {

       List<String> list = List.of(new String[]{"1", "2", "3"});

       System.out.println(JoinStringToList("+suffix" , list , "prefix")) ;

    }


}
