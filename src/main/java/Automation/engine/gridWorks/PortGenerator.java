package Automation.engine.gridWorks;

import Automation.engine.helpers.RandomDigitsGenerator;
import Automation.engine.loggers.Loggers;
import org.testng.Assert;

import javax.sound.sampled.Port;

public class PortGenerator {

    public static int GenerateHubPort(int PortNumberOfDigits) {

        int Port = 0 ;
        try {
           Port = RandomDigitsGenerator.GenerateRandomNumber(PortNumberOfDigits);
            Loggers.Info("Generating node port from random number : " + Port);


        } catch (Exception E) {
            Loggers.ExceptionError("Failed Generating node port from random number", E);
            Assert.fail("Failed Generating node port from random number", E);
        }

        return Port;
    }

    public static void main(String[] args) {
        GenerateHubPort(5);
    }
}
