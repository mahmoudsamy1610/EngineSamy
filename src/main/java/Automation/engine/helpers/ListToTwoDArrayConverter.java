package Automation.engine.helpers;

import java.util.List;

public class ListToTwoDArrayConverter {


    public static String[][] ConvertListToTwoDArray(List<String> List1 ,List<String> List2){

        int Rows = List1.size();
        int Cols = 2;

        String[][] TwoDArray = new String[Rows][Cols];

        for (int i=0; i<Rows; i++){
            TwoDArray[i][0] = List1.get(i);
            TwoDArray[i][1] = List2.get(i);
            //Here you managed to gather the two columns of the first row
        }
    return TwoDArray;
    }


    public static void main(String[] args) {

        List<String> platforms = List.of("Windows", "Linux", "Windows");
        List<String> browsers = List.of("Chrome", "Firefox", "Edge");
        String[][] twoDArray = ConvertListToTwoDArray(platforms, browsers);
        for (String[] row : twoDArray) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }

        }
    }

}
