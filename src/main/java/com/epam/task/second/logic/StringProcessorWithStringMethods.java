package com.epam.task.second.logic;

import java.util.ArrayList;
import java.util.List;

public class StringProcessorWithStringMethods implements StringProcessor {

    private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private boolean isConsonant(char c) {
        return isLetter(c) && c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'y' &&
                c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U' && c != 'Y';
    }

    private List<String> sliceToWords(String text) {

        List<String> result = new ArrayList<>();

        StringBuilder builder = new StringBuilder();

        for (char currentCher : text.toCharArray()) {

            if (isLetter(currentCher)) {
                builder.append(currentCher);

            } else if (builder.length() > 0) {
                String currentWord = builder.toString();
                builder = new StringBuilder();

                result.add(currentWord);
            }
        }

        if (builder.length() > 0) {
            String currentWord = builder.toString();
            result.add(currentWord);
        }

        return result;
    }

    private String combineToText(List<String> words) {

        StringBuilder builder = new StringBuilder();

        for (String word : words) {
            builder.append(word);
            builder.append(' ');
        }

        builder.setLength(builder.length() - 1);

        return builder.toString();
    }

    //same as with Regex
    @Override
    public String changeSymbolInEveryWord(String text, int changeIndex, char replaceWith) {

        List<String> words = sliceToWords(text);

        for (int i = 0; i < words.size(); i++) {

            String currentWord = words.get(i);
            StringBuilder builder = new StringBuilder(currentWord);

            if (changeIndex <= currentWord.length()) {
                builder.setCharAt(changeIndex - 1, replaceWith);
            }

            String result = builder.toString();
            words.set(i, result);
        }

        return combineToText(words);
    }

    @Override
    public String correctWords(String text) {

        StringBuilder builder = new StringBuilder(text);

        for (int i = 0; i < text.length() - 1; i++) {

            char currentChar = text.charAt(i);

            if (currentChar == 'p' || currentChar == 'P') {

                char nextChar = text.charAt(i + 1);

                if (nextChar == 'a') {
                    builder.setCharAt(i + 1, 'o');
                } else if (nextChar == 'A') {
                    builder.setCharAt(i + 1, 'O');
                }
            }
        }

        return builder.toString();
    }

    //same as with Regex
    @Override
    public String replaceWords(String text, int requiredLength, String replaceWith) {

        List<String> words = sliceToWords(text);

        for (int i = 0; i < words.size(); i++) {

            String currentWord = words.get(i);

            if (currentWord.length() == requiredLength) {
                words.set(i, replaceWith);
            }
        }

        return combineToText(words);
    }

    //same as with Regex
    @Override
    public String removeAllNonLettersAndSpaces(String text) {

        List<String> words = sliceToWords(text);

        return combineToText(words);
    }

    @Override
    public String removeAllWordsByLengthStartedWithConsonant(String text, int requiredLength) {

        List<String> givenWords = sliceToWords(text);
        List<String> result = new ArrayList<>();

        for (String word : givenWords) {

            char firstChar = word.charAt(0);

            if (word.length() != requiredLength || !isConsonant(firstChar)) {
                result.add(word);
            }
        }

        return combineToText(result);
    }
}
