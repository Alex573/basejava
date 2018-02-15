
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    int sizeArray = 0;

    void clear() {
        for (int i = 0; i < sizeArray; i++) {
            storage[i] = null;
        }
        sizeArray = 0;
    }

    void save(Resume r) {

        if ( sizeArray  == storage.length){
            System.out.println("storage full!, not save!");
        }else {
            storage[sizeArray] = r;
            System.out.println("save good");
        }
        sizeArray++;

    }

    Resume get(String uuid) {

        for (int i = 0; i < sizeArray; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;

    }

    void delete(String uuid) {

        for (int i = 0; i < sizeArray; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[sizeArray - 1];
                storage[sizeArray - 1] = null;
            }
        }
        sizeArray--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return  Arrays.copyOf(storage,sizeArray);
    }

    int size() {
        return sizeArray;
    }
}
