package ru.vasilyev.webapp.storage;

import org.junit.Ignore;
import org.junit.Test;

public class ListStorageTest extends AbstractStorageTest {

    public ListStorageTest() {
        super(new ListStorage());
    }

    @Ignore
    @Test
    @Override
    public void saveOverflow() throws Exception {
        super.saveOverflow();
    }
}