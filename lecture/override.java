class Person {
    String name;
    int age;

    public Person(String name){
        this(name, 4);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "Person{name:" + name + " age=" + age + "}" + "\n";
    }
}

class Main {
    public static void main(String[] args) {
        Person person = new Person("Danial");
        // java автоматом вызывает метод toString()
        System.out.println(person);  // Выведет что-то вроде: Person@6bc7c054
    }
}


// @Override
// public boolean equals(Object obj) {
//     if (this == obj) {
//         return true;
//     }
//     if (obj == null || getClass() != obj.getClass()) {
//         return false;
//     }
//     problem1 other = (problem1) obj;
//     return this.count == other.count &&
//            Double.compare(this.sum, other.sum) == 0 &&
//            Double.compare(this.max, other.max) == 0;
// }

