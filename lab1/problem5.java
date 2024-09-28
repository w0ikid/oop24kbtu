package lab1;

import java.util.Vector;

enum Gender {
    BOY, GIRL
}

class Person {
    private Gender gender;

    public Person(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return gender == Gender.BOY ? "B" : "G";
    }
}

class DragonLaunch {
    private Vector<Person> kidnappedPeople = new Vector<>();

    public void kidnap(Person p) {
        kidnappedPeople.add(p);
    }

    public boolean willDragonEatOrNot() {
        int i = 0;
        while (i < kidnappedPeople.size() - 1) {
            if (kidnappedPeople.get(i).getGender() == Gender.BOY &&
                kidnappedPeople.get(i + 1).getGender() == Gender.GIRL) {

                `
                kidnappedPeople.remove(i);
                // B G G B
                if (i > 0) i--;
            } else {
                i++;
            }
        }
        return kidnappedPeople.size() > 0;
    }

    public void displayKidnappedPeople() {
        for (Person person : kidnappedPeople) {
            System.out.print(person + " ");
        }
        System.out.println();
    }
}

class problem5 {
    public static void main(String[] args) {
        DragonLaunch dragonLaunch = new DragonLaunch();

        dragonLaunch.kidnap(new Person(Gender.BOY));
        dragonLaunch.kidnap(new Person(Gender.GIRL));
        dragonLaunch.kidnap(new Person(Gender.BOY));
        dragonLaunch.kidnap(new Person(Gender.GIRL));

        dragonLaunch.displayKidnappedPeople();

        System.out.println("Кушац?: " + dragonLaunch.willDragonEatOrNot());

        DragonLaunch dragonLaunch2 = new DragonLaunch();
        dragonLaunch2.kidnap(new Person(Gender.GIRL));
        dragonLaunch2.kidnap(new Person(Gender.BOY));
        dragonLaunch2.kidnap(new Person(Gender.GIRL));
        dragonLaunch2.kidnap(new Person(Gender.BOY));

        dragonLaunch2.displayKidnappedPeople();

        System.out.println("Кушац?: " + dragonLaunch2.willDragonEatOrNot());
    }
}
