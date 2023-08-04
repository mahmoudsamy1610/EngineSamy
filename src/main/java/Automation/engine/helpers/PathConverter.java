package Automation.engine.helpers;

import java.nio.file.Paths;

public class PathConverter {

    public static String ConvertPath(String RelativePath, String FileName) {

        String AbsolutePath ;
        try {
          AbsolutePath = Paths.get(RelativePath, FileName)
                    .toAbsolutePath().toString();
          return AbsolutePath ;

        } catch (Exception e) {
            e.getMessage();
            System.out.println("an Error occurred while Converting relative path to absolute path");
        }

        return null;

    }


}
