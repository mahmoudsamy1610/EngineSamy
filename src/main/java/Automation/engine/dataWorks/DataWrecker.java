package Automation.engine.dataWorks;

import Automation.engine.helpers.RandomDigitsGenerator;
import Automation.engine.helpers.StringConcatenator;

public class DataWrecker {


    public static String Wreck(String Data) {

        String WreckedData = null;

        try {
            String Wrecker = String.valueOf(RandomDigitsGenerator.GenerateRandomNumber(6));
            WreckedData = StringConcatenator.Concatenate(Wrecker, Data);
        } catch (Exception E) {
            E.printStackTrace();
        }

        return WreckedData;

    }


    public static void main(String[] args) {
        String ValidEmail =  DataFaker.FakeEmail();
        String InvalidEmail = Wreck(ValidEmail);
        System.out.println(InvalidEmail);
    }

}
