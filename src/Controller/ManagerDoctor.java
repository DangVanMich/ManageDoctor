/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;

import Repository.DoctorRepository;
import Repository.IDoctorRepository;
import java.util.ArrayList;
import model.Doctor;
import view.Menu;

/**
 *
 * @author This PC
 */
public class ManagerDoctor extends Menu<String> {

    private IDoctorRepository doctorRepository = new DoctorRepository();
    static String title = "WELCOME TO DOCTOR MANAGEMENT";
    static String[] s = new String[]{"Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor","Display All", "Exit"};

    public ManagerDoctor() {
        super(title, s);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                doctorRepository.addDoctor();
                break;
            case 2:
                doctorRepository.updateDoctor();
                break;
            case 3:
                doctorRepository.deletedDoctor();
                break;
            case 4:
                doctorRepository.searchDoctor();
                break;
            case 5:
                doctorRepository.display();
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println("Your choice invalid! Pls input another choice");
        }

    }
}
