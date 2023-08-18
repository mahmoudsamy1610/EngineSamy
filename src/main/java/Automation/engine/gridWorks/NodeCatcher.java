package Automation.engine.gridWorks;

import Automation.engine.jsonWorks.GetJsonDuplicateKeys;
import Automation.engine.suiteWorks.SuiteNameGetter;

import java.util.List;

public class NodeCatcher {

    public static String CatchPlatform(String XmlRelativePath , String TagName , String AttName , String JsonFileName) {

        String XmlSuiteName = SuiteNameGetter.GetSuiteName(XmlRelativePath, TagName, AttName);
        List<String> JsonSuiteNames = GetJsonDuplicateKeys.GetJsonDuplicateKeys(JsonFileName, "Suite");
       // String JsonSuiteName = GetJsonKey.GetJsonKey(JsonSuiteNames, XmlSuiteName);
        String NodePlatformType = null;

        //if (JsonSuiteName != null) {

        //}
        return null;
    }
    }


