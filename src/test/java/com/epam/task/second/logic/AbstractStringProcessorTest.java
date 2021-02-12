package com.epam.task.second.logic;

import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractStringProcessorTest {

    StringProcessor stringProcessor;

    protected abstract StringProcessor createStringProcessor();

    @Test
    public void testChangeSymbolInEveryWord() {
        stringProcessor = createStringProcessor();
        String text     = "abc vbnm Test";
        String expected = "azc vznm Tzst";

        String result = stringProcessor.changeSymbolInEveryWord(text, 2, 'z');

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testCorrectWords() {
        stringProcessor = createStringProcessor();
        String text     = "papaPapAPA apppppp apa";
        String expected = "popoPopOPO apppppp apo";

        String result = stringProcessor.correctWords(text);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testReplaceWords() {
        stringProcessor = createStringProcessor();
        String text     = "abc word qwerty test";
        String expected = "abc newOne qwerty newOne";

        String result = stringProcessor.replaceWords(text, 4, "newOne");

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testRemoveAllNonLettersAndSpaces() {
        stringProcessor = createStringProcessor();
        String text     = "aa23abcd qwerty   ; teSt";
        String expected = "aa abcd qwerty teSt";

        String result = stringProcessor.removeAllNonLettersAndSpaces(text);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testRemoveAllWordsByLengthStartedWithConsonant() {
        stringProcessor = createStringProcessor();
        String text     = "aa pbcd abc pqwert Paaa";
        String expected = "aa abc pqwert";

        String result = stringProcessor.removeAllWordsByLengthStartedWithConsonant(text, 4);

        Assert.assertEquals(expected, result);
    }
}
