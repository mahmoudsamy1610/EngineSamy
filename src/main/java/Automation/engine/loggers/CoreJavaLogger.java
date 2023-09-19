package Automation.engine.loggers;

import Automation.engine.propertyWorks.PropertyGetter;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoreJavaLogger {

   public static String Log4jPropPath = PropertyGetter.GetPropertyValue( "PropertyPath", "Log4j") ;

    public static Logger Logger = LoggerFactory.getLogger(CoreJavaLogger.class);


    public static void CoreJavaInfo(String Message){
        System.out.print("\u001B[32m"); //Green
        PropertyConfigurator.configure(Log4jPropPath);
        int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
        Logger.info(Line+" : "+Message);
        System.out.print("\u001B[0m");
    }

    public static void CoreJavaDebug(String Message){
        PropertyConfigurator.configure(Log4jPropPath);
        int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
        Logger.debug(Line+" : "+Message);
    }

    public static void CoreJavaWarn(String Message){
        System.out.print("\u001B[33m"); //Yellow
        PropertyConfigurator.configure(Log4jPropPath);
        int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
        Logger.warn(Line+" : "+Message);
        System.out.print("\u001B[0m");
    }

    public static void CoreJavaError(String Message){
        System.out.print("\u001B[31m"); //Red
        PropertyConfigurator.configure(Log4jPropPath);
        int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
        Logger.error(Line+" : "+Message);
        System.out.print("\u001B[0m");
    }

    public static void CoreJavaExceptionError(String Message , Throwable Exception){
        System.out.print("\u001B[31m"); //Red
        PropertyConfigurator.configure(Log4jPropPath);
        int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
        Logger.error(Line+" : "+Message , Exception);
        System.out.print("\u001B[0m");
    }



    public static void main(String[] args) {

    }
}
