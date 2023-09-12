package Automation.engine.gridWorks;

import Automation.engine.gridWorks.GridSetup;
import Automation.engine.propertyWorks.PropertyGetter;
import org.testng.ITestContext;
import org.testng.TestListenerAdapter;

public class HubBuilderByRun extends TestListenerAdapter {


    @Override
    public void onStart(ITestContext ITestContext){

            GridSetup.SetupGrid();

    }

}
