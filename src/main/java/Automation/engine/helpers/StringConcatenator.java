package Automation.engine.helpers;

public class StringConcatenator {

    public static String Concatenate(String... Strings) {

        StringBuilder Output = new StringBuilder();
        try {
            for (String string : Strings) {
                Output.append(string);
            }
        }catch (Exception E) {
            E.printStackTrace();
        }
        return Output.toString();
    }




    public static void main(String[] args) {

        System.out.println(Concatenate("asda" , "asdas" , "asdasdasdasdadsa"));

    }


}
