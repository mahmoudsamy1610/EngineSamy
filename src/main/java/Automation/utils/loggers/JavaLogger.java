package Automation.utils.loggers;

import Automation.utils.propertyWorks.PropertyGetter;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaLogger {

   public static String Log4jPropPath = PropertyGetter.GetPropertyValue( "PropertyPath", "Log4j") ;

    public static Logger Logger = LoggerFactory.getLogger(JavaLogger.class);


    public static void JavaInfo(String Message){
        try {
            PropertyConfigurator.configure(Log4jPropPath);
            int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
            String ClassName = new Throwable().getStackTrace()[1].getClassName();

            System.out.print("\u001B[32m"); //Green
            Logger.info(ClassName+" - "+Line + " : " + Message);
            System.out.print("\u001B[0m");

        }catch (Exception E) {E.printStackTrace();}
    }

    public static void JavaDebug(String Message){
        try {
            PropertyConfigurator.configure(Log4jPropPath);
            int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
            Logger.debug("Line : -"+Line + "- : " + Message);
        }catch (Exception E) {E.printStackTrace();}
    }

    public static void JavaWarn(String Message){
        try {
            PropertyConfigurator.configure(Log4jPropPath);
            int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
            String ClassName = new Throwable().getStackTrace()[1].getClassName();

            System.out.print("\u001B[33m"); //Yellow
            Logger.warn(ClassName+" - "+Line + " : " + Message);
            System.out.print("\u001B[0m");

        }catch (Exception E) {E.printStackTrace();}
    }

    public static void JavaError(String Message){
        try {
            PropertyConfigurator.configure(Log4jPropPath);
            int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
            String ClassName = new Throwable().getStackTrace()[1].getClassName();

            System.out.print("\u001B[31m"); //Red
            Logger.error(ClassName+" - "+Line + " : " + Message);
            System.out.print("\u001B[0m");

        }catch (Exception E) {E.printStackTrace();}
    }

    public static void JavaExceptionError(String Message , Throwable Exception){
        try {
            PropertyConfigurator.configure(Log4jPropPath);
            int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
            String ClassName = new Throwable().getStackTrace()[1].getClassName();

            System.out.print("\u001B[31m"); //Red
            Logger.error(ClassName+" - "+Line + " : " + Message, Exception);
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
