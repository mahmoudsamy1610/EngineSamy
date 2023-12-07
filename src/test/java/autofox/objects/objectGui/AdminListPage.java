package autofox.objects.objectGui;

import automation.engine.elementWorks.ElementActions;
import automation.utils.loggers.BusinessLogger;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static automation.utils.tableWorks.TableDesigner.DesignTableRows;
import static automation.utils.tableWorks.TableDesigner.FillTableRow;

public class AdminListPage {
    //driver constructor
    public AdminListPage(WebDriver driver){this.driver = driver;}

    //initialization
    public WebDriver driver;
    AutofoxSideMenu autofoxSideMenu ;


    //Locators
    public static List<String> Columns = new ArrayList<>();



    public int GetColumnIndex(String ColumnName){

        Columns.add(0, "Null");
        Columns.add(1,"Status");
        Columns.add(2,"Email");
        Columns.add(3,"Role");
        Columns.add(4,"DayApproved");
        Columns.add(5,"TotalApproved");

        return Columns.indexOf(ColumnName);
    }

    public By GetCellLocator(int RowIndex , String ColumnName){
        int ColumnIndex = GetColumnIndex(ColumnName);
        return By.cssSelector("tr:nth-child("+RowIndex+") > td:nth-child("+ColumnIndex+")");
    }



    public String GetCellText(int RowIndex ,String ColumnName){

        By CellLocator = GetCellLocator(RowIndex , ColumnName);
        return ElementActions.GetElementText(driver,CellLocator , "Admin "+ColumnName+" at row : "+RowIndex );

    }



}
