package user;

import utils.PropertyReader;

public class UserFactory {
    public static User withAdminPermission() {
        return new User(PropertyReader.getProperty("saucedemo_test1.user"),
                PropertyReader.getProperty("saucedemo_test1.password"));
    }

    public static User withLockUserPermission() {
        return new User(PropertyReader.getProperty("saucedemo_test1.locked"),
                PropertyReader.getProperty("saucedemo_test1.password"));
    }

    public static User withEmptyUsername() {
        return new User("", PropertyReader.getProperty("saucedemo_test1.password"));
    }

    public static User withEmptyPassword() {
        return new User(PropertyReader.getProperty("saucedemo_test1.user"), "");
    }
}
