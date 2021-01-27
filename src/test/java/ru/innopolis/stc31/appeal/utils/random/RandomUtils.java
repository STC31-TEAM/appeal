package ru.innopolis.stc31.appeal.utils.random;

import ru.innopolis.stc31.appeal.utils.random.dictionaries.Dictionary;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;

/**
 * @author Sergey Fomin
 */
public class RandomUtils {
    /**
     * Do generate random word
     *
     * @param countLetters Number of letters
     * @return Random word
     */
    public static String makeWord(int countLetters) {
        char[] chars = new char[countLetters];

        for (int i = 0; i < countLetters; i++) {
            chars[i] = getRandomLatinLetter();
        }

        return String.valueOf(chars);
    }

    /**
     * @return Random login
     */
    public static String makeLogin() {
        return makeWord(getRandomValue(3, 32));
    }

    /**
     * @return Random name
     */
    public static String makeName() {
        return makeWord(getRandomValue(3, 32));
    }

    /**
     * @return Random name
     */
    public static String makeSurname() {
        return makeWord(getRandomValue(3, 32));
    }

    /**
     * @return Random email
     */
    public static String makeEmail() {
        return makeWord(getRandomValue(3, 12)) +
                "@" +
                makeWord(getRandomValue(2, 10)) +
                "." + getRandomDomain();
    }

    /**
     * @return Random id
     */
    public static Long makeId() {
        return new SecureRandom().nextLong();
    }

    /**
     * Get random letter from dictionary
     *
     * @return Random letter
     */
    private static char getRandomLatinLetter() {
        return Dictionary.LATIN_LETTERS[new SecureRandom().nextInt(Dictionary.LATIN_LETTERS.length)];
    }

    /**
     * Get random letter from dictionary
     *
     * @return Random domain
     */
    private static String getRandomDomain() {
        return Dictionary.DOMAINS[new SecureRandom().nextInt(Dictionary.DOMAINS.length)].toLowerCase(Locale.ROOT);
    }

    /**
     * Generate a random value within the bounds
     *
     * @param min Min value
     * @param max Max value
     * @return Random value
     */
    public static int getRandomValue(int min, int max) {
        return new SecureRandom().nextInt(max - min + 1) + min;
    }

    /**
     * Generate random phone number
     *
     * @return Random phone number
     */
    public static Long getRandomPhone() {
        return (1000000000L * getRandomValue(1, 9)) + getRandomValue(0, 999999999);
    }

    /**
     * Generate random country
     *
     * @return Random name country
     */
    public static String getRandomCountryName() {
        String[] country = new String[]{"Россия","Украина","Белоруссия","Казахстан"};
        return  country[new SecureRandom().nextInt(country.length)];
    }

    /**
     * Generate random street
     *
     * @return Random name street
     */
    public static String getRandomStreetName() {
        String[] streets = new String[]{"ул.Ленина","ул.Набережная","ул.Центральная","площадь Революции"};
        return  streets[new SecureRandom().nextInt(streets.length)];
    }

}
