package com.epam.task.second.data;

import java.util.Scanner;

public class ConsoleDataReader implements DataReader {

    @Override
    public String read() {

        Scanner scanner = new Scanner(System.in);

        StringBuilder builder = new StringBuilder();

        while (scanner.hasNext()) {
            String currentLine = scanner.nextLine();
            builder.append(currentLine);
        }

        scanner.close();

        return builder.toString();
    }
}
