package com.epam.task.second.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Scanner;

public class FileDataReader implements DataReader {

    private static final Logger LOGGER = LogManager.getLogger(FileDataReader.class);

    private final String filename;

    public FileDataReader(String filename) {
        this.filename = filename;
    }

    @Override
    public String read() throws DataException {

        try (FileInputStream inputStream = new FileInputStream(filename)){

            Scanner scanner = new Scanner(inputStream);

            StringBuilder builder = new StringBuilder();

            while (scanner.hasNext()) {
                String currentLine = scanner.nextLine();
                builder.append(currentLine);
            }

            scanner.close();

            return builder.toString();

        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);

            throw new DataException(e.getMessage(), e);
        }
    }
}
