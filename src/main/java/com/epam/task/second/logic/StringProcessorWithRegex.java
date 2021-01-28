package com.epam.task.second.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessorWithRegex implements StringProcessor {

    private static final String WORD_REGEX = "[a-zA-z]+";
    private static final Pattern WORD_PATTERN = Pattern.compile(WORD_REGEX);

    private static final String PA_REGEX = "[pP][aA]";
    private static final Pattern PA_PATTERN = Pattern.compile(PA_REGEX);

    private static final String NON_LETTER_OR_SPACE_REGEX = "[^a-zA-z ]+";
    private static final Pattern NON_LETTER_OR_SPACE_PATTERN = Pattern.compile(NON_LETTER_OR_SPACE_REGEX);

    private static final String FIRST_CONSONANT_REGEX = "^((?![aeiouy])[a-z]|(?![AEIOUY])[A-Z]).*$";

    private List<String> sliceToWords(String text) {

        Matcher matcher = WORD_PATTERN.matcher(text);

        List<String> result = new ArrayList<>();

        while (matcher.find()) {
            String currentWord = matcher.group();
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

    //same as with String Methods
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

        Matcher matcher = PA_PATTERN.matcher(text);

        while (matcher.find()) {

            int aIndex = matcher.end() - 1;

            if (text.charAt(aIndex) == 'a') {
                builder.setCharAt(aIndex, 'o');
            } else {
                builder.setCharAt(aIndex, 'O');
            }
        }

        return builder.toString();
    }

    //same as with String Methods
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

    //same as with String Methods
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

            if (word.length() != requiredLength || !word.matches(FIRST_CONSONANT_REGEX)) {
                result.add(word);
            }
        }

        return combineToText(result);
    }
}
