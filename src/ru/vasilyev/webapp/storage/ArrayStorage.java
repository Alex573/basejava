package ru.vasilyev.webapp.storage;

import ru.vasilyev.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;
    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void update (Resume r){
        int res = searchByObject(r);
        if (res != -1){
            storage[res] = r;
        }else {
            printNotFound();
        }

    }

    public void save(Resume r) {
        if ( size == storage.length){
            System.out.println("storage full!, not save!");
        }else {
            int res = searchByObject(r);
            if (res == -1){
                storage[size] = r;
                size++;
            }else {
                System.out.println("DataBase have: " + r + " not save");;
            }
        }

    }

    public Resume get(String uuid) {
        int res = searchByUuid(uuid);
        if (res != -1){
           return storage[res];
        }else {
            printNotFound();
        }
        return null;

    }

    public void delete(String uuid) {
        int res = searchByUuid(uuid);
        if (res != -1){
            storage[res] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }else {
            printNotFound();
        }
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

    private int searchByObject(Resume r){
        for (int i = 0; i < size; i++) {
            if (storage[i] == r) {
                return i;
            }
        }
        return -1;
    }
    private int searchByUuid(String uuid){
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
    private void printNotFound(){
        System.out.println("Not found!");
    }
}
