// class Book {
//     private String serialNumber;  // Обычное (нестатическое) поле, для каждого объекта своё

//     // Статическое поле, общее для всех объектов класса
//     public static String manufacturer = "Chetotam";

//     // Статический метод, который можно вызвать без создания объекта
//     public static void printManufacturer() {
//         System.out.println("Manufacturer: " + manufacturer);
//     }

//     public Book(String serialNumber){
//         this.serialNumber = serialNumber;
//     }

// }

// class Main {
//     public static void main(String[] args) {
//         Book.printManufacturer();
//     }
// }
