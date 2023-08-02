import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {

    }

    public static String generateCity() {
        var cities = new String[]{"Архангельск", "Астрахань", "Белгород", "Биробиджан", "Благовещенск", "Брянск", "Великий Новгород",
                "Владимир", "Волгоград", "Вологда", "Воронеж", "Гатчина", "Екатеринбург", "Иваново", "Иркутск", "Калининград",
                "Калуга", "Кемерово", "Киров", "Кострома", "Красногорск", "Курган", "Курск", "Липецк", "Магадан", "Москва",
                "Мурманск", "Нижний Новгород", "Новосибирск", "Омск", "Орёл", "Оренбург", "Пенза", "Псков", "Ростов-на-Дону",
                "Рязань", "Самара", "Санкт-Петербург", "Саратов", "Смоленск", "Тамбов", "Тверь", "Томск", "Тула", "Тюмень", "Ульяновск",
                "Челябинск", "Южно-Сахалинск", "Ярославль"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();

    }

    public static String generatePhone(String locale){
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }
    public static class Registration{
        private Registration(){

        }
        public static UserInfo generateUser(String locale){
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }
    @Value
    public static class UserInfo{
        String city;
        String name;
        String phone;
    }
}
