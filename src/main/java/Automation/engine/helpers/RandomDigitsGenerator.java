package Automation.engine.helpers;

import java.util.Random;

public class RandomDigitsGenerator {


    public static int GenerateRandomNumber(int NumberOfDigits) {


        try {
            int min = (int) Math.pow(10, NumberOfDigits - 1);
            int max = (int) Math.pow(10, NumberOfDigits) - 1;

            Random rand = new Random();
            return rand.nextInt(max - min + 1) + min;

        }catch (IllegalArgumentException IAE){IAE.getMessage();}

      return 0 ;
    }


}
