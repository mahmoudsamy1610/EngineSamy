package Automation.engine.loggers;

import Automation.engine.propertyWorks.PropertyGetter;
import net.bytebuddy.implementation.FieldAccessor;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Loggers {

   public static String Log4jPropPath = PropertyGetter.GetPropertyValue( "PropertyPath", "Log4j") ;

    public static Logger Logger = LoggerFactory.getLogger(Loggers.class);


    public static void Info(String Message){
        PropertyConfigurator.configure(Log4jPropPath);
        Logger.info(Message);
    }

    public static void Debug(String Message){
        PropertyConfigurator.configure(Log4jPropPath);
        Logger.debug(Message);
    }

    public static void Warn(String Message){
        PropertyConfigurator.configure(Log4jPropPath);
        Logger.warn(Message);
    }

    public static void Error(String Message){
        PropertyConfigurator.configure(Log4jPropPath);
        Logger.error(Message);
    }

    public static void ExceptionError(String Message , Throwable Exception){
        PropertyConfigurator.configure(Log4jPropPath);
        Logger.error(Message , Exception);
    }



    public static void main(String[] args) {

    }
}
