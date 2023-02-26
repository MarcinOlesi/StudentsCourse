package tracker;

import java.text.NumberFormat;
import java.text.ParsePosition;

import static tracker.Student.scanner;

public class input {
   static int totalStudents=0;
    public static Student[] addStudent(Student listOfStudents[] ,String string){
        System.out.println("Enter student credentials or 'back' to return:");
        String data = scanner.nextLine();
        Student studentNew = new Student("proba","proba","proba");

        String[] studentString = new String[3];
        while(!data.equals("back")) {

            studentString = data.split(" ");


            if(studentString.length < 3) {
                System.out.println("Incorrect credentials.");
                data = scanner.nextLine();

            }else if(check.checkString(data)){
                studentNew = check.checkDataArray(studentString ,listOfStudents);
                if(studentNew != null){
                listOfStudents[totalStudents] = studentNew;
                totalStudents++;
                System.out.println("Student has been added.");
                }
                data = scanner.nextLine();
            }
            else
                data = scanner.nextLine();
        }

        System.out.println("Total "+ totalStudents + " students have been added.");

        return listOfStudents;
        //  System.out.println("Enter 'exit' to exit the program.");
    }
    public static Student[] addPoints(Student listOfStudents[]){
        System.out.println("Enter an id and points or 'back' to return:");
        String string = scanner.nextLine();
        String[] stringArr = string.split(" ");
        boolean flag;
        while(!string.equals("back")) {
             flag = false;

            if (stringArr.length != 5 || !isNumeric(stringArr[1]) || !isNumeric(stringArr[2]) || !isNumeric(stringArr[3]) || !isNumeric(stringArr[4])) {
                System.out.println("Incorrect points format.");
                flag = true;
            }
            else if(stringArr.length == 5){
                int i = 0;
                for (; i < totalStudents; i++) {
                    if (listOfStudents[i].getId().equals(stringArr[0])) {
                        if(Integer.parseInt(stringArr[1]) > 0) {
                            listOfStudents[i].addJava(Integer.parseInt(stringArr[1]));
                            listOfStudents[i].addJavaActivity();
                        }
                        if(Integer.parseInt(stringArr[2]) > 0) {
                            listOfStudents[i].addDSA(Integer.parseInt(stringArr[2]));
                            listOfStudents[i].addDsaActivity();
                        }
                        if(Integer.parseInt(stringArr[3]) > 0) {
                            listOfStudents[i].addDatabases(Integer.parseInt(stringArr[3]));
                            listOfStudents[i].addDatabasesActivity();
                        }
                        if(Integer.parseInt(stringArr[4]) > 0) {
                            listOfStudents[i].addSpring(Integer.parseInt(stringArr[4]));
                            listOfStudents[i].addSpringActivity();
                        }
                        System.out.println("Points updated.");
                        flag = true;
                    }
                }
            }

            if (flag == false)
                System.out.println("No student is found for " + stringArr[0]);


            string = scanner.nextLine();
           stringArr =  string.split(" ");

        }

      return listOfStudents;
    }

    public static void find(Student listOfStudents[]){
        System.out.println("Enter an id or 'back' to return:");
        String string = scanner.nextLine();

        while(!string.equals("back")) {
           boolean flag = false;
            for (int i = 0; i < totalStudents; i++) {
                if(listOfStudents[i].getId().equals(string)) {
                    System.out.println(listOfStudents[i].getId() + " points: Java=" + listOfStudents[i].getJava() + " DSA=" + listOfStudents[i].getDSA() + " Databases=" + listOfStudents[i].getDatabases() + " Spring=" + listOfStudents[i].getSpring());
                    flag = true;
                }
            }
            if(flag == false)
                System.out.println("No student is found for id="+ string +".");

            string = scanner.nextLine();
        }

    }


    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

}
