package com.epam.tat.domainmodel.giftbox;

import com.epam.tat.domainmodel.candies.Candy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestOfSorting {
    public static void main(String[] args) {
        GiftBox giftBox = new GiftBox();
        //Candy(String name, int weight
        List<Candy>candyList = new ArrayList<>();
            Candy candy = new Candy("Mars", 2);
            candyList.add(candy);
            Candy candy1 = new Candy("Arac", 2);
            candyList.add(candy1);
        Candy candy2 = new Candy("M&M's", 2);
        candyList.add(candy2);
        Candy candy3 = new Candy("Mila", 2);
        candyList.add(candy3);
        Candy candy4 = new Candy("Arahise", 2);
        candyList.add(candy4);
        Candy candy5 = new Candy("M&M", 2);
        candyList.add(candy5);
        Candy candy6 = new Candy("Maharich", 2);
        candyList.add(candy6);
        Candy candy7 = new Candy("Morjovie lapki", 2);
        candyList.add(candy7);
        Candy candy8 = new Candy("Aaron", 2);
        candyList.add(candy8);
        for (int i = 0; i < candyList.size(); i++) {
            giftBox.addCandy(candyList.get(i));
        }

        giftBox.findCandiesByNameStartedWith('M');
        System.out.println("*****");
        giftBox.sortCandiesByNameAsc();
        List<Candy> strings = giftBox.sortCandiesByNameAsc();
        for (Candy c : strings) {
            System.out.println(c.getName());
        }


    }
}
