package Automation.engine.helpers;

import java.nio.file.Paths;

public class PathConverter {

    public static String ConvertPathToAbs(String RelativePath) {

        String AbsolutePath ;
        try {
          AbsolutePath = Paths.get(RelativePath)
                    .toAbsolutePath().toString();
          return AbsolutePath ;

        } catch (Exception e) {
            e.getMessage();
            System.out.println("an Error occurred while Converting relative path to absolute path");
        }

        return null;

    }

    public static void main(String[] args) {
        System.out.println(ConvertPathToAbs("bla" ));
    }


}
