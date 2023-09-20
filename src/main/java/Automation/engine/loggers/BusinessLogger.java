package Automation.engine.loggers;

import Automation.engine.propertyWorks.PropertyGetter;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BusinessLogger {

   public static String Log4jPropPath = PropertyGetter.GetPropertyValue( "PropertyPath", "Log4j") ;

    public static Logger Logger = LoggerFactory.getLogger(BusinessLogger.class);


    public static void  BusinessInfo(String Message){
        try {
            PropertyConfigurator.configure(Log4jPropPath);
            int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
            Logger.info(Line + " : " + Message);
        }catch (Exception E) {E.printStackTrace();}
    }

    public static void  BusinessDebug(String Message){
        try {
            PropertyConfigurator.configure(Log4jPropPath);
            int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
            Logger.debug(Line + " : " + Message);
        }catch (Exception E) {E.printStackTrace();}
    }

    public static void  BusinessWarn(String Message){
        try {
            System.out.print("\u001B[33m"); //Yellow
            PropertyConfigurator.configure(Log4jPropPath);
            int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
            Logger.warn(Line + " : " + Message);
            System.out.print("\u001B[0m");
        }catch (Exception E) {E.printStackTrace();}
    }

    public static void  BusinessError(String Message){
        try {
            System.out.print("\u001B[36m"); //Cyan
            PropertyConfigurator.configure(Log4jPropPath);
            int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
            Logger.error(Line + " : " + Message);
            System.out.print("\u001B[0m");
        }catch (Exception E) {E.printStackTrace();}
    }

    public static void  BusinessExceptionError(String Message , Throwable Exception){
        try {
            System.out.print("\u001B[36m"); //Cyan
            PropertyConfigurator.configure(Log4jPropPath);
            int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
            Logger.error(Line + " : " + Message, Exception);
            System.out.print("\u001B[0m");
        }catch (Exception E) {E.printStackTrace();}
    }



    public static void main(String[] args) {

    }
}
