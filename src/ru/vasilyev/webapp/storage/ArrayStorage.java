package ru.vasilyev.webapp.storage;

import ru.vasilyev.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int STORAGE_LIMIT = 10000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int res = searchIndex(r.getUuid());
        if (res != -1) {
            storage[res] = r;
        } else {
            System.out.println("Resume " + r.getUuid() + " not found");
        }

    }

    public void save(Resume r) {

        if (size == STORAGE_LIMIT) {
            System.out.println("storage full!, not save!");
        } else {
            if (searchIndex(r.getUuid()) == -1) {
                storage[size] = r;
                size++;
            } else {
                System.out.println("DataBase have: " + r.getUuid() + " not save");
                ;
            }
        }

    }

    public Resume get(String uuid) {
        int res = searchIndex(uuid);
        if (res != -1) {
            return storage[res];
        } else {
            System.out.println("Resume " + uuid + " not found");
        }
        return null;

    }

    public void delete(String uuid) {
        int res = searchIndex(uuid);
        if (res != -1) {
            storage[res] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Resume " + uuid + " not found");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    private int searchIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

}
