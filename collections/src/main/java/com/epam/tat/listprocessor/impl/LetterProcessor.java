package com.epam.tat.listprocessor.impl;

public class LetterProcessor implements Comparable<LetterProcessor> {
    private final int count;
    private final String word;

    public LetterProcessor(int count, String word) {
        this.count = count;
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }

    @Override
    public int compareTo(LetterProcessor o) {
        return 0;
    }
}
