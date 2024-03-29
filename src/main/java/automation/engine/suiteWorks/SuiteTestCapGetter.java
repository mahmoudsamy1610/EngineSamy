package automation.engine.suiteWorks;

import automation.engine.config.ConfigParaModule;
import automation.utils.jsonWorks.GetJsonValueByKey;
import automation.utils.loggers.JavaLogger;

import java.util.ArrayList;
import java.util.List;

public class SuiteTestCapGetter {


    public static List<String> CatchPlatforms(String Catcher) {

        List<String> NodePlatformTypes = new ArrayList<>();
        String ParaModule = null;

        try {
            ParaModule = ConfigParaModule.GetParaModule();
            NodePlatformTypes = (GetJsonValueByKey.GetValueByContainerKey("Platform", ParaModule, Catcher));

        } catch (Exception E) {
            JavaLogger.JavaExceptionError("No platform value found in parallel module : " + ParaModule+ " , using this catcher : " +Catcher , E);
        }
        if (NodePlatformTypes.isEmpty()){
            JavaLogger.JavaError("Cannot find any platform results from module : " + ParaModule+ " , using this catcher : " +Catcher);
            throw new NullPointerException();
        }

        return NodePlatformTypes;

    }

    public static List<String> CatchBrowsers(String Catcher) {

        List<String> NodeBrowserTypes = new ArrayList<>();
        String ParaModule = null;

        try {
            ParaModule = ConfigParaModule.GetParaModule();
            NodeBrowserTypes = GetJsonValueByKey.GetValueByContainerKey("Browser", ParaModule, Catcher);

        } catch (Exception E) {
            JavaLogger.JavaExceptionError("No browser value found in parallel module : " + ParaModule+ " , using this catcher : " +Catcher , E);
        }
        if (NodeBrowserTypes.isEmpty()){
            JavaLogger.JavaError("Cannot find any platform results from module : " + ParaModule+ " , using this catcher : " +Catcher);
            throw new NullPointerException();
        }
        return NodeBrowserTypes;

    }






    public static void main(String[] args) {


    }

}


