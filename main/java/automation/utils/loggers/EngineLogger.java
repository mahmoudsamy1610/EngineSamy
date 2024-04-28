package automation.utils.loggers;

import automation.utils.propertyWorks.PropertyGetter;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EngineLogger {

   public static String Log4jPropPath = PropertyGetter.GetPropertyValue( "PropertyPath", "Log4j") ;
    public static Logger Logger = LoggerFactory.getLogger(EngineLogger.class);




    public static void EngineInfo(String Message){
        try {
            PropertyConfigurator.configure(Log4jPropPath);
            int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
            String ClassName = new Throwable().getStackTrace()[1].getClassName();

            System.out.print("\u001B[0m");
            System.out.print("\u001B[34m"); //Blue
            Logger.info(ClassName+" - "+Line + " : " + Message);
            System.out.print("\u001B[0m");

        }catch (Exception E) {E.printStackTrace();}
    }

    public static void EngineDebug(String Message){
        try {
            int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
            Logger.debug("Line : -"+Line + "- : " + Message);
        }catch (Exception E) {E.printStackTrace();}
    }

    public static void EngineWarn(String Message){
        try {
            PropertyConfigurator.configure(Log4jPropPath);
            int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
            String ClassName = new Throwable().getStackTrace()[1].getClassName();

            System.out.print("\u001B[0m");
            System.out.print("\u001B[33m"); //Yellow
            Logger.warn(ClassName+" - "+Line + " : " + Message);
            System.out.print("\u001B[0m");

        }catch (Exception E) {E.printStackTrace();}
    }

    public static void EngineError(String Message){
        try {
            PropertyConfigurator.configure(Log4jPropPath);
            int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
            String ClassName = new Throwable().getStackTrace()[1].getClassName();

            System.out.print("\u001B[0m");
            System.out.print("\u001B[35m"); //Purple
            Logger.error(ClassName+" - "+Line + " : " + Message);
            System.out.print("\u001B[0m");

        }catch (Exception E) {E.printStackTrace();}
    }

    public static void EngineExceptionError(String Message , Throwable Exception){
        try {
            PropertyConfigurator.configure(Log4jPropPath);
            int Line = Thread.currentThread().getStackTrace()[2].getLineNumber();
            String ClassName = new Throwable().getStackTrace()[1].getClassName();

            System.out.print("\u001B[0m");
            System.out.print("\u001B[35m"); //Purple
            Logger.error(ClassName+" - "+Line + " : " + Message , Exception);
            System.out.print("\u001B[0m");

        }catch (Exception E) {E.printStackTrace();}
    }


}
