package intre;

public class Main {
    public static void main(String[] args) {
        Users[] usersArray = new Users[15];

        usersArray[0] = new Users(1, "user1", "pass1", "1", "11");
        usersArray[1] = new Users(2, "user2", "pass2", "2", "22");
        usersArray[2] = new Users(3, "user3", "pass3", "3", "33");
        usersArray[3] = new Users(4, "user4", "pass4", "4", "44");
        usersArray[4] = new Users(5, "user5", "pass5", "5", "55");

        usersArray[5] = new Staff(6, "staff1", "pass6", "6", "66", 50000, new String[]{"Math", "Physics"});
        usersArray[6] = new Staff(7, "staff2", "pass7", "7", "77", 55000, new String[]{"Chemistry", "Biology"});
        usersArray[7] = new Staff(8, "staff3", "pass8", "8", "88", 60000, new String[]{"History", "Geography"});
        usersArray[8] = new Staff(9, "staff4", "pass9", "9", "99", 58000, new String[]{"English", "Literature"});
        usersArray[9] = new Staff(10, "staff5", "pass10", "10", "1010", 62000, new String[]{"Computer Science", "Programming"});

        usersArray[10] = new Student(11, "student1", "pass11", "11", "11", 3.9, new String[]{"Math", "Physics"});
        usersArray[11] = new Student(12, "student2", "pass12", "12", "1212", 3.7, new String[]{"Chemistry", "Biology"});
        usersArray[12] = new Student(13, "student3", "pass13", "13", "1313", 3.8, new String[]{"History", "Geography"});
        usersArray[13] = new Student(14, "student4", "pass14", "14", "1414", 3.6, new String[]{"English", "Literature"});
        usersArray[14] = new Student(15, "student5", "pass15", "15", "1515", 4.0, new String[]{"Computer Science", "Programming"});

        for (Users user : usersArray) {
            System.out.println(user.getData());
        }
    }
}
