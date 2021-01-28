package com.epam.task.second.logic;

public class StringProcessorWithRegexTest extends AbstractStringProcessorTest {
    @Override
    protected StringProcessor createStringProcessor() {
        return new StringProcessorWithRegex();
    }
}
