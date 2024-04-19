package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class RandomUtils {

    Faker faker = new Faker();
    Faker ruFaker = new Faker(new Locale("ru"));

    public String getRandomPhoneNumber(int len) {
        return "9" + ruFaker.phoneNumber().subscriberNumber(len-1);
    }

    public String getRandomPhoneNumberWithWrongRegionCode() {
        return "0" + ruFaker.phoneNumber().subscriberNumber(9);
    }

    public String getRandomFullName() {
        return ruFaker.name().fullName();
    }

    public String getRandomBirthDateOfAge(int min, int max) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(faker.date().birthday(min, max));
    }
}
