/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import view.Validation;

/**
 *
 * @author admin
 */
public class ListDoctor {

    private static ListDoctor instance = null;
    private ArrayList<Doctor> list_doctor;
    private Validation validate;

    public ListDoctor() {
        this.list_doctor = new ArrayList<>();
        this.validate = new Validation();
    }

    public static ListDoctor Instance() {
        if (instance == null) {
            synchronized (ListDoctor.class) {
                if (instance == null) {
                    instance = new ListDoctor();
                }
            }
        }
        return instance;
    }

    public void CreateDoctor(ArrayList<Doctor> doctors) {
        System.out.println("-----------ADD DOCTOR----------");
        while (true) {
            String id = validate.checkInputString("Enter id: ");
            if (!validate.checkIdExist(doctors, id)) {
                String Name = validate.checkInputString("Enter name: ");
                String Speci = validate.checkInputString("Enter specialization: ");
                int Avai = validate.checkInputInt("Enter Availability");
                doctors.add(new Doctor(id, Name, Speci, Avai));
            }
            System.out.println("Successful!");
            System.out.println("Do you want to continue (Y/N)? Choose Y to continue, N to return main screen");
            if (!validate.checkInputYesNo()) {
                return;
            }
        }
    }

    public void UpdateDoctor(ArrayList<Doctor> doctors) {
        System.out.println("---------UPDATE DOCTOR--------");
        System.out.print("Enter code want to update: ");
        String code_find = validate.checkInputString1();
        Doctor doctor_find = findCodeDoctor(doctors, code_find);
        if (doctor_find == null) {
            System.err.println("Code no exist in list!");
            return;
        } else {
            System.out.println("Please enter information update of doctor.");
            System.out.println("Enter Name: ");
            String name = validate.checkInputString1();
            doctor_find.setName(name);
            System.out.println("Enter Specialization: ");
            String specialization = validate.checkInputString1();
            doctor_find.setSpecialization(specialization);
            int availability = validate.checkInputInt("Enter Availability: ");
            doctor_find.setAvailability(availability);
            System.out.println("Updated successful!");
        }
    }

    public void SearchDoctor(ArrayList<Doctor> doctors) {
        System.out.println("------------SearchDoctor----------");
        String id_find = validate.checkInputString("Enter name want to search: ");
        ArrayList<Doctor> doctor_find = findNameDoctor(doctors, id_find);
        if (doctor_find.isEmpty()) {
            System.err.println("No finded name of Doctor");
            return;
        } else {
            System.out.println("----- Result -----");
            displayDoctor(doctor_find);
        }
    }

    public void DeleteDoctor(ArrayList<Doctor> doctors) {
        System.out.println("------------ Delete a Doctor ---------");
        String id = validate.checkInputString("Enter ID want to Delete : ");
        Doctor find_contact = findCodeDoctor(doctors, id);
        if (find_contact != null) {
            doctors.remove(find_contact);
            System.out.println("Deleted Successful!");
        } else {
            System.err.println("Code does not exist Doctor");
        }
    }

   public ArrayList<Doctor> findNameDoctor(ArrayList<Doctor> doctors, String name){
        ArrayList<Doctor> doctor_findName= new ArrayList<>();
        for (Doctor doctor : doctors) {
            if(doctor.getName().contains(name)){
                doctor_findName.add(doctor);
            }
        }
        return doctor_findName;        
    }

    public Doctor findCodeDoctor(ArrayList<Doctor> doctors, String code){
        Doctor doctor_find=null;
        for (Doctor doctor : doctors) {
            if(doctor.getCode().equalsIgnoreCase(code)){
                doctor_find= doctor;
                break;
            }
        }
        return doctor_find;
    }

    public void displayDoctor(ArrayList<Doctor> doctors) {
        if (doctors.isEmpty()) {
            System.err.println("List is Empty!");
            return;
        }
        System.out.println("----- Display all Contact -----");
        System.out.println("Code    Name     Specialization   Availability");
        for (Doctor dt : doctors) {
            System.out.println(dt.display());
        }

    }

}
