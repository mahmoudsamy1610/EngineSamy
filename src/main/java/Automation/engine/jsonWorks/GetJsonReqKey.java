package Automation.engine.jsonWorks;

import Automation.engine.helpers.ArrayElementFinder;

import java.util.List;

public class GetJsonReqKey {

    public static String GetJsonKey(String JsonFileName ,String JsonKeyName , String RequiredValue) {

        List<String> List = GetJsonDuplicateKeys.GetJsonDuplicateKeys(JsonFileName,JsonKeyName);
        String KeyValue = ArrayElementFinder.FindArrayElement(List, RequiredValue);
        return KeyValue;

    }


    public static void main(String[] args) {
        String reqvalue = "Login4";
        //List<String> ArrayList = GetAllJsonKeys.GetJsonKeyValue("TimeSavingModule", "Browser");
        //System.out.println(ArrayList);
        System.out.println(GetJsonKey("TimeSavingModule" , "Suite" ,reqvalue));



    }
}
