package testData;

import org.testng.annotations.DataProvider;

public class StaticDataProvider {

    @DataProvider(name ="StaticProvider")
    public static Object [][] ProvideData(){

        String [][] DataArr = new String[][] {
                {"asda", "Asdasda" , "Asdasd"} ,
                {"asda"} ,
                {"ertetkerotk"}
        };
        return  DataArr;
    }

    public static void main(String[] args) {

        Object [][] DataArr = ProvideData() ;

        for(Object[] arr : DataArr ){
            for (Object str : arr) {
                System.out.println(str);
            }
        }

    }

}
