package com.epam.tat.domainmodel.giftbox;

import com.epam.tat.domainmodel.candies.Candy;
import com.epam.tat.domainmodel.util.Finding;
import com.epam.tat.domainmodel.util.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class Description:
 * Implement interfaces: Sorting and Finding and
 * their methods for sorting candies by name or weight and
 * finding candies by parameters.
 * <p>
 */
public class GiftBox implements Finding, Sorting {
    /**
     * No actions are required for class variable candiesList.
     */
    private final List<Candy> candiesList;

    /**
     * No actions are required for constructor GiftBox().
     */
    public GiftBox() {
        candiesList = new ArrayList<Candy>();
    }

    /**
     * No actions are required for method addCandy().
     */
    public void addCandy(Candy candy) {
        this.candiesList.add(candy);
    }

    /**
     * Implement sorting of candiesList by its names in ascending order
     * and return sorted by name ascending list of candies.
     */
    @Override
    public List<Candy> sortCandiesByNameAsc() {
        ComporatorFindName comporatorFindName = new ComporatorFindName();
        candiesList.sort(comporatorFindName);
        return candiesList;
    }

    /**
     * Implement sorting of candiesList by its weight in ascending order
     * and return sorted by weight ascending list of candies.
     */
    @Override
    public List<Candy> sortCandiesByWeightAsc() {
        ComporatorWeight comporatorWeight = new ComporatorWeight();
        candiesList.sort(comporatorWeight);
        return candiesList;
    }

    /**
     * Implement selection of candies from candiesList with names started with candyNameFirstLetter
     * and return list of candies which names started with candyNameFirstLetter in name ascending list of candies.
     */
    @Override
    public List<Candy> findCandiesByNameStartedWith(char candyNameFirstLetter) {
        List<Candy> list = new ArrayList<>();
        for (Candy c : candiesList) {
            if (c.getName().charAt(0) == candyNameFirstLetter) {
                list.add(c);
            }
        }
        ComporatorFindName comporatorFindName = new ComporatorFindName();
        list.sort(comporatorFindName);
        Collections.sort(list);
        for (Candy candy : list) {
            System.out.println(candy.getName());
        }
        return list;
    }

    /**
     * Implement selection ot candies from candiesList so that its [weightFrom <= weight => weightTo]
     * and return list of candies with weight in range [weightFrom, weightTo] in weight ascending list of candies.
     */
    @Override
    public List<Candy> findCandiesByWeightInRange(int weightFrom, int weightTo) {
        List<Candy> candyList = new ArrayList<>();
        for (Candy c : candiesList) {
            if (c.getWeight() >= weightFrom && c.getWeight() <= weightTo) {
                candyList.add(c);
            }
        }
        return candyList;
    }
}
