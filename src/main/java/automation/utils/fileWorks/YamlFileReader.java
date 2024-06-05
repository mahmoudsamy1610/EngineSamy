package automation.utils.fileWorks;
import automation.utils.loggers.JavaLogger;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

public class YamlFileReader {

    public static String ReadFromYamlFile(String filePath , String Key) {

        Yaml yaml = new Yaml();
        InputStream inputStream = null;
        Map<String, String> yamlMap;
        String value ;
        JavaLogger.JavaInfo("Read from YAML file from relative path : " + filePath+ "  , to get the value of key : "+ Key);


        try {
            inputStream = new FileInputStream(filePath);
            yamlMap = yaml.load(inputStream);
            value = yamlMap.get(Key);
            JavaLogger.JavaInfo("found value : " + value+ " , from the key : "+ Key + " , in the Yaml file path : " + filePath );

        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed Reading from YAML file from : " + filePath + "  , to get the value of key : "+ Key, E);
            throw new RuntimeException(E);
        }

        return value ;

    }




    public static void main(String[] args) {
        String value = ReadFromYamlFile("appBrowserStack.yml" , "app");
        System.out.println(value);
    }


}
