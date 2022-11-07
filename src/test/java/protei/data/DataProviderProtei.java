package protei.data;

import org.testng.annotations.DataProvider;

public class DataProviderProtei {

    @DataProvider(name = "positive testing data")
    public static Object[][] getPositiveTestData() {
        return new Object[][]{
                {"test@mail.ru", "Женя", "Мужской", "1.1", "2.1"},
                {"test@mail.ru", "Катя", "Женский", "1.2", "2.2"},
                {"test@mail.ru", "Жора", "Мужской", "1.1, 1.2", "2.3"},
                {"test@mail.ru", "Денис", "Мужской", "Нет", ""},
                {"test@mail.ru", "Валентина", "Женский", "Нет", "2.3"},
                {"test@mail.ru", "Прокопий", "Мужской", "1.1, 1.2", ""},
        };
    }

    @DataProvider(name = "invalid login testing data")
    public static Object[][] getInvalidLoginTestData() {
        return new Object[][]{
                {"test@protei.ru", "protei"},
                {"protei@test.ru", "test"}
        };
    }

    @DataProvider(name = "invalid email submit testing data")
    public static Object[][] getInvalidEmailSubmitTestData() {
        return new Object[][]{
                {"@protei.ru"},
                {"protei@"}
        };
    }

    @DataProvider(name = "blank name submit testing data")
    public static Object[][] getBlankNameSubmitTestData() {
        return new Object[][]{
                {"test@protei.ru", ""},
        };
    }
}

