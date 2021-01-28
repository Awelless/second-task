package com.epam.task.second.logic;

public class StringProcessorWithStringMethodsTest extends AbstractStringProcessorTest {
    @Override
    protected StringProcessor createStringProcessor() {
        return new StringProcessorWithStringMethods();
    }
}
