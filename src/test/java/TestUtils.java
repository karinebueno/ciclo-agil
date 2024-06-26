import java.security.SecureRandom;
import java.util.Random;

public class TestUtils {

    private static final String[] FIRST_NAMES = {
            "Ana", "Beatriz", "Carlos", "Daniel", "Eduardo",
            "Fernanda", "Gabriel", "Helena", "Isabela", "João",
            "Karina", "Lucas", "Mariana", "Nícolas", "Olívia",
            "Paulo", "Rafael", "Sofia", "Tiago", "Vitória",
            "Silva", "Santos", "Oliveira", "Souza", "Rodrigues",
            "Ferreira", "Almeida", "Costa", "Gomes", "Martins",
            "Araújo", "Pereira", "Ribeiro", "Carvalho", "Mendes",
            "Barbosa", "Lima", "Correia", "Dias", "Rocha", "Maria Antonietaa", "João Paulo", "Antônio"
    };

    private static final String[] EMAIL_DOMAINS = {
            "@example.com", "@mail.com", "@business.com", "@corporate.com",
            "@enterprise.com", "@company.com", "@industry.com", "@commerce.com",
            "@firm.com", "@professional.com"
    };

    private static final Random RANDOM = new SecureRandom();

    public static String generateName() {
        return FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.length)];
    }

    public static String generateEmail(String name) {
        String domain = EMAIL_DOMAINS[RANDOM.nextInt(EMAIL_DOMAINS.length)];
        long timestamp = System.currentTimeMillis();
        return name.toLowerCase() + timestamp + domain;
    }

    public static String generatePassword() {
        String specialChars = "!@$%&*";
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";

        StringBuilder password = new StringBuilder();
        password.append(specialChars.charAt(RANDOM.nextInt(specialChars.length())));
        password.append(upperCaseLetters.charAt(RANDOM.nextInt(upperCaseLetters.length())));
        password.append(lowerCaseLetters.charAt(RANDOM.nextInt(lowerCaseLetters.length())));
        password.append(numbers.charAt(RANDOM.nextInt(numbers.length())));

        for (int i = 4; i < 8; i++) {
            int charType = RANDOM.nextInt(4);
            switch (charType) {
                case 0:
                    password.append(specialChars.charAt(RANDOM.nextInt(specialChars.length())));
                    break;
                case 1:
                    password.append(upperCaseLetters.charAt(RANDOM.nextInt(upperCaseLetters.length())));
                    break;
                case 2:
                    password.append(lowerCaseLetters.charAt(RANDOM.nextInt(lowerCaseLetters.length())));
                    break;
                case 3:
                    password.append(numbers.charAt(RANDOM.nextInt(numbers.length())));
                    break;
            }
        }
        return password.toString();
    }

    public static String generateBirthday() {
        int startYear = 1950;
        int endYear = 2005;
        int year = startYear + RANDOM.nextInt(endYear - startYear + 1);
        int month = RANDOM.nextInt(12) + 1;
        int day = RANDOM.nextInt(28) + 1;
        return String.format("%d-%02d-%02d", year, month, day);
    }
}

