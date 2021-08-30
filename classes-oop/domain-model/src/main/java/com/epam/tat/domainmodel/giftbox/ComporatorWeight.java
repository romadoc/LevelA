package com.epam.tat.domainmodel.giftbox;

import com.epam.tat.domainmodel.candies.Candy;

import java.util.Comparator;

public class ComporatorWeight implements Comparator<Candy> {

    @Override
    public int compare(Candy o1, Candy o2) {
        return o1.getWeight() - o2.getWeight();
    }
}
