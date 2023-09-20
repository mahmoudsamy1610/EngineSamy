package Automation.engine.loggers;

import Automation.engine.propertyWorks.PropertyGetter;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaLogger {

   public static String Log4jPropPath = PropertyGetter.GetPropertyValue( "PropertyPath", "Log4j") ;

    public static Logger Logger = LoggerFactory.getLogger(JavaLogger.class);


    public static void JavaInfo(String Message){
        try {
            System.out.print("\u001B[32m"); //Green
            PropertyConfigurator.configure(Log4jPropPath);
            int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
            Logger.info(Line + " : " + Message);
            System.out.print("\u001B[0m");
        }catch (Exception E) {E.printStackTrace();}
    }

    public static void JavaDebug(String Message){
        try {
            PropertyConfigurator.configure(Log4jPropPath);
            int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
            Logger.debug(Line + " : " + Message);
        }catch (Exception E) {E.printStackTrace();}
    }

    public static void JavaWarn(String Message){
        try {
            System.out.print("\u001B[33m"); //Yellow
            PropertyConfigurator.configure(Log4jPropPath);
            int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
            Logger.warn(Line + " : " + Message);
            System.out.print("\u001B[0m");
        }catch (Exception E) {E.printStackTrace();}
    }

    public static void JavaError(String Message){
        try {
            System.out.print("\u001B[31m"); //Red
            PropertyConfigurator.configure(Log4jPropPath);
            int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
            Logger.error(Line + " : " + Message);
            System.out.print("\u001B[0m");
        }catch (Exception E) {E.printStackTrace();}
    }

    public static void JavaExceptionError(String Message , Throwable Exception){
        try {
            System.out.print("\u001B[31m"); //Red
            PropertyConfigurator.configure(Log4jPropPath);
            int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
            Logger.error(Line + " : " + Message, Exception);
            System.out.print("\u001B[0m");
        }catch (Exception E) {E.printStackTrace();}
    }



    public static void main(String[] args) {
        System.out.print("\u001B[31m"); //Red
        System.out.println("asdasdadasd");
        System.out.print("\u001B[0m");
        System.out.println("asdasdadasd");

    }
}
