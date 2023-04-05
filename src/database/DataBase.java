package database;

import classes.Hospital;

import java.util.List;

public class DataBase {
    private List<Hospital> hospitals;

    public DataBase(List<Hospital> hospitals) {
        this.hospitals = hospitals;
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
