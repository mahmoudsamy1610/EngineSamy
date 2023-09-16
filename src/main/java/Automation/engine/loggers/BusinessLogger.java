package Automation.engine.loggers;

import Automation.engine.propertyWorks.PropertyGetter;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BusinessLogger {

   public static String Log4jPropPath = PropertyGetter.GetPropertyValue( "PropertyPath", "Log4j") ;

    public static Logger Logger = LoggerFactory.getLogger(BusinessLogger.class);


    public static void  BusinessInfo(String Message){
        PropertyConfigurator.configure(Log4jPropPath);
        Logger.info(Message);
    }

    public static void  BusinessDebug(String Message){
        PropertyConfigurator.configure(Log4jPropPath);
        Logger.debug(Message);
    }

    public static void  BusinessWarn(String Message){
        System.out.print("\u001B[33m"); //Yellow
        PropertyConfigurator.configure(Log4jPropPath);
        Logger.warn(Message);
        System.out.print("\u001B[0m");
    }

    public static void  BusinessError(String Message){
        System.out.print("\u001B[36m"); //Cyan
        PropertyConfigurator.configure(Log4jPropPath);
        Logger.error(Message);
        System.out.print("\u001B[0m");
    }

    public static void  BusinessExceptionError(String Message , Throwable Exception){
        System.out.print("\u001B[36m"); //Cyan
        PropertyConfigurator.configure(Log4jPropPath);
        Logger.error(Message , Exception);
        System.out.print("\u001B[0m");
    }



    public static void main(String[] args) {

    }
}
