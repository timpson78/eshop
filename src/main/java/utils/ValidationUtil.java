package utils;

import utils.exceptions.NotFoundException;

public class ValidationUtil {

    public static void checkNotFoundWithId(boolean found, int id) {
        checkNotFound(found, "Not found entity with id=" + id);
    }

    public static void checkNotFoundWithId(boolean found, int id, int itemId) {
        checkNotFound(found, " Not found entity with id=" + id +"item_Id "+itemId);
    }

    public static void checkNotFound(boolean found, String msg) {
        if (!found) {
            throw new NotFoundException("Not found entity with " + msg);
        }
    }
}

