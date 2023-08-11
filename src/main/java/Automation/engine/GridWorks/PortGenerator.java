package Automation.engine.GridWorks;

import Automation.engine.helpers.RandomDigitsGenerator;

public class PortGenerator {

    public static int GenerateHubPort(int PortNumberOfdigits){

        return RandomDigitsGenerator.GenerateRandomNumber(PortNumberOfdigits);

    }

}
