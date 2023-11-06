package automation.utils.helpers;

import automation.utils.loggers.JavaLogger;

import java.io.File;

public class PathConverter {

    public static String ConvertPathToAbs(String RelativePath) {
        JavaLogger.JavaInfo("Converting relative path to absolute path : " + RelativePath);


        String AbsolutePath ;
        try {
          AbsolutePath = new File(RelativePath).getAbsolutePath();
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
