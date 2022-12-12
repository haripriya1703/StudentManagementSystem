package com.haripriya.service;

import com.haripriya.model.Student;

import java.util.LinkedList;
import java.util.Scanner;

public class CrudMethods {
    LinkedList<Student> list1;

    public CrudMethods() {
        list1 = new LinkedList<>();
    }

    //find record by id
    public Student findRecordById(int id) {
        for (Student studentList : list1) {
            if (studentList.getId() == id) {
                return studentList;
            }
        }
        return null;
    }

    //find record
    public boolean findRecord(int id) {
        for (Student studentList : list1) {
            if (studentList.getId() == id) {
                return true;
            }
        }
        return false;
    }

    //insert record
    public void insertRecord(Student student) {
        if (!findRecord(student.getId())) {
            System.out.println(student.getId());
            list1.add(student);
            System.out.println("Inserted Successfully...");
        } else
            System.out.println("Record already exists");
    }

    //update record
    public void updateRecord(int id1, Scanner scanner) {
        Student updateStudent = findRecordById(id1);
        if (updateStudent != null) {
            System.out.println("Enter Student First Name");
            String firstname1 = scanner.next();
            updateStudent.setFirstname(firstname1);
            System.out.println("Enter Student Last Name");
            String lastname1 = scanner.next();
            updateStudent.setLastname(lastname1);
            System.out.println("Enter Student Contact Number");
            int contactNumber1 = scanner.nextInt();
            updateStudent.setContactNumber(contactNumber1);
            System.out.println("Updated Successfully...");
        } else {
            System.out.println("Student Record not found to update the details");
        }
    }

    //delete record
    public void deleteRecord(int id) {
        Student record=null;
        for (Student ll : list1 ){
            // Finding record to be deleted by id Number
            if (ll.getId() == id) {
                record = ll;
            }
        }
        if (record!=null) {
            list1.remove(record);
            System.out.println("Deleted Successfully!.....");
        } else {
            System.out.println("Student Record not found to delete the details");
        }
    }

    //display records
    public void displayRecords() {
        System.out.println("***************List of all Students data available****************");
        for (Student studentList : list1) {
            System.out.println("Student id\t" + "First Name\t" + "Last Name\t" + "Contact Number");
            System.out.println(studentList.getId() + "\t" + studentList.getFirstname() + "\t" + studentList.getLastname() + "\t" + studentList.getContactNumber());
        }
        System.out.println("*******************************************************************");
    }
    public void displayRecordById(int id) {
        Student studentList = findRecordById(id);
        if(studentList!=null) {
            System.out.println("*************************Student data available********************");
            System.out.println("Student id\t" + "First Name\t" + "Last Name\t" + "Contact Number");
            System.out.println(studentList.getId() + "\t" + studentList.getFirstname() + "\t" + studentList.getLastname() + "\t" + studentList.getContactNumber());
            System.out.println("*******************************************************************");
        }
        else{
            System.out.println("Record not found");
        }
    }

}
