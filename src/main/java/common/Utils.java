package common;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class Utils {

    public static String randomString(int length) {
        return RandomStringUtils.random(length, true, false);
    }

    public static String randomParagraph() {
        return new Faker().lorem().paragraph();
    }
}
