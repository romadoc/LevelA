package com.epam.tat.listprocessor.impl;

import com.epam.tat.listprocessor.IListProcessor;
import com.epam.tat.listprocessor.exception.ListProcessorException;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Function Description:
 * Complete the functions below. All methods must work with list of String.
 * <p>
 * In case of incorrect input values or inability to perform an action, the method should throw an appropriate
 * exception.
 */
public class ListProcessor implements IListProcessor {

    public static final char[] VOWEL = new char[]{'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U', 'y', 'Y'};
    public static final char[] CONSONANT = new char[]{'B', 'b', 'C', 'c', 'D', 'd', 'F', 'f', 'G', 'g', 'H', 'h'
            , 'J', 'j', 'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n', 'P'
            , 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't', 'V', 'v'
            , 'W', 'w', 'X', 'x', 'Y', 'y', 'Z', 'z'};

    /**
     * Find the second by length string in a list.
     * <p>
     * Ex.:
     * From list:
     * {"a", "aa", "aaaaa", "aaaa", "aaa"}
     * will be return "aaaa"
     *
     * @param list - input data
     * @return second by length string in the input list
     */
    @Override
    public String getSecondStringByLength(List<String> list) {
        if (list == null || list.isEmpty() || list.size() == 1) {
            throw new ListProcessorException();
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(0).equals(list.get(i))) {
                throw new ListProcessorException();
            }
        }
        Collections.sort(list);
        Collections.reverse(list);

        return list.get(1);

    }

    /**
     * Sort list by string length.
     * <p>
     * Ex.:
     * From list:
     * {"a", "aa", "aaA", "aAa", "aaa", "Aa"}
     * will be return
     * {"a", "Aa", "aa", "aAa", "aaA", "aaa"}
     *
     * @param list - input data
     * @return sort list by string length
     */
    @Override
    public List<String> getSortedListByLength(List<String> list) {

        if (list == null || list.isEmpty()) {
            throw new ListProcessorException();
        }
        List<String> stringList = new ArrayList<>();
        for (String s : list) {
            stringList.add(s);
        }
        Comparator<String> stringLengthComparator = (o1, o2) -> Integer.compare(o1.length(), o2.length());

        Collections.sort(stringList, stringLengthComparator);
        return stringList;
    }

    /**
     * Sort list or array by count of vowels in string.
     * If the number of vowels in several words is the same, the order is alphabetical.
     * <p>
     * Ex.:
     * From list:
     * {"Puma", "Nike", "Timberland", "Adidas"}
     * will be return
     * {"Nike", "Puma", "Adidas", "Timberland"}
     *
     * @param list - input data
     * @return sort list by string length
     */
    @Override
    public List<String> getSortedListByCountOfVowels(List<String> list) {
        if (list == null || list.isEmpty()) {
            throw new ListProcessorException();
        }
        List<LetterProcessor> setWordAndQuantity = new ArrayList<>();
        List<String> sortedWordByQuantity = new ArrayList<>();
        LetterEntrylComparator letterEntrylComparator = new LetterEntrylComparator();

        for (String s : list) {
            int countOfVowels = 0;
            countOfVowels = countIsVowel(s);
            if (countOfVowels == 0) {
                throw new ListProcessorException();
            }
            LetterProcessor letterProcessor = new LetterProcessor(countOfVowels, s);
            setWordAndQuantity.add(letterProcessor);
            setWordAndQuantity.sort(letterEntrylComparator
                    .thenComparing(LetterProcessor::getWord));

        }

        for (LetterProcessor letterProcessor : setWordAndQuantity) {
            sortedWordByQuantity.add(letterProcessor.getWord());
        }
        return sortedWordByQuantity;
    }

    /**
     * Sort list or array by count of consonants in string.
     * If the number of consonants in several words is the same, the order is alphabetical.
     * <p>
     * Ex.:
     * From list:
     * {"Puma", "Nike", "Timberland", "Adidas"}
     * will be return
     * {"Nike", "Puma", "Adidas", "Timberland"}
     *
     * @param list - input data
     * @return sort list by string length
     */
    @Override
    public List<String> getSortedListByCountOfConsonants(List<String> list) {

        if (list == null || list.isEmpty()) {
            throw new ListProcessorException();
        }

        List<LetterProcessor> setWordAndQuantity = new ArrayList<>();
        List<String> sortedWordByQuantity = new ArrayList<>();
        LetterEntrylComparator letterEntrylComparator = new LetterEntrylComparator();

        for (String s : list) {
            int countOfConsonants = 0;
            countOfConsonants = countIsConsonant(s);
            if (countOfConsonants == 0) {
                throw new ListProcessorException();
            }
            LetterProcessor letterProcessor = new LetterProcessor(countOfConsonants, s);
            setWordAndQuantity.add(letterProcessor);
            setWordAndQuantity.sort(letterEntrylComparator
                    .thenComparing(LetterProcessor::getWord));

        }

        for (LetterProcessor letterProcessor : setWordAndQuantity) {
            sortedWordByQuantity.add(letterProcessor.getWord());
        }
        return sortedWordByQuantity;
    }

    /**
     * Change by places first and last symbols in each second string of list.
     * <p>
     * Ex.:
     * From list:
     * {"Puma", "Nike", "Timberland", "Adidas"}
     * will be return
     * {"Puma", "eikN", "Timberland", "sdidaA"}
     *
     * @param list - input data
     * @return sort list by string length
     */
    @Override
    public List<String> changeByPlacesFirstAndLastSymbolsInEachSecondStringOfList(List<String> list) {
        if (list == null || list.isEmpty() || list.size() == 1) {
            throw new ListProcessorException();
        }

        List<String> stringList = new ArrayList<>();
        for (String s : list) {
            stringList.add(s);

            for (int j = 1; j < stringList.size(); j = j + 2) {
                if (!list.get(j).isEmpty()) {
                    stringList.set(j, recombinateString(list.get(j)));
                }
            }
        }
        return stringList;
    }

    /**
     * Revert strings of list.
     * <p>
     * Ex.:
     * From list:
     * {"Puma", "Nike", "Timberland", "Adidas"}
     * will be return
     * {"amuP", "ekiN", "dnalrebmiT", "sadidA"}
     *
     * @param list - input data
     * @return sort list by string length
     */
    @Override
    public List<String> reverseStringsOfList(List<String> list) {
        if (list == null || list.isEmpty()) {
            throw new ListProcessorException();
        }

        List<String> strings = new ArrayList<>();
        String[] array = new String[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = StringUtils.reverse(list.get(i));
            strings.add(array[i]);
        }
        return strings;
    }

    private String recombinateString(String s) {
        if (s.isEmpty()) {
            throw new ListProcessorException();
        }
        char[] chars = s.toCharArray();
        char first = chars[0];
        char last = chars[chars.length - 1];


        for (int i = 0; i < chars.length; i++) {
            chars[0] = last;
            chars[chars.length - 1] = first;
        }
        return new String(chars);
    }

    private int countIsVowel(String word) {
        int counter = 0;
        char[] charsOfWords = word.toCharArray();
        for (char charsOfWord : charsOfWords) {
            for (char c : VOWEL) {
                if (charsOfWord == c) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private int countIsConsonant(String word) {
        int counter = 0;
        char[] charsOfWords = word.toCharArray();
        for (char charsOfWord : charsOfWords) {
            for (char c : CONSONANT) {
                if (charsOfWord == c) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
