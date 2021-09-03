package com.epam.tat.exceptions.client.impl;

import com.epam.tat.exceptions.bean.Toy;
import com.epam.tat.exceptions.constants.*;
import java.util.*;
import java.util.List;

public class TestMyClass {

    public static void main(String[] args) {
        Toy chToy = new Toy(16L, "Doll", GameType.STORY, Gender.FEMALE, 6, Size.MEDIUM, Material.PLASTIC, 150);

        ArrayList<Toy> toyList = new ArrayList<>();
        toyList.add(new Toy(1L, "Doll", GameType.STORY, Gender.FEMALE, 6, Size.MEDIUM, Material.PLASTIC, 150));
        toyList.add(new Toy(2L, "Car", GameType.SPORTS, Gender.MALE, 4, Size.SMALL, Material.METAL, 70));
        toyList.add(new Toy(3L, "Car", GameType.SPORTS, Gender.FEMALE, 4, Size.LARGE, Material.METAL, 70));
        toyList.add(new Toy(5L, "Toy kitchen", GameType.STORY, Gender.FEMALE, 7, Size.LARGE, Material.PLASTIC, 1170));
        toyList.add(new Toy(8L, "Car", GameType.SPORTS, Gender.FEMALE, 3, Size.SMALL, Material.PLUSH, 330));
        toyList.add(new Toy(13L, "Bug", GameType.PUZZLES, Gender.MALE, 5, Size.SMALL, Material.WOODEN, 220));
        toyList.add(new Toy(21L, "Car", GameType.SPORTS, Gender.MALE, 4, Size.SMALL, Material.METAL, 70));

        PlayroomBaseClient playroomBaseClient = new PlayroomBaseClient(toyList);

        List<Toy> foundToys = playroomBaseClient.getToysByParameter(Parameter.TOY_NAME.getName(), "Doll");
        foundToys.forEach(System.out :: println);

    }

}
