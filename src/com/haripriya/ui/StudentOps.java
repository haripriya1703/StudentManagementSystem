package com.haripriya.ui;

import com.haripriya.model.Student;
import com.haripriya.service.CrudMethods;

import java.util.Scanner;

public class StudentOps {

    public int validateID(Scanner sc) {
        System.out.println("Enter student id");
        int id= sc.nextInt();
        try{
            while(id<=0){
                System.out.println("Id should be >=0. Re-enter Student id");
                id = sc.nextInt();
            }
            return id;
        }
        catch(Exception e){
            System.out.println("Exception Occurred!!!!!...");
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to ABC Student Management System");
        System.out.println("**********************************************************************");
        //boolean on = true;
        Scanner scanner=new Scanner(System.in);
        CrudMethods crudMethods = new CrudMethods();
        StudentOps t = new StudentOps();
        while (true) {
            System.out.println("Menu Options");
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Display all records");
            System.out.println("5. Search Record");
            System.out.println("6. Exit");
            System.out.println("Enter your choice");
            int choice=0;
            try {
                choice = scanner.nextInt();
            }
            catch(Exception e3){
                System.out.println("Enter Integers only!.....");
            }
            switch (choice) {
                case 1://insert
                    Student student = new Student();
                    int a = t.validateID(scanner);
                    if (a >= 0) {
                        try {
                            student.setId(a);
                            System.out.println("Enter Student First Name");
                            String firstname = scanner.next();
                            student.setFirstname(firstname);
                            System.out.println("Enter Student Last Name");
                            String lastname = scanner.next();
                            student.setLastname(lastname);
                            System.out.println("Enter Student Contact Number");
                            int contactNumber = scanner.nextInt();
                            student.setContactNumber(contactNumber);
                            crudMethods.insertRecord(student);
                        }
                        catch (Exception e){
                            System.out.println("Enter valid details!......");
                        }
                    }
                    break;
                case 2://update
                    int id1 = t.validateID(scanner);
                    if (id1 >= 0) {
                        crudMethods.updateRecord(id1, scanner);
                    }
                    break;
                case 3://delete
                    int id2 = t.validateID(scanner);
                    if (id2 >= 0) {
                        crudMethods.deleteRecord(id2);
                    }
                    break;
                case 4://Display
                    crudMethods.displayRecords();
                    break;
                case 5://Search Record
                    int id5 = t.validateID(scanner);
                    if (id5 >= 0) {
                        crudMethods.displayRecordById(id5);
                    }
                    break;
                case 6://exit
                    System.out.println("Thank you!....");
                    System.exit(0);
                default:
                    System.exit(0);
            }//switch
        }//while
    }//main
}//class