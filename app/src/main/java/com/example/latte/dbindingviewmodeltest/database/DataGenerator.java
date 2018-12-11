package com.example.latte.dbindingviewmodeltest.database;

import com.example.latte.dbindingviewmodeltest.database.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by latte on 2018. 2. 21..
 */

public class DataGenerator {

    private static final String[] FIRSTNAME = new String[]{
            "Special edition", "New", "Cheap", "Quality", "Used"};
    private static final String[] LASTNAME = new String[]{
            "Three-headed Monkey", "Rubber Chicken", "Pint of Grog", "Monocle"};

    public static List<User> generateUsers() {
        List<User> users = new ArrayList<>(FIRSTNAME.length * LASTNAME.length);
        for (int i = 0; i < FIRSTNAME.length; i++) {
            for (int j = 0; j < LASTNAME.length; j++) {
                User user = new User();
                user.setFirstName(FIRSTNAME[i]);
                user.setLastName(LASTNAME[j]);
                users.add(user);

            }
        }
        return users;
    }

}
