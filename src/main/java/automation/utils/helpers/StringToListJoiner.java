package automation.utils.helpers;

import automation.utils.loggers.JavaLogger;

import java.util.ArrayList;
import java.util.List;

public class StringToListJoiner {

    //Location is the location of the single string to be joind

    public static List<String> JoinStringToList(String StringToJoin, List<String> ListOfStrings, String Location)  {

        List<String> JoinedList = new ArrayList<>();
        String JoinedString ;


        if (Location.equalsIgnoreCase("Suffix")) {
            JavaLogger.JavaInfo("Joining String : " + StringToJoin + " , After list of strings : " + ListOfStrings);

                for (String string : ListOfStrings) {
                    if (string != null && !string.isBlank() && StringToJoin != null && !StringToJoin.isBlank()) {
                    JoinedString = string + StringToJoin;
                    JoinedList.add(JoinedString);
                }else {
                        JavaLogger.JavaError("Failed Joining String : " + StringToJoin + " , After list of strings : " + ListOfStrings + " , because on or more value is null or blank");
                        throw new  NullPointerException() ;
                    }
            }



        } else if (Location.equalsIgnoreCase("Prefix")) {
            JavaLogger.JavaInfo("Joining String : " + StringToJoin + " , Before list of strings : " + ListOfStrings);


            for (String string : ListOfStrings) {
                if (string != null && !string.isBlank() && StringToJoin != null && !StringToJoin.isBlank()) {
                    JoinedString = StringToJoin + string;
                    JoinedList.add(JoinedString);
                } else {
                    JavaLogger.JavaError("Failed Joining String : " + StringToJoin + " , Before list of strings : " + ListOfStrings+ " , because on or more value is null or blank");
                    throw new  NullPointerException() ;
                }
            }
        }
        return JoinedList;
    }


}
