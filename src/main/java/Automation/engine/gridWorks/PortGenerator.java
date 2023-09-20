package Automation.engine.gridWorks;

import Automation.engine.helpers.RandomDigitsGenerator;
import Automation.engine.loggers.EngineLogger;
import org.testng.Assert;

public class PortGenerator {

    public static int GenerateHubPort(int PortNumberOfDigits) {

        int Port = 0 ;
        try {
           Port = RandomDigitsGenerator.GenerateRandomNumber(PortNumberOfDigits);
            EngineLogger.EngineInfo("Generating node port from random number : " + Port);


        } catch (Exception E) {
            EngineLogger.EngineExceptionError("Failed Generating node port from random number", E);
            Assert.fail("Failed Generating node port from random number", E);
        }

        return Port;
    }

    public static void main(String[] args) {
        GenerateHubPort(5);
    }
}
