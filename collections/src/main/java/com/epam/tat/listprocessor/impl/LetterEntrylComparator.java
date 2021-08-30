package com.epam.tat.listprocessor.impl;

import java.util.Comparator;

public class LetterEntrylComparator implements Comparator<LetterProcessor> {

    @Override
    public int compare(LetterProcessor o1, LetterProcessor o2) {
        return o1.getCount() - o2.getCount();
    }
}
