package automation.utils.helpers;

import automation.utils.loggers.JavaLogger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CMDRunner {

    public  static void runCommand(String Command) {
        JavaLogger.JavaInfo("Running CMD command : " + Command);

        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("cmd", "/c", Command);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                JavaLogger.JavaInfo("Line : " + line);
            }

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                JavaLogger.JavaInfo("CMD command ran successfully : " + Command);
            } else {
                JavaLogger.JavaError("Running interrupted with exit code : " + exitCode );
                throw new InterruptedException();
            }
        } catch (Exception E) {
            JavaLogger.JavaExceptionError("Failed running CMD command : " + Command , E);
        }
    }
}