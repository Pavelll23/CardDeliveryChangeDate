package data;

import com.github.javafaker.Faker;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {

        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity() {

        var city = new String[]{"Благовещенск", "Архангельск", "Астрахань", "Белгород", "Брянск", "Владимир",
                "Волгоград", "Вологда", "Воронеж", "Иркутск"};
        Random random = new Random();
        int rendItem = random.nextInt(city.length);
        return city[rendItem];
    }

    public static String generateName(String locale) {

        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().firstName() + " " + faker.name().lastName();
        return name;
    }

    public static String generatePhone(String locale) {

        Faker faker = new Faker(new Locale(locale));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {

            return new UserInfo(generateName(locale), generatePhone(locale), generateCity());
        }

        @Value
        public static class UserInfo {
            String name;
            String phone;
            String city;
        }
    }
}
