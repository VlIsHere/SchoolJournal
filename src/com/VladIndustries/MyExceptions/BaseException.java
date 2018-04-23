package com.VladIndustries.MyExceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.logging.Logger;

public abstract class BaseException extends Exception {
    public Logger myLogger;

    public BaseException() {
        File file = new File("warning.log");
        try (PrintWriter writer = new PrintWriter(file)) {
            myLogger = Logger.getLogger("Logger1");
            logging(writer);
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException e1) {
            }
        } catch (IOException e) {
        }

    }

    public abstract String getLogMessage();

   private void logging(PrintWriter writer) throws IOException {
        myLogger.info(getLogMessage());
        writer.printf("\n%s: %s\n", LocalDateTime.now(), getLogMessage());
        writer.flush();
    }

}
