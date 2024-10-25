package test;

public class problem5 {
    public static void main(String[] args) {
        // Шаг 1: Присваиваем переменной типа int значение 100
        int intValue = 100;
        System.out.println("Значение int: " + intValue);

        // Шаг 2: Преобразуем значение int в тип long (широкая конверсия)
        long longValue = intValue;  // Автоматическое преобразование
        System.out.println("Значение long после широкой конверсии: " + longValue);

        // Шаг 3: Преобразуем значение long обратно в int (узкая конверсия)
        int narrowedIntValue = (int) longValue;  // Явное преобразование (приведение типов)
        System.out.println("Значение int после узкой конверсии: " + narrowedIntValue);
    }
}
