package tracker;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class check {

    public static boolean checkFirstName(Student student[], String firstName) {
        for (int i = 0; i < student.length; i++) {
            if (student[i].getFirstName().equals(firstName))
                return true;
        }
        return false;
    }

    public static boolean checkLastName(Student student[], String lastName) {

        for (int i = 0; i < student.length; i++) {
            if (student[i].getFirstName().equals(lastName))
                return true;
        }
        return false;
    }

    public static boolean checkEmail(Student student[], String email) {

     /* System.out.println(student[input.totalStudents ].getFirstName());
        System.out.println(student[input.totalStudents].getLastName());
        System.out.println(student[input.totalStudents ].getEmail()); */

        for (int i = 0; i < input.totalStudents; i++) {
            if (student[i] != null)
                if (student[i].getEmail().equals(email)) {
                    return true;
                }
        }
        return false;
    }


    public static Student checkDataArray(String[] array, Student studentAll[]) {

        if (array.length == 4) {
            array[0] = array[0] + array[1];
            array[1] = array[2];
            array[2] = array[3];
        }

        if (array.length == 5) {
            array[0] = array[0] + array[1] + array[2];
            array[1] = array[3];
            array[2] = array[4];
        }





        Student student = new Student(array[0], array[1], array[2]);
        student.setId(Integer.toString(input.totalStudents+10000));
        studentAll[input.totalStudents] = student;



        if (check.checkEmail(studentAll, student.getEmail())) {
            System.out.println("This email is already taken.");
            return null;
        }

        student.number++;
        return student;
    }

    public static boolean checkString(String string) {
        String[] array = string.split(" ");


        Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z0-9]{1,}$");
        Matcher email = pattern.matcher(array[array.length - 1]);


        Pattern pattern2 = Pattern.compile("^([A-Za-z]{1,}[A-Za-z'\\-]?[A-Za-z]+)$");
        Matcher firstName = pattern2.matcher(array[0]);

        Pattern pattern3 = Pattern.compile("^([A-Za-z]{1,}[A-Za-z'\\-]?[A-Za-z]+[A-Za-z'\\-]?[A-Za-z]+)$|^([A-Za-z]{1,}[A-Za-z'\\-]?[A-Za-z])$");
        Matcher lastName = pattern3.matcher(array[array.length - 2]);

        if (!firstName.find() || array[0].length() == 1) {
            System.out.println("Incorrect first name.");
            return false;
        }

        if (!lastName.find() || array[1].length() == 1) {
            System.out.println("Incorrect last name.");
            return false;
        }


        if (!email.find()) {
            System.out.println("Incorrect email.");
            return false;
        }

        return true;
    }

    public static void printStudents(Student studentAll[]){
        if(input.totalStudents == 0)
            System.out.println("No students found.");
        else {
            System.out.println("Students:");
            for (int i = 0; i < input.totalStudents; i++) {
                System.out.println(studentAll[i].getId());
           /* System.out.println(studentAll[i].getFirstName());
            System.out.println(studentAll[i].getLastName());
            System.out.println(studentAll[i].getEmail()); */
            }
        }
    }
}