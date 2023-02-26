package tracker;

public class notify {

    public static void sendNotify(Student[] listOfStudents){
        int notifyCount = 0;
        boolean flag = false;
        for(int i = 0; i < input.totalStudents; i++) {
            if (listOfStudents[i].getJava() >= 600 && !listOfStudents[i].getJavaNotify()) {

                System.out.println("To: " + listOfStudents[i].getEmail());
                System.out.println("Re: Your Learning Progress");
                System.out.println("Hello, " + listOfStudents[i].getFirstName() + " " + listOfStudents[i].getLastName() + "! You have accomplished our Java course!");
                listOfStudents[i].javaNotified();
                flag = true;
            }
            if (listOfStudents[i].getDSA() >= 400 && !listOfStudents[i].getDsaNotify()) {
                System.out.println("To: " + listOfStudents[i].getEmail());
                System.out.println("Re: Your Learning Progress");
                System.out.println("To:" + listOfStudents[i].getFirstName() + " " + listOfStudents[i].getLastName() + "! You have accomplished our DSA course!");
                listOfStudents[i].dsaNotified();
                flag = true;
            }
            if (listOfStudents[i].getDatabases() >= 480&& !listOfStudents[i].getDatabasesNotify()) {
                System.out.println("To: " + listOfStudents[i].getEmail());
                System.out.println("Re: Your Learning Progress");
                System.out.println("To:" + listOfStudents[i].getFirstName() + " " + listOfStudents[i].getLastName() + "! You have accomplished our Databases course!");
                listOfStudents[i].databasesNotified();
                flag = true;
            }
            if (listOfStudents[i].getSpring() >= 55 && !listOfStudents[i].getSpringNotify()) {
                System.out.println("To: " + listOfStudents[i].getEmail());
                System.out.println("Re: Your Learning Progress");
                System.out.println("To:" + listOfStudents[i].getFirstName() + " " + listOfStudents[i].getLastName() + "! You have accomplished our Spring course!");
                listOfStudents[i].springNotified();
                flag = true;
            }
            if (listOfStudents[i].getJava() >= 600 || listOfStudents[i].getDSA() >= 400 || listOfStudents[i].getDatabases() >= 480 ||listOfStudents[i].getSpring() >= 550)
                if(flag)
                     notifyCount++;
        }
            System.out.println("Total " +notifyCount+ " students have been notified.");
             notifyCount=0;
    }

}
