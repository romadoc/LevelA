package com.epam.tat.listprocessor.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("", "", "aaa"));
        ListProcessor letterProcessor = new ListProcessor();
        letterProcessor.changeByPlacesFirstAndLastSymbolsInEachSecondStringOfList(list);
    }
}
