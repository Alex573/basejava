package ru.vasilyev.webapp.storage;

import ru.vasilyev.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;
    private boolean flag = false;
    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void update (Resume r){
        flag = false;
        for (int i = 0; i < size; i++) {
            if (storage[i] == r) {
                storage[i] = r;
                flag = true;
            }
        }
        if (!flag){System.out.println("Not found!");}

    }

    public void save(Resume r) {

        if ( size == storage.length){
            System.out.println("storage full!, not save!");
        }else {
            flag = false;
            for (int i = 0; i < size; i++) {
                if (storage[i] == r) {
                    storage[size] = r;
                    size++;
                    flag = true;
                    System.out.println("save good");
                }
            }
            if (!flag){System.out.println("Not found!");}
        }



    }

    public Resume get(String uuid) {
        flag = false;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        if (!flag){System.out.println("Not found!");}
        return null;

    }

    public void delete(String uuid) {
        flag = false;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                flag = true;
            }
        }
        if (!flag){System.out.println("Not found!");}
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return  Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

//    private int searchByObject(Resume r){
//
//    }
}
