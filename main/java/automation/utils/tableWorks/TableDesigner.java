package automation.utils.tableWorks;


import com.google.common.collect.Table;

import java.util.*;

public class TableDesigner {


    public static List<Map<Integer , String[]>> DesignTableRows(int RowsCount){

        List <List<Map<Integer , String[]>>> Table = new ArrayList<>();
        List<Map<Integer , String[]>> RowDesign = new ArrayList<>() ;

        while (Table.size() < RowsCount ){
                 for (List<Map<Integer , String[]>> Row : Table){
                        Table.add(Row);
                        RowDesign = Row ;
                    }
        }
            return RowDesign ;
    }

    public static Map<Integer , String[]> FillTableRow(List<Map<Integer , String[]>> Row , Integer ColumnNumber , String... RowData){

        Map<Integer , String[]> CellDesign = new HashMap<>();

        while (Row.size() < ColumnNumber ){
            for (Map<Integer , String[]> Cell : Row){
                for (String CellData : RowData) {
                    Cell.put(ColumnNumber, RowData);
                        CellDesign = Cell ;
                }
            }
        }
        return CellDesign ;

    }

        //Neglected as BETTER solutions were found
    // planned to be made working
    public static void main(String[] args) {
        List<Map<Integer , String[]>> Rows = DesignTableRows(5);
          Map<Integer , String[]> Cells = FillTableRow(Rows, 3 , "cell1", "cell2", "cell3");
          String[] Cell= Cells.get(2);
          System.out.println(Arrays.toString(Cell));


    }


}
