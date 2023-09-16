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
        Logger.info(Message);
        System.out.print("\u001B[0m");
    }

    public static void CoreJavaDebug(String Message){
        PropertyConfigurator.configure(Log4jPropPath);
        Logger.debug(Message);
    }

    public static void CoreJavaWarn(String Message){
        System.out.print("\u001B[33m"); //Yellow
        PropertyConfigurator.configure(Log4jPropPath);
        Logger.warn(Message);
        System.out.print("\u001B[0m");
    }

    public static void CoreJavaError(String Message){
        System.out.print("\u001B[31m"); //Red
        PropertyConfigurator.configure(Log4jPropPath);
        Logger.error(Message);
        System.out.print("\u001B[0m");
    }

    public static void CoreJavaExceptionError(String Message , Throwable Exception){
        System.out.print("\u001B[31m"); //Red
        PropertyConfigurator.configure(Log4jPropPath);
        Logger.error(Message , Exception);
        System.out.print("\u001B[0m");
    }



    public static void main(String[] args) {

    }
}
