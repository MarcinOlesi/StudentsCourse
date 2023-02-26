package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Learning Progress Tracker");
        Student[] students = new Student[1000];
        String string = " ";

        while(true) {

            string = scanner.nextLine();

            if(string.isEmpty() ||  string.isBlank())
                System.out.println("no input");

            else if(string.equals("add students")) {

                students = input.addStudent(students,string);
            }
            else if(string.equals("list")) {
                check.printStudents(students);
            }
            //else if(check.checkString(string))
              //  System.out.println("Enter 'exit' to exit the program");
            else if(string.equals("exit")) break;
            else if(string.equals("back")) System.out.println("Enter 'exit' to exit the program.");
            else if(string.equals("add points")) {
                    students = input.addPoints(students);
            }
            else if(string.equals("find")){
                input.find(students);
            }
            else if(string.equals("statistics")){
                statistics.statisticsMain(students);
            }
            else if(string.equals("notify")) {
                notify.sendNotify(students);
            }
            else {
                System.out.println("Error: unknown command!");
            }

        }
        System.out.println("Bye!");
    }
}
