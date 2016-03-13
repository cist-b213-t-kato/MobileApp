package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyDaoGenerator {
    public static void main(String args[]) throws Exception {
        Schema schema = new Schema(1, "greendao");
        Entity todo = schema.addEntity("Todo");
        todo.addIdProperty();
        todo.addIntProperty("colorLabel");
        todo.addStringProperty("value");
        todo.addLongProperty("createdTime");
        new DaoGenerator().generateAll(schema, args[0]);
    }
}