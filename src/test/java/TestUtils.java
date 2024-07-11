import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
        int startYear = 1966; //considerando que a mulher pode mestruar até 58 anos
        int endYear = 2010; //deve ter no mínimo 14 anos
        int year = startYear + RANDOM.nextInt(endYear - startYear + 1);
        int month = RANDOM.nextInt(12) + 1;
        int day = RANDOM.nextInt(28) + 1;
        return String.format("%d-%02d-%02d", year, month, day);
    }
    
    public static String generateFutureDate() {
        LocalDate futureDate = LocalDate.now().plusMonths(1); // Adiciona um mês à data atual
        return futureDate.format(DateTimeFormatter.ISO_DATE);
    }

    public static List<String> generateInvalidDates() {
        List<String> invalidDates = new ArrayList<>();
        invalidDates.add("2023-02-30");
        invalidDates.add("2023-04-31");
        invalidDates.add("2023-06-31");
        invalidDates.add("2023-09-31");
        invalidDates.add("2023-11-31");
        return invalidDates;
    }

    // Método para selecionar uma data inexistente aleatoriamente
    public static String generateRandomInvalidDate() {
        List<String> invalidDates = generateInvalidDates();
        Random random = new Random();
        return invalidDates.get(random.nextInt(invalidDates.size()));
    }
}

