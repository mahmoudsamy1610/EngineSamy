package automation.utils.varWorks;

import automation.utils.loggers.JavaLogger;

import java.util.Random;

public class RandomDigitsGenerator {


    public static int GenerateRandomNumber(int NumberOfDigits) {
        JavaLogger.JavaInfo("Creating random number of digits count " + NumberOfDigits);

        try {
            int min = (int) Math.pow(10, NumberOfDigits - 1);
            int max = (int) Math.pow(10, NumberOfDigits) - 1;
            Random rand = new Random();
            int ResultRandom = rand.nextInt(max - min + 1) + min;

            if (ResultRandom == 0){
                JavaLogger.JavaError("Error occurred while generating random number of digits :  " + NumberOfDigits);
                throw new IllegalArgumentException();
            }

            return ResultRandom;

        }catch (Exception E){
            JavaLogger.JavaExceptionError("Failed Creating random number of digits count " + NumberOfDigits , E);
        }

      return 0 ;
    }


}
