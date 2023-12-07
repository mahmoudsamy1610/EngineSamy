package automation.utils.arrayWorks;

import automation.utils.loggers.JavaLogger;

import java.util.List;

public class ListToTwoDArrayConverter {


    public static String[][] ConvertListToTwoDArray(List<String> List1 ,List<String> List2){
        JavaLogger.JavaInfo("Receiving List and converting into Two Dimensional array ");

        int Rows = List1.size();
        int Cols = 2;
        String[][] TwoDArray = new String[Rows][Cols];
        try {
            for (int i = 0; i < Rows; i++) {
                TwoDArray[i][0] = List1.get(i);
                TwoDArray[i][1] = List2.get(i);
                //Here you managed to gather the two columns of the first row ONLY

            }
            for (String[] row : TwoDArray) {
                for (String cell : row) {
                    System.out.print(cell + "\t");
                }
                JavaLogger.JavaInfo("Two dimensional array created ");
            }

        }catch (Exception E){
            JavaLogger.JavaExceptionError("Failed receiving List and converting into Two Dimensional array : " + TwoDArray  , E);
        }
    return TwoDArray;
    }


    public static void main(String[] args) {

        List<String> platforms = List.of("Windows", "Linux", "Windows");
        List<String> browsers = List.of("Chrome", "Firefox", "Edge");
        String[][] twoDArray = ConvertListToTwoDArray(platforms, browsers);

    }

}
