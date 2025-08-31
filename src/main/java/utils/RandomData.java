package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData {


    public static String getRandomUsername() {
        return RandomStringUtils.randomAlphabetic(3).toLowerCase()
                + RandomStringUtils.randomAlphabetic(4)
                + RandomStringUtils.randomAlphanumeric(2);
    }

    public static String getRandomPassword() {
        return RandomStringUtils.randomAlphabetic(3).toLowerCase()
                + RandomStringUtils.randomAlphabetic(4).toUpperCase()
                + RandomStringUtils.randomNumeric(2) + "!";
    }

}
