package tracker;


import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.*;



import static tracker.Student.scanner;

public class statistics {

    public static void statisticsMain(Student[] listOfStudents){
        System.out.println("Type the name of a course to see details or 'back' to quit:");
        System.out.println("Most popular: " + mostPopular(listOfStudents));
        System.out.println("Least popular: " + leastPopular(listOfStudents));
        System.out.println("Highest activity: " + highestActivity(listOfStudents));
        System.out.println("Lowest activity: " + lowestActivity(listOfStudents));
        System.out.println("Easiest course: " + easiestCourse(listOfStudents));
        System.out.println("Hardest course: " + hardestCourse(listOfStudents));
        String string = scanner.nextLine();
        while(!string.equals("back")){
            if(string.equalsIgnoreCase("java")) {
                javaCourse(listOfStudents);
            }
            else if(string.equalsIgnoreCase("dsa")){
                dsaCourse(listOfStudents);
            }
            else if(string.equalsIgnoreCase("databases")){
                databasesCourse(listOfStudents);
            }
            else if(string.equalsIgnoreCase("spring")){
                springCourse(listOfStudents);
            }
            else
                System.out.println("Unknown course.");

            string = scanner.nextLine();
        }

    }

    public static String mostPopular(Student[] listOfStudents){
        int javaCount = 0;
        int dsaCount = 0;
        int databaseCount = 0;
        int springCounnt = 0;

        for(int i = 0; i < input.totalStudents; i++){
            if(listOfStudents[i].getJava() != 0)
                javaCount++;
            if(listOfStudents[i].getDSA() != 0)
                dsaCount++;
            if(listOfStudents[i].getDatabases() != 0)
                databaseCount++;
            if(listOfStudents[i].getSpring() != 0)
                springCounnt++;
        }
        if(javaCount > dsaCount && javaCount >databaseCount && javaCount > springCounnt)
            return "Java";
        if(dsaCount > javaCount && dsaCount > databaseCount && dsaCount > springCounnt )
            return "DSA";
        if(databaseCount > javaCount && databaseCount > dsaCount && databaseCount > springCounnt)
            return "Databases";
        if(springCounnt > javaCount && springCounnt > dsaCount && springCounnt > databaseCount)
            return "Spring";
        if(javaCount == 0 && dsaCount == 0 && databaseCount == 0 && springCounnt == 0)
            return "n/a";

        StringBuilder answer = new StringBuilder("n/a");
        HashMap<String, Integer> courses= new HashMap<String, Integer>();
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        courses.put("Java" , javaCount);
        courses.put("DSA" ,dsaCount );
        courses.put("Databases" , databaseCount);
        courses.put("Spring" , springCounnt);
        for (Map.Entry<String, Integer> entry : courses.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list);
        for (int num : list) {
            for (Map.Entry<String, Integer> entry : courses.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }

        List<String> lKeys
               = new ArrayList<String>(sortedMap.keySet());
        for (int i = 0 ; i < sortedMap.size(); i++) {

            if(i == 0){
                answer = new StringBuilder(lKeys.get(0));
            }
            else if(Objects.equals(sortedMap.get(lKeys.get(i)), sortedMap.get(lKeys.get(i - 1)))){
                answer.append(" ").append(lKeys.get(i));
            }
        }


        return answer.toString();
    }

    public static String leastPopular(Student[] listOfStudents) {
        int javaCount = 0;
        int dsaCount = 0;
        int databaseCount = 0;
        int springCount = 0;

        for(int i = 0; i < input.totalStudents; i++){
            if(listOfStudents[i].getJava() != 0)
                javaCount++;
            if(listOfStudents[i].getDSA() != 0)
                dsaCount++;
            if(listOfStudents[i].getDatabases() != 0)
                databaseCount++;
            if(listOfStudents[i].getSpring() != 0)
                springCount++;
        }
        if(javaCount < dsaCount && javaCount <databaseCount && javaCount < springCount)
            return "Java";
        if(dsaCount < javaCount && dsaCount < databaseCount && dsaCount < springCount )
            return "DSA";
        if(databaseCount < javaCount && databaseCount < dsaCount && databaseCount < springCount)
            return "Databases";
        if(springCount < javaCount && springCount < dsaCount && springCount < databaseCount)
            return "Spring";
        if(javaCount == 0 && dsaCount == 0 && databaseCount == 0 && springCount == 0)
            return "n/a";


        StringBuilder answer = new StringBuilder("n/a");
        HashMap<String, Integer> courses= new HashMap<String, Integer>();
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        courses.put("Java" , javaCount);
        courses.put("DSA" ,dsaCount );
        courses.put("Databases" , databaseCount);
        courses.put("Spring" , springCount);
        for (Map.Entry<String, Integer> entry : courses.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list);
        for (int num : list) {
            for (Map.Entry<String, Integer> entry : courses.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }

        List<String> lKeys
                = new ArrayList<String>(sortedMap.keySet());
        for (int i = sortedMap.size()-1 ; i > -1; i--) {

            if(i == sortedMap.size()-1){
                answer = new StringBuilder(lKeys.get(sortedMap.size() - 1));
            }
            else if(Objects.equals(sortedMap.get(lKeys.get(i)), sortedMap.get(lKeys.get(i + 1)))){
                answer.append(" ").append(lKeys.get(i));
            }
        }
        String[] stringArr = answer.toString().split(" ");
        if(stringArr.length == 4)
            return "n/a";

        return answer.toString();



    }

    public static String highestActivity(Student[] listOfStudents){

        int sumJavaActivity = 0;
        int sumDsaActivity = 0;
        int sumDatabasesActivity = 0;
        int sumSpringActivity = 0;
        for(int i = 0; i < input.totalStudents; i++){
           sumJavaActivity += listOfStudents[i].getJavaActivity();
           sumDsaActivity += listOfStudents[i].getDsaActivity();
           sumDatabasesActivity += listOfStudents[i].getDatabasesActivity();
           sumSpringActivity += listOfStudents[i].getSpringActivity();
        }
        if(sumJavaActivity > sumDatabasesActivity && sumJavaActivity > sumDsaActivity && sumJavaActivity > sumSpringActivity)
            return "Java";
        if(sumDsaActivity > sumJavaActivity && sumDsaActivity > sumDatabasesActivity && sumDsaActivity > sumSpringActivity)
            return "DSA";
        if(sumDatabasesActivity > sumJavaActivity && sumDatabasesActivity > sumDsaActivity && sumDatabasesActivity > sumSpringActivity)
            return "Databases";
        if(sumSpringActivity > sumDatabasesActivity && sumSpringActivity > sumJavaActivity && sumSpringActivity > sumDsaActivity)
            return "Spring";
        if(sumJavaActivity == 0 && sumDsaActivity == 0 && sumDatabasesActivity == 0 && sumSpringActivity == 0)
            return "n/a";

        StringBuilder answer = new StringBuilder("n/a");
        HashMap<String, Integer> courses= new HashMap<String, Integer>();
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        courses.put("Java" , sumJavaActivity);
        courses.put("DSA" ,sumDsaActivity );
        courses.put("Databases" , sumDatabasesActivity);
        courses.put("Spring" , sumSpringActivity);
        for (Map.Entry<String, Integer> entry : courses.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list);
        for (int num : list) {
            for (Map.Entry<String, Integer> entry : courses.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }

        List<String> lKeys
                = new ArrayList<String>(sortedMap.keySet());
        for (int i = 0 ; i < sortedMap.size(); i++) {

            if(i == 0){
                answer = new StringBuilder(lKeys.get(0));
            }
            else if(Objects.equals(sortedMap.get(lKeys.get(i)), sortedMap.get(lKeys.get(i - 1)))){
                answer.append(" ").append(lKeys.get(i));
            }
        }

        return answer.toString();

    }

    public static String lowestActivity(Student[] listOfStudents){
        int sumJavaActivity = 0;
        int sumDsaActivity = 0;
        int sumDatabasesActivity = 0;
        int sumSpringActivity = 0;
        for(int i = 0; i < input.totalStudents; i++){
            sumJavaActivity += listOfStudents[i].getJavaActivity();
            sumDsaActivity += listOfStudents[i].getDsaActivity();
            sumDatabasesActivity += listOfStudents[i].getDatabasesActivity();
            sumSpringActivity += listOfStudents[i].getSpringActivity();
        }
        if(sumJavaActivity < sumDatabasesActivity && sumJavaActivity < sumDsaActivity && sumJavaActivity < sumSpringActivity)
            return "Java";
        if(sumDsaActivity < sumJavaActivity && sumDsaActivity < sumDatabasesActivity && sumDsaActivity < sumSpringActivity)
            return "DSA";
        if(sumDatabasesActivity < sumJavaActivity && sumDatabasesActivity < sumDsaActivity && sumDatabasesActivity < sumSpringActivity)
            return "Databases";
        if(sumSpringActivity < sumDatabasesActivity && sumSpringActivity < sumJavaActivity && sumSpringActivity < sumDsaActivity)
            return "Spring";
        if(sumJavaActivity == 0 && sumDsaActivity == 0 && sumDatabasesActivity == 0 && sumSpringActivity == 0)
            return "n/a";

        StringBuilder answer = new StringBuilder("n/a");
        HashMap<String, Integer> courses= new HashMap<String, Integer>();
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        courses.put("Java" ,sumJavaActivity);
        courses.put("DSA" ,sumDsaActivity );
        courses.put("Databases" , sumDatabasesActivity);
        courses.put("Spring" , sumSpringActivity);
        for (Map.Entry<String, Integer> entry : courses.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list);
        for (int num : list) {
            for (Map.Entry<String, Integer> entry : courses.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }
        List<String> lKeys
                = new ArrayList<String>(sortedMap.keySet());
        for (int i = sortedMap.size()-1 ; i > -1; i--) {

            if(i == sortedMap.size()-1){
                answer = new StringBuilder(lKeys.get(sortedMap.size() - 1));
            }
            else if(Objects.equals(sortedMap.get(lKeys.get(i)), sortedMap.get(lKeys.get(i + 1)))){
                answer.append(" ").append(lKeys.get(i));
            }
        }
        String[] stringArr = answer.toString().split(" ");
        if(stringArr.length == 4)
            return "n/a";


        return answer.toString();

    }

    public static String easiestCourse(Student[] listOfStudents){
        int sumJava=0;
        int sumDsa=0;
        int sumDatabases=0;
        int sumSpring=0;


        for(int i = 0; i < input.totalStudents; i++){
            sumJava += listOfStudents[i].getJava();
            sumDsa += listOfStudents[i].getDSA();
            sumDatabases += listOfStudents[i].getDatabases();
            sumSpring += listOfStudents[i].getSpringActivity();

        }
        int countJava=0;
        int countDsa=0;
        int countDatabases=0;
        int countSpring=0;

        for(int i = 0; i < input.totalStudents; i++){
            if(listOfStudents[i].getJavaActivity() != 0)
                countJava++;
            if(listOfStudents[i].getDsaActivity() != 0)
                countDsa++;
            if(listOfStudents[i].getDatabases() != 0)
                countDatabases++;
            if (listOfStudents[i].getSpring() != 0)
                countSpring++;
            }

        int avgJava=0;
        int avgDsa=0;
        int avgDatabases=0;
        int avgSpring=0;

        if(countJava != 0)
            avgJava=sumJava / countJava;
        if(countDsa !=0)
            avgDsa= sumDsa / countDsa;
        if(countDatabases !=0)
            avgDatabases=sumDatabases / countDatabases;
        if(countSpring != 0)
            avgSpring= sumSpring / countSpring;

        if(avgJava > avgDsa && avgJava > avgDatabases && avgJava > avgSpring)
            return "Java";
        if(avgDsa > avgJava && avgDsa > avgDatabases && avgDsa > avgSpring)
            return "Dsa";
        if(avgDatabases > avgJava && avgDatabases > avgDsa && avgDsa > avgSpring)
            return "Databases";
        if(avgSpring > avgJava && avgSpring > avgDatabases && avgSpring > avgDsa)
            return "Spring";

        return "n/a";
    }

    public static String hardestCourse(Student[] listOfStudents){
        int sumJava=0;
        int sumDsa=0;
        int sumDatabases=0;
        int sumSpring=0;


        for(int i = 0; i < input.totalStudents; i++){
            sumJava += listOfStudents[i].getJava();
            sumDsa += listOfStudents[i].getDSA();
            sumDatabases += listOfStudents[i].getDatabases();
            sumSpring += listOfStudents[i].getSpring();

        }
        int countJava=0;
        int countDsa=0;
        int countDatabases=0;
        int countSpring=0;

        for(int i = 0; i < input.totalStudents; i++){
            if(listOfStudents[i].getJavaActivity() != 0)
                countJava++;
            if(listOfStudents[i].getDsaActivity() != 0)
                countDsa++;
            if(listOfStudents[i].getDatabasesActivity() != 0)
                countDatabases++;
            if (listOfStudents[i].getSpringActivity() != 0)
                countSpring++;
        }

        int avgJava=0;
        int avgDsa=0;
        int avgDatabases=0;
        int avgSpring=0;

        if(countJava != 0)
            avgJava=sumJava / countJava;
        if(countDsa !=0)
            avgDsa= sumDsa / countDsa;
        if(countDatabases !=0)
            avgDatabases=sumDatabases / countDatabases;
        if(countSpring != 0)
            avgSpring= sumSpring / countSpring;

        if(avgJava < avgDsa && avgJava < avgDatabases && avgJava < avgSpring)
            return "Java";
        if(avgDsa < avgJava && avgDsa < avgDatabases && avgDsa < avgSpring)
            return "Dsa";
        if(avgDatabases < avgJava && avgDatabases < avgDsa && avgDatabases < avgSpring)
            return "Databases";
        if(avgSpring < avgJava && avgSpring < avgDatabases && avgSpring < avgDsa)
            return "Spring";

        return "n/a";
    }

    public static void javaCourse(Student[] listOfStudents){
        float completed;
        System.out.println("Java");
        System.out.println("id    points    completed");

        Student[] listOfStudentsComparator = new Student[input.totalStudents];
        System.arraycopy(listOfStudents, 0, listOfStudentsComparator, 0, input.totalStudents);


        Arrays.sort(listOfStudentsComparator, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.Spring - o2.Spring != 0)
                    return o1.Java - o2.Java;
                else
                    return -(o1.getId().compareTo(o2.getId()));// or whatever property you want to sort
            }
        });
        listOfStudents = listOfStudentsComparator;

        for(int i = input.totalStudents -1 ; i >= 0; i--) {
            completed = ((float)listOfStudents[i].getJava() / 600) *100;

            NumberFormat numf = NumberFormat.getNumberInstance();
            numf.setMaximumFractionDigits(1);
            numf.setRoundingMode (RoundingMode.HALF_UP);
            String formattedString = numf.format( completed);
           completed =Float.parseFloat(formattedString);

            String points = String.valueOf(listOfStudents[i].getJava());
            StringBuilder empty = new StringBuilder();
            empty.append(" ".repeat(Math.max(0, 8 - points.length())));
           if(listOfStudents[i].getJava() != 0) {
            System.out.print(listOfStudents[i].getId() + " " +listOfStudents[i].getJava() +  empty +"  ");
            System.out.printf("%.1f",completed);
            System.out.println("%");
           }
        }

    }

    public static void dsaCourse(Student[] listOfStudents){
        float completed;
        System.out.println("DSA");
        System.out.println("id    points    completed");

        Student[] listOfStudentsComparator = new Student[input.totalStudents];
        System.arraycopy(listOfStudents, 0, listOfStudentsComparator, 0, input.totalStudents);


        Arrays.sort(listOfStudentsComparator, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.Spring - o2.Spring != 0)
                    return o1.DSA - o2.DSA;
                else
                    return -(o1.getId().compareTo(o2.getId()));// or whatever property you want to sort
            }
        });
        listOfStudents = listOfStudentsComparator;
        for(int i = input.totalStudents -1 ; i >= 0; i--) {
            completed =((float)listOfStudents[i].getDSA() / 400) * 100;

            NumberFormat numf = NumberFormat.getNumberInstance();
            numf.setMaximumFractionDigits(1);
            numf.setRoundingMode (RoundingMode.HALF_UP);
            String formattedString = numf.format( completed);
            completed =Float.parseFloat(formattedString);

            String points = String.valueOf(listOfStudents[i].getDSA());
            StringBuilder empty = new StringBuilder();
            empty.append(" ".repeat(Math.max(0, 8 - points.length())));
            if(listOfStudents[i].getDSA() != 0) {
                System.out.print(listOfStudents[i].getId() + " " + listOfStudents[i].getDSA() + empty + "  ");
                System.out.printf("%.1f", completed);
                System.out.println("%");
            }

        }

    }
    public static void databasesCourse(Student[] listOfStudents){
        float completed;
        System.out.println("Databases");
        System.out.println("id    points    completed");

        Student[] listOfStudentsComparator = new Student[input.totalStudents];
        System.arraycopy(listOfStudents, 0, listOfStudentsComparator, 0, input.totalStudents);


        Arrays.sort(listOfStudentsComparator, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.Spring - o2.Spring != 0)
                    return o1.Databases - o2.Databases;
                else
                    return -(o1.getId().compareTo(o2.getId()));// or whatever property you want to sort
            }
        });
        listOfStudents = listOfStudentsComparator;
        for(int i = input.totalStudents -1 ; i >= 0; i--) {
            completed =((float)listOfStudents[i].getDatabases() / 480) * 100;
            //String string =String.format("%f",completed);
            NumberFormat numf = NumberFormat.getNumberInstance();
            numf.setMaximumFractionDigits(1);
            numf.setRoundingMode (RoundingMode.HALF_UP);
            String formattedString = numf.format( completed);
            completed =Float.parseFloat(formattedString);

            String points = String.valueOf(listOfStudents[i].getDatabases());
            StringBuilder empty = new StringBuilder();
            empty.append(" ".repeat(Math.max(0, 8 - points.length())));
            if(listOfStudents[i].getDatabases() != 0) {
                System.out.print(listOfStudents[i].getId() + " " + listOfStudents[i].getDatabases() + empty + "  ");
                System.out.printf("%.1f", completed);
                System.out.println("%");
            }
        }

    }

    public static void springCourse(Student[] listOfStudents){
        float completed;
        System.out.println("Spring");
        System.out.println("id    points    completed");

        Student[] listOfStudentsComparator = new Student[input.totalStudents];
        System.arraycopy(listOfStudents, 0, listOfStudentsComparator, 0, input.totalStudents);


        Arrays.sort(listOfStudentsComparator, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.Spring - o2.Spring != 0)
                    return o1.Spring - o2.Spring;
                else
                    return -(o1.getId().compareTo(o2.getId()));// or whatever property you want to sort
            }
        });
        listOfStudents = listOfStudentsComparator;
        for(int i = input.totalStudents -1 ; i >= 0; i--) {
            completed =((float)listOfStudents[i].getSpring() / 550) * 100;

            NumberFormat numf = NumberFormat.getNumberInstance();
            numf.setMaximumFractionDigits(1);
            numf.setRoundingMode (RoundingMode.HALF_UP);
            String formattedString = numf.format( completed);
            completed =Float.parseFloat(formattedString);

            String points = String.valueOf(listOfStudents[i].getSpring());
            StringBuilder empty = new StringBuilder();
            empty.append(" ".repeat(Math.max(0, 8 - points.length())));
            if(listOfStudents[i].getSpring() != 0) {
                System.out.print(listOfStudents[i].getId() + " " + listOfStudents[i].getSpring() + empty + "  ");
                System.out.printf("%.1f", completed);
                System.out.println("%");
            }

        }

    }
}
