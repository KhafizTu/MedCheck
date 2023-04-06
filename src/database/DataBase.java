package database;

import classes.Doctor;
import classes.Hospital;

import java.util.List;

public class DataBase {
    private List<Hospital> hospitals;
    private List<Doctor> doctors;



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

    @Override
    public String toString() {
        return "DataBase{" +
                "hospitals=" + hospitals +
                '}';
    }
}
