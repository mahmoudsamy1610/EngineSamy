package Automation.engine.reportingworks;

import Automation.engine.helpers.DirCleaner;

public class AllureResultsCleaner {


    public static void CleanAllurePreviousResults(String AllureResultsDir) {

        try {
            DirCleaner.CleanDir(AllureResultsDir);
         } catch (IllegalArgumentException IAE){IAE.getMessage();}
        }


    }
