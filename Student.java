package tracker;

import java.util.Scanner;


public class Student {
    static Scanner scanner = new Scanner(System.in);
    Student(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    String firstName;
    String lastName;
    String email;

    static int number= 1000;

    String id;

    int Java=0;
    int javaActivity = 0;
    boolean javaNotify=false;
    int DSA=0;

    int dsaActivity = 0;

    boolean dsaNotify=false;
    int Databases=0;

    int databasesActivity = 0;

    boolean databasesNotify = false;
    int Spring=0;
    int springActivity = 0;

    boolean springNotify = false;

    public String getEmail(){

        return this.email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId(){return id;}

    public int getJava(){ return Java;}
    public int getDSA(){ return DSA;}
    public int getDatabases(){ return Databases;}
    public int getSpring(){ return Spring;}

    public void setId(String number){
        this.id = number;
    }

    public void addJava(int Java){
        this.Java +=  Java;
    }
    public void addDSA(int DSA){
        this.DSA +=  DSA;
    }
    public void addDatabases(int Databases){
        this.Databases +=  Databases;
    }
    public void addSpring(int Spring){
        this.Spring +=  Spring;
    }

    public void addJavaActivity(){
        this.javaActivity++;
    }
    public void addDsaActivity(){
        this.dsaActivity++;
    }

    public void addDatabasesActivity(){
        this.databasesActivity++;
    }
    public void addSpringActivity(){
        this.springActivity++;
    }

    public int getJavaActivity(){
        return javaActivity;
    }
    public int getDsaActivity(){
        return dsaActivity;
    }
    public int getDatabasesActivity(){
        return databasesActivity;
    }
    public int getSpringActivity(){
        return springActivity;
    }


    public boolean getJavaNotify(){
        return javaNotify;
    }
    public boolean getDsaNotify(){
        return dsaNotify;
    }

    public boolean getDatabasesNotify(){
        return databasesNotify;
    }

    public boolean getSpringNotify(){
        return springNotify;
    }
    public void javaNotified() {
        this.javaNotify = true;
    }
    public void dsaNotified() {
        this.dsaNotify = true;
    }
    public void databasesNotified() {
        this.databasesNotify = true;
    }
    public void springNotified(){
        this.springNotify = true;
    }
}
