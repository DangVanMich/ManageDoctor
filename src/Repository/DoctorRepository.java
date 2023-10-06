/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import model.ListDoctor;
import java.util.ArrayList;
import model.Doctor;

/**
 *
 * @author This PC
 */
public class DoctorRepository implements IDoctorRepository{
    
    private ArrayList<Doctor> doctors;
    
    public DoctorRepository(){
        doctors= new ArrayList<>();
    }

    @Override
    public void addDoctor() {
        ListDoctor.Instance().CreateDoctor(doctors);            
    }

   
    @Override
    public void updateDoctor() {
        ListDoctor.Instance().UpdateDoctor(doctors);
    }

    @Override
    public void deletedDoctor() {
        ListDoctor.Instance().DeleteDoctor(doctors);
    }

    @Override
    public void searchDoctor() {
        ListDoctor.Instance().SearchDoctor(doctors);
    }
    
    @Override
    public void display(){
        ListDoctor.Instance().displayDoctor(doctors);
    }
    
}