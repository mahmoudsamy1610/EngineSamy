package Automation.engine.helpers;

import Automation.engine.loggers.JavaLogger;

import java.nio.file.Paths;

public class PathConverter {

    public static String ConvertPathToAbs(String RelativePath) {
        JavaLogger.JavaInfo("Converting relative path to absolute path : " + RelativePath);


        String AbsolutePath ;
        try {
          AbsolutePath = Paths.get(RelativePath)
                    .toAbsolutePath().toString();
          return AbsolutePath ;

        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed Converting relative path to absolute path : "+ RelativePath , E);
        }

        return null;

    }

    public static void main(String[] args) {
        System.out.println(ConvertPathToAbs("bla"));
    }


}
