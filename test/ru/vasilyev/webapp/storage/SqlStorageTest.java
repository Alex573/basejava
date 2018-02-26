package ru.vasilyev.webapp.storage;

import ru.vasilyev.webapp.Config;

public class SqlStorageTest extends AbstractStorageTest {

    public SqlStorageTest() {
        super(Config.get().getStorage());
    }
}