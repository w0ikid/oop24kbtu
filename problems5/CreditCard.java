// Создаем собственное исключение InvalidCardException

class InvalidCardException extends Exception {
    public InvalidCardException(String message) {
        super(message);
    }
}

public class CreditCard {

    // Метод проверки корректности номера карты
    public void validateCardNumber(String cardNumber) throws InvalidCardException {
        // Проверяем, что номер состоит из 16 цифр
        if (cardNumber.length() != 16 || !cardNumber.matches("\\d+")) {
            throw new InvalidCardException("Номер карты должен содержать 16 цифр.");
        }

        // Проверяем номер карты по алгоритму Луна
        if (!isValidCardNumber(cardNumber)) {
            throw new InvalidCardException("Номер карты недействителен по алгоритму Луна.");
        }
        
        System.out.println("Номер карты действителен.");
    }

    // Метод реализации алгоритма Луна
    public static boolean isValidCardNumber(String cardNumber) {
        int sum = 0;
        boolean alternate = false;

        // Проходимся по цифрам с конца
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int n = Character.getNumericValue(cardNumber.charAt(i));

            if (alternate) {
                // Удваиваем каждую вторую цифру
                n *= 2;
                if (n > 9) {
                    // Складываем цифры, если число больше 9
                    n = (n % 10) + 1;
                }
            }

            // Суммируем результат
            sum += n;
            alternate = !alternate; // Меняем флаг, чтобы удваивать каждую вторую цифру
        }

        // Проверяем делимость на 10
        return sum % 10 == 0;
    }

    public static void main(String[] args) {
        CreditCard card = new CreditCard();
        String cardNumber = "4539148803436467"; // Пример номера карты

        try {
            card.validateCardNumber(cardNumber);
        } catch (InvalidCardException e) {
            System.out.println(e.getMessage());
        }
        

    }
}
