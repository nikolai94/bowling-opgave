package mylogger;

import Interfaces.IMyLogger;

import java.io.File;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger implements IMyLogger {
    private Logger logger;
    private SimpleFormatter formatter;
    private String folderPath;

    public MyLogger() {
        logger = Logger.getLogger("MyLog");
        //disable output in console
        logger.setUseParentHandlers(false);
        formatter = new SimpleFormatter();
        //If this folder does not exists,
        // then the log file will be saved in the root folder for this project
        folderPath = "/home/nikolai/javaBowling/src/main/java/logs/";
    }

    public void writeToLogFile(String msg){

        try {
            String logFile = "logfile.log";
            FileHandler fileHandler;

            if(checkFolderExists(this.folderPath))
                fileHandler = new FileHandler(folderPath+logFile, true);
            else
                fileHandler = new FileHandler(logFile, true);

            logger.addHandler(fileHandler);

            fileHandler.setFormatter(formatter);

            logger.info(msg);
            fileHandler.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean checkFolderExists(String folder){
        File tmpDir = new File(folder);
        return tmpDir.exists();
    }
}
