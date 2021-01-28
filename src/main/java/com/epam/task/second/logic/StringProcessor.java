package com.epam.task.second.logic;

public interface StringProcessor {

    String changeSymbolInEveryWord(String text, int changeIndex, char replaceWith);
    String correctWords(String text);
    String replaceWords(String text, int requiredLength, String replaceWith);
    String removeAllNonLettersAndSpaces(String text);
    String removeAllWordsByLengthStartedWithConsonant(String text, int requiredLength);
}
