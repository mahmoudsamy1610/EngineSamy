package automation.utils.fileWorks;

import automation.utils.loggers.JavaLogger;

import java.io.FileWriter;


public class TomlFileCreator {

        public static void CreateToml(String Content , String TomlRelativePath) {

            JavaLogger.JavaInfo("Creating TOML file at : " + TomlRelativePath);

            try {
                    FileWriter writer = new FileWriter(TomlRelativePath) ;
                    writer.write(Content);
                    writer.flush();
                    writer.close();
                } catch (Exception E) {
                    JavaLogger.JavaExceptionError("Failed creating TOML file at : " + TomlRelativePath , E);
                }

            }

    public static void main(String[] args) {
            CreateToml("[sadad]" , "src/main/resources/automationResources/tomlFiles/gridHubNodes/windows 11/firefox/bla.Toml");
    }

    }


