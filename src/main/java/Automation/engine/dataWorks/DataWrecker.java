package Automation.engine.dataWorks;

import Automation.utils.helpers.RandomDigitsGenerator;
import Automation.utils.helpers.StringConcatenator;
import Automation.utils.loggers.EngineLogger;

public class DataWrecker {


    public static String Wreck(String Data) {

        String WreckedData = null;
        String Wrecker = null;

        try {
            Wrecker = String.valueOf(RandomDigitsGenerator.GenerateRandomNumber(6));
            WreckedData = StringConcatenator.Concatenate(Wrecker, Data);

            EngineLogger.EngineInfo("Wrecking the provided string randomly : " + Data + " , with wrecker random string : " + Wrecker);

        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Wrecking the provided string randomly : " + Data + " , with wrecker random string : " + Wrecker, E);
        }

        return WreckedData;

    }


    public static void main(String[] args) {
        String ValidEmail =  DataFaker.FakeEmail();
        String InvalidEmail = Wreck(ValidEmail);
        System.out.println(InvalidEmail);
    }

}
