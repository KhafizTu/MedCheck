package database;

import classes.Department;
import classes.Doctor;
import classes.Hospital;
import classes.Patient;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Hospital> hospitals;
    private List<Doctor> doctors;

    private List<Patient> patients;

    private List<Department> departments;



    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }


    public DataBase(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }
    public DataBase(List<Doctor>doctors,int number){
        this.doctors = doctors;

    }

    public DataBase(int num,List<Patient> patients) {
        this.patients = patients;
    }

    public DataBase(List<Department> departments,String s) {
        this.departments = departments;
    }



    @Override
    public String toString() {
        return "DataBase{" +
                "hospitals=" + hospitals +
                '}';
    }
}
