package ru.vasilyev.webapp.model;

/**
 * com.urise.webapp.model.ru.vasilyev.webapp.model.Resume class
 */
public class Resume {

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    // Unique identifier
    private String uuid;

    @Override
    public String toString() {
        return uuid;
    }
}
