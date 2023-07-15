package Automation.engine;

import org.openqa.selenium.WebDriver;

public class RunningSpace {



    public static WebDriver SetRunningType( String BrowserType , String ExecutionType ) {


        if (ExecutionType.equalsIgnoreCase("Local") ) {
            return BrowserFactory.SetBrowserType(BrowserType);
        }
        else if (ExecutionType.equalsIgnoreCase("Grid")) {
            //System.out.println("Remote Implementation is not ready"); --> Implementing

           return GridManager.TakeToGrid();

        }else {
            System.out.println("invalid Execution type");
        }

        return null;

    }





}
