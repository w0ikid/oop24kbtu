package lab1;

public class Computer {

    public enum ProcessorType {
        INTEL, AMD, ARM;
    }

    private static int totalComputersCreated = 0;

    // Поле только для чтения (final, не static)
    private final String serialNumber;

    // Поле только для чтения (final, не static)
    private final int memorySize; // размер памяти в ГБ

    // Статическое финальное поле для производителя (static и final)
    private static final String MANUFACTURER;

    // Поле с типом перечисления (enum)
    private ProcessorType processor;

    
    {
        memorySize = 8;
    }

    static {
        MANUFACTURER = "LRT";
    }

    // Конструктор, принимающий параметры для процессора и серийного номера
    public Computer(String serialNumber, ProcessorType processor) {
        this.serialNumber = serialNumber; // Используем ключевое слово 'this' для ссылки на поле объекта
        this.processor = processor; // Используем 'this' для процессора
        totalComputersCreated++; // Увеличиваем счётчик созданных компьютеров
    }

    // Перегрузка конструктора, который также принимает размер памяти
    public Computer(String serialNumber, ProcessorType processor, int memorySize) {
        this(serialNumber, processor);  // Вызов конструктора с двумя параметрами (reusing constructor)
        System.out.println("Custom memory size of " + memorySize + " GB was specified, but default of " + this.memorySize + " GB is used.");
    }

    // Перегрузка методов для отображения деталей компьютера
    public void showDetails() {
        System.out.println("Serial Number: " + serialNumber);
        System.out.println("Processor: " + processor);
        System.out.println("Memory: " + memorySize + " GB");
        System.out.println("Manufacturer: " + MANUFACTURER);
    }

    public void showDetails(boolean showTotal) {
        showDetails(); // Вызов основного метода
        if (showTotal) {
            System.out.println("Total Computers Created: " + totalComputersCreated);
        }
    }

    // Пример метода с final параметром (параметр не может быть изменён внутри метода)
    public void upgradeProcessor(final ProcessorType newProcessor) {
        this.processor = newProcessor; // Изменение типа процессора
    }

    public static int getTotalComputersCreated() {
        return totalComputersCreated;
    }
}

// Класс с методом main для проверки
class Main {
    public static void main(String[] args) {
        Computer computer1 = new Computer("ABC123", Computer.ProcessorType.INTEL);
        Computer computer2 = new Computer("DEF456", Computer.ProcessorType.AMD, 16);
        // Computer computer3 = new Computer("OOP2024", Computer.ProcessorType.AMD, 64);
    
        computer1.showDetails();
        
        computer2.showDetails(true);

        // Обновляем процессор первого компьютера
        computer1.upgradeProcessor(Computer.ProcessorType.ARM);

        // Показываем детали первого компьютера после обновления процессора
        computer1.showDetails();

        // Вывод общего числа созданных компьютеров через статический метод
        System.out.println("Total computers created: " + Computer.getTotalComputersCreated());
    }
}
