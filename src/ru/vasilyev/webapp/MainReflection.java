package ru.vasilyev.webapp;

import ru.vasilyev.webapp.model.Resume;

import java.lang.reflect.Field;


public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        System.out.println(field.getName());
        field.setAccessible(true);
        field.get(r);
        System.out.println(r);
        field.set(r, "newuuid");
        // TODO : invoke r.toString via reflection
        System.out.println(r);
    }
}
