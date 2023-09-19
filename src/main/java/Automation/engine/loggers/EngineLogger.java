package Automation.engine.loggers;

import Automation.engine.propertyWorks.PropertyGetter;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EngineLogger {

   public static String Log4jPropPath = PropertyGetter.GetPropertyValue( "PropertyPath", "Log4j") ;
    public static Logger Logger = LoggerFactory.getLogger(EngineLogger.class);




    public static void EngineInfo(String Message){
        System.out.print("\u001B[34m"); //Blue
        PropertyConfigurator.configure(Log4jPropPath);
        int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
        Logger.info(Line+" : "+Message);
        System.out.print("\u001B[0m");
    }

    public static void EngineDebug(String Message){
        int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
        Logger.debug(Line+" : "+Message);
    }

    public static void EngineWarn(String Message){
        System.out.print("\u001B[33m"); //Yellow
        PropertyConfigurator.configure(Log4jPropPath);
        int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
        Logger.warn(Line+" : "+Message);
        System.out.print("\u001B[0m");
    }

    public static void EngineError(String Message){
        System.out.print("\u001B[35m"); //Purple
        PropertyConfigurator.configure(Log4jPropPath);
        int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
        Logger.error(Line+" : "+Message);
        System.out.print("\u001B[0m");
    }

    public static void EngineExceptionError(String Message , Throwable Exception){
        System.out.print("\u001B[35m"); //Purple
        PropertyConfigurator.configure(Log4jPropPath);
        int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
        Logger.error(Line+" : "+Message , Exception);
        System.out.print("\u001B[0m");
    }


}
