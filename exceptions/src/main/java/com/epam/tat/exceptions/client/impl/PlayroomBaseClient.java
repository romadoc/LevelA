package com.epam.tat.exceptions.client.impl;

import com.epam.tat.exceptions.bean.Toy;
import com.epam.tat.exceptions.client.IPlayroom;
import com.epam.tat.exceptions.constants.Parameter;
import com.epam.tat.exceptions.exception.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class PlayroomBaseClient implements IPlayroom {

    private final List<Toy> toyList;


    public PlayroomBaseClient(List<Toy> toyList) {
        if (toyList == null) {
            throw new InitializationException();
        }
        this.toyList = toyList;
    }

    @Override
    public List<Toy> getAllToys() {
        return new ArrayList<>(toyList);

    }

    @Override
    public List<Toy> getToysByParameter(String parameter, String value) {
        ArrayList<Toy> listOfFounds = new ArrayList<>();
        if (parameter == null || value == null) {
            throw new GetToysByParameterException();
        }

        try {
            for (Toy toy : toyList) {
                if (parameter.equals(Parameter.ID.getName())) {
                    Long nesessaryId = Long.parseLong(value);
                    if (!isIdPresent(nesessaryId)) {
                        break;
                    }
                    if (nesessaryId.equals(toy.getId())) {
                        listOfFounds.add(toy);
                    }
                }
                if (parameter.equals(Parameter.TOY_NAME.getName())) {
                    if (!isSuchToyNamePresent(value)) {
                        throw new GetToysByParameterException();
                    }
                    if (toy.getToyName().equals(value)) {
                        listOfFounds.add(toy);

                    }

                }
                if (parameter.equals(Parameter.GENDER.getName())) {
                    if (toy.getGender().toString().equals(value)) {
                        listOfFounds.add(toy);
                    }
                }
                if (parameter.equals(Parameter.AGE.getName())) {
                    if (toy.getAge() == Integer.parseInt(value)) {
                        listOfFounds.add(toy);
                    }
                }
                if (parameter.equals(Parameter.PRICE.getName())) {
                    if (toy.getPrice() == Double.parseDouble(value)) {
                        listOfFounds.add(toy);
                    }
                }
                if (parameter.equals(Parameter.MATERIAL.getName())) {
                    if (toy.getMaterial().toString().equals(value)) {
                        listOfFounds.add(toy);
                    }
                }
                if (parameter.equals(Parameter.SIZE.getName())) {
                    if (toy.getMaterial().toString().equals(value)) {
                        listOfFounds.add(toy);
                    }
                }
                if (parameter.equals(Parameter.GAME_TYPE.getName())) {
                    if (toy.getGameType().toString().equals(value)) {
                        listOfFounds.add(toy);
                    }
                }

            }
        } catch (NumberFormatException e) {
            throw new GetToysByParameterException();
        }

        return listOfFounds;

    }

    @Override
    public boolean addToy(Toy toy) throws AddToyException {
        if (toy == null || !isAllToyFieldsAreFilled(toy)) {
            throw new AddToyException();
        }
        return toyList.add(toy);

    }

    @Override
    public boolean removeToy(Toy toy) throws RemoveToyException {
        if (toy == null || !isAllToyFieldsAreFilled(toy)) {
            throw new RemoveToyException();
        }

        return toyList.remove(toy);

    }

    @Override
    public boolean updateToy(Long id, Toy toy) throws UpdateToyException {
        if (toy == null || !isAllToyFieldsAreFilled(toy) || !isIdPresent(id)) {
            throw new UpdateToyException();
        }
        int indexOfChangedElement = getIndexOfChangedElement(id);
        toyList.set(indexOfChangedElement, toy);
        return indexOfChangedElement == toyList.indexOf(toy);

    }

    private int getIndexOfChangedElement(Long id) {
        int indexOfChengedElement = 0;
        for (int i = 0; i < toyList.size(); i++) {
            if (toyList.get(i).getId() == id) {
                indexOfChengedElement = i;
            }
        }
        return indexOfChengedElement;
    }

    public List<Toy> getToyList() {
        return toyList;

    }

    public boolean isSuchToyNamePresent(String name) {
        boolean isSuch = false;
        for (Toy toy : toyList) {
            if (toy.getToyName().equals(name)) {
                isSuch = true;
                break;
            }
        }
        return isSuch;
    }

    public boolean isIdPresent(Long id) {
        boolean isPresent = false;
        for (Toy toy : toyList) {
            if (toy.getId() == id) {
                isPresent = true;

            }
        }
        return isPresent;
    }

    public boolean isAllToyFieldsAreFilled(Toy toy) {
        boolean isFilled = true;
        try {
            for (Field field : toy.getClass().getFields()) {
                if (field.get(toy) == null) {
                    isFilled = false;

                }
            }
        } catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return isFilled;
    }

}
