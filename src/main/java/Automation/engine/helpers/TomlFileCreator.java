package Automation.engine.helpers;

import java.io.FileWriter;
import java.io.IOException;


public class TomlFileCreator {



        public static void CreateToml(String Content , String TomlRelativePath) {


                try (FileWriter writer = new FileWriter(TomlRelativePath)) {
                    writer.write(Content);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
    }


