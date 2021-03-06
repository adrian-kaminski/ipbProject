package com.project.ipb.ipbProject.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Class containing car characteristics, in Polish to keep the same as in documentation
 */
@Entity(name = "car")
public class Car {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    private String registrationNumber;
    private String brand;
    private String fuelType;
    private double displacement; //pojemność skokowa
    private double standardPower; //moc seryjna
    private double standardTorque;
    private double turbo;

    @OneToMany(mappedBy = "car", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Application> applications;

    public Car() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String marka) {
        this.brand = marka;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String rodzajPaliwa) {
        this.fuelType = rodzajPaliwa;
    }

    public double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(double pojemnoscSkokowa) {
        this.displacement = pojemnoscSkokowa;
    }

    public double getStandardPower() {
        return standardPower;
    }

    public void setStandardPower(double mocSeryjna) {
        this.standardPower = mocSeryjna;
    }

    public double getStandardTorque() {
        return standardTorque;
    }

    public void setStandardTorque(double momentObrotowySeryjny) {
        this.standardTorque = momentObrotowySeryjny;
    }

    public double getTurbo() {
        return turbo;
    }

    public void setTurbo(double turbo) {
        this.turbo = turbo;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }
}
