package test;

// Перечисление (enum) Day для дней недели
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class problem7 {
    public static void main(String[] args) {
        // Пример использования метода для разных дней
        checkDayType(Day.MONDAY);
        checkDayType(Day.SATURDAY);
        checkDayType(Day.SUNDAY);
    }

    // Метод, который принимает значение Day и определяет, является ли день рабочим или выходным
    public static void checkDayType(Day day) {
        switch (day) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                System.out.println(day + " - это рабочий день.");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println(day + " - это выходной день.");
                break;
            default:
                System.out.println("Неизвестный день.");
        }
    }
}
