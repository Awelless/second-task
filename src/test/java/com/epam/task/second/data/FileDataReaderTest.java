package com.epam.task.second.data;

import org.junit.Assert;
import org.junit.Test;

public class FileDataReaderTest {

    private DataReader dataReader;

    @Test
    public void testReadShouldReturnAllDataWhenCorrectFilenameApplied() throws DataException {

        dataReader = new FileDataReader("./src/test/resources/input.txt");
        String expected = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";

        String result = dataReader.read();

        Assert.assertEquals(expected, result);
    }

    @Test(expected = DataException.class)
    public void testReadShouldThrowExceptionWhenIncorrectFilenameApplied() throws DataException {
        dataReader = new FileDataReader("./src/test/resources/input_123.txt");

        dataReader.read();
    }
}
